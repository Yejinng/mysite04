package com.bit2016.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD)
@Retention( RetentionPolicy.RUNTIME)
public @interface Auth {
	String role() default "user";
	boolean required() default false;
	
}
