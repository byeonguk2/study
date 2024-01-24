package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import study.datajpa.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements  MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        System.out.println(member);
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member =  em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // member 객체 자체를 select한다
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
}
