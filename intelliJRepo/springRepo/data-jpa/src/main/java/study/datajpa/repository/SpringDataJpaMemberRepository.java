package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository{

    // select m from Member m where m.name = ? 와 같다.
    @Override
    Optional<Member> findByName(String name);

}
