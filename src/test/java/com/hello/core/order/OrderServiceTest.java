package com.hello.core.order;

import com.hello.core.AppConfig;
import com.hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        memberService=new AppConfig().memberService();
        orderService=new AppConfig().orderService();

    }
    @Test
    void orderServiceTest(){
        //given
        Member member =new Member(1L,"oks", Grade.VIP);
        memberService.join(member);
        int itemPrice=10000;


        //when
        Order order=orderService.createOrder(1L,"box",itemPrice);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
