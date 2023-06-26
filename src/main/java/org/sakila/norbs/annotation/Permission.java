package org.sakila.norbs.annotation;

import org.sakila.norbs.enums.AuthModule;
import org.sakila.norbs.enums.Privilege;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    Privilege privilege();

    AuthModule[] modules();
}
