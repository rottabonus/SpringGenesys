package karigrandi.kg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KgApplication extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder kgapplication){
		return kgapplication.sources(KgApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(KgApplication.class, args);
	}
}
