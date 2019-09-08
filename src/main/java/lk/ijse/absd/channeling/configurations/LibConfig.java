package lk.ijse.absd.channeling.configurations;

import lk.ijse.absd.channeling.configurations.security.JWTAuthenticator;
import lk.ijse.absd.channeling.util.SMSHandler;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LibConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public SMSHandler smsHandler() {
        return new SMSHandler();
    }

    @Bean
    public JWTAuthenticator jwtAuthenticator() {
        return new JWTAuthenticator();
    }

}

