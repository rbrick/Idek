package me.rbrickis.idekgame.framework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 *
 * Marks a class as a Game
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GameInfo {
    String name();

    String version();

    String author() default "";
}
