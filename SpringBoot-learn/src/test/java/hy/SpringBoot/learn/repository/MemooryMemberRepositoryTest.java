package hy.SpringBoot.learn.repository;

import hy.SpringBoot.learn.model.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
class MemooryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + result);
//        Assertions.assertEquals(member, null);
//        if (member == null){
//            throw new IllegalArgumentException("사용자 정보 x");
//        }
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member m = new Member();
        m.setName("hy");
        repository.save(m);

        Member m2 = new Member();
        m2.setName("hy2");
        repository.save(m2);

        Member result = repository.findByName("hy").get();

        assertThat(result).isEqualTo(m);
    }

    @Test
    public void findAll() {
        Member m1 = new Member();
        m1.setName("hy1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("hy2");
        repository.save(m2);

        List<Member> results = repository.findAll();
        assertThat(results.size()).isEqualTo(2);
//        assertThat(results.size()).isEqualTo(3);

    }

}
