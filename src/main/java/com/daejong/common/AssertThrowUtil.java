package com.daejong.common;

/**
 * Created by DaeJong on 2017/4/7.
 */
public class AssertThrowUtil {


    public static String assertNotBlank(String message, String target) {
        if(target == null || target.trim().length() == 0) {
            throw new ThisSystemException(message);
        }
        return target;
    }

    public static String $(String message, String target) {
        return assertNotBlank(message, target);
    }

    public static void assertNotNull(String message, Object o) {
        if(null == o) {
            throw new ThisSystemException(message);
        }
    }

    public static void assertNull(String message, Object o) {
        if(null != o) {
            throw new ThisSystemException(message);
        }
    }

    public static void assertEquals(String message, Object o1, Object o2) {
        if(!o1.equals(o2)) {
            throw new ThisSystemException(message);
        }
    }
}
