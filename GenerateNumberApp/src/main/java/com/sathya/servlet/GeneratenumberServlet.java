package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GeneratenumberServlet")
public class GeneratenumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int num1=Integer.parseInt(request.getParameter("num1"));
			int num2=Integer.parseInt(request.getParameter("num2"));
			String operation=request.getParameter("operation");
			int result=0,i,j;
			ArrayList<Integer>al=new ArrayList<Integer>();
			switch(operation) {
			
			case "even" : 
				for(i=num1;i<=num2;i++)
				{
					if(i%2==0)
						al.add(i);
					
				}
			           break;
			
			case "odd" : 
				for(i=num1;i<=num2;i++)
				{
					if(i%2!=0)
						al.add(i);
				}
	                    break;
	        
			case "prime" : int flag;
			for(i=num1;i<=num2;i++)
			{
				flag=0;
				for(j=2;j<=i/2;j++)
				{
					if(i%j==0)
					{
						flag=1;
						 break;
					}
					
					}
				if(flag==0)
					al.add(i);
				}
			          break;
	                    
	        
			case "perfect" : int sum=0;
			for(i=num1;i<=num2;i++)
			{
				for(j=1;j<=i/2;j++)
			if(i%j==0)
			{
				sum=sum+j;
			}
			if(sum==i)
				al.add(i);
	                   break;
			}   
			case "strong" :int s,temp,rem,fact;
			               for(i=num1;i<=num2;i++)
			               {
			            	   s=0;
			            	   temp=i;
			            	   while(temp>0)
			            	   {
			            		   rem=temp%10;
			            		   if(rem==0||rem==1)
			            			   fact=1;
			            		   else 
			            		   {
			            			   fact=1;
			            			   for(j=1;j<=rem;j++)
			            				   fact=fact*j;
			            		   }
			            		   s=s+fact;
			            		   temp=temp/10;
			               }
			            	   if(i==s)
			            		   al.add(i);
			               }
	                    break;
	}
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<h2>Generating Numbers</h2>"+"<br>");
			writer.println("Start number:"+num1+"<br>");
			writer.println("End number:"+num2+"<br>");
			writer.println("Operation:"+operation+"<br>");
			writer.println("Result:"+al+"<br>");
			writer.println("</html>");
			

}
}