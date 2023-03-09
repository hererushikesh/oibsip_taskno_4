package com.onlineExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class OnlineTest extends JFrame implements ActionListener {

	JLabel l;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	OnlineTest() {
		super();
		l = new JLabel();
		getContentPane().add(l);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			getContentPane().add(jb[i]);
			bg.add(jb[i]);
		}
		b1 = new JButton("Next");
		b2 = new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		getContentPane().add(b1);
		getContentPane().add(b2);
		set();
		l.setBounds(30, 40,550, 20);
		jb[0].setBounds(50, 80, 200, 20);
		jb[1].setBounds(50, 110, 200, 20);
		jb[2].setBounds(50, 140, 200, 20);
		jb[3].setBounds(50, 170, 200, 20);
		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocation(250, 100);
		setSize(600, 350);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			getContentPane().add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			// System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this, "correct ans=" + count);
			System.exit(0);
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText("Que1: Who invented Java Programming?");
			jb[0].setText("Guido van Rossum");
			jb[1].setText("James Gosling");
			jb[2].setText("Dennis Ritchie");
			jb[3].setText("Bjarne Stroustrup");
		}
		if (current == 1) {
			l.setText("Que2: . Which component is used to compile,"+"debug and execute the java programs?");
			jb[0].setText("JRE");
			jb[1].setText("JIT");
			jb[2].setText("JDK");
			jb[3].setText("JVM");
		}
		if (current == 2) {
			l.setText("Que3: Which one of the following is not a Java feature?");
			jb[0].setText("Object-oriented");
			jb[1].setText("Use of pointers");
			jb[2].setText("Portable");
			jb[3].setText("Dynamic and Extensible");
		}
		if (current == 3) {
			l.setText("Que4:  Which of these cannot be used for a variable name in Java?");
			jb[0].setText("identifires & keywords");
			jb[1].setText("identifires");
			jb[2].setText("keywords");
			jb[3].setText("none of the above");
		}
		if (current == 4) {
			l.setText("Que5: What is the extension of java code files?");
			jb[0].setText(".js");
			jb[1].setText(".txt");
			jb[2].setText(".class");
			jb[3].setText(".java");
		}
		if (current == 5) {
			l.setText("Que6: Which one among these is not a keyword?");
			jb[0].setText("class");
			jb[1].setText("int");
			jb[2].setText("get");
			jb[3].setText("if");
		}
		if (current == 6) {
			l.setText("Que7:  Which of the following is not an OOPS concept in Java? ");
			jb[0].setText("Polymorphism");
			jb[1].setText("Inheritance");
			jb[2].setText("Compilation");
			jb[3].setText("Encapsulation");
		}
		if (current == 7) {
			l.setText("Que8: Which exception is thrown when java is out of memory?");
			jb[0].setText("MemoryError");
			jb[1].setText("OutOfMemoryError");
			jb[2].setText("MemoryOutOfBoundsException");
			jb[3].setText("MemoryFullException");
		}
		if (current == 8) {
			l.setText("Que9: Which of these are selection statements in Java?");
			jb[0].setText("break");
			jb[1].setText("continue");
			jb[2].setText("for()");
			jb[3].setText("if()");
		}
		if (current == 9) {
			l.setText("Que10:  Which of these keywords is used to define interfaces in Java?");
			jb[0].setText("Intf");
			jb[1].setText("intf");
			jb[2].setText("interface");
			jb[3].setText("Interface");
		}
		l.setBounds(30, 40, 550, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (jb[1].isSelected());
		if (current == 1)
			return (jb[2].isSelected());
		if (current == 2)
			return (jb[1].isSelected());
		if (current == 3)
			return (jb[2].isSelected());
		if (current == 4)
			return (jb[3].isSelected());
		if (current == 5)
			return (jb[2].isSelected());
		if (current == 6)
			return (jb[2].isSelected());
		if (current == 7)
			return (jb[1].isSelected());
		if (current == 8)
			return (jb[3].isSelected());
		if (current == 9)
			return (jb[2].isSelected());
		return false;
	}
}
