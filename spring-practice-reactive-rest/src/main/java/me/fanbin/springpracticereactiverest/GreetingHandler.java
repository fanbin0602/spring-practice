package me.fanbin.springpracticereactiverest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 在 Spring Reactive 的语境中，使用 Handler 来处理请求并创建响应
 *
 * @author fanbin
 * @date 2020/2/23
 */
@Component
public class GreetingHandler {

    /**
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }

}
