package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionTest implements MyColl {

	List<String> list;
	Map<String,String> map;
	Set<String> set;
	Properties prop;
	
	@Override
	public void setList(List<String> list) {
		// TODO Auto-generated method stub
		this.list = list;
		
	}

	@Override
	public void setMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		this.map = map;
	}

	@Override
	public void setSet(Set<String> set) {
		// TODO Auto-generated method stub
		this.set = set;
	}

	@Override
	public void setProp(Properties prop) {
		// TODO Auto-generated method stub
		this.prop =   prop;
	}

}
