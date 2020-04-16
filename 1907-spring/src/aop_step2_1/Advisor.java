package aop_step2_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Advisor {
	SimpleDateFormat logTime= new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	Dao member;
	
	
	public void before() { // advice(시간적 개념)
		System.out.println(logTime.format(new Date()));
		member.select();
	}
	public void after() {
		member.insert();
		System.out.println(logTime.format(new Date()));
	}
	public void arround() {
		System.out.println(logTime.format(new Date()));
		member.delete();
		System.out.println(logTime.format(new Date()));
	}
	public Dao getMember() {
		return member;
	}
	public void setMember(Dao member) {
		this.member = member;
	}
 // 당신의 파란펜 내가 가져간다 - 괴도민수-
	
}
