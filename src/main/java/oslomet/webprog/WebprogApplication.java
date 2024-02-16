package oslomet.webprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "oslomet.webprog")
public class WebprogApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebprogApplication.class, args);
    }
}
