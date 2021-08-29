package io.github.mahendrabagul.cacherefresher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.github.mahendrabagul.cacherefresher")
public class CacheRefresherApplication {

  public static void main(String[] args) {
    SpringApplication.run(CacheRefresherApplication.class, args);
  }

}
