package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //컴포넌트 스캔을 시작할 위치를 지정
        //basePackages = "hello.core.member",
        // -> 지정하지 않을 경우 @ComponentScan 이 붙은 설정정보 클래스의 패키지가 시작위치가 된다

        // 해당 class는 컴포넌트 스캔에서 제외한다 , 실무에서는 이렇게 안 함 예제코드를 살리기 위해서 쓴 경우임 ㅋㄷ
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name =  "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
