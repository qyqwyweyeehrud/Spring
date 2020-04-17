package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //얘때문에 BoardController 가 controller 역할을 하는것이다
public class BoardController {
	//두겟이나 두포스트라는 개념이 없다 / 대신에 메서드를 내맘대로 만드는 것이다
	
	@RequestMapping(value = "/select.brd", method = {RequestMethod.GET,RequestMethod.POST}) //어느때 얘를 쓸것인가 에대한 어노태이션 // "/select.brd"가 들어왔는데 get이거나 post로 들어오든 무조건 실행하라
	public ModelAndView select() {//데이터와 뷰
		ModelAndView mv = new ModelAndView();
		List<Object> list = new ArrayList<Object>();
		list.add("참 잘했어~(board)");
		
		mv.addObject("list",list);//데이터를 심을때 / 이 애들은 request 영역을 타고 나간다 따라서 ${list}를 바로 사용 할수 있다.
		mv.setViewName("select");//위 오브젝트를 누구에게 넘기겠냐? / 그러면 뷰리졸브가 받고 url을 편집해줘서  index.jsp?inc=./board/select.jsp가 만들어 지는것이야~
		return mv;
	}
	
	@RequestMapping(value = "/view.brd" , method = {RequestMethod.POST})
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView();
		Object vo = null;
		
		mv.addObject("vo",vo);
		mv.setViewName("view");
		return mv;
	}
}
