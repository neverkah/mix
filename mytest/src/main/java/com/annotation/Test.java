package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明Test注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Test {



}
