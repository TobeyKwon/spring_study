package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int price1 = statefulService1.order("userA", 10000);

        //ThreadA: B사용자 10000원 주문
        int price2 = statefulService2.order("userB", 20000);

        Assertions.assertThat(price1).isNotEqualTo(20000);
    }

    static class  TestConfig {
        @Bean StatefulService statefulService() {
            return new StatefulService();
        }
    }
}