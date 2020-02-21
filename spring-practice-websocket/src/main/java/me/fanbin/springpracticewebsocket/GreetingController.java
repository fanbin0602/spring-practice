package me.fanbin.springpracticewebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * @author fanbin
 * @date 2020/2/21
 */
@Controller
public class GreetingController {
    /**
     *
     * '@MessageMapping("/hello")' 确保当一个消息被发送到 /hello 的时候，greeting() 方法被调用
     * 信息被装载到一个 HelloMessage 实体中，传入 greeting() 方法
     *
     * 方法返回的 Greeting 对象被广播到所有订阅了 /topic/greetings 的远程端点，在 `@SendTo` 中定义
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
