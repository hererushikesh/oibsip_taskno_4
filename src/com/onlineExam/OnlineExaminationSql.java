package com.onlineExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OnlineExaminationSql {
	private static String DB_URL = "jdbc:mysql://localhost/onlineExamination";
	private static String USER = "root";
	private static String PASS = "admin";
	private static final String SQL_INSERT = "INSERT INTO registration"
			+ "(fname, lname, phone, email,pass,age) VALUES (?,?,?,?,?,?)";

	private static final String SQL_SELECT = "SELECT * From registration where email=? and pass=?";

	public static void insertDataIntoRegistrationTable(String fname, String lname, String email, String pass, int age,
			long phone) {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);

			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setLong(3, phone);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, pass);
			preparedStatement.setInt(6, age);
			int row = preparedStatement.executeUpdate();
			System.out.println("record inserted");

		} catch (SQLException e) {
			System.out.println("exception occirred" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isUserPresent(String userEnteredemail, String userEnteredpassword) {
		try {

			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);

			preparedStatement.setString(1, userEnteredemail);
			preparedStatement.setString(2, userEnteredpassword);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
