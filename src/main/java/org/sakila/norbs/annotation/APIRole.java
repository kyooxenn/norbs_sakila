package org.sakila.norbs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface APIRole {
    /** 管理员 */
    int ADMIN = 0b0001;
    /** 营运商(总代) */
    int COMPANY = 0b0010;
    /** 代理 */
    int AGENT = 0b0100;
    /** 用户 */
    int PLAYER = 0b1000;

    int NOT_PLAYER = ADMIN | COMPANY | AGENT;

    int value() default 0;
}