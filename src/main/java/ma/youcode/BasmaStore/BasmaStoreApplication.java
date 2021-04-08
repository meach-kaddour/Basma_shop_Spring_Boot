package ma.youcode.BasmaStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasmaStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasmaStoreApplication.class, args);
	}

}
