package lk.ijse.absd.channeling.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("lk.ijse.absd.channeling.controller")
public class WebAppConfig {

}
