package aop_aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;


public class Advisor {
	SimpleDateFormat logTime= new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	
	//aop에서 선언한 메서드는 반드시 오브젝트 타입이여야한다
	public Object beforeMethod(JoinPoint point) {//여기서 invoke 작업을 JoinPoint가 작업해준다
		System.out.println(logTime.format(new Date()));
		return null;
	}
	
	
	
}
