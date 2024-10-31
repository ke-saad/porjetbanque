package com.emsi.jaxrs.config;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Configuration
public class MyConfig {

    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(JacksonJaxbJsonProvider.class); // Uncomment this if needed
        jerseyServlet.register(com.emsi.jaxrs.rest.CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper(); // Configure as needed
    }

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper(); // Configure as needed
    }
}
