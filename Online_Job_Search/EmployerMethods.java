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

import java.util.ArrayList;

public class EmployerMethods {
	public void addEmployer(Employer employer){
		//jobsearchdata.setupDataSource();
		int rowsAffected, generatedKey;
		String createEmployersql="INSERT INTO employer(id,companyName,address,email,password,ph_no) VALUES (?, ?, ?, ?, ?, ?);";
 
		try(Connection dbConn = JobSearchData.getConnection()) {
			dbConn.setAutoCommit(false);
			try (PreparedStatement createEmployerStmt = dbConn.prepareStatement(createEmployersql, PreparedStatement.RETURN_GENERATED_KEYS)) {
		     createEmployerStmt.setInt(1, employer.getId());
			 createEmployerStmt.setString(2, employer.getCompanyName());
			 createEmployerStmt.setString(3, employer.getAddress());
	         createEmployerStmt.setString(4, employer.getEmail());
	         createEmployerStmt.setString(5, employer.getPassword());
	         createEmployerStmt.setString(6, employer.getph_no());
	         //System.out.println("here1");
	         //System.out.println("insertUser statement => " + createEmployerStmt.toString());
	         
	         rowsAffected = createEmployerStmt.executeUpdate();
	        
	         //createEmployerStmt.
	        // System.out.println("here");
				ResultSet rs= createEmployerStmt.getGeneratedKeys();
				
	        	if (rs.next()) {
	        		generatedKey =rs.getInt(1);
	        		System.out.println("EmployeeIDGenerated: "+generatedKey);
	        		employer.setId(generatedKey);
	            }
				if (rowsAffected != 1) {
					dbConn.rollback();
				} 
				
				dbConn.commit();
				rs.close();
				
			} catch (SQLException ex) {
				//System.out.println("SQLException => " + ex);  //prints exception
				//System.out.println("here2");
				dbConn.rollback();
				//throw new EmployerMethods(EmployerMethods.STMT_FAILED);
				}
			} catch (SQLException ex) {
					ex.printStackTrace();
				}
}

	//Transaction occurs at the delete operation
	
	public void deleteEmployer(int id) {
		 //jobsearchdata.setupDataSource();
		    
			int rowsAffected;
			int x;
			String deleteEmployersql = ("delete from employer where id=?");
		//	System.out.println("here3");
			try(Connection dbConn =  JobSearchData.getConnection()) {
				dbConn.setAutoCommit(false);
				//System.out.println("here4");	
				VacancyMethods vacmethod=new VacancyMethods();
			    
				//x=vacmethod.deleteVacancy(id,dbConn);
			//	System.out.println("here5");
				//System.out.println(x);
				try (PreparedStatement deleteEmployerStmt = dbConn.prepareStatement(deleteEmployersql)) {
					deleteEmployerStmt.setInt(1, id);
				//	System.out.println("here6" + id);
					deleteEmployerStmt.executeUpdate();
				//	System.out.println("here7");
					rowsAffected = deleteEmployerStmt.executeUpdate();
					if (rowsAffected != 1 ) {              //&& x != 1.
					//	System.out.println("here8 "+ rowsAffected);
						//dbConn.rollback();
					} 
				//	System.out.println("here9");
					dbConn.commit();
				} catch (SQLException ex) {
					System.out.println("SQL Exception=====>"+ex);
					dbConn.rollback();
					}
				} catch (SQLException ex) {
					System.out.println("SQL Exception=====>"+ex);
					ex.printStackTrace();
					}
			}

			

		
	}
	

			 
			 
			 
			
		
	

		
	




