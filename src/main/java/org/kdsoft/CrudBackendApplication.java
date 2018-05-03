package org.kdsoft;

import javax.sql.DataSource;

import org.kdsoft.entities.User;
import org.kdsoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@ImportResource(value="classpath:Beans.xml")
public class CrudBackendApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
		/*SpringApplication application = new SpringApplication(CrudBackendApplication.class);
		Map<String, Object> configMap = new HashMap<>();
		configMap.put("SERVER_CONTEXT_PATH", "/automation1");
		application.setDefaultProperties(configMap);
		application.run(args);*/
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("one", "one"));
		userRepository.save(new User("two", "one"));
		userRepository.save(new User("three", "one"));
		
		System.out.println("DataSource : "+ dataSource);
		
	}
	  @Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
                      return builder.sources(CrudBackendApplication.class);
      }
}
