package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repositiry = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repositiry.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repositiry.save(member);
        Member result = repositiry.findById(member.getId()).get();
        //Assertions.assertEquals(member,result);
        //System.out.println("(result==member) = " + (result==member));
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);


        Member result = repositiry.findByName("spring2").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);

        List<Member> result = repositiry.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

