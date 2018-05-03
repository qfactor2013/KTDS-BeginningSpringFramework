package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * Around Advice : Target�� �޼��尡 ����Ǳ�
 * ��(before) �� ��(after) ������ ȣ��Ǵ� Advice
 * AroundAdvice�� ProceedingJoinPoint�� proceed()�� ȣ���ؾ� �Ѵ�.
 */
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼����� signature ����
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println(signatureString + " ����");
		//Ÿ�� �޼����� argument ����
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(signatureString + " Argument :  " + arg);
		}
		
		
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð� 
		long start = System.currentTimeMillis();		
		try {
			//Ÿ���� �޼��� ȣ��
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
			   (finish - start) + " ms");
		}
	}
}
