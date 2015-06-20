package me.rbrickis.idekgame.framework;

import me.rbrickis.idekgame.framework.annotations.GameInfo;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
public class AbstractGame implements Game {

    private Game parent;
    private GameInfo info;

    public AbstractGame(Game parent, GameInfo info) {
        this.parent = parent;
        this.info = info;
    }

    public void onCreate() {
        parent.onCreate();
    }

    public void onTick() {
         parent.onTick();
    }

    public void onDestroy() {
        parent.onDestroy();
    }

    public String getName() {
        return info.name();
    }

    public String getVersion() {
        return info.version();
    }

    public String getAuthor() {
        return info.author();
    }
}
