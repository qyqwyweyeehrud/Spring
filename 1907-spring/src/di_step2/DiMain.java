package di_step2;

public class DiMain {
	
	public DiMain(DB db){//여기서 DB는 인터페이스
		db.getIrum();
	}
	
	public static void main(String[] args) {
		MsSql sql = new MsSql();
		Oracle sql2 = new Oracle();
		MySql sql3 = new MySql();
		//여기서 오라클로 쓸거라고 고객이 그러면 그냥 위 객체만 바꿔주면 되는것이다!!
		new DiMain(sql3);
		
		//어셈블러 라는 외부조립기를 가지는것이 step3이다  --> di_step3으로 ㄱㄱ!!
		
	}

}
