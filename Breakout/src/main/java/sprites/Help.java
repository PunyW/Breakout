package sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Sprite that holds the help image
 * 
 * @author Joel
 */
public class Help extends Sprite {

    private BufferedImage image;

    /**
     *
     * @param x images x coordinate
     * @param y images y coordinate
     * @param height image height
     * @param width image width
     */
    public Help(int x, int y, int height, int width) {
        super(x, y, height, width);
        setImage("/resources/help.png");
    }

    /**
     * Set the background image
     *
     * @param path file path to the image
     */
    public final void setImage(String path) {
        try {
            image = ImageIO.read(Background.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }

}
