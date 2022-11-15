package _1177_B;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame {

	main() {
		setTitle("Multiple Layout Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentP = new JPanel();
		contentP.setLayout(new BorderLayout());
		
		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 2));
		contentP.add(topGrid, BorderLayout.CENTER);
		
		JPanel upperLeft = new JPanel();
		upperLeft.setLayout(new GridLayout(4, 1));
		upperLeft.setBackground(Color.YELLOW);
		upperLeft.add(new JLabel("Type ID", SwingConstants.CENTER));
		upperLeft.add(new JTextField(""));
		upperLeft.add(new JLabel("Type Password", SwingConstants.CENTER));
		upperLeft.add(new JTextField(""));
		topGrid.add(upperLeft);
		
		JPanel upperRight = new JPanel();
		upperRight.setLayout(new GridLayout(3, 1));
		upperRight.setBackground(Color.GREEN);
		upperRight.add(new JLabel("Please Check!!", SwingConstants.CENTER));
		upperRight.add(new JLabel("C# JCheckBox", SwingConstants.CENTER));
		upperRight.add(new JLabel("C++ JCheckBox", SwingConstants.CENTER));
		topGrid.add(upperRight);

		JPanel lowerP = new JPanel();
		JButton okB = new JButton("OK");
		okB.setPreferredSize(new Dimension(100, 30));
		lowerP.add(okB);
		contentP.add(lowerP, BorderLayout.SOUTH);
		add(contentP);
		setSize(600, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new main();
	}
}
