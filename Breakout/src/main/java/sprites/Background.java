package sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Joel
 */
public class Background extends Sprite {
    private BufferedImage image;
    
    /**
     * 
     * @param x         images x coordinate
     * @param y         images y coordinate
     * @param height    image height
     * @param width     image width
     */
    public Background(int x, int y, int height, int width) {
        super(x, y, height, width);
        setImage();
    }
    
    /**
     * Assign image to our sprite
     */
    public final void setImage() {
        try {
            image = ImageIO.read(Background.class.getResource("/resources/bg_img.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public BufferedImage getImage() {
        return image;
    }

}
