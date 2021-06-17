/* @Class : StudentInfoEntityConfiguration
 * @Description : Class to create Entity Manager Factory once using 
 *                LocalEntityManagerFactoryBean
 * */
package com.onebill.Spring.configuration;

/*
 * @author : Rathesh Prabakar
 * @Version : 2.0 17/06/2021
 * */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class StudentInfoEntityConfiguration {
	
	@Bean
	public LocalEntityManagerFactoryBean getManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("sms");
		return bean;
	}

}
