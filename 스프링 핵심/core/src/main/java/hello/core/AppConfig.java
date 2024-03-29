package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixeDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다.
@Configuration
public class AppConfig {

    // @Bean 이 표기된 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
    // 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixeDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
