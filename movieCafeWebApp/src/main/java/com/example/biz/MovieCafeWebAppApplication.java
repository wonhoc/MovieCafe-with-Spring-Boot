package com.example.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"}) 
public class MovieCafeWebAppApplication extends SpringBootServletInitializer{

   public static void main(String[] args) {
      SpringApplication.run(MovieCafeWebAppApplication.class, args);
   }
   @Override 
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(MovieCafeWebAppApplication.class); 
   }
}