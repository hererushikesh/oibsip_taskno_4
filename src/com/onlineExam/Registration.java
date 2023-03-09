package com.onlineExam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Registration extends JFrame implements ActionListener {

	JLabel heading;
	JLabel firstName, lastName, phoneNumber, email, password, age_lbl;
	JTextField txtFirstName, txtLastName, txtPhoneNumber, txtEmail, txtAge;
	JPasswordField txtPassword;

	JButton register, cancel, back;

	Font myFont = new Font("TimesNewRoman", Font.PLAIN, 15);

	public Registration() {
		getContentPane().setBackground(new Color(128, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		heading = new JLabel();
		heading.setForeground(new Color(255, 255, 255));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setText("Welcome to Registration");
		heading.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
		heading.setBounds(10, 10, 430, 40);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 250, 154));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("Registration"));
		panel.setBounds(20, 50, 420, 400);
		getContentPane().add(panel);

		firstName = new JLabel();
		firstName.setHorizontalAlignment(SwingConstants.CENTER);
		firstName.setForeground(new Color(255, 255, 255));
		firstName.setText("First Name");
		firstName.setFont(myFont);
		firstName.setBounds(20, 50, 90, 30);
		panel.add(firstName);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(180, 50, 170, 30);
		panel.add(txtFirstName);

		lastName = new JLabel();
		lastName.setHorizontalAlignment(SwingConstants.CENTER);
		lastName.setForeground(new Color(255, 255, 255));
		lastName.setText("Last Name");
		lastName.setFont(myFont);
		lastName.setBounds(20, 90, 90, 30);
		panel.add(lastName);

		txtLastName = new JTextField();
		txtLastName.setBounds(180, 90, 170, 30);
		panel.add(txtLastName);

		phoneNumber = new JLabel();
		phoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumber.setForeground(new Color(255, 255, 255));
		phoneNumber.setText("Phone Number");
		phoneNumber.setFont(myFont);
		phoneNumber.setBounds(20, 130, 110, 30);
		panel.add(phoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(180, 130, 170, 30);
		panel.add(txtPhoneNumber);

		email = new JLabel();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setForeground(new Color(255, 255, 255));
		email.setText("Email-Id");
		email.setFont(myFont);
		email.setBounds(20, 168, 70, 30);
		panel.add(email);

		txtEmail = new JTextField();
		txtEmail.setBounds(180, 170, 170, 30);
		panel.add(txtEmail);

		password = new JLabel();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setForeground(Color.WHITE);
		password.setText("Password");
		password.setFont(myFont);
		password.setBounds(20, 210, 90, 30);
		panel.add(password);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 210, 170, 30);
		panel.add(txtPassword);

		age_lbl = new JLabel();
		age_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		age_lbl.setForeground(Color.WHITE);
		age_lbl.setText("Age");
		age_lbl.setFont(myFont);
		age_lbl.setBounds(30, 248, 52, 30);
		panel.add(age_lbl);

		txtAge = new JTextField();
		txtAge.setBounds(180, 250, 170, 30);
		panel.add(txtAge);

		register = new JButton("Register");
		register.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
		register.setBounds(10, 320, 110, 30);
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				OnlineExaminationSql addData = new OnlineExaminationSql();
				String fname = txtFirstName.getText();
				String lname = txtLastName.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();//
				int age = Integer.parseInt(txtAge.getText());
				long phone = Long.parseLong(txtPhoneNumber.getText());
				
				if (txtFirstName.getText().trim().isEmpty() && txtLastName.getText().trim().isEmpty()
						&& txtEmail.getText().trim().isEmpty() && txtPassword.getText().trim().isEmpty()
						&& txtAge.getText().trim().isEmpty() && txtPhoneNumber.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Null Fields Not Allowed");
				}

				else if (fname != null && lname != null && email != null && password != null && age != 0) {
					addData.insertDataIntoRegistrationTable(fname, lname, email, password, age, phone);
					JOptionPane.showMessageDialog(null, "SuccessFully Registered");
				}
				 txtFirstName.setText(""); txtLastName.setText(""); txtEmail.setText("");
				 txtPassword.setText(""); txtAge.setText(""); txtPhoneNumber.setText("");
				 txtFirstName.requestFocus();

			}

		});
		panel.add(register);

		back = new JButton("Go to Login");
		back.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
		back.setBounds(140, 320, 135, 30);
		back.addActionListener(this);
		panel.add(back);

		cancel = new JButton("Cancel");
		cancel.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
		cancel.setBounds(295, 320, 100, 30);
		cancel.addActionListener(this);
		panel.add(cancel);

		getContentPane().add(heading);
		setTitle("Registration Form");
		setSize(470, 506);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			Login log = new Login();
			log.setVisible(true);
			this.dispose();
		} else if (e.getSource() == cancel) {
			this.dispose();
		}

	}
}
