package Framework;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite 
{
	private Vector<ImageIcon> mImages;
	private JLabel mImageLabel;
	
	public Sprite()
	{
		mImages = new Vector<ImageIcon>();
		mImageLabel = new JLabel();
	}
	
	public void AddImage(String imagePath)
	{
		mImages.add(new ImageIcon(imagePath));
	}
	
	public void SetPosition()
	{
			
	}
}
