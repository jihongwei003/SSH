import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author JiHongwei
 */
public class AspectTest {

	public void doBefore(JoinPoint jp) {
		System.out.println("before advice.");
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("after returning advice.");
	}

	//如果掉用的函数有返回值，则一定要加Object类型的返回值！！！
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around advice.");

		Object[] args = pjp.getArgs();
		String method = pjp.getSignature().getName();
		Object target = pjp.getTarget();

		//将这个值返回！！！
		Object result = pjp.proceed();

		System.out.println("" + method + "\n" + args[0] + "\n"
				+ target + "\n" + result);
		
		System.out.println("around advice out.");
		
		return result;
	}

	public void doThrow(JoinPoint jp, Throwable e) {
		System.out.println("");
	}

}
