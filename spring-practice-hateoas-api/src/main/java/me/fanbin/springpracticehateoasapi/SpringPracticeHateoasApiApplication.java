package me.fanbin.springpracticehateoasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 示例：创建 HATEOAS 驱动的 REST API
 * @see <a href="https://spring.io/guides/gs/rest-hateoas/">
 *     Building a Hypermedia-Driven RESTful Web Service</a>
 * @see <a href="https://restfulapi.net/hateoas/">
 *     HATEOAS Driven REST APIs</a>
 *
 * @author fanbin
 */
@SpringBootApplication
public class SpringPracticeHateoasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeHateoasApiApplication.class, args);
    }

}
