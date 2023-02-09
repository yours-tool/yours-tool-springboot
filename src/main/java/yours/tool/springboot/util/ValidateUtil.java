package yours.tool.springboot.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @Author wbh
 * @Description 检验工具类
 * @Date 2021/6/17 16:10
 * @Version: v1.0
 */
public class ValidateUtil {

    public ValidateUtil(){ }

    /**
     * 是否为空或0
     * @param integer 对象
     * @return
     */
    public static boolean isEmptyZero(Integer integer) {
        return  integer == null || 0==integer;
    }

    /**
     * 是否不为空或0
     * @param integer 对象
     * @return
     */
    public static boolean isNotEmptyZero(Integer integer) {
        return  !isEmptyZero(integer);
    }

    /**
     * 是否为空或0
     * @param l 对象
     * @return
     */
    public static boolean isEmptyZero(Long l) {
        return  l == null || 0==l;
    }

    /**
     * 是否不为空或0
     * @param l 对象
     * @return
     */
    public static boolean isNotEmptyZero(Long l) {
        return  !isEmptyZero(l);
    }

    /**
     * 是否为空
     * @param str 对象
     * @return
     */
    public static boolean isEmpty(String str) {
        return  str == null || str.isBlank();
    }

    /**
     * 是否不为空
     * @param str 对象
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return  !isEmpty(str);
    }

    /**
     * 是否为空
     * @param integer 对象
     * @return
     */
    public static boolean isEmpty(Integer integer) {
        return  integer == null ;
    }

    /**
     * 是否不为空
     * @param integer 对象
     * @return
     */
    public static boolean isNotEmpty(Integer integer) {
        return  !isEmpty(integer);
    }

    /**
     * 是否为空
     * @param l 对象
     * @return
     */
    public static boolean isEmpty(Long l) {
        return  l == null ;
    }

    /**
     * 是否不为空
     * @param l 对象
     * @return
     */
    public static boolean isNotEmpty(Long l) {
        return  !isEmpty(l);
    }

    /**
     * 是否为空
     * @param collection 对象
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 是否不为空
     * @param collection 对象
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 是否为空
     * @param map 对象
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 是否不为空
     * @param map 对象
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && isNotEmpty(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
