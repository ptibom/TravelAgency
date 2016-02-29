/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.computerscience.travelagency.view;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import resources.TestModel;
import javax.sql.DataSource;

@ManagedBean(name="customer")
@SessionScoped
/**
 *
 * @author MonoMan
 */
public class CustomerBean implements Serializable {
    
    
    @Resource(name="jdbc/travelAgency")
	private DataSource ds;
  
	//connect to DB and get customer list
	public List<TestModel> getCustomerList() throws SQLException{
		
		if(ds==null)
			throw new SQLException("Can't get data source");
		//get database connection
		Connection con = ds.getConnection();
		if(con==null)
			throw new SQLException("Can't get database connection");
		
		PreparedStatement ps 
			= con.prepareStatement(
			   "select customer_id, name, address, created_date from customer"); 
		
		//get customer data from database
                //
		ResultSet result =  ps.executeQuery();
		
		List<TestModel> list = new ArrayList<TestModel>();
		
                
                // Depending on whatever kind of model we will use, this retrueves the result from
                // query and initlalize the beans model
		while(result.next()){
			TestModel cust = new TestModel();
			cust.setCustomerID(result.getLong("customer_id"));
			cust.setName(result.getString("name"));
			cust.setAddress(result.getString("address"));
			cust.setCreated_date(result.getDate("created_date"));
			//store all data into a List
			list.add(cust);
		}
		return list;
	}
}