package springgenesys.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder demoapplication) {
		return demoapplication.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}


