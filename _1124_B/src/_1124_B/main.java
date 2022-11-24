package _1124_B;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class main extends JFrame {

	JTextField tf = new JTextField(20);
	JTextField nameTf = new JTextField(20);
	JTextArea ta;
	JRadioButton[] radio = new JRadioButton[3];
	int id = 20190001;
	String[] text = { "==선택==", "교수", "직원", "학생" };
	String type;
	String name;
	JPanel lowerP;
	private JTextArea mTextArea;
	JComboBox nameCombo;

	main() {
		setTitle("사용자 등록 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);

		JPanel contentP = new JPanel();
		contentP.setLayout(new GridLayout(2, 1));

		JPanel upperP = new JPanel();
		upperP.setLayout(new GridLayout(1, 2));

		JPanel leftP = new JPanel();
		leftP.setLayout(new GridLayout(3, 1));

		leftP.add(new JLabel("학번"));
		leftP.add(new JLabel("타입"));
		leftP.add(new JLabel("이름"));

		upperP.add(leftP);

		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(3, 1));

		tf.setEditable(false);
		tf.setText(Integer.toString(id));
		rightP.add(tf);
		
		nameCombo = new JComboBox();
		for (int i = 0; i < text.length; i++)
			nameCombo.addItem(text[i]);
		rightP.add(nameCombo);
		
		rightP.add(nameTf);

		upperP.add(rightP);
		contentP.add(upperP);

		lowerP = new JPanel();
		lowerP.setLayout(new GridLayout(2, 1));

		//버튼
		JButton addB = new JButton(new ImageIcon("./Assets/button.png"));
		
		addB.addActionListener(new MyActionListener());
		lowerP.add(addB);

		mTextArea = new JTextArea();
		lowerP.add(new JScrollPane( mTextArea));

		contentP.add(lowerP, BorderLayout.SOUTH);
		lowerP.setBounds(0, 0, 500, 100);
		lowerP.setSize(500, 200);
		add(contentP);
		setSize(500, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new main();
	}

	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			
			if(nameCombo.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null, "콤보박스를 선택하세요", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(nameTf.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "이름을 입력하세요", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PrintScreen();
			ResetInputField();
		}
	}
	
	private void ResetInputField()
	{
		nameTf.setText("");
		nameCombo.setSelectedIndex(0);
	}
	
	private void PrintScreen()
	{
		mTextArea.setText(mTextArea.getText() + "\n" + "id: " + tf.getText() + ", type: " + nameCombo.getItemAt(nameCombo.getSelectedIndex()) + ", name: " + nameTf.getText());
//		ta = new JTextArea("id: " + id + ", type: " + type + ", name" + name, 5, 30);
		String beforeText =  tf.getText();
		int refreshNum =  Integer.parseInt(beforeText);
		++refreshNum;
		tf.setText(Integer.toString(refreshNum));
		
		
	}
}
