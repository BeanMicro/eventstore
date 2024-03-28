package io.beandev.eventstore.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // This annotation applies to class declarations.
@Retention(RetentionPolicy.RUNTIME) // This annotation will be available at runtime.
public @interface Entity {
    String value() default ""; // A member with a default value
}