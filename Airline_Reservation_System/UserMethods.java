package jdbc_methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbUtil.JobSearchData;
import domain.*;



public class UserMethods {
	
	public void addUser(User user){
		
		int rowsAffected, generatedKey;
		String createUsersql=("insert into jobseeker_detail(id,firstname,lastname,dob,email,address,skill,qualification,ph_no,password) values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?)");
		try(Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement createUserStmt = dbConn.prepareStatement(createUsersql, PreparedStatement.RETURN_GENERATED_KEYS)) {
		    createUserStmt.setInt(1, user.getId());
			createUserStmt.setString(2, user.getFirstName());
			createUserStmt.setString(3, user.getLastName());
			createUserStmt.setDate(4, user.getDob());
			createUserStmt.setString(5, user.getEmail());
			createUserStmt.setString(6, user.getAddress());
			createUserStmt.setString(7, user.getSkill());
			createUserStmt.setString(8, user.getQualification());
			createUserStmt.setString(9, user.getph_no());
			createUserStmt.setString(10, user.getPassword());
			
			rowsAffected = createUserStmt.executeUpdate();
			
			ResultSet rs= createUserStmt.getGeneratedKeys();
	    	if (rs != null && rs.next()) {
	    		generatedKey =rs.getInt(1);
	    		user.setId(generatedKey);
	        }
			if (rowsAffected != 1) {
				dbConn.rollback();
			} 
			
			dbConn.commit();
		} catch (SQLException ex) {
			dbConn.rollback();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			}
	}

	public void updateUser(User user){
		
		int rowsAffected;
		String updateUsersql=("update jobseeker_detail set firstname=?, lastname=?,dob=?,email=?,address=?,skill=?,qualification=?,ph_no=?,password=? " +
                "where id=?");
		try(Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement updateUserStmt = dbConn.prepareStatement(updateUsersql)) {
				updateUserStmt.setString(1, user.getFirstName());
				updateUserStmt.setString(2, user.getLastName());
				updateUserStmt.setDate(3, user.getDob());
				updateUserStmt.setString(4, user.getEmail());
				updateUserStmt.setString(5, user.getAddress());
				updateUserStmt.setString(6, user.getSkill());
				updateUserStmt.setString(7, user.getQualification());
				updateUserStmt.setString(8, user.getph_no());
				updateUserStmt.setString(9, user.getPassword());
				
				rowsAffected = updateUserStmt.executeUpdate();
				if (rowsAffected != 1) {
					dbConn.rollback();
				} 
				
				dbConn.commit();
			} catch (SQLException ex) {
				dbConn.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	 public void deleteUser(int userId) {
		 //jobsearchdata.setupDataSource();
			int rowsAffected;
			String deleteUsersql = ("delete from users where id=?");
			try(Connection dbConn =  JobSearchData.getConnection()) {
				dbConn.setAutoCommit(false);

				try (PreparedStatement deleteUserStmt = dbConn.prepareStatement(deleteUsersql)) {
					deleteUserStmt.setInt(1, userId);
					deleteUserStmt.executeUpdate();
					
					rowsAffected = deleteUserStmt.executeUpdate();
					if (rowsAffected != 1) {
						dbConn.rollback();
					} 
					
					dbConn.commit();
				} catch (SQLException ex) {
					dbConn.rollback();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					}
			}

			

		 
	 }
		
	
	
	


				
			
			

		
	
	





