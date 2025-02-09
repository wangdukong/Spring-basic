package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName +" object = "+bean);
        }
    }@Test
    @DisplayName("모든 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        //등록된 모든 빈 이름 조회
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                //이름으로 빈 조회
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
