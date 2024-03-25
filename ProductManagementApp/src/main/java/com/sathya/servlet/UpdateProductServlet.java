package com.sathya.servlet;
import java.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		
		Part filePart=request.getPart("newProImage");
		if(filePart!=null&&filePart.getSize()>0)
		{
			InputStream inputStream=filePart.getInputStream();
			byte[] newImageData=IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);
		}
		else
		{
			Part file=request.getPart("existingImage");
			InputStream inputStream=file.getInputStream();
			byte[] existingImage=IOUtils.toByteArray(inputStream);
			product.setProImage(existingImage);	
			String s=request.getParameter("existingImage");
			byte[] existingImage1=Base64.getDecoder().decode(s);
			product.setProImage(existingImage1);
			
		}
		
		//Reading the new Audio else old Audio
		Part audioPart=request.getPart("newProAudio");
		if(audioPart.getSize()!=0 && audioPart!=null)
		{
			InputStream inputStream=audioPart.getInputStream();
			byte[] newAudioData=IOUtils.toByteArray(inputStream);
			product.setProImage(newAudioData);
		}
		else
		{
			String s=request.getParameter("existingAudio");
			byte[] existingAudio=Base64.getDecoder().decode(s);
			product.setProAudio(existingAudio);
		}
		
		//Reading the new Video else old video
		Part videoPart=request.getPart("newProVideo");
		if(videoPart.getSize()!=0 && videoPart!=null)
		{
			InputStream inputStream=audioPart.getInputStream();
			byte[] newVideoData=IOUtils.toByteArray(inputStream);
			product.setProImage(newVideoData);
		}
		else
		{
			String s=request.getParameter("existingVideo");
			byte[] existingVideo=Base64.getDecoder().decode(s);
			product.setProVideo(existingVideo);
		}

		String s=request.getParameter("existingAudio");
		byte[] existingAudio=Base64.getDecoder().decode(s);
		product.setProAudio(existingAudio);
		
		String s1=request.getParameter("existingVideo");
		byte[] existingVideo=Base64.getDecoder().decode(s1);
		product.setProVideo(existingVideo);
		
		ProductDao dao=new ProductDao();
		int result=dao.updateById(product);
		if(result==1)
		{
			request.setAttribute("updateResult",result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Updation failed.TRY AGAIN");
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}
	}

}