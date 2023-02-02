package hy.SpringBoot.learn.service;

import hy.SpringBoot.learn.model.Member;
import hy.SpringBoot.learn.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    void 회원가입() {
        //given 뭔가가 주어졌어
        Member member = new Member();
        member.setName("spring");
        //when 뭔가를 했는데
        Long saveId = memberService.join(member);
        //then 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        //단축키 컨트롤 쉬프트 v
        IllegalStateException e =assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다.");
//        }
        //then

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}