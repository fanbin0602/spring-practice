package me.fanbin.springpracticecrossorigin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 示例：开启接口的跨域访问
 * @see <a href="https://spring.io/guides/gs/rest-service-cors/">
 *     Enabling Cross Origin Requests for a RESTful Web Service</a>
 *
 * @author fanbin
 */
@SpringBootApplication
public class SpringPracticeCrossOriginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeCrossOriginApplication.class, args);
    }

    /**
     *
     * Java 配置跨域访问，这种方式可以用来全剧配置跨域访问。
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/greeting-javaconfig")
                        .allowedOrigins("http://localhost:9000");
            }
        };
    }

}
