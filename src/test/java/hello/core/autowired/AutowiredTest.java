package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    //임의의 테스트 클래스
    static class TestBean {

        //@Autowired(required = false)
        public void setBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        //@Autowired
        public void setBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //@Autowired
        public void setBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }


    }


}
