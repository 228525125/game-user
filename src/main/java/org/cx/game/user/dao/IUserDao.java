package org.cx.game.user.dao;

import org.cx.game.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {
	
	public User findByAccount(String account);
}
