package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.BoardMybatisDao;
import bean.Page;
import mybatis.AttVo;
import mybatis.BoardVo;
import mybatis.FileUpload;

@Controller //얘때문에 BoardController 가 controller 역할을 하는것이다
public class BoardController {
	//두겟이나 두포스트라는 개념이 없다 / 대신에 메서드를 내맘대로 만드는 것이다
	
	BoardMybatisDao dao;
	
	public BoardController(BoardMybatisDao dao) {//생성자를 통해서Dao를 넘겨받는게 편하겠다.
		//this.dao = new BoardMybatisDao();  -->  sring을 배우지 않았다면 당연이 이 코드가 만들어 져야한다
		this.dao = dao;//스프링의 환경성정 bean에 등록되면서 constructor로 되서
	}
	
	@RequestMapping(value = "/select.brd", method = {RequestMethod.GET,RequestMethod.POST}) //어느때 얘를 쓸것인가 에대한 어노태이션 // "/select.brd"가 들어왔는데 get이거나 post로 들어오든 무조건 실행하라
	public ModelAndView select(HttpServletRequest req) {//데이터와 뷰  //이전에는 서블렛을 디스페처서블렛으로 포워딩을 햇다면 얘는 모델앤뷰를 사용해서 리퀘스트를 받아서 리퀘스트에 담아서 리턴하는것임
		// HttpServletRequest 이런 타입이 들어오면 자동으로 di 가 byType에의한 자동으로 주입되게(autowire) 하고있는게 spring이다 
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		if(req.getParameter("nowPage")==null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("p",p);
		mv.addObject("list",list);//데이터를 심을때 / 이 애들은 request 영역을 타고 나간다 따라서 ${list}를 바로 사용 할수 있다. //req.setAttribute("list",list) 가 스프링에서는 이렇게 쓴다
		mv.setViewName("select");//위 오브젝트를 누구에게 넘기겠냐? / 그러면 뷰리졸브가 받고 url을 편집해줘서  index.jsp?inc=./board/select.jsp가 만들어 지는것이야~
		return mv;//이정보들은 request에 담긴다
	}
	
	@RequestMapping(value = "/view.brd" , method = {RequestMethod.POST})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = null;
		List<AttVo> attList = null;
		int serial = Integer.parseInt(req.getParameter("serial"));
		char v = 'v';
		
		vo = dao.view(serial, v);
		attList = dao.getAttList(serial);
		
		Page p = new Page();						//이런 반복되는 것은 메서드를 만들어서 간소화 ㄱ ㄱ
		p.setFindStr(req.getParameter("findStr"));
		if(req.getParameter("nowPage")==null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		
		mv.addObject("p",p);
		mv.addObject("vo",vo);
		mv.addObject("attList",attList);
		mv.setViewName("view");
		return mv;
	}
	@RequestMapping(value = "/insert.brd" , method = RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insert");
		return mv;
	}
//	@RequestMapping(value = "/insertR.brd" , method = RequestMethod.POST) 
//	public ModelAndView insertR(HttpServletRequest req,HttpServletResponse resp) { //오토와이어가 바이 타입으로 되있기때문에 오토와이어 자동주입 되서 req와 resp가 넘어오는것이다
//		ModelAndView mv = new ModelAndView();
//		String msg = "";
//		Page p = new Page();
//		//FileUpload
//		FileUpload fu = new FileUpload(req, resp);
//		HttpServletRequest newReq = fu.uploading();//enctype이 없는 req로 갈아주자
//		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
//		List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
//		msg = dao.insert(vo, attList);
//		
//		
//		
//		mv.addObject("p",newReq.getAttribute("p"));
//		mv.addObject("msg",msg);
//		mv.setViewName("result");
//		return mv;
//	}
	   @RequestMapping(value="/insertR.brd", method=RequestMethod.POST)
	   public ModelAndView insertR(HttpServletRequest req,HttpServletResponse resp) {
	      ModelAndView mv = new ModelAndView();
	      String msg = "";
	      //FileUpload
	      FileUpload fu = new FileUpload(req, resp);
	      HttpServletRequest newReq = fu.uploading();
	      BoardVo vo = (BoardVo)newReq.getAttribute("vo");
	      List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
	      msg = dao.insert(vo, attList);
	      
	      
	      
	      mv.addObject("p",newReq.getAttribute("p"));
	      mv.addObject("msg", msg);
	      mv.setViewName("result");
	      return mv;
	   }   
	@RequestMapping(value = "/modify.brd" , method = {RequestMethod.POST})
	public ModelAndView modify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int serial = Integer.parseInt(req.getParameter("serial"));
		
		BoardVo vo = dao.view(serial, 'm');
		
		List<AttVo> attList = dao.getAttList(serial);
		
		Page p = new Page();						//이런 반복되는 것은 메서드를 만들어서 간소화 ㄱ ㄱ
		p.setFindStr(req.getParameter("findStr"));
		if(req.getParameter("nowPage")==null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		
		mv.addObject("vo",vo);
		mv.addObject("attList",attList);
		mv.addObject("p",p);
		mv.setViewName("modify");
		return mv;
	}
	@RequestMapping(value = "/modifyR.brd" , method = {RequestMethod.POST})
	public ModelAndView update(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = null;
		List<AttVo> attList = null;
		List<AttVo> delList = null;
		Page p = null;
		
		FileUpload fu = new FileUpload(req, resp);
		fu.uploading();
		vo = (BoardVo)req.getAttribute("vo");
		attList = (List<AttVo>)req.getAttribute("attList");
		delList = (List<AttVo>)req.getAttribute("delList");
		String msg = dao.modify(vo, attList, delList);
		
		mv.addObject("msg",msg);
		mv.addObject("p",req.getAttribute("p"));
		mv.setViewName("result");
		return mv;
	}
	@RequestMapping(value = "/deleteR.brd" , method = {RequestMethod.POST})
	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = new BoardVo();
		int serial = Integer.parseInt(req.getParameter("serial"));
		String pwd = req.getParameter("pwd");
		vo.setSerial(serial);
		vo.setPwd(pwd);
		String msg = dao.delete(vo);
		System.out.println("msg = "+ msg);
		
		Page p = new Page();						//이런 반복되는 것은 메서드를 만들어서 간소화 ㄱ ㄱ
		p.setFindStr(req.getParameter("findStr"));
		if(req.getParameter("nowPage")==null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		
		mv.addObject("p",p);
		mv.addObject("msg",msg);
		mv.setViewName("result");
		return mv;
	}
	@RequestMapping(value = "/repl.brd" , method = {RequestMethod.POST})
	public ModelAndView repl() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("repl");
		return mv;
	}
	@RequestMapping(value = "/replR.brd" , method = {RequestMethod.POST})
	public ModelAndView replR(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = null;
		List<AttVo> attList = null;
		Page p = null;
		
		FileUpload fu = new FileUpload(req, resp);
		fu.uploading();
		vo = (BoardVo)req.getAttribute("vo");
		attList = (List<AttVo>)req.getAttribute("attList");
		p = (Page)req.getAttribute("p");
		String msg = dao.repl(vo, attList);
		
		mv.addObject("msg",msg);
		mv.addObject("p",p);
		mv.setViewName("result");
		return mv;
	}
	
}
