package com.onlineExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Login extends JFrame implements ActionListener {
	private final JPanel panel = new JPanel();
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton cancelBtn, loginBtn;

	public Login() {
		setTitle("Login Page");
		getContentPane().setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 398);
		getContentPane().setLayout(null);
		panel.setBackground(new Color(60, 179, 113));
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 59, 384, 226);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel userlbl = new JLabel("UserName *");
		userlbl.setBounds(19, 55, 84, 35);
		panel.add(userlbl);
		userlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel passlbl = new JLabel("Password *");
		passlbl.setBounds(19, 131, 75, 35);
		panel.add(passlbl);
		passlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));

		userField = new JTextField();
		userField.setBounds(144, 56, 178, 35);
		panel.add(userField);
		userField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(144, 132, 178, 35);
		panel.add(passwordField);

		JCheckBox checkbox = new JCheckBox("Show Password");
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkbox.isSelected()) {
					passwordField.setEchoChar((char) 0);

				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		checkbox.setBounds(144, 174, 124, 23);
		panel.add(checkbox);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setBackground(new Color(60, 179, 113));

		JLabel lblNewLabel = new JLabel("Student Login Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 452, 37);
		getContentPane().add(lblNewLabel);

		JButton regbtn = new JButton("New Registration");
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
			}
		});
		regbtn.setBounds(20, 296, 165, 35);
		getContentPane().add(regbtn);
		regbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));

		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(this);
		cancelBtn.setBounds(195, 296, 104, 35);
		getContentPane().add(cancelBtn);
		cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));

		loginBtn = new JButton("Login");
		loginBtn.setBounds(309, 296, 96, 35);
		getContentPane().add(loginBtn);
		loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		loginBtn.addActionListener(this);
		setVisible(true);

	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = userField.getText();
		String password = passwordField.getText();

		OnlineExaminationSql checkLogin = new OnlineExaminationSql();
		boolean userPresent = checkLogin.isUserPresent(userName, password);

		userField.setText("");
		passwordField.setText("");
		userField.requestFocus();

		if (userPresent && e.getSource() == loginBtn) {
			JOptionPane.showMessageDialog(loginBtn, "successfully login-In", "Congratulation !",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			OnlineTest ot = new OnlineTest();
			ot.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(loginBtn, "Failed to Log-In", "OOPS !", JOptionPane.OK_OPTION);

		}
		if (e.getSource() == cancelBtn) {
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}
