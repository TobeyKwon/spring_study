package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmound = 1000;

    /**
     * @return int 대상 할인 금액
     */
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixAmound;
        return 0;
    }
}
