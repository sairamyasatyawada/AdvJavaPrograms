package com.sathya.servlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sathya.servlet.DatabaseUtils;
import com.sathya.servlet.Product;
public class ProductDao {

	//insert the values 
	public int save(Product product)
	{
		int saveCount=0;
		try(Connection connection=DatabaseUtils.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)"))
			{
				preparedStatement.setString(1,product.getProId());
				preparedStatement.setString(2,product.getProName());
				preparedStatement.setDouble(3,product.getProPrice());
				preparedStatement.setString(4,product.getProBrand());
				preparedStatement.setString(5,product.getProMadeIn());
				preparedStatement.setDate(6,product.getProMfgDate());
				preparedStatement.setDate(7,product.getProExpDate());
				preparedStatement.setBytes(8,product.getProImage());
				preparedStatement.setBytes(9,product.getProAudio());
				preparedStatement.setBytes(10,product.getProVideo());
				
				saveCount=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return saveCount;
	}
	public List<Product> findAll()
	{
		List<Product> productList=new ArrayList<Product>();
		try(Connection connection=DatabaseUtils.createConnection();
				Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select * from product_data");
				while(resultSet.next())
				{
					Product product=new Product();
					product.setProId(resultSet.getString("proId"));
					product.setProName(resultSet.getString("proName"));
					product.setProPrice(resultSet.getDouble("proPrice"));
					product.setProBrand(resultSet.getString("proBrand"));
					product.setProMadeIn(resultSet.getString("proMadeIn"));
					product.setProMfgDate(resultSet.getDate("proMfgDate"));
					product.setProExpDate(resultSet.getDate("proExpDate"));
					product.setProImage(resultSet.getBytes("proImage"));
					product.setProAudio(resultSet.getBytes("proAudio"));
					product.setProVideo(resultSet.getBytes("proVideo"));
					productList.add(product);
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return productList;
	}
	//delete by id
		public int deleteById(String id)
		{
			int count=0;
			try(Connection connection=DatabaseUtils.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?"))
				{
					preparedStatement.setString(1,id);
					count=preparedStatement.executeUpdate();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			return count;
		}
		//find by id
		public Product findById(String id)
		{
			Product product=null;
			try(Connection connection=DatabaseUtils.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?"))
				{
					preparedStatement.setString(1,id);
					ResultSet  resultSet=preparedStatement.executeQuery();
					if(resultSet.next())
					{
						product=new Product();
						product.setProId(resultSet.getString("proId"));
						product.setProName(resultSet.getString("proName"));
						product.setProPrice(resultSet.getDouble("proPrice"));
						product.setProBrand(resultSet.getString("proBrand"));
						product.setProMadeIn(resultSet.getString("proMadeIn"));
						product.setProMfgDate(resultSet.getDate("proMfgDate"));
						product.setProExpDate(resultSet.getDate("proExpDate"));
						product.setProImage(resultSet.getBytes("proImage"));
						product.setProAudio(resultSet.getBytes("proAudio"));
						product.setProVideo(resultSet.getBytes("proVideo"));
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			return product;
		}
		//update by id
		public int updateById(Product product)
		{
			int updateCount=0;
			try(Connection connection=DatabaseUtils.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("update product_data set proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=?, proAudio=?, proVideo=? where proId=?"))
			{
				preparedStatement.setString(1,product.getProName());
				preparedStatement.setDouble(2,product.getProPrice());
				preparedStatement.setString(3,product.getProBrand());
				preparedStatement.setString(4,product.getProMadeIn());
				preparedStatement.setDate(5,product.getProMfgDate());
				preparedStatement.setDate(6,product.getProExpDate());
				preparedStatement.setBytes(7,product.getProImage());
				preparedStatement.setBytes(8,product.getProAudio());
				preparedStatement.setBytes(9,product.getProVideo());
				preparedStatement.setString(10,product.getProId());
				
				updateCount=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return updateCount;
		}
}