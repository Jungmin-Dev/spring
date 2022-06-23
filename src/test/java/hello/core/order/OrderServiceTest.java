package hello.core.order;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "jungmin", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "item", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}