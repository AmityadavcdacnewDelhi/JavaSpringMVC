package springmvc.config;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"mvcspring.controller"})
public class AppConfigurator {
	@Bean
	public Configuration hibernateConfiguration()
	{
		Configuration hibernateConfig = new Configuration();
		hibernateConfig.configure("MySql.cfg.xml");
		return hibernateConfig;
		
	}
	@Bean
	public SessionFactory hibernateFactory(Configuration hibernateConfiguration)
	{
		return hibernateConfiguration.buildSessionFactory();
	}

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
