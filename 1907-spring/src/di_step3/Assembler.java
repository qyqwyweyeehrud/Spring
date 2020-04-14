package di_step3;

//사용될 객체를 비즈니스 로직이 있는 클래스 에서 작업하지 않고 외부에 둠으로 주요한 비즈니스 로직을 보호하는 역할
//특정 main에서 사용될 객체가있는데 비즈니스 로직을 최대한 오픈하지않도록 하기위해 유해도로를 파는 작업
public class Assembler {
	DB db;
	public MsSql MsSqlgetDb() {
		return new MsSql();
	}
	public MySql MySqlgetDb() {
		return new MySql();
	}
	public Oracle OraclegetDb() {
		return new Oracle();
	}
}
