package com.binsoft.springbootaction.springbootaction.common.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DataSource {
    String name() default "";
}
