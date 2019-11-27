package com.reduxcrud.reduxcrud;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReduxcrudApplication implements WebMvcConfigurer {

	public static void main(String[] args) throws Exception {
		initializeUserList();
		SpringApplication.run(ReduxcrudApplication.class, args);
	}
	
	   @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/**")
           .addResourceLocations("classpath:/static/","classpath:/image/")
           .setCachePeriod(0);
       }
	
	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedMethods("*");
	    }
	
	  private static void initializeUserList() throws Exception {
		  for(int i =1;i<11;i++) {
			  File file = ResourceUtils.getFile("classpath:static/pic"+i+".jpg");
			  User user = new User();
			  user.setUuId(i);
			  user.setAddress(new Address("primaryAddress"+i, "secondaryAddress"+i));
			  user.setCompany("company"+i);
			  user.setDesignation("designation"+i);
			  user.setEmailId("email"+i);
			  user.setFirstName("firstName"+i);
			  user.setLastName("lastName"+i);
			  user.setPhoneNumber("131231"+i);
			  user.setProfileImage("data:image/jpeg;base64,"+Base64Utils.encodeToString(Files.readAllBytes(file.toPath())));
			  UserList.users.add(user);
		  }
	  }

}
