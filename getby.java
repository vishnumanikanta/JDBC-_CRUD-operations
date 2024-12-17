package createdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getby {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		
		try {
			
			Scanner scr=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter tablename");
			String sql="select * from "+scr.next()+ "where id =?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter id");
			pmst.setString(1, scr.next());
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				System.out.println("id :"+rs.getInt("id"));
				System.out.println("name :"+rs.getString("name"));
				System.out.println("email :"+rs.getString("email"));
				System.out.println("password :"+rs.getString("password"));
			}
			pmst.close();
			conn.close();
			scr.close();
		} catch (Exception e) {
		e.printStackTrace();
}}}

