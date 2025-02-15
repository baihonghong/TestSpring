package taco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:TODO
 * @author:baihhw
 * @date:2025/01/19 16:54
 */
@Controller//主要⽬的是将该类识别为组件扫描的组件
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
