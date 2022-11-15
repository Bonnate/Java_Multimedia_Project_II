package _1117_D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {
	private JPanel contentPane;
	private JPanel panelUp;
	private JPanel panelDown;
	
	private JButton buttonLeft;
	private JButton buttonCenter;
	private JButton buttonRight;
	
	private JPanel panelLeft;
	private JPanel panelCenter;
	private JPanel panelRight;
	
	private JLabel labelNewLabel_1;
	private JButton buttonNewButton;
	private JButton buttonNewButton_1;
	private JButton buttonNewButton_2;
	
	private final static String PANEL_LEFT = "버튼3개";
	private final static String PANEL_CENTER = "이전연습문제";
	private final static String PANEL_RIGHT = "글자";

	public static void main(String[] args) {
		main frame = new main();
		frame.setVisible(true);
	}

	public main() {
		setTitle("CardLayout 사용하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelUp = new JPanel();
		contentPane.add(panelUp, BorderLayout.NORTH);
		buttonLeft = new JButton(PANEL_LEFT);
		buttonLeft.addActionListener(new MyActionListener());
		panelUp.add(buttonLeft);
		
		buttonCenter = new JButton(PANEL_CENTER);
		buttonCenter.addActionListener(new MyActionListener());
		panelUp.add(buttonCenter);
		
		buttonRight = new JButton(PANEL_RIGHT);
		buttonRight.addActionListener(new MyActionListener());
		panelUp.add(buttonRight);
		
		panelDown = new JPanel();
		contentPane.add(panelDown, BorderLayout.CENTER);
		panelDown.setLayout(new CardLayout());
		
		panelLeft = new JPanel();
		buttonNewButton = new JButton("button1");
		panelLeft.add(buttonNewButton);
		buttonNewButton_1 = new JButton("button2");
		panelLeft.add(buttonNewButton_1);
		buttonNewButton_2 = new JButton("button3");
		panelLeft.add(buttonNewButton_2);
		panelDown.add(panelLeft, PANEL_LEFT);
		
		panelCenter = new JPanel();
		_1117C center = new _1117C();
		panelCenter.add(center.getPanel());
		panelDown.add(panelCenter, PANEL_CENTER);

		
		panelRight = new JPanel();
		labelNewLabel_1 = new JLabel("오른쪽 입니다");
		panelRight.add(labelNewLabel_1);
		panelDown.add(panelRight, PANEL_RIGHT);
	}

	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			CardLayout cl = (CardLayout) (panelDown.getLayout());
			cl.show(panelDown, button.getText());
		}
	}
}