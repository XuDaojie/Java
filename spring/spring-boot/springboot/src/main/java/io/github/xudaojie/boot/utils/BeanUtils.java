package io.github.xudaojie.boot.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xdj
 * @date 2018/9/17
 */
public class BeanUtils {

    private static final Map<String, BeanCopier> sBeanCopierMap = new ConcurrentHashMap<>();

    public static void copy(Object source, Object target) {
        String key = source.getClass() + ":" + target.getClass();
        BeanCopier copier = sBeanCopierMap.get(key);
        if (copier == null) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            sBeanCopierMap.put(key, copier);
        } else {
            copier = sBeanCopierMap.get(key);
        }
        copier.copy(source, target, null);
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }
}
