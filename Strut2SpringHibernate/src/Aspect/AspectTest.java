package Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author JiHongwei
 * 
 */
public class AspectTest {

	public void doBefore(JoinPoint jp) {
		System.out.println("before advice.");
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("after returning advice...");
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around advice.");
		
		Object[] args = pjp.getArgs();
		String method = pjp.getSignature().getName();
		Object target = pjp.getTarget();

		Object result = pjp.proceed();

		System.out.println("" + method + "\n" + args[0] + "\n"
				+ target + "\n" + result);
		
		return result;
	}

	public void doThrow(JoinPoint jp, Throwable e) {
		System.out.println("");
	}

}
