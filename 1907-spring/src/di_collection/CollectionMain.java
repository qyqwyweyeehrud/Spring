package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionMain {
	AbstractApplicationContext factory;
	CollectionTest coll;
	public CollectionMain() {
		//list
		this.factory = new GenericXmlApplicationContext("di_collection/collection.xml");
		this.coll = (CollectionTest) factory.getBean("list");
		List<String> list = coll.list;
		System.out.println("<주소 목록>");
		for(String address : list) {
			System.out.println(address.toString());
		}
		factory.close();
		
		
		//set
		this.factory = new GenericXmlApplicationContext("di_collection/collection.xml");
		this.coll = (CollectionTest) factory.getBean("set");
		Set<String> set = coll.set;
		System.out.println("<주소 목록>");
		for(String address : set) {
			System.out.println(address.toString());
		}
		factory.close();
		
		
		//map
		this.factory = new GenericXmlApplicationContext("di_collection/collection.xml");
		this.coll = (CollectionTest) factory.getBean("map");
		Map<String,String> map = coll.map;
		System.out.println("<주소 목록>");
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + "의 주소 : " + map.get(key));
		}
		factory.close();
		
		
		//prop
		this.factory = new GenericXmlApplicationContext("di_collection/collection.xml");
		this.coll = (CollectionTest) factory.getBean("prop");
		Properties addList = coll.prop;
		Set<Object> propKeys = addList.keySet();
		System.out.println("<주소 목록>");
		for(Object oKey : propKeys) {
			System.out.println(oKey+"의 주소 : " + addList.get(oKey));
		}
		factory.close();
	}
	
	public static void main(String[] args) {
		new CollectionMain();
	}
}
