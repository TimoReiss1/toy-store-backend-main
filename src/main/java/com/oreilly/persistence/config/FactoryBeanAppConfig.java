package com.oreilly.persistence.config;

import com.oreilly.persistence.Factory.ToyFactory;
import com.oreilly.persistence.entities.AbstractToy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanAppConfig {

    @Bean(name = "abstractToy")
    public ToyFactory toolFactory() {
        ToyFactory factory = new ToyFactory();
        factory.setId(1);
        factory.setSpeed(5);
        factory.setDistanceTraveled(500);
        factory.setAmountOfWheels(4);
        factory.setToyType("car");
        return factory;
    }

    @Bean
    public AbstractToy toy() throws Exception {
        return toolFactory().getObject();
    }
}
