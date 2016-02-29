/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class TestModel {
    
    public long customerID;
	public String name;
	public String address;
	public Date created_date;
        
        
     public long getCustomerID(){
         return customerID;
     }
     
     public String getName(){
         
         return name;
     }
      
     public String getAdress(){
         
         return address;
     }
     
     public Date getCreated_date(){
         
         return created_date;
     }
     
 
      public void setCustomerID(long customerID){
         this.customerID = customerID;
     }
     
     public void setName( String name ){
         
         this.name = name;
     }
      
     public void setAddress(String adress){
         
         this.address = adress;
     }
     
     public void setCreated_date(Date created_date){
         
         this.created_date = created_date;
     }
}
