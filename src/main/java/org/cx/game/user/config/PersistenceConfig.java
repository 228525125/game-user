package org.cx.game.user.config;

import org.cx.game.user.dao.IDao;
import org.cx.game.user.domain.IEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {IDao.class})
@EntityScan(basePackageClasses = {IEntity.class})
public class PersistenceConfig {

}
