package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * Around Advice : Target의 메서드가 실행되기
 * 전(before) 과 후(after) 시점에 호출되는 Advice
 * AroundAdvice는 ProceedingJoinPoint의 proceed()를 호출해야 한다.
 */
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println(signatureString + " 시작");
		//타겟 메서드의 argument 정보
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(signatureString + " Argument :  " + arg);
		}
		
		
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();		
		try {
			//타겟의 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
