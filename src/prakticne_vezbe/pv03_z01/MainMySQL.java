package prakticne_vezbe.pv03_z01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {

	public static void main(String[] args) {

		String host 	= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user 	= MySQL_Access.USER;
		String passwd 	= MySQL_Access.PASS;
		
		Connection conn = null;
		CallableStatement cstmt  = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" 
					+ database + "?" + "user=" + user + "&password=" + passwd);
			
			// povezivanje nastavnika sa predmetom
			cstmt = conn.prepareCall("{call povezi (?, ?, ?, ?)}");
			cstmt.setString(1, "Petar");
			cstmt.setString(2, "Peric");
			cstmt.setString(3, "Analiza 1");
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.executeUpdate();
			
			System.out.println("Status : " + cstmt.getInt(4));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				cstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
