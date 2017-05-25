/**
 * 
 */
package com.dev.hospital.management.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.dev.hospital.management.bean.InsuranceType;
import com.dev.hospital.management.bean.Patient;

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
	
	public static Double getBill(Patient patient) {
		Double amoutPernight = insurancePrices.get(patient.getInsuranceType());
		return amoutPernight;
//		return amoutPernight * patient.getNumberOfNights();
	}
	
	public static void main(String[] args) {
		Date dateOfBirth = DateUtil.stringToDate("2012-12-23");
		Date now = new Date(System.currentTimeMillis());
		int numberOfNights = 5;
		InsuranceType insuranceType = InsuranceType.Aetna;
		
		Patient p1 = new Patient("test", "test", dateOfBirth, insuranceType);
		Double bill = getBill(p1);
		
		System.out.println("The bill is: " + bill);
		
	}

}
