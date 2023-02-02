package hy.SpringBoot.learn.service;

import hy.SpringBoot.learn.model.Member;
import hy.SpringBoot.learn.repository.MemberRepository;
import hy.SpringBoot.learn.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//test단축키 ctrl + shift + t

public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     *  회원가입
     *
     * @param member Member
     * @return id Long
     */
    public Long join(Member member) {
        //리팩토링 단축키 ctrl + shift + alt + t
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return memberList List
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
