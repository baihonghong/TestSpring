package taco.tacos;

import taco.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/**
 * @description:TODO
 * @author:baihhw
 * @date:2025/02/10 7:05
 */
@WebMvcTest(HomeController.class)//Spring Boot 提供的⼀个特殊测试注释，它安排测试在Spring MVC 应⽤程序的上下⽂中运⾏
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;//测试类被注⼊了⼀个 MockMvc 对象中，以此⽤来测试来驱动模型。

    /**
     * testHomePage() ⽅法定义了要对主⻚执⾏的测试。它从 MockMvc 对象
     * 开始，执⾏针对 /（根路径）的 HTTP GET 请求。该请求规定了下列
     * 期望值：
     * 响应应该有⼀个HTTP 200（OK）状态。
     * 视图应该有⼀个合理的主⻚名称。
     * 呈现的视图应该包含 “Welcome to...”
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to ...")));
    }
}
