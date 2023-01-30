package hy.SpringBoot.learn.service;

import hy.SpringBoot.learn.model.Member;
import hy.SpringBoot.learn.repository.MemberRepository;
import hy.SpringBoot.learn.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
                .orElseThrow(() -> new IllegalArgumentException("이미존재하는 회원입니다."));
    }

    /**
     * 전체 회원 조회
     *
     * @return memberList List
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
