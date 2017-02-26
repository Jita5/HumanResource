import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	private String empID;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String dob;
	private String ssn;
	private String address;
	private String apt;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String id;
	
	protected Employee(){		
	}
	
	protected Employee(int eId){
//		this.id = empId;
		getEmployee(eId);
	}

	private void getEmployee(int idNum){
		this.id = String.valueOf(idNum);
		
		try {
			// creating mysql connection
			Class.forName("com.mysql.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/humanresource";
			Connection con = DriverManager.getConnection(myUrl, "root", "root");

			// creating select query & statement
			Statement st = con.createStatement();
			PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id> ?");
			prepSt.setString(1, id);
			
//			prepSt.setString(1, "0");
			ResultSet rs = prepSt.executeQuery();
			if (rs.next()) {
				empID = rs.getString("emp_id");
				setEmpID(empID);
				firstName = rs.getString("first_name");
				setFirstName(firstName);
				middleInitial = rs.getString("middle_initial");
				setMiddleInitial(middleInitial);
				lastName = rs.getString("last_name");	
				setLastName(lastName);
				dob = rs.getString("dob");
				setDob(dob);
				ssn = rs.getString("ssn");
				setSsn(ssn);
				address = rs.getString("address");
				setAddress(address);
				apt = rs.getString("apt");
				setApt(apt);
				city = rs.getString("city");
				setCity(city);
				state = rs.getString("state");
				setState(state);
				zip = rs.getString("zip");
				setZip(zip);
				email = rs.getString("email");
				setEmail(email);
			}						
			st.close();
			prepSt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
	}

	protected String getEmpID() {
		return empID;
	}

	private void setEmpID(String empID) {
		this.empID = empID;
	}

	protected String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getMiddleInitial() {
		return middleInitial;
	}

	private void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	protected String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected String getDob() {
		return dob;
	}

	private void setDob(String dob) {
		this.dob = dob;
	}

	protected String getSsn() {
		return ssn;
	}

	private void setSsn(String ssn) {
		this.ssn = ssn;
	}

	protected String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	protected String getApt() {
		return apt;
	}

	private void setApt(String apt) {
		this.apt = apt;
	}

	protected String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	protected String getState() {
		return state;
	}

	private void setState(String state) {
		this.state = state;
	}

	protected String getZip() {
		return zip;
	}

	protected void setZip(String zip) {
		this.zip = zip;
	}

	protected String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}	
}
