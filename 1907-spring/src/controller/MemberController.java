package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/select.mm" , method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<Object> list = new ArrayList<Object>();
		list.add("참 잘했어~(member)");
		
		mv.addObject("list",list);
		mv.setViewName("select");
		return mv;
	}
}
