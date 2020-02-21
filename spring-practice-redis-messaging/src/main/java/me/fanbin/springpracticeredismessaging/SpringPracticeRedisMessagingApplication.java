package me.fanbin.springpracticeredismessaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 示例：用 Spring Data Redis 发布和订阅消息。
 * @see <a href="https://spring.io/guides/gs/messaging-redis/">
 *     Messaging with Redis</a>
 * @author fanbin
 */
@SpringBootApplication
public class SpringPracticeRedisMessagingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringPracticeRedisMessagingApplication.class);

    /**
     * RedisMessageListenerContainer
     * @param factory Redis 连接驱动
     * @param adapter 注册为消息监听器，监听 Topic 为 chat 的消息
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(adapter, new PatternTopic("chat"));
        return container;
    }

    /**
     * MessageListenerAdapter
     * @param receiver 被 MessageListenerAdapter 包装，作为消息监听，同时配置默认的监听方法
     * @return
     */
    @Bean
    MessageListenerAdapter adapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }

    /**
     * StringRedisTemplate 用来发布信息
     * @param factory
     * @return
     */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(SpringPracticeRedisMessagingApplication.class, args);
        StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
        Receiver receiver = context.getBean(Receiver.class);
        while (receiver.getCount() == 0) {
            LOGGER.info("sending message...");
            template.convertAndSend("chat", "Hello from Redis!");
            Thread.sleep(500L);
        }
        System.exit(0);
    }

}
