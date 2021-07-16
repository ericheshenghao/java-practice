package demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author: 何胜豪
 * @Title: TODO
 * @Package: demo
 * @Description:
 * @date : 2021/7/16 15:05
 */
public class AppTest {

    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
