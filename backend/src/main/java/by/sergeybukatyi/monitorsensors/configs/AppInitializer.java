package by.sergeybukatyi.monitorsensors.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@ComponentScan(basePackages = {"by.sergeybukatyi.monitorsensors"})
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{PersistenceJPaConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebMvcConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
