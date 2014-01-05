package sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class to hold the background image
 * 
 * @author Joel
 */
public class Background extends Sprite {

    private BufferedImage image;

    /**
     *
     * @param x images x coordinate
     * @param y images y coordinate
     * @param height image height
     * @param width image width
     */
    public Background(int x, int y, int height, int width) {
        super(x, y, height, width);
        setImage("/resources/bg_img.png");
    }

    /**
     * Set the background image
     * @param path  file path to the image
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
