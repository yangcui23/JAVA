package com.caresoft.models;
import java.util.ArrayList;
import java.util.Date;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	
	public Physician() {
		this.patientNotes = new ArrayList<String>();
	}
	
	public Physician(Integer id) {
		super(id);
	}
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
	public boolean assignPin(int pin) {
			if (Integer.toString(pin).length() == 4) {
				super.setPin(pin);
				return true;
			}else {
				return false;
			}
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (super.getId().equals(confirmedAuthID)) {
            return true;
        }
        
        return false;
	}
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
}
    
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

}