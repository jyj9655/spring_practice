package com.mycompany.practice.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.practice.member.model.service.MemberService;
import com.mycompany.practice.member.model.vo.Member;

@Controller
@RequestMapping("/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView signUp(HttpServletRequest request, ModelAndView mv) {
		String msg = request.getParameter("msg");
		mv.setViewName("/member/index");
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST)
	public String signUp(Member m, RedirectAttributes ra) {
		int result = 0;
		try {
			result = memberService.join(m);
			if (result > 0) {
				ra.addAttribute("msg", "회원가입 성공");
			} else {
				ra.addAttribute("msg", "회원가입 실패");
			}
		}catch (Exception e) {
			ra.addAttribute("msg", "회원가입 과정에서 오류 발생");
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
}
