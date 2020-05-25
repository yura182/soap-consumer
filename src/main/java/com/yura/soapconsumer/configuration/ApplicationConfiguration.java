package com.yura.soapconsumer.configuration;

import com.yura.soapconsumer.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.yura.soapconsumer.wsdl");

        return marshaller;
    }

    @Bean
    public UserService userService(Jaxb2Marshaller marshaller) {
        UserService userService = new UserService();
        userService.setDefaultUri("http://localhost:8088/ws");
        userService.setMarshaller(marshaller);
        userService.setUnmarshaller(marshaller);

        return userService;
    }
}
