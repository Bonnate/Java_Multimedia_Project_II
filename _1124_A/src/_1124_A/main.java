package _1124_A;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {

	private JLabel mImageLabel;
	private ImageIcon[] mImages;
	private int mImageIndex;

	public static void main(String[] args) {
		main frame = new main();
		frame.setVisible(true);
	}

	public main() {
		this.setSize(500, 300);
		this.setTitle("GUI Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel bottom = new JPanel();

		mImageLabel = new JLabel();
		mImageLabel.setHorizontalAlignment(JLabel.CENTER);
		mImages = new ImageIcon[4];

		for (int i = 0; i < 4; ++i) {
			mImages[i] = new ImageIcon("./Assets/image" + (i+1) + ".png");
		}
		mImageIndex = 0;
		mImageLabel.setIcon(mImages[mImageIndex]);

		JButton btnL = new JButton(new ImageIcon("./Assets/button_Left.png"));
		JButton btnR = new JButton(new ImageIcon("./Assets/button_Right.png"));

		bottom.add(btnL);
		bottom.add(btnR);

		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshImageIndex(false);
				
				mImageLabel.setIcon(mImages[mImageIndex]);
			}
		});
		
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RefreshImageIndex(true);
				
				mImageLabel.setIcon(mImages[mImageIndex]);
			}
		});

		this.add(mImageLabel, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

		this.setVisible(true);

	}
	
	private void RefreshImageIndex(boolean isForward)
	{
		mImageIndex += isForward ? +1 : -1;

		if(mImageIndex == 4)  mImageIndex = 0;
		if(mImageIndex == -1) mImageIndex = 3;
	}
}