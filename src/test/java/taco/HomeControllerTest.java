package taco;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HomeControllerTest {
    @Mock//注解可以理解为对 mock 方法的一个替代，不会走真实的方法，模拟真实方法的行为。
    // 使用该注解时，要使用MockitoAnnotations.openMocks(this)  方法，让注解生效。
    private Mock mock;

    @BeforeEach//用在测试前准备，测试前会构建很多的环境配置或者基础配置，都可以在这里设置。
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach//用于测试后设置
    void tearDown() {
    }

    @Test
    void home() {
        //mock 打桩，就是不管真实的方法如何执行，我们可以自行假设该方法执行的结果

        //后续的测试都是基于打桩结果来走

        // Mockito.when(demo.add(1,2)).thenReturn(4);

        // Assertions.assertEquals(3,demo.add(1,2));

        //当测试方法出现异常，测试方法  如果有try{}catch{} 则可以测试异常是否正常

        //Mockito.when(demo.add(1,1)).thenThrow(new RuntimeException());

        //调用真实的方法

//        Mockito.when(mock.add(1,1)).thenCallRealMethod();

//        Assertions.assertEquals(2,demo.add(1,1));

    }
}