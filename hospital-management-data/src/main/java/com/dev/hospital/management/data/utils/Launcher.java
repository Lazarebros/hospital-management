/**
 * 
 */
package com.dev.hospital.management.data.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.InsuranceType;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public class Launcher {
	
	private static Map<InsuranceType, Double> insurancePrices = new HashMap<InsuranceType, Double>();
	
	static {
		insurancePrices.put(InsuranceType.None, 150.78);
		insurancePrices.put(InsuranceType.Aetna, 120.68);
		insurancePrices.put(InsuranceType.Axa, 150.78);
		insurancePrices.put(InsuranceType.Allstate, 150.78);
		insurancePrices.put(InsuranceType.AmericanFamilyInsurance, 150.78);
		insurancePrices.put(InsuranceType.BankersLifeInsurance, 150.78);
		insurancePrices.put(InsuranceType.Conseco, 150.78);
	}
	
	public static Doctor createDoctor() {
		Date dateOfBirth = DateUtil.stringToSQLDate("2012-12-23");
		return new Doctor("Test", "Test", "test@test.com", dateOfBirth);
	}
	
	public static Patient createPatient() {
		Date dateOfBirth = DateUtil.stringToSQLDate("2012-12-23");
		return new Patient("Test", "Test", "test@test.com", dateOfBirth, InsuranceType.Aetna);
	}
	
	public static Double getBill(Patient patient) {
		Double amoutPernight = insurancePrices.get(patient.getInsuranceType());
		return amoutPernight;
//		return amoutPernight * patient.getNumberOfNights();
	}
	
	public static void main(String[] args) {
		Date dateOfBirth = DateUtil.stringToSQLDate("2012-12-23");
//		Date now = new Date(System.currentTimeMillis());
//		int numberOfNights = 5;
		
		Patient p1 = new Patient("test", "test", "test@test.com", dateOfBirth, InsuranceType.Aetna);
		Double bill = getBill(p1);
		
		System.out.println("The bill is: " + bill);
		
	}

}
