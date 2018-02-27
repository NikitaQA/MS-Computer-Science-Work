package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import dbUtil.*;
import jdbc_methods.*;

   @WebServlet("/servlet/Page")
	public class Loginservlet extends HttpServlet {

	    public void service(HttpServletRequest request,  HttpServletResponse response) 
	           throws ServletException, IOException   
	    {
	     //  JobSearchData.setupDataSource();
	       PrintWriter out = response.getWriter();
	       String name = request.getParameter("name");
	       String password = request.getParameter("password");
	      	
	       Admin admin=new Admin(name,password);
	       
	       AdminMethods admethd=new AdminMethods();
	       admin=admethd.getAdminByName(name,password);//,password);
	       
	        
	       try{
	    	  // if(!admin.hasPasswd(password)){
	    	   if(admin==null){
	    		  // request.setAttribute("Error","Invalid Password");
	    		   response.sendError(401,"Invalid Username or Password" );
	    	   }
	    	   else
	    	   {
	    		   out.println("<html>");
		            out.println("<head><title>LogIn Confirmation</title></head>");
		            out.println("<body bgcolor=Cyan><h1><font color=Red><i><b>");
		            out.println("Welcome " + admin.getName() + "<BR></h1>");
		            out.println("<h2>You are Logged In with correct password <BR></h2>");  // + admin.getPassword()+ "");   
		            out.println("<h2>Your Admin_Id is " +admin.getId()  + "<BR></h2>");
		            out.println("</b></i></font></body></html>");
		       }
	       }catch(Exception ex)
	       {
	    	   request.setAttribute("Error","Invalid Password");
	    	  
	    	   out.println("<html>");
	            out.println("<head><title>LogIn Confirmation</title></head>");
	            out.println("<body bgcolor=Cyan><h1><font color=Red><i><b>");
	            out.println("Welcome " + admin.getName() + "<BR></h1>");
	            out.println("<h2>You are Logged In with password " + admin.getPassword()+ "</h2>");   
	            out.println("</b></i></font></body></html>");
	       }
	      /* try {
		    	JobSearchData.shutdownDataSource();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	*/	
	    }

	      

	}



