package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//controller는 어차피 spring이 관리하는것이기 때문에 그대로 나둠
@Controller
public class MemberController {
    //이런식으로 하면 다른 컨트롤러에서도 서비스를 사용할 수 있지만 여러 기능이 있지 않기 때문에 하나만 생성하여 공용으로 쓰는게 좋음
    //private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    //dependency injection
    //1.생성자를 통해서 memberservice가 member contorller에 주입이됨
    //   처음에 올때 조립하기 때문에 가장 좋음, 생성하는 시점에 넣고 변경을 막을 수 잇음
    //2. 생성자를 빼고 필드에 Autowired (필드 주입), 별로 안좋음, 바꿀수 있는 방법이 없음
    //    @Autowired private final MemberService memberService;
    //3. setter에 Autowired를 넣어 set할때 주입하는 것 , public하게 노출이 됨, 잘못바꾸면 문제가 생길 수 잇음
    //   호출되지 말아야할 것이 자주 호출되면 안좋음 변경이 많아질 수 있음
    //   @Autowired
    //   public void setMemberService(MemberService memberService){
    //           this.MemberService = memberService;}
    @Autowired
    public MemberController(MemberService memberService){

        this.memberService=memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
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
        return "members/memberList";
    }
}
