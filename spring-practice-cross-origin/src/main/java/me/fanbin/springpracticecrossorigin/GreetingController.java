package me.fanbin.springpracticecrossorigin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fanbin
 * @date 2020/2/22
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *
     * CrossOrigin 注解会开启这个特定方法的跨域访问，默认情况下，
     * 会开启对所有该方法的 RequestMapping 注解声明的所有源地址、header、HTTP 方法的访问权限
     * 可以在 CrossOrigin 注解的属性中自定义这些限定行为
     *
     * @param name
     * @return
     */
    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("====== in greeting ======");
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaConfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("====== in greeting ======");
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

}
