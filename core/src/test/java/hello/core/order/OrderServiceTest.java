package hello.core.order;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrderTest() {
        //given
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(member.getId(), "BBQ", 2000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}