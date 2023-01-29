package springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext application) throws ServletException {
	AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
	applicationContext.register(AppConfigurator.class);
	applicationContext.setServletContext(application);
	ServletRegistration.Dynamic controller = application.addServlet("controller",new DispatcherServlet(applicationContext) );
	controller.setLoadOnStartup(100);
	controller.addMapping("/spring/*");

	}

}
