package me.rbrickis.idekgame.framework.renderer.objects;

import lombok.Getter;
import me.rbrickis.idekgame.framework.renderer.Model;

/**
 * Created by Ryan on 6/19/2015
 * <p>
 * Project: IdekGame
 */
public abstract class AbstractModel implements Model {
    /**
     * The ID of the vertex array object
     */
    @Getter private int vaoID;

    /**
     * The amount of vertices
     */
    @Getter private int vertextCount;

    public AbstractModel(int vaoID, int vertextCount) {
        this.vaoID = vaoID;
        this.vertextCount = vertextCount;
    }

}
