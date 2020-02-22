package me.fanbin.springpracticecachingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 示例：数据缓存
 *
 * EnableCaching 注解创建 post-processor 会检查所有 bean 中需要添加缓存的 public 方法，
 * 如果发现一个，就会创建一个代理，用来拦截方法调用和缓存行为处理。
 *
 * post-processor 会处理 Cacheable, CachePut, CacheEvict 注解，
 * 更多信息在这里：https://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html
 *
 * Spring Boot 会自动配置一个合适的 CacheManager 提供相关的缓存，
 * 更多信息在这儿：https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-caching
 *
 * 这个示例当中，没有定义特定的缓存哭，因此数据被缓存在一个 ConcurrentHashMap 当中。
 * Spring 中的缓存概念支持很多缓存库，并且完全符合 JSR-107
 *
 * @see <a href="https://spring.io/guides/gs/caching/">
 *     Caching Data with Spring</a>
 *
 * @author fanbin
 */
@SpringBootApplication
@EnableCaching
public class SpringPracticeCachingDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeCachingDataApplication.class, args);
    }

}
