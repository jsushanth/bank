package com.capgemini.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import java.sql.*;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.service.DemandDraftService;


public class DemandDraftDAO implements IDemandDraftDAO {
	//Logging using log4j for DAO operations
	final static Logger logger=Logger.getLogger(DemandDraftService.class);

	//Inserting the details of draft into database
	public int addDemandDraftDetails(DemandDraft demanddraft) {
		
		String sql="insert into demand_draft(customer_name,in_favour_of,phone_number,date_of_transaction,dd_amount,dd_commission,dd_description) values(?,?,?,?,?,?,?)";
		String sql1="select * from demand_draft";
		try(Connection conn=getDbConnection())
		{
		    PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, demanddraft.getCustomer_name());
			pst.setString(2, demanddraft.getIn_favor_of());
			pst.setString(3, demanddraft.getPhone_number());
			pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
			pst.setDouble(5, demanddraft.getDd_amount());
			pst.setDouble(6, demanddraft.getDd_commission());
			pst.setString(7, demanddraft.getDd_description());
			
			
			int count=pst.executeUpdate();
			
		   if(count>=1)
		   {
			   logger.info("Insertion done into DB!");
			   
			   PreparedStatement pst1=conn.prepareStatement(sql1);
			   
			   ResultSet resultSet=pst1.executeQuery();
			   //To get the transaction id based on name and in favor of
			   while(resultSet.next())
			   {
				   if(resultSet.getString(2).compareTo(demanddraft.getCustomer_name())==0 && resultSet.getString(3).compareTo(demanddraft.getIn_favor_of())==0)
				   {
					   return resultSet.getInt(1);
				   }
			   }
		   }
			
		} catch (SQLException e) {
			logger.error("An sql Exception occoured!"+e);
			e.printStackTrace();
		}
		return 0;
	}

	//Connecting to database using driver manager
	private Connection getDbConnection() {
		Connection connection=null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/module2", "root", "India123");
			return connection;
		}catch (ClassNotFoundException|SQLException e) {
			logger.error("Exception while connecting to Database"+e);
			e.printStackTrace();
		}
		
		return null;
		
	}	
	

	//To print output to the console 
	public DemandDraft getDemandDraftDetails(int transactionid) {
		
		System.out.println("Your Demand Draft request has been succesfully registered along with the "+transactionid);
		return null;
	}

}
