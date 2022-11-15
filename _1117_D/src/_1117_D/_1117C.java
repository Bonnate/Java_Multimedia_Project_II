package _1117_D;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class _1117C extends JFrame {

	JLabel label;
	JPanel grid;

	_1117C() {
		setTitle("버튼 눌러 텍스트 보여주기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		grid = new JPanel();
		grid.setLayout(new GridLayout(2, 1));

		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 3));

		JButton button1 = new JButton("Hannam");
		JButton button2 = new JButton("University");
		JButton button3 = new JButton("Student");

		topGrid.add(button1);
		topGrid.add(button2);
		topGrid.add(button3);

		grid.add(topGrid);

		label = new JLabel("Press Button", SwingConstants.CENTER);
		grid.add(label);

		add(grid);
		setSize(300, 150);
		setVisible(true);

		MyActionListener listener = new MyActionListener();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		
	}
	
	public JPanel getPanel()
	{
		return grid;
	}

	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			label.setText(((JButton)e.getSource()).getText());
		}
	}
}
