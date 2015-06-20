package me.rbrickis.idekgame;

import me.rbrickis.idekgame.framework.registry.GameRegistry;
import me.rbrickis.idekgame.framework.registry.RegistrationException;
import org.lwjgl.LWJGLException;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
public class Main {

    public static void main(String... args) throws LWJGLException {
        try {
            GameRegistry.registerGame(IdekGame.class);
        } catch (RegistrationException e) {
            e.printStackTrace();
        }

        GameRegistry.startGame("Idek");

    }
}
