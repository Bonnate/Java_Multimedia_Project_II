package main;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
	BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new JButton("Console"), BorderLayout.SOUTH);
		add(new JButton("Test.java"), BorderLayout.CENTER);
		add(new JButton("Package Explorer"), BorderLayout.WEST);
		setSize(600, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}
