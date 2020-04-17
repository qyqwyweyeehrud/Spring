package aop_step3;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class Advisor implements MethodInterceptor{//aop꺼 임포트
	SimpleDateFormat logTime= new SimpleDateFormat("yyyy-MM-dd(E요일) hh:mm:ss:SS");
	
	
	
	//MethodInterceptor 상속받으면 invoke 재정의해야함
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {//aop.xml 의 .*select.* 들이 실행되기 전에 얘가 가로챔 
		
		//횡단적 관심사로 분리된 처리내용
		System.out.println(logTime.format(new Date()));//시간적
		
		Object o = invocation.proceed();//프록시에 의해서 호출된 메서드명을 실행해주는 명령어 / 이결과치가 오브젝트가 나오는데 이걸 반환해주면 됨
										//.*select.* 들 <--공간적
										//호출된 메서드를 실행 시켜주는 메서드
		
		System.out.println(logTime.format(new Date()));//시간적
		return o;
	}
	
}
