package jdbc_methods;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dbUtil.JobSearchData;
import domain.Admin;
import org.apache.commons.dbcp.BasicDataSource;

public class AdminMethods {
	public Admin getAdminByName(String name,String password){//,String password){
		
		Admin admin=new Admin(name,password);
		int rowsAffected, generatedKey;
		String createAdminsql=("select admin_id,name,password from admin where name=? and password=?");
		try (Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement createAdminStmt = dbConn.prepareStatement(
					createAdminsql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				//createAdminStmt.setInt(1, admin.getId());
				createAdminStmt.setString(1, name);
				createAdminStmt.setString(2, password);
				ResultSet rs = createAdminStmt.executeQuery();
				if (rs.next()) {
					admin.setId(rs.getInt("admin_id"));
					admin.setName(rs.getString("name"));
					admin.setPassword(rs.getString("password"));
				} else {
					System.out.println("User not found");
					admin = null;
					
					
				}
			}
		} catch (SQLException e) {
		//	System.out.println(e);
	        	e.printStackTrace();
	    }

			return admin;
			
		}
}

					
				

	

