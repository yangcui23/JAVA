package com.caresoft.models;
import java.util.*;
import com.caresoft.clinicapp.HIPAACompliantAdmin;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	 
		private Integer employeeID;
	    private String role;
	    private ArrayList<String> securityIncidents = new ArrayList<String>();
	
	    
	    public AdminUser(Integer employeeID , String role) {
	    	this.employeeID = employeeID;
	    	this.role = role;
	    }
	    // TO DO: Implement a constructor that takes an ID and a role
	    // TO DO: Implement HIPAACompliantUser!
	    // TO DO: Implement HIPAACompliantAdmin!
	    
	    public boolean assignPin(int pin) {
			if (Integer.toString(pin).length() >= 6 ) {
				return true;
				
			}else {
				return false;
			}
	    }
	    
	    public boolean accessAuthorized(Integer confirmedAuthID) {
	    	if (this.employeeID.equals(confirmedAuthID)){
				return true;
			} else {
				this.authIncident();
				return false;
			}
			
	    }
	    
	    
	    public ArrayList<String> reportSecurityIncidents(){
	    	return securityIncidents;
	    }
	    
	    
	    
	    
	    public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.employeeID, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
}

		public Integer getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	    
}
