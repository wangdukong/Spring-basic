package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야한다")
    void vip_o(){
        //given
        Member member=new Member(1L,"memberVip", Grade.VIP);

        //when
        int discount=rateDiscountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        Member member=new Member(1L,"memberBasic", Grade.BASIC);

        //when
        int discount=rateDiscountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}