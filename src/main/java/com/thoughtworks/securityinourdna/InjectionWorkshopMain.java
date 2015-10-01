package com.thoughtworks.securityinourdna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class InjectionWorkshopMain {

    @Bean
    public InvoiceRepo userRepo() {
        try {
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            final InvoiceRepo userRepo = new JdbcInvoiceRepo(connectionFactory.createInMemoryDatabase());

            return userRepo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
        factory.setPort(8081);
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(InjectionWorkshopMain.class);
        app.run(args);
    }
}
