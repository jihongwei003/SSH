import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author JiHongwei
 * 
 *         先执行before通知，然后执行around的前处理，执行切点方法，再执行return处理。最后执行around的后处理。经过测试，
 *         知道spring 处理顺序是按照xml配置顺序依次处理通知，以队列的方式存放前通知，以压栈的方式存放后通知。所以是前通知依次执行，
 *         后通知到切入点执行完之后，从栈里在后进先出的形式把后通知执行。
 */
public class AspectTest {

	public void doBefore(JoinPoint jp) {
		System.out.println("这是before advice.");
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("这是after returning advice.");
	}

	public void doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是around advice.");

		//getThis()：返回代理对象
		
		// 调用方法的参数
		Object[] args = pjp.getArgs();
		// 调用的方法名
		String method = pjp.getSignature().getName();
		// 获取目标对象
		Object target = pjp.getTarget();

		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		Object result = pjp.proceed();

		System.out.println("输出：\n方法名：" + method + "\n参数：" + args[0] + "\n目标："
				+ target + "\n返回值：" + result);
	}

	public void doThrow(JoinPoint jp, Throwable e) {
		System.out.println("出错了");
	}

}
