package di_anno;

import org.springframework.beans.factory.annotation.Autowired;

public class AnnoDao {
	DB abc;
	
	@Autowired
	public void setAbc(DB abc) {
		this.abc = abc;
		abc.getIrum();
	}
	
	
}
