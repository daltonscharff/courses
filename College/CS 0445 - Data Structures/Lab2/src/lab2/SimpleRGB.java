
public class SimpleRGB
{
	// TO DO: Instant Variables
        private int width;
        private int height;
        private int[][] red;
        private int[][] green;
        private int[][] blue;

	public SimpleRGB(int aWidth, int aHeight)
	{
		// TO DO: Constructor
            width = aWidth;
            height = aHeight;
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
	}
	
	/**
	 * Gets the width of this image.
	 * @return the width of this image.
	 */
	public int getWidth()
	{
		// TO DO
            return width;
	}
	
	/**
	 * Gets the height of this image.
	 * @return the height of this image.
	 */
	public int getHeight()
	{
		// TO DO
            return height;
	}
	
	/**
	 * Sets the red value at coordinate (x,y) to aRed.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aRed the red value (0 - 255)
	 */
	public void setRed(int x, int y, int aRed)
	{
		// TO DO
            red[x][y] = aRed;
	}

	/**
	 * Sets the green value at coordinate (x,y) to aGreen.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aGreen the green value (0 - 255)
	 */
	public void setGreen(int x, int y, int aGreen)
	{
		// TO DO
            green[x][y] = aGreen;
	}

	/**
	 * Sets the blue value at coordinate (x,y) to aBlue.
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @param aBlue the blue value (0 - 255)
	 */
	public void setBlue(int x, int y, int aBlue)
	{
		// TO DO
            blue[x][y] = aBlue;
	}
	
	/**
	 * Gets the red value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of red at coordinate (x,y). 
	 */
	public int getRed(int x, int y)
	{
		// TO DO
            return red[x][y];
	}

	/**
	 * Gets the green value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of green at coordinate (x,y). 
	 */
	public int getGreen(int x, int y)
	{
		// TO DO
            return green[x][y];
	}
	
	/**
	 * Gets the blue value at coordinate (x,y).
	 * @param x the x coordinate of this image.
	 * @param y the y coordinate of this image.
	 * @return the value of blue at coordinate (x,y). 
	 */
	public int getBlue(int x, int y)
	{
		// TO DO
            return blue[x][y];
	}
	
	/**
	 * Get the NEW image containing only the red color.
	 * The red values of this new image should be exactly
	 * the same as red value of this image. The green and
	 * blue values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the red color of this image.
	 */
	public SimpleRGB getRedImage()
	{
		// TO DO
            SimpleRGB redPic = new SimpleRGB(width,height);
            for(int x = 0; x < redPic.width; x++){
                for(int y = 0; y < redPic.height; y++){
                    redPic.setRed(x, y, this.getRed(x,y));
                    redPic.setGreen(x, y, 0);
                    redPic.setBlue(x, y, 0);
                }
            }
            return redPic;
	}
	
	/**
	 * Get the NEW image containing only the green color.
	 * The green values of this new image should be exactly
	 * the same as green value of this image. The red and
	 * blue values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the green color of this image.
	 */
	public SimpleRGB getGreenImage()
	{
		// TO DO
            SimpleRGB greenPic = new SimpleRGB(width,height);
            for(int x = 0; x < greenPic.width; x++){
                for(int y = 0; y < greenPic.height; y++){
                    greenPic.setRed(x, y, 0);
                    greenPic.setGreen(x, y, this.getGreen(x,y));
                    greenPic.setBlue(x, y, 0);
                }
            }
            return greenPic;
	}
	
	/**
	 * Get the NEW image containing only the blue color.
	 * The blue values of this new image should be exactly
	 * the same as blue value of this image. The red and
	 * green values of this new image should be 0s.
	 * @return the NEW image (SimpleRGB) containing only
	 * the blue color of this image.
	 */
	public SimpleRGB getBlueImage()
	{
		// TO DO
            SimpleRGB bluePic = new SimpleRGB(width,height);
            for(int x = 0; x < bluePic.width; x++){
                for(int y = 0; y < bluePic.height; y++){
                    bluePic.setRed(x, y, 0);
                    bluePic.setGreen(x, y, 0);
                    bluePic.setBlue(x, y, this.getBlue(x,y));
                }
            }
            return bluePic;
	}
	
	/**
	 * Get the NEW image representing the greyscale of this
	 * image. The grey colors are colors that the red, green
	 * and blue value are exactly the same. To convert an RGB
	 * image into a greyscale image, use the following formula
	 * to calculate the new value.
	 *    (0.21 * red) + (0.72 * green) + (0.07 * blue)
	 * For example, suppose the (R,G,B) value of this image at
	 * coordinate (10,20) are (10,100,200), since
	 *    (0.21 * 10) + (0.72 * 100) + (0.07 * 200) = 88
	 * the (R,G,B) value of the new greyscale image at (10,20)
	 * should be (88,88,88).
	 * @return the NEW image representing the greyscale of this
	 * image.
	 */
	public SimpleRGB getGreyImage()
	{
		// TO DO
            SimpleRGB greyPic = new SimpleRGB(width,height);
            for(int x = 0; x < greyPic.width; x++){
                for(int y = 0; y < greyPic.height; y++){
                    greyPic.setRed(x, y, (int)(this.getRed(x,y)*.21+this.getGreen(x,y)*.72+this.getBlue(x,y)*.07));
                    greyPic.setGreen(x, y, (int)(this.getRed(x,y)*.21+this.getGreen(x,y)*.72+this.getBlue(x,y)*.07));
                    greyPic.setBlue(x, y, (int)(this.getRed(x,y)*.21+this.getGreen(x,y)*.72+this.getBlue(x,y)*.07));
                }
            }
//            greyPic.setRed(width, height, (int)((red*0.21)+(green*0.72)+(blue*0.07)));
//            greyPic.setGreen(width, height, (int)((red*0.21)+(green*0.72)+(blue*0.07)));
//            greyPic.setBlue(width, height, (int)((red*0.21)+(green*0.72)+(blue*0.07)));
            return greyPic;
            
	}
}
