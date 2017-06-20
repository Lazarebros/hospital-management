package com.dev.hospital.management.data.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.InsuranceType;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.utils.DBConfig;

/**
 * @author dayanlazare
 *
 */
public class PersonDaoImpl implements PersonDao {

	@Override
	public void saveDoctor(Doctor doctor) {
		String query = "insert into doctor(firstname, lastname, date_of_birth, email, mobile_number, pager_number) values (?,?,?,?,?,?)";
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setString(1, doctor.getFirstname());
			pstmt.setString(2, doctor.getLastname());
			pstmt.setDate(3, new java.sql.Date(doctor.getDateOfBirth().getTime()));
			pstmt.setString(4, doctor.getEmail());
			pstmt.setString(5, doctor.getMobileNumber());
			pstmt.setString(6, doctor.getPagerNumber());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void savePatient(Patient patient) {
		String query = "insert into patient(firstname, lastname, date_of_birth, email, mobile_number, insurance_type) values (?,?,?,?,?,?)";
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setString(1, patient.getFirstname());
			pstmt.setString(2, patient.getLastname());
			pstmt.setDate(3, new java.sql.Date(patient.getDateOfBirth().getTime()));
			pstmt.setString(4, patient.getEmail());
			pstmt.setString(5, patient.getMobileNumber());
			pstmt.setString(6, patient.getInsuranceType().name());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Doctor> getDoctors() {
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, pager_number From doctor";
		List<Doctor> doctorList = new ArrayList<>();
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Doctor doctor = this.createDoctor(rs);
				if(doctor != null) {
					doctorList.add(doctor);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}

	@Override
	public List<Patient> getPatients() {
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, insurance_type From patient";
		List<Patient> patientList = new ArrayList<>();
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Patient patient = this.createPatient(rs);
				if(patient != null) {
					patientList.add(patient);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public Doctor getDoctor(Long id) {
		String query = "Select firstname, lastname, date_of_birth, email, mobile_number, pager_number From doctor Where id = ?";
		Doctor doctor = null;
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setLong(0, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				doctor = this.createDoctor(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	public Patient getPatient(Long id) {
		String query = "Select firstname, lastname, date_of_birth, email, mobile_number, insurance_type From patient Where id = ?";
		Patient patient = null;
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setLong(0, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				patient = this.createPatient(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	private Doctor createDoctor(ResultSet rs) {
		Doctor doctor = null;
		try {
			Long id = rs.getLong("id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			Date dateOfBirth = rs.getDate("date_of_birth");
			String email = rs.getString("email");
			String mobileNumber = rs.getString("mobile_number");
			String pagerNumber = rs.getString("pager_number");

			doctor = new Doctor(firstname, lastname, email, dateOfBirth);
			doctor.setId(id);
			doctor.setMobileNumber(mobileNumber);
			doctor.setPagerNumber(pagerNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	private Patient createPatient(ResultSet rs) {
		Patient patient = null;
		try {
			Long id = rs.getLong("id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			Date dateOfBirth = rs.getDate("date_of_birth");
			String email = rs.getString("email");
			String mobileNumber = rs.getString("mobile_number");
			String insurance = rs.getString(6);
			InsuranceType insuranceType = InsuranceType.fromValue(insurance);

			patient = new Patient(firstname, lastname, email, dateOfBirth, insuranceType);
			patient.setId(id);
			patient.setMobileNumber(mobileNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

}
