package com.nubelity.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.nubelity.dao.ContactoDao;
import com.nubelity.dao.ContactoDaoImpl;

@Configuration
@EnableWebMvc
//la linea siguiente indica el paquete raiz 
@ComponentScan(basePackages = "com.nubelity")
public class MvcConfiguration implements WebMvcConfigurer{
	//inversion de control -> construye objetos en base a como los necesitas
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/javadb");
		dataSource.setUsername("root");
		dataSource.setPassword("inefable12");
		return dataSource;
	}
	
	@Bean 
	public ContactoDao getContactoDao() {
		return new ContactoDaoImpl(getDataSource());
	}
}
