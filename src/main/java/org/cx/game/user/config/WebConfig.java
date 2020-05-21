package org.cx.game.user.config;

import org.cx.game.tools.SharedConfig;
import org.cx.game.user.controller.IController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={IController.class, SharedConfig.class})
public class WebConfig {

}
