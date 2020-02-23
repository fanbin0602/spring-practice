package me.fanbin.springpracticereactiverest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 示例：响应式 REST 服务
 * @see <a href="https://spring.io/guides/gs/reactive-rest-service/">
 *     Building a Reactive RESTful Web Service</a>
 *
 * @author fanbin
 */
@SpringBootApplication
public class SpringPracticeReactiveRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeReactiveRestApplication.class, args);

        GreetingWebClient client = new GreetingWebClient();
        System.out.println(client.getResult());
    }

}
