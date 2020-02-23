package me.fanbin.springpracticedocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例：Spring with Docker
 *
 * @see <a href="https://spring.io/guides/gs/spring-boot-docker/">
 *     Spring Boot with Docker</a>
 *
 * @author fanbin
 */
@SpringBootApplication
@RestController
public class SpringPracticeDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeDockerApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

}
