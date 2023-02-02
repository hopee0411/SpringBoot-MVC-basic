package hy.SpringBoot.learn.config;

import hy.SpringBoot.learn.repository.MemberRepository;
import hy.SpringBoot.learn.repository.MemoryMemberRepository;
import hy.SpringBoot.learn.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
