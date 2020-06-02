package io.github.xudaojie.springframework.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 打印所有参数
 */
public class PrintArgsAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method m, Object[] args, Object target) throws Throwable {
        System.out.println("MethodBeforeAdvice");
        StringBuilder argsStr = new StringBuilder();

        if (args != null && args.length > 0) {
            for (Object arg : args) {
                argsStr.append(arg).append(",");
            }
        }

        System.out.println("MethodBeforeAdvice: [class] ->" + target.getClass().getName()
            + " [method] ->" + m.getName()
            + " [args] ->" + argsStr + " ");

        setTag(target);
    }

    /**
     * 如果类包含setTag(String)则执行setTag("aop")
     * 在test中通过此字段判断已进行代理
     */
    private void setTag(Object target) {
        try {
            Method setTag = target.getClass().getMethod("setTag", String.class);
            setTag.invoke(target, "aop");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
