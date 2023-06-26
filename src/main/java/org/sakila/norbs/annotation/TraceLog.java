package org.sakila.norbs.annotation;


import org.sakila.norbs.enums.TraceOptId;
import org.sakila.norbs.enums.TraceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceLog {
    TraceType value() default TraceType.NONE;

    TraceOptId optId() default TraceOptId.None;
}
