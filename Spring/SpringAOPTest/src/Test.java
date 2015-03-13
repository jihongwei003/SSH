import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author JiHongwei
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// aspectBusiness代理bean是由Spring自动生成的
		BusinessInter business = (BusinessInter) context
				.getBean("aspectBusiness");
		business.addStudent("吉宏伟");
	}

}
