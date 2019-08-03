package lk.ijse.absd.channeling.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("lk.ijse.absd.channeling.service")
@Import(JPAConfig.class)
public class WebRootConfig {

}
