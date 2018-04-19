package config;

import app.App;
import beans.Client;
import java.text.DateFormat;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("beans")
@Import(LoggersConfig.class)
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public App app() {
    return new App();
  }

  @Bean
  public DateFormat dateFormat() {
    return DateFormat.getDateTimeInstance();
  }

  @Bean
  public Date date() {
    return new Date();
  }

}

