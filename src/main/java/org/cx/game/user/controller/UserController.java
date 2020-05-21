package org.cx.game.user.controller;

import org.cx.game.filter.UserContextHolder;
import org.cx.game.tools.Logger;
import org.cx.game.user.dao.IUserDao;
import org.cx.game.user.domain.User;
import org.cx.game.user.exception.DataException;
import org.cx.game.user.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/User")
public class UserController {

	@Autowired
	private IUserDao userDao;
	
	@RequestMapping(value="/{account}",method = RequestMethod.GET)
	public User get(@PathVariable("account") String account) {
		User u = userDao.findByAccount(account);
		Logger.debug("UserController2.get: {}", UserContextHolder.getContext().getCorrelationId());
		return u;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User save(@RequestBody User user){
		return userDao.save(user);
	}
	
	//@ExceptionHandler({LoginException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Error handleException(DataException e) {
		String msg = e.getMessage();
		return new Error(HttpStatus.BAD_REQUEST.value(), msg);
	}
	
	private static <T> ResponseEntity<T> getResponseEntity(T body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(body, headers, HttpStatus.OK);
		return responseEntity;
	}
}
