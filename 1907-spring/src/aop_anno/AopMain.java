package aop_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
	
	public AopMain() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/aop_anno/aop.xml");
		
		Dao dao = (Dao)ac.getBean("member");//직관적으로 member를 가져옴
		dao.select();
		dao.delete();
		dao.modify();
		dao.insert();
		dao.view();
	}
	public static void main(String[] args) {
		new AopMain();
	}

}
