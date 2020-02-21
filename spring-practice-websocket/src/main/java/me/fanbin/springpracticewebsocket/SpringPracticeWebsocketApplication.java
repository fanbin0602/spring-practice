package me.fanbin.springpracticewebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 示例：Spring WebSocket
 * @see <a href="https://spring.io/guides/gs/messaging-stomp-websocket/">
 *     Using WebSocket to build an interactive web application</a>
 * @see <a href="https://stomp.github.io/">
 *     Stomp</a>
 * @see <a href="http://jmesnil.net/stomp-websocket/doc/">
 *     STOMP Over WebSocket</a>
 *
 * @author fanbin
 */
@SpringBootApplication
public class SpringPracticeWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeWebsocketApplication.class, args);
    }

}
