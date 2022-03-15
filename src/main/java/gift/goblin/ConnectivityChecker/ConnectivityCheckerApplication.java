package gift.goblin.ConnectivityChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConnectivityCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectivityCheckerApplication.class, args);
	}

}
