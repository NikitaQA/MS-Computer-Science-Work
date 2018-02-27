package jdbc_methods;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dbUtil.JobSearchData;
import domain.*;

public class SearchingMethods {
	public static void main(String[] args) throws ParseException {
		
		JobSearchData.setupDataSource();
		
		Employer employer = new Employer(111,"Google","San Jose","employer@google.com","pwd111","1234567889");
		Employer employer1 = new Employer(222,"Yahoo","New York","employer@yahoo.com","pwd222","1234554589");
		
		EmployerMethods empMethods = new EmployerMethods();
		empMethods.addEmployer(employer);
		empMethods.addEmployer(employer1);
		
		System.out.println("Employer added: "+ employer);

		System.out.println("Employer added: "+ employer1);
		
		Vacancy vacancy =new Vacancy(101,"Chicago","Java",2,"S/W developer ","MS",111);
		Vacancy vacancy1 =new Vacancy(102,"New York","Networking",2,"Quality Aanalyst","MS",222);
		
	    vacancy.setEmp_id(employer.getId());
		VacancyMethods vacmethod=new VacancyMethods();
		vacmethod.addVacancy(vacancy);
		vacancy1.setEmp_id(employer1.getId());
		vacmethod.addVacancy(vacancy1);
		
		System.out.println("\nVacancy added: " +vacancy );		
		System.out.println("Vacancy added: " +vacancy1 );
		
	/*	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date myDate = formatter.parse(calender.getTime());
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());*/

		//db.insert_date(sqlDate)
		
		 Calendar calendar = Calendar.getInstance();
	     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		
		User user=new User(100,"Nikita","Patil",startDate,"123@gmail.com","San jose","Java","MS","1231231234","nik123");
		UserMethods usermethod=new UserMethods();
		usermethod.addUser(user);
		System.out.println("\nUser added:" +user);
		
		empMethods.deleteEmployer(employer.getId());
		System.out.println("\nEmployer deleted: " +employer);
		System.out.println("Vacancy deleted: " +vacancy); 
		
	    try {
	    	JobSearchData.shutdownDataSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}

