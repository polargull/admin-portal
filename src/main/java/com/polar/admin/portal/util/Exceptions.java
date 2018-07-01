package com.polar.admin.portal.util;

import com.google.common.base.Strings;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * Created by fuyuanpu on 2018/6/18.
 */
public class Exceptions {
    private Exceptions() {
    }

    public static FaultException notFoundObject(String objectName, Object objectId) {
        return new NotFoundObjectException(objectName, objectId);
    }

    public static FaultException notImpl(String methodName) {
        return new FaultException("Not implemented " + methodName);
    }

    public static FaultException undefinedEnum(Class enumClass, Object value) {
        return new FaultException(String.format("Undefined enum %s: %s", enumClass.getSimpleName(), value));
    }

    public static FaultException undefinedEnum(String enumName, Object value) {
        return new FaultException(String.format("Undefined enum %s: %s", enumName, value));
    }

    public static RuntimeException error(String message, Object... args) {
        return new RuntimeException(MessageFormat.format(message, args));
    }

    public static UncheckedException asUnchecked(Throwable ex) {
        return new UncheckedException(ex);
    }

    public static String getStackTrace(Throwable e) {
        Objects.requireNonNull(e, "arg e");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

    public static String getMessage(Throwable e) {
        Objects.requireNonNull(e, "arg e");
        String msg = e.getMessage();
        if (Strings.isNullOrEmpty(msg)) {
            msg = e.getClass().getName();
        }

        return msg;
    }
}
