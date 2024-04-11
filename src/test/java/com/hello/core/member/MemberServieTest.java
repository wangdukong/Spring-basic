package com.hello.core.member;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServieTest {

    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        memberService=new AppConfig().memberService();
    }

    @Test
    void join(){
        //given
        Member member=new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember=memberService.findById(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
