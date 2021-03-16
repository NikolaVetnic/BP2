package prakticne_vezbe.pv03_z02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {

	public static void main(String[] args) {

		String host 	= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user 	= MySQL_Access.USER;
		String passwd 	= MySQL_Access.PASS;
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" 
					+ database + "?" + "user=" + user + "&password=" + passwd);
			
			System.out.print("Unesi neki upit: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String query = br.readLine();
			
			stmt = conn.createStatement();
			rSet = stmt.executeQuery(query);
			
			ResultSetMetaData rsmd = rSet.getMetaData();
			
			int brKolona = rsmd.getColumnCount();
			
			for (int i = 1; i <= brKolona; i++)
				System.out.print(rsmd.getColumnName(i) + " [" + rsmd.getColumnTypeName(i) + "] ");
			System.out.println();
			
			System.out.println();
			
			while (rSet.next()) {
				for (int i = 1; i <= brKolona; i++) {
					if (rsmd.getColumnTypeName(i).equals("INT"))
						System.out.printf("%5d ", rSet.getInt(i));
					else if (rsmd.getColumnTypeName(i).equals("VARCHAR"))
						System.out.printf("%20s ", rSet.getString(i));
					else if (rsmd.getColumnTypeName(i).equals("DATE"))
						System.out.printf("%10s", rSet.getDate(i));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				rSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
