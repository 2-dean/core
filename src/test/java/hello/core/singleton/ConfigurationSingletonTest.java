package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //원래 구체 클래스로 꺼내면 안좋음..
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService - > memberRepository = " + memberRepository1);
        System.out.println("orderService - > memberRepository = " + memberRepository2);
        System.out.println("memberRepository  = " + memberRepository);

        //검증
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // 이렇게 넘기면 ac도 스프링 빈 등록이 됨
         AppConfig been= ac.getBean(AppConfig.class);

        System.out.println("been = " + been.getClass());
        //결과: been = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$ad8aea39
        // 스프링이 CGBLIB라는 바이트 조작 라이브러리를 사용해서 AppConfig를 상속받은 임의의 클래스를 스프링 컨테이너에 등록함
    }

}
