// Pakkenavn og import-setninger
package oslomet.webprog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot Application-klasse
@SpringBootApplication(scanBasePackages = "oslomet.webprog")
public class WebprogApplication {

    // Hovedmetode som starter Spring Boot-applikasjonen
    public static void main(String[] args) {
        SpringApplication.run(WebprogApplication.class, args);
    }
}
