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
	
	public ArrayList<Image> getAllImagesFromDatabase()
	{
		
	}
	
	public Image getTheme(String themeName)
	{
		
	}
	
}