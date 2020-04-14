package di_step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DiMain {

	
	public DiMain(DB db) {
		db.getIrum();
	}
	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/di_step4/assembler.xml");
		
		// DB db = ac.getBean("oracle",Oracle.class);
		//DB db = (Oracle)ac.getBean("oracle");						<--constructor-arg 를쓰면 이 코드가 19행으로 바뀐다
		
		//Assembler ass = ac.getBean("assemble",Assembler.class);
		Assembler ass = (Assembler) ac.getBean("assemble");// 		<--이렇게 바뀐다
		DB db = ass.getDb();
		DiMain dm = new DiMain(db);
		
		
		
		//메서드를 통합 DI 주입
		MemberVo vo = (MemberVo)ac.getBean("mVo");
		System.out.println(vo.getmId());
		System.out.println(vo.getmName());
		
		
		//bean 등록과 dI 예
		//MyConnection mc = (MyConnection)ac.getBean("MyConnection"); <--이건 알아서 setter싱행됨
		MemberDao dao = (MemberDao)ac.getBean("dao");
		
	}

}
