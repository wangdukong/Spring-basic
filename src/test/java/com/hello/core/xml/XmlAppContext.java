package com.hello.core.xml;

import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {
    ApplicationContext ac=new GenericXmlApplicationContext("appConfig.xml");
    @Test
    void xmlAppContext() {
        MemberService memberService=ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
