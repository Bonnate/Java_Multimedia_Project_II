package Framework;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite {
	private Vector<ImageIcon> mImages;
	private JLabel mImageLabel;
	private GameObject mParent;

	private float mOriginAnimTimer;
	private float mCurrentAnimTimer;
	private int mCurrentImageIndex;

	public JLabel GetLabel() {
		return mImageLabel;
	}

	public Sprite(GameObject parent) {
		this.mParent = parent;
		this.mImages = new Vector<ImageIcon>();
		this.mImageLabel = new JLabel();

		// 인덱스 설정
		mCurrentImageIndex = 0;
		
		mCurrentAnimTimer = mOriginAnimTimer = -1f;
	}

	public void SetAnimDelay(float delayTime)
	{
		mCurrentAnimTimer = mOriginAnimTimer = delayTime;
	}
	
	public void AddImage(String imagePath) {
		mImages.add(new ImageIcon(imagePath));
//		System.out.println(mImages.get(mImages.size() - 1).getIconWidth() + " " + mImages.get(mImages.size() - 1).getIconHeight());

		// 최초인경우에만 해당 이미지로 세팅
		if (mImages.size() == 1) {
			mImageLabel.setBounds((int)mParent.GetPosition().x, (int)mParent.GetPosition().y, mImages.get(0).getIconWidth(), mImages.get(0).getIconHeight());
			mImageLabel.setIcon(mImages.get(0));
		}
	}

	public void Draw() {
		if (mOriginAnimTimer != -1) {
			mCurrentAnimTimer -= Time.DeltaTime();

			if (mCurrentAnimTimer < 0f) {
				mCurrentImageIndex = mCurrentImageIndex >= mImages.size() - 1 ? 0 : mCurrentImageIndex + 1;
				mImageLabel.setIcon(mImages.get(mCurrentImageIndex));
				
				mCurrentAnimTimer = mOriginAnimTimer;
			}
		}

		mImageLabel.setBounds((int) mParent.GetPosition().x, (int) mParent.GetPosition().y, mImages.get(mCurrentImageIndex).getIconWidth(), mImages.get(mCurrentImageIndex).getIconHeight());
	}
	
	public int GetImageLength()
	{
		return mImages.size();
	}
}
