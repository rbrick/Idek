package me.rbrickis.idekgame;

import lombok.Getter;
import me.rbrickis.idekgame.framework.Game;
import me.rbrickis.idekgame.framework.annotations.GameInfo;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
@GameInfo(
        name = "Idek",
        version = "0.0.1",
        author = "rbrick"
)
public class IdekGame implements Game {

    @Getter
    private final int DISPLAY_WIDTH = 1280;

    @Getter
    private final int DISPLAY_HEIGHT = 720;

    public void onCreate() {

        ContextAttribs attribs = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Hello World!");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
    }

    public void onTick() {
        Display.sync(120);
        Display.update();
    }

    public void onDestroy() {
        Display.destroy();
    }
}
