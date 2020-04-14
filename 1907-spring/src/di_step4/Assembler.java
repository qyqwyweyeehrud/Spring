package di_step4;

public class Assembler {
	private DB db;
	public Assembler(DB db) {
		this.db = db;
	}
	
	public DB getDb() {
		return db;
	}
}
