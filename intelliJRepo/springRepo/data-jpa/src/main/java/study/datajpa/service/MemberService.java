package study.datajpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;
import study.datajpa.repository.MemberRepository;
import study.datajpa.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
// 클래스 커맨드+쉬프트+t 테스트 클래스생성 단축키
    private  final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원x
        // ifPresent란? 값이 있으면 로직이 동작함
        // 기존이면 if null이아니면 이런건데
        // optionnal로 널일 가능성이 있는거를 감싼다.
        long start = System.currentTimeMillis();

        try{
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        System.out.println("회원이름: "+member.getName());
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        ;
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        Long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        }finally {
            Long end = System.currentTimeMillis();
            Long timeMs = start - end;
            System.out.println("findMembers = " + timeMs + "ms");
        }
    }

    /**
     * 회원 힌명 조회하기
     */
    public  Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
