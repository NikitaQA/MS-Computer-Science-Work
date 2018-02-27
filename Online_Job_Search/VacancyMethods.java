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

public class VacancyMethods {
	public void addVacancy(Vacancy vacancy){
		//jobsearchdata.setupDataSource();
		int rowsAffected, generatedKey;
		String createVacancySql=("insert into vacancy (id,location,skill_required,no_of_seats,jobCategory,qualification,emp_id) values (?, ?, ?, ?, ? ,?,?)");
		try(Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement createVacancyStmt = dbConn.prepareStatement(createVacancySql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				createVacancyStmt.setInt(1, vacancy.getId());
				createVacancyStmt.setString(2, vacancy.getLocation());
				createVacancyStmt.setString(3, vacancy.getSkill_required());
				createVacancyStmt.setInt(4, vacancy.getNo_of_seats());
				createVacancyStmt.setString(5, vacancy.getJobCategory());
				createVacancyStmt.setString(6, vacancy.getQualification());               
				createVacancyStmt.setInt(7, vacancy.getEmp_id()); 
				//System.out.println("here");
				 rowsAffected = createVacancyStmt.executeUpdate();
				// System.out.println("here1");
					ResultSet rs= createVacancyStmt.getGeneratedKeys();
				//	System.out.println("here2");
					if (rs.next()) {
		        		generatedKey =rs.getInt(1);
		        		vacancy.setEmp_id(generatedKey);
		            }
					if (rowsAffected != 1) {
						dbConn.rollback();
					} 
					
					dbConn.commit();
					rs.close();
				} catch (SQLException ex) {
					System.out.println("SQLException => " + ex);
					dbConn.rollback();
					}
				} catch (SQLException ex) {
						ex.printStackTrace();
					}
		
	}
	public void updateVacancy(Vacancy vacancy){
		//jobsearchdata.setupDataSource();
		int rowsAffected;
		String updateVacancysql=("update vacancy set id=?, location=?, skill_required=?,no_of_seats=?,qualification=?,jobCategory=? " +
                "where emp_id=?");
		try(Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement updateVacancyStmt = dbConn.prepareStatement(updateVacancysql)) {
				updateVacancyStmt.setInt(1, vacancy.getId());
				updateVacancyStmt.setString(2, vacancy.getLocation());
				updateVacancyStmt.setString(3, vacancy.getSkill_required());
				updateVacancyStmt.setInt(4, vacancy.getNo_of_seats());
				updateVacancyStmt.setString(5, vacancy.getQualification());
				updateVacancyStmt.setString(6, vacancy.getJobCategory());
				
				rowsAffected = updateVacancyStmt.executeUpdate();
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
	 public int deleteVacancy(int id, Connection dbConn) throws SQLException {
	//	 jobsearchdata.setupDataSource();
			int rowsAffected=-1;
			String deleteVacancysql = ("delete from vacancy1 where empid=?");
			//try(Connection dbConn =  jobsearchdata.getConnection()) {
				dbConn.setAutoCommit(false);

				try (PreparedStatement deleteVacancyStmt = dbConn.prepareStatement(deleteVacancysql)) {
					deleteVacancyStmt.setInt(1, id);
				
					//deleteUserStmt.executeUpdate();
					
					rowsAffected = deleteVacancyStmt.executeUpdate();
					
					if (rowsAffected != 1) {
						dbConn.rollback();
					} 
					
					dbConn.commit();
				} catch (SQLException ex) {
					System.out.println("SQLException => " + ex);
					dbConn.rollback();
					//dbConn.rollback();
					//System.out.println("Unable to rollback changes");
					}
//				} catch (SQLException ex) {
//					ex.printStackTrace();
//					}
			return rowsAffected;
			}
	


	 }



					  

	        
	
	




