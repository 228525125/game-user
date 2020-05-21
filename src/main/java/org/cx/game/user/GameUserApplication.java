package org.cx.game.user;

import org.cx.game.user.config.PersistenceConfig;
import org.cx.game.user.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@Import({PersistenceConfig.class, WebConfig.class})
//@EnableResourceServer            //受保护的服务
@SpringBootApplication
public class GameUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameUserApplication.class, args);
	}

}
