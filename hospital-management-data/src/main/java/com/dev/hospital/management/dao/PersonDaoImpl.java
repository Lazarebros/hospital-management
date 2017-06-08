package com.dev.hospital.management.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dev.hospital.management.bean.Doctor;
import com.dev.hospital.management.bean.InsuranceType;
import com.dev.hospital.management.bean.Patient;
import com.dev.hospital.management.bean.Person;
import com.dev.hospital.management.utils.Launcher;

/**
 * @author dayanlazare
 *
 */
public class PersonDaoImpl implements PersonDao {

	@Override
	public void saveDoctor(Doctor doctor) {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "insert into doctor(firstname, lastname, date_of_birth, email, mobile_number, pager_number) values (?,?,?,?,?,?)";

		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setString(1, doctor.getFirstname());
			pstmt.setString(2, doctor.getLastname());
			pstmt.setDate(3, doctor.getDateOfBirth());
			pstmt.setString(4, doctor.getEmail());
			pstmt.setString(5, doctor.getMobileNumber());
			pstmt.setString(6, doctor.getPagerNumber());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void savePatient(Patient patient) {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "insert into patient(firstname, lastname, date_of_birth, email, mobile_number, insurance_type) values (?,?,?,?,?,?)";

		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setString(1, patient.getFirstname());
			pstmt.setString(2, patient.getLastname());
			pstmt.setDate(3, patient.getDateOfBirth());
			pstmt.setString(4, patient.getEmail());
			pstmt.setString(5, patient.getMobileNumber());
			pstmt.setString(6, patient.getInsuranceType().name());


			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> getDoctors() {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, pager_number From doctor";

		List<Person> personList = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Long personId = rs.getLong("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String email = rs.getString("email");
				String mobileNumber = rs.getString("mobile_number");
				String pagerNumber = rs.getString("pager_number");
				
				Doctor doctor = new Doctor(firstname, lastname, email, dateOfBirth);
				doctor.setPersonId(personId);
				doctor.setMobileNumber(mobileNumber);
				doctor.setPagerNumber(pagerNumber);
				
				personList.add(doctor);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personList;
	}

	@Override
	public List<Person> getPatients() {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, insurance_type From patient";

		List<Person> personList = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Long personId = rs.getLong("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String email = rs.getString("email");
				String mobileNumber = rs.getString("mobile_number");
				String insurance = rs.getString(6);
				InsuranceType insuranceType = InsuranceType.fromValue(insurance);
				
				Patient patient = new Patient(firstname, lastname, email, dateOfBirth, insuranceType);
				patient.setPersonId(personId);
				patient.setMobileNumber(mobileNumber);
				
				personList.add(patient);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personList;
	}

	@Override
	public Person getDoctor(Long id) {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, pager_number From doctor Where id = ?";

		Person person = null;
		
		List<Person> personList = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			
			pstmt.setLong(0, id);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Long personId = rs.getLong(0);
				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				Date dateOfBirth = rs.getDate(3);
				String email = rs.getString(4);
				String mobileNumber = rs.getString(5);
				String pagerNumber = rs.getString(6);
				
				Doctor doctor = new Doctor(firstname, lastname, email, dateOfBirth);
				doctor.setPersonId(personId);
				doctor.setMobileNumber(mobileNumber);
				doctor.setPagerNumber(pagerNumber);
				
				personList.add(doctor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(!personList.isEmpty()) {
			person = personList.get(0);
		}
		
		return person;
	}

	@Override
	public Person getPatient(Long id) {
		String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pwd = "root";
		String query = "Select id, firstname, lastname, date_of_birth, email, mobile_number, insurance_type From patient Where id = ?";
		
		Person person = null;
		
		List<Person> personList = new ArrayList<>();
		try(Connection connection = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setLong(0, id);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Long personId = rs.getLong(0);
				String firstname = rs.getString(1);
				String lastname = rs.getString(2);
				Date dateOfBirth = rs.getDate(3);
				String email = rs.getString(4);
				String mobileNumber = rs.getString(5);
				String insurance = rs.getString(6);
				InsuranceType insuranceType = InsuranceType.fromValue(insurance);
				
				Patient patient = new Patient(firstname, lastname, email, dateOfBirth, insuranceType);
				patient.setPersonId(personId);
				patient.setMobileNumber(mobileNumber);
				
				personList.add(patient);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(!personList.isEmpty()) {
			person = personList.get(0);
		}
		
		return person;
	}

	public static void main(String[] args) {
		PersonDaoImpl impl = new PersonDaoImpl();
		Doctor doctor = Launcher.createDoctor();
		Patient patient = Launcher.createPatient();

		impl.saveDoctor(doctor);
		impl.savePatient(patient);
		List<Person> personList = impl.getDoctors();
		
		for (Iterator<Person> iterator = personList.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println(person);
		}
		
		
	}

}
