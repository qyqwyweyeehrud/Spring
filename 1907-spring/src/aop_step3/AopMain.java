package aop_step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	
	public AopMain() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/aop_step3/aop.xml");
		//우리가 만든코드를 보면 advisor라는 빈을 실행시킨건데 
//		Advisor ad = (Advisor)ac.getBean("advisor");
//		ad.before();
//		ad.after();
//		ad.arround();
		
		//인터페이스를 적용시켜주는 것이다 지금현제 memberDao로 해야 하지만 우리는  자식클래스이기때문에 여기서 그냥 Dao로 가져다 쓰는것이다
		Dao dao = (Dao)ac.getBean("proxy");
		dao.select();//반환타입은 object타입이다//인터셉터를 시켜서 어드바이저를 호출하고 인보크를 싱행해서 시간을 출력하고 그리고 select를 실행시켜준다
					//셀렉트가 list<BoardVo> 타입이라면 invoke의 반환값은  List<BoardVo> 타입일것이다(기본은 object형)
	}
	public static void main(String[] args) {
		new AopMain();
	}

}
