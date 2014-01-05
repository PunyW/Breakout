package sprites;

import java.awt.Rectangle;

/**
 *
 * @author Joel
 */
public interface Collideable {

    /**
     *
     * @return Returns a new Rectangle with the Sprites attributes
     */
    Rectangle getCollisionRect();
}
