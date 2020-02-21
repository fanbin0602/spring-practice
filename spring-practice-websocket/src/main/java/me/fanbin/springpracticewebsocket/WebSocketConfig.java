package me.fanbin.springpracticewebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * `@EnableWebSocketMessageBroker` 开启由代理支持的消息，这个代理在 WebSocket 之上使用一个更高级的子协议。
 *
 * @see <a href="https://stomp.github.io/">
 *     Stomp</a>
 * @see <a href="http://jmesnil.net/stomp-websocket/doc/">
 *     STOMP Over WebSocket</a>
 *
 * @author fanbin
 * @date 2020/2/21
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 配置消息代理
     * @param registry
     */
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 开启基于内存的 SimpleBroker 的消息代理，捕获地址以 /topic 开头的握手消息
        registry.enableSimpleBroker("/topic");
        // 指派以 /app 前缀的消息绑定到 `@MessageMapping` 注解的方法上
        // 这个前缀会被用来定义所有的消息映射
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     *
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册 "/gs-guide-websocket" 端点，允许 SockJS 回退选项，以便在 WebSocket 不可用的时候传输消息
        // SockJS 客户端会试图连接 "/gs-guide-websocket" 然后使用最佳的可用传输方案（websocket, xhr-streaming, xhr-polling, and so on.）
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
