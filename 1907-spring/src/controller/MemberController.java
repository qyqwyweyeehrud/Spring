package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.Page;

@Controller
public class MemberController {

	@RequestMapping(value="/select.mm", 
			            method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<Object> list = new ArrayList<Object>();
		list.add("잘했군 잘했어~(member)");
		
		mv.addObject("list", list);
		mv.setViewName("select");
		
		return mv;
	}

	
	
	@RequestMapping(value="/insert.mm", method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insert");
		return mv;
	}
	
	@RequestMapping(value="/insertR.mm", method=RequestMethod.POST)
	public ModelAndView insertR() {
		ModelAndView mv = new ModelAndView();
		String msg = "게시판 정보가 저장되었습니다.";
		Page p = new Page();
		//FileUpload
		
		
		
		mv.addObject("p", p);
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}	
	
	
	
	@RequestMapping(value="/view.mm", method= {RequestMethod.POST})
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo", vo);
		mv.setViewName("view");
		return mv;
	}
	@RequestMapping(value="/modify.mm", method= {RequestMethod.POST})
	public ModelAndView modify() {
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo", vo);
		mv.setViewName("modify");
		return mv;
	}	
	@RequestMapping(value="/modifyR.mm", method= {RequestMethod.POST})
	public ModelAndView modifyR() {
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo", vo);
		mv.setViewName("result");
		return mv;
	}	

	@RequestMapping(value="/deleteR.mm", method= {RequestMethod.POST})
	public ModelAndView deleteR() {
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo", vo);
		mv.setViewName("result");
		return mv;
	}	
	
	
	
}
