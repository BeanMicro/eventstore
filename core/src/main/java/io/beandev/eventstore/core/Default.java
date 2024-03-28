package io.beandev.eventstore.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // This annotation applies to attribute declarations.
@Retention(RetentionPolicy.RUNTIME) // This annotation will be available at runtime.
public @interface Default {
    String value() default ""; // A member with a default value
}