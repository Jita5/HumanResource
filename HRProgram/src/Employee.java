import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
	private Boolean display;
	private Boolean clearScreen;
	
	protected Employee(){		
	}
	
	protected Employee(int eId, int action){
		if (action == 1){
			prevEmployee(eId);
		}
		else if (action == 2) {
			saveEmployee();			
		}
		else if (action == 3) {
			deleteEmployee(eId);
		}
		else if (action == 4) {
			nextEmployee(eId);
		}		
	}
	
	private void prevEmployee(int idNum){
		this.id = String.valueOf(idNum);
		
		try {
			// creating mysql connection
			Class.forName("com.mysql.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/humanresource";
			Connection con = DriverManager.getConnection(myUrl, "root", "root");

			// creating select query & statement
			PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id = (SELECT max(emp_id) FROM employee where emp_id< ?)"
					+ " ORDER BY emp_id");
			System.out.println("ID for lookup is "+id);
			prepSt.setString(1, id);
			
			ResultSet rs = prepSt.executeQuery();
			if (rs.next()) {
				setDisplay(true);
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
			else {
				setDisplay(false);
				JOptionPane.showMessageDialog(null, "Beginning of Employee Records");
			}
			prepSt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
	}
	
	private void saveEmployee() {
		try {
			// creating mysql connection
			Class.forName("com.mysql.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/humanresource";
			Connection con = DriverManager.getConnection(myUrl, "root", "root");
			String idReturn = "";

			// creating select query & statement
			Statement st = con.createStatement();
			String query = "INSERT INTO employee(emp_id, first_name, middle_initial, last_name, ssn) VALUES(NULL,'Test','T','TestLast', 456227777)";
			st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);			
			
			ResultSet rsGetkey = st.getGeneratedKeys();
			if (rsGetkey.next()){				
				idReturn = String.valueOf(rsGetkey.getInt(1));				
				System.out.println("Added ID " + idReturn);
			
				PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id= ?");
				prepSt.setString(1, idReturn);				
				ResultSet rs = prepSt.executeQuery();
				if (rs.next()) {				
					setDisplay(true);
					empID = rs.getString("emp_id");
					setEmpID(empID);
					firstName = rs.getString("first_name");
					setFirstName(firstName);
					middleInitial = rs.getString("middle_initial");
					setMiddleInitial(middleInitial);
					lastName = rs.getString("last_name");	
					setLastName(lastName);
	//				dob = rs.getString("dob");
	//				setDob(dob);
					ssn = rs.getString("ssn");
					setSsn(ssn);
	//				address = rs.getString("address");
	//				setAddress(address);
	//				apt = rs.getString("apt");
	//				setApt(apt);
	//				city = rs.getString("city");
	//				setCity(city);
	//				state = rs.getString("state");
	//				setState(state);
	//				zip = rs.getString("zip");
	//				setZip(zip);
	//				email = rs.getString("email");
	//				setEmail(email);
					prepSt.close();
				}
			}	
//			else {
//				setDisplay(false);
//				JOptionPane.showMessageDialog(null, "Beginning of Employee Records");
//			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private void deleteEmployee(int idNum){
		this.id = String.valueOf(idNum);
		
		try {
			// creating mysql connection
			Class.forName("com.mysql.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/humanresource";
			Connection con = DriverManager.getConnection(myUrl, "root", "root");

			// query for deleting current record
			PreparedStatement prepSt = con.prepareStatement("DELETE FROM employee WHERE emp_id= ?");
			prepSt.setString(1, id);
			prepSt.execute();
			
			// query to display next record
			prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id> ?");
			prepSt.setString(1, id);			
			ResultSet rsNext = prepSt.executeQuery();
			//if next record not found look for previous record
			if (rsNext.next()) {
				setDisplay(true);
				empID = rsNext.getString("emp_id");
				setEmpID(empID);
				firstName = rsNext.getString("first_name");
				setFirstName(firstName);
				middleInitial = rsNext.getString("middle_initial");
				setMiddleInitial(middleInitial);
				lastName = rsNext.getString("last_name");	
				setLastName(lastName);
				dob = rsNext.getString("dob");
				setDob(dob);
				ssn = rsNext.getString("ssn");
				setSsn(ssn);
				address = rsNext.getString("address");
				setAddress(address);
				apt = rsNext.getString("apt");
				setApt(apt);
				city = rsNext.getString("city");
				setCity(city);
				state = rsNext.getString("state");
				setState(state);
				zip = rsNext.getString("zip");
				setZip(zip);
				email = rsNext.getString("email");
				setEmail(email);
			}
			else {
				//set up query for previous record
				prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id = (SELECT max(emp_id) FROM employee where emp_id< ?)");
				prepSt.setString(1, id);				
				ResultSet rsPrev = prepSt.executeQuery();
				//if this query fails, no more records exist
				if (rsPrev.next()) {
					setDisplay(true);
					setClearScreen(false);
					empID = rsPrev.getString("emp_id");
					setEmpID(empID);
					firstName = rsPrev.getString("first_name");
					setFirstName(firstName);
					middleInitial = rsPrev.getString("middle_initial");
					setMiddleInitial(middleInitial);
					lastName = rsPrev.getString("last_name");	
					setLastName(lastName);
					dob = rsPrev.getString("dob");
					setDob(dob);
					ssn = rsPrev.getString("ssn");
					setSsn(ssn);
					address = rsPrev.getString("address");
					setAddress(address);
					apt = rsPrev.getString("apt");
					setApt(apt);
					city = rsPrev.getString("city");
					setCity(city);
					state = rsPrev.getString("state");
					setState(state);
					zip = rsPrev.getString("zip");
					setZip(zip);
					email = rsPrev.getString("email");
					setEmail(email);					
				}
				else {
					setDisplay(false);
					setClearScreen(true);
					JOptionPane.showMessageDialog(null, "No Employee Records Exist");
				}
			}
			prepSt.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
	}
	
	private void nextEmployee(int idNum){
		this.id = String.valueOf(idNum);
		
		try {
			// creating mysql connection
			Class.forName("com.mysql.jdbc.Driver");
			String myUrl = "jdbc:mysql://localhost:3306/humanresource";
			Connection con = DriverManager.getConnection(myUrl, "root", "root");

			// creating select query & statement
			PreparedStatement prepSt = con.prepareStatement("SELECT * FROM employee WHERE emp_id> ?");
			prepSt.setString(1, id);
			
			ResultSet rs = prepSt.executeQuery();
			if (rs.next()) {
				setDisplay(true);
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
			else {
				setDisplay(false);
				JOptionPane.showMessageDialog(null, "End of Employee Records");
			}
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
	
	protected Boolean getDisplay() {
		return display;
	}

	private void setDisplay(Boolean disp) {
		this.display = disp;
	}
	protected Boolean getClearScreen() {
		return clearScreen;
	}

	private void setClearScreen(Boolean screen) {
		this.clearScreen = screen;
	}
}
