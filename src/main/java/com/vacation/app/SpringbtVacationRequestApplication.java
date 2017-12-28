package com.vacation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.vacation.app.form.ActivitiForm;

@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class
})
@SpringBootApplication
@EnableConfigurationProperties({ActivitiForm.class})
public class SpringbtVacationRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbtVacationRequestApplication.class, args);
	}
}
