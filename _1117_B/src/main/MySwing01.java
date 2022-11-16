package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MySwing01 extends JFrame{
	MySwing01(){
	setTitle("Multiple Layout Example"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel contentP=new JPanel();
	contentP.setLayout(new BorderLayout());
	
	JPanel upperP = new JPanel();
	upperP.setLayout(new GridLayout(1, 2));
	
	JPanel leftP=new JPanel();
	leftP.setLayout(new GridLayout(4,1));
	leftP.setBackground(Color.YELLOW);
	
	leftP.add(new JLabel("Type ID", SwingConstants.CENTER));
	leftP.add(new JTextField(""));
	
	leftP.add(new JLabel("Type Password", SwingConstants.CENTER));
	leftP.add(new JTextField(""));
	
	upperP.add(leftP);
	
	JPanel rightP=new JPanel();
	rightP.setLayout(new GridLayout(3,1));
	rightP.setBackground(Color.GREEN);
	rightP.add(new JLabel("Plaese check!!", SwingConstants.CENTER));
	rightP.add(new JLabel("C# JCheckBox", SwingConstants.CENTER));
	rightP.add(new JLabel("C++ JCheckBox", SwingConstants.CENTER));
	
	upperP.add(rightP);
	contentP.add(upperP);
	
	JPanel lowerP=new JPanel(); 
	JButton okB=new JButton("OK");
	okB.setPreferredSize(new Dimension(100,30));
	lowerP.add(okB);
	contentP.add(lowerP, BorderLayout.SOUTH); 
	add(contentP);
	setSize(300, 200); setVisible(true);
	}

	public static void main(String[] args) {
		new MySwing01();
	}
}
