package taco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:启动类
 * Springboot默认扫包的问题，我们知道在之前SpringMVC中我们自己需要手动配置注解驱动、扫包等等一系列的操作，
 * 但是Springboot有一个@EnableAutoConfiguration注解已经帮我们自动配置了。默认的扫包是只扫与主程序在同一级目录或者是主程序的下一级目录，
 * 所以目录结构不能变
 * @author:baihhw
 * @date:2025/01/19 16:42
 */
@SpringBootApplication
public class TacoCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
}
