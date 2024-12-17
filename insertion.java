package createdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
			
			String sql="insert into details(name,email,password)values(?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter name");
			pmst.setString(1, scr.next());
			System.out.println("enter email");
			pmst.setString(2, scr.next());
			System.out.println("enter password");
			pmst.setString(3, scr.next());
			int i=pmst.executeUpdate();
			if(i > 0) {
				System.out.println("successfull created");
			}
			else {
				System.out.println("error");
			}
			pmst.close();
			conn.close();
			scr.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
