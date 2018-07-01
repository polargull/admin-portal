package com.polar.admin.portal.util;

/**
 * Created by fuyuanpu on 2018/6/18.
 */
public class UncheckedException extends RuntimeException {
    public UncheckedException() {
    }

    public UncheckedException(String msg) {
        super(msg);
    }

    public UncheckedException(Throwable inner) {
        super(inner);
    }

    public UncheckedException(String msg, Throwable inner) {
        super(msg, inner);
    }
}
