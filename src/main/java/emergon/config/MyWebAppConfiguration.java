package emergon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc// Supports Validations, Converters, Finding Beans (Controllers, Services, Repositories)
@ComponentScan(basePackages = {"emergon"})
public class MyWebAppConfiguration implements WebMvcConfigurer{

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver myViewResolver = new InternalResourceViewResolver();
        myViewResolver.setPrefix("/WEB-INF/views/");
        myViewResolver.setSuffix(".jsp");
        registry.viewResolver(myViewResolver);
    }

   
    
}
