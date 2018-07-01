package com.polar.admin.portal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fuyuanpu on 2018/6/18.
 */
public class Enums {
    private static final Map<Class<?>, Map<Integer, Object>> caches = new ConcurrentHashMap();

    private Enums() {
    }

    public static <T extends EnumValueSupport> T valueOf(Class<T> enumClass, int value) {
        return valueOf(enumClass, value, true);
    }

    public static <T extends EnumValueSupport> T valueOf(Class<T> enumClass, int value, boolean throwIfUndefined) {
        Map<Integer, Object> map = getValues(enumClass);
        Object v = map.get(value);
        if (v == null) {
            if (throwIfUndefined) {
                throw Exceptions.undefinedEnum(enumClass, value);
            } else {
                return null;
            }
        } else {
            return (T) v;
        }
    }

    public static <T extends EnumValueSupport> boolean isDefined(Class<T> enumClass, int value) {
        Map<Integer, Object> map = getValues(enumClass);
        return map.containsKey(value);
    }

    public static <T extends EnumDisplayNameSupport & EnumValueSupport> String displayName(Class<T> enumClass, int value) {
        T e = valueOf(enumClass, value, false);
        return e != null ? e.displayName() : "";
    }

    private static <T extends EnumValueSupport> Map<Integer, Object> getValues(Class<T> enumClass) {
        if (!enumClass.isEnum()) {
            throw new IllegalArgumentException(enumClass + " is not enum type");
        } else {
            Map<Integer, Object> map = caches.get(enumClass);
            if (map == null) {
                map = new HashMap();
                EnumValueSupport[] var2 = enumClass.getEnumConstants();
                int var3 = var2.length;

                for (int var4 = 0; var4 < var3; ++var4) {
                    T v = (T) var2[var4];
                    map.put(v.value(), v);
                }

                caches.put(enumClass, map);
            }

            return map;
        }
    }
}
