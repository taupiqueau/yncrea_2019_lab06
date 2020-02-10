package yncrea.lab06.web;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.lab06.core.config.AppConfig;
import yncrea.lab06.core.config.DBConfig;
import yncrea.lab06.web.config.WSConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        Dynamic servlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/api/*");
    }


    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                AppConfig.class, DBConfig.class, WSConfig.class };
    }


    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] { "/web/" };
    }
}
