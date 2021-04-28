import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author XuDaojie
 * @since 2021/4/22
 */
public class Reflect {


    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Class<?> kclass = Class.forName("Reflect");
        Method method = kclass.getMethod("target", int.class);
        for (int i = 0; i < 17; i++) {
            method.invoke(null, i);
        }
    }
}
