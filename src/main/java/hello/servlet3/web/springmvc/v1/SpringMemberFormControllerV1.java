package hello.servlet3.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    스프링 빈 자동 등록
 */
@Controller
public class SpringMemberFormControllerV1 {

    /*
        요청 정보 매핑
        지정한 URL 호출 시 해당 메소드 호출
     */
    @RequestMapping("springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
