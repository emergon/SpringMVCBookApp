package emergon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//this method returns the configuration of DispatcherServlet
        return new Class<?> [] {MyWebAppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        String [] urlMappings = {"/"};
        return urlMappings;
    }
    
}
