package main;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class MyActionListener extends JFrame{
	MyActionListener(){
	setTitle("버튼 눌러 텍스트 보여주기"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel mainP = new JPanel();
	mainP.setLayout(new GridLayout(2, 1));
	
	JPanel btnP = new JPanel();
	btnP.setLayout(new GridLayout(1, 3));
	JButton btn1 = new JButton("Hannam");
	JButton btn2 = new JButton("University");
	JButton btn3 = new JButton("Student");
	btnP.add(btn1);
	btnP.add(btn2);
	btnP.add(btn3);
	
	JLabel lbl = new JLabel();
    lbl.setBounds(30, 200, 274, 50);
    lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬

    // 버튼이 눌렸을때
    btn1.addActionListener(event -> {
        lbl.setText("Hannam");
    });
    
    btn2.addActionListener(event -> {
        lbl.setText("University");
    });
    
    btn3.addActionListener(event -> {
        lbl.setText("Student");
    });
    mainP.add(btnP);
    mainP.add(lbl);

	add(mainP);
	setSize(300, 200); setVisible(true);
	}

	public static void main(String[] args) {
		new MyActionListener();
	}
}