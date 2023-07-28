package hello.servlet3.web.springmvc.v3;

import hello.servlet3.domain.member.Member;
import hello.servlet3.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용으로 파라미터를 직접 받을 수 있다.
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    /*
        파라미터로 받을 값의 타입도 바로 캐스팅이 가능
        파라미터로 넘어온 모델에 데이터 객체 저장도 가능하며 뷰 논리 이름을 리턴한다.
     */
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}