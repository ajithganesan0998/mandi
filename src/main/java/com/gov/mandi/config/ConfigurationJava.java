package com.gov.mandi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigurationJava implements WebMvcConfigurer {

	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tilesDefinition.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
	 
		/*
		 * @Bean public ViewResolver internalResourceViewResolver() {
		 * InternalResourceViewResolver bean = new InternalResourceViewResolver();
		 * bean.setViewClass(JstlView.class); bean.setPrefix("/WEB-INF/jsp/");
		
		 * bean.setSuffix(".jsp"); return bean; }
		 */
		/*
		 * @Bean(name = "dataSource1") DataSource dataSource() { DriverManagerDataSource
		 * driverManagerDataSource = new DriverManagerDataSource();
		 * driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/world");
		 * driverManagerDataSource.setUsername("root");
		 * driverManagerDataSource.setPassword("root");
		 * driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 * return driverManagerDataSource; }
		 */
	
	@Bean
	DataSource dataSource1() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}
	

	/*
	 * @Bean(name = "jbcTemplatenew") public JdbcTemplate
	 * jdbcTemplate(@Qualifier("dataSource1") DataSource ds) { JdbcTemplate
	 * jdbcTemplate = new JdbcTemplate(ds);
	 * 
	 * return jdbcTemplate; }
	 */
	
	@Bean
	public JdbcTemplate jbcTemplateOld(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}
}
