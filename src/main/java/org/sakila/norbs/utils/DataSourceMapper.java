package org.sakila.norbs.utils;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated
public @interface DataSourceMapper {
    String dataSource() default "";

    boolean isSwitchDataSource() default false;

    String startTime() default "";
}
