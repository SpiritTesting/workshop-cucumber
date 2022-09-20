package com.spirittesting.workshop;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = { TestConfiguration.class })
public class CucumberSpringContextConfig {
}
