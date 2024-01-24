package study.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.datajpa.domain.Member;
import study.datajpa.service.MemberService;

import java.util.List;

/*
*   스프링 빈을 등록하는 2가지 방법
*   - 컴포넌트 스캔과 자동 의존관계 설정
*   - 자바 코드로 직접 스프링 빈 등록하기
*
*   스프링 빈을 등록해주는 어노테이션은
*   사실 @Component라는 어노테이션이고
*   controller , service , repository안에는
*   @Component가 존재한다.
*
* */


/* component 어노테이션이 존재한다면
   스프링 컨테이너에 memberController
   객체를 생성하여 넣어둔다.
   이런걸 스프링 빈이 관리된다 라고 표현함 */
@Controller
public class MemberController {

    /* 스프링 컨테이너에 등록을 한다면
       여러 객체가 생성될 필요가 없음 */
    private MemberService memberService;

    /* 생성자 파라미터에 데이터를 전달받고
       필드에 변수를 할당해줌
       @Autowired를 어노테이션을 통해
       스프링 컨테이너에 있는 MemberService를 찾아
       주입해줌
       이걸 di라고 한다.
       의존성 주입 (외존관계를 주입해줌) */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "member/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "member/memberList";
    }

}
