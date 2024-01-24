package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.datajpa.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날때마다 저장된 데이터를 클리어 해줘야함
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        // optionnal에서 데이터를 빼는것 get으로 가능
        Member result = repository.findById(member.getId()).get();

        // 서로 비교해줌 만약 일치하지 안다면 에러코드가 발생
//        Assertions.assertEquals(result,member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 멤버 repository에서 아이디를 비교해서 찾고 result할당
        Member result = repository.findByName("spring1").get();

        // assertThat을 이용해서 result와 member를 비교
        assertThat(result).isEqualTo(member1);
    }

    // 모든 테스트 순서 순서가 보장안됌
    @Test
    public  void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
