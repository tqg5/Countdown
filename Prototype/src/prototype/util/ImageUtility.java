/**
 * 
 */
/**
 * @author joe.buza
 *
 */
package prototype.util;

import java.awt.*;

public final class ImageUtility
{

	//TODO: what is it be initialized in the constructor
	public ImageUtility()
	{
		
	}
	
	public static BufferedImage resizeImage(final Image image, int width, int height)
	{
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
 
        return bufferedImage;
    }
	
	//TODO: how to set up a place to store images and how to retrieve them
	public ArrayList<Image> getAllImagesFromDatabase()
	{
		
	}
	
	//TODO: discuss how we are going to implement this
	public Image getTheme(String themeName)
	{
		
	}
	
}