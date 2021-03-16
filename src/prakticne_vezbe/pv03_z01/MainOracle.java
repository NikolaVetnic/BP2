package prakticne_vezbe.pv03_z01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class MainOracle {

	public static void main(String[] args) {
		
		Connection conn = null;
		CallableStatement cstmt  = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			
			// povezivanje nastavnika sa predmetom
			cstmt = conn.prepareCall("{? = call povezi (?, ?, ?)}");
			cstmt.setString(2, "Mina");
			cstmt.setString(3, "Minic");
			cstmt.setString(4, "Analiza 1");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.executeUpdate();
			
			System.out.println("Status : " + cstmt.getInt(1));
			
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
