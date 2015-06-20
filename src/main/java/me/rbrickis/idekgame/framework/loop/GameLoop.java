package me.rbrickis.idekgame.framework.loop;

import me.rbrickis.idekgame.framework.Game;
import org.lwjgl.opengl.Display;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
public class GameLoop implements Loop {

    ExecutorService gameExecutor = Executors.newSingleThreadExecutor();


    @Override
    public void submit(final Game game) {
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                game.onCreate();

                while (!Display.isCloseRequested()) {
                    game.onTick();
                }

                game.onDestroy();

            }
        };

        gameThread.start();

    }
}
