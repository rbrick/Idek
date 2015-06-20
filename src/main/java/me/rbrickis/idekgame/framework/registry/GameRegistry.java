package me.rbrickis.idekgame.framework.registry;

import com.google.common.collect.Maps;
import me.rbrickis.idekgame.framework.AbstractGame;
import me.rbrickis.idekgame.framework.Game;
import me.rbrickis.idekgame.framework.annotations.GameInfo;
import me.rbrickis.idekgame.framework.loop.GameLoop;
import me.rbrickis.idekgame.framework.loop.Loop;

import java.util.Map;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
public class GameRegistry {

    private static Loop gameLoop = new GameLoop();

    private static Map<String, AbstractGame> games = Maps.newHashMap();

    public static Game registerGame(Class<? extends Game> game) throws RegistrationException {
        if (!game.isAnnotationPresent(GameInfo.class)) {
            throw new RegistrationException("Game does not have a @GameInfo annotation");
        }

        GameInfo info = game.getAnnotation(GameInfo.class);

        try {
            Game g = game.newInstance();
            AbstractGame impl = new AbstractGame(g, info);
            games.put(info.name(), impl);

            return g;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // something went wrong
        return null;
    }


    public static void startGame(String name) {
        Game game = getGame(name);

        if (game != null) {
          gameLoop.submit(game);
        }

    }

    public static Game getGame(String name) {
        Game game = null;

        for (Map.Entry<String, AbstractGame> e : games.entrySet()) {
            if (e.getKey().equalsIgnoreCase(name)) {
                game = e.getValue();
            }
        }
        return game;
    }


}
