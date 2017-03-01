import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanResources {

	private JFrame frame;
	private JTextField firstTxt;
	private JTextField middleTxt;
	private JTextField lastTxt;
	private JTextField dobTxt;
	private JTextField ssnTxt;
	private JTextField addressTxt;
	private JTextField aptTxt;
	private JTextField cityTxt;
	private JTextField stateTxt;
	private JTextField emailTxt;
	private JTextField zipTxt;
	private int univID;
	private Boolean firstClick;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanResources window = new HumanResources();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HumanResources() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Employee emp = new Employee(univID, 4);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
				
		JLabel empIDLbl = new JLabel("Employee ID:");
		empIDLbl.setBounds(10, 30, 80, 14);
		frame.getContentPane().add(empIDLbl);
		
		JLabel empIDdisp = new JLabel("");
		empIDdisp.setBounds(90, 30, 46, 14);
		frame.getContentPane().add(empIDdisp);
		
		JLabel firstLbl = new JLabel("First Name:");
		firstLbl.setBounds(10, 50, 60, 14);
		frame.getContentPane().add(firstLbl);
		
		JLabel middleLbl = new JLabel("M.I:");
		middleLbl.setBounds(180, 50, 46, 14);
		frame.getContentPane().add(middleLbl);
		
		JLabel lastLbl = new JLabel("Last Name:");
		lastLbl.setBounds(260, 50, 60, 14);
		frame.getContentPane().add(lastLbl);
		
		firstTxt = new JTextField();
		firstTxt.setBounds(75, 50, 85, 20);
		frame.getContentPane().add(firstTxt);
		firstTxt.setColumns(10);
		
		middleTxt = new JTextField();
		middleTxt.setBounds(205, 50, 20, 20);
		frame.getContentPane().add(middleTxt);
		middleTxt.setColumns(10);
		
		lastTxt = new JTextField();
		lastTxt.setBounds(320, 50, 85, 20);
		frame.getContentPane().add(lastTxt);
		lastTxt.setColumns(10);
		
		JLabel dobLbl = new JLabel("DOB:");
		dobLbl.setBounds(10, 80, 46, 14);
		frame.getContentPane().add(dobLbl);
		
		dobTxt = new JTextField();
		dobTxt.setBounds(75, 80, 60, 20);
		frame.getContentPane().add(dobTxt);
		dobTxt.setColumns(10);
		
		JLabel ssnLbl = new JLabel("SSN:");
		ssnLbl.setBounds(260, 80, 46, 14);
		frame.getContentPane().add(ssnLbl);
		
		ssnTxt = new JTextField();
		ssnTxt.setBounds(320, 80, 60, 20);
		frame.getContentPane().add(ssnTxt);
		ssnTxt.setColumns(10);
		
		JLabel addressLbl = new JLabel("Address:");
		addressLbl.setBounds(10, 110, 46, 14);
		frame.getContentPane().add(addressLbl);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(75, 110, 110, 20);
		frame.getContentPane().add(addressTxt);
		addressTxt.setColumns(10);
		
		JLabel aptLbl = new JLabel("APT/STE:");
		aptLbl.setBounds(260, 110, 46, 14);
		frame.getContentPane().add(aptLbl);
		
		aptTxt = new JTextField();
		aptTxt.setBounds(320, 110, 40, 20);
		frame.getContentPane().add(aptTxt);
		aptTxt.setColumns(10);
		
		JLabel cityLbl = new JLabel("City:");
		cityLbl.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(cityLbl);
		
		cityTxt = new JTextField();
		cityTxt.setBounds(75, 140, 86, 20);
		frame.getContentPane().add(cityTxt);
		cityTxt.setColumns(10);
		
		JLabel stateLbl = new JLabel("State:");
		stateLbl.setBounds(260, 140, 46, 14);
		frame.getContentPane().add(stateLbl);
		
		stateTxt = new JTextField();
		stateTxt.setBounds(320, 140, 86, 20);
		frame.getContentPane().add(stateTxt);
		stateTxt.setColumns(10);
		
		zipTxt = new JTextField();
		zipTxt.setBounds(320, 170, 86, 20);
		frame.getContentPane().add(zipTxt);
		zipTxt.setColumns(10);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setBounds(10, 170, 46, 14);
		frame.getContentPane().add(emailLbl);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(75, 170, 110, 20);
		frame.getContentPane().add(emailTxt);
		emailTxt.setColumns(10);				
		
		JLabel zipLbl = new JLabel("Zip Code:");
		zipLbl.setBounds(260, 170, 46, 14);
		frame.getContentPane().add(zipLbl);
		
		JButton prevBtn = new JButton("Previous");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				univID = Integer.parseInt(empIDdisp.getText());
				System.out.println(univID);
				Employee emp = new Employee(univID, 1);
				if (emp.getDisplay()) {				
					empIDdisp.setText(emp.getEmpID());
					firstTxt.setText(emp.getFirstName());
					middleTxt.setText(emp.getMiddleInitial());
					lastTxt.setText(emp.getLastName());
					dobTxt.setText(emp.getDob());
					ssnTxt.setText(emp.getSsn());
					addressTxt.setText(emp.getAddress());				
					aptTxt.setText(emp.getApt());
					cityTxt.setText(emp.getCity());
					stateTxt.setText(emp.getState());
					zipTxt.setText(emp.getZip());
					emailTxt.setText(emp.getEmail());
				}				
			}
		});
		prevBtn.setBounds(0, 0, 90, 23);
		frame.getContentPane().add(prevBtn);
		
		JButton saveBtn = new JButton("Create");
		firstClick = true;
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstClick) {
					firstClick = false;
					saveBtn.setText("Save");
					empIDdisp.setText("");
					firstTxt.setText("");
					middleTxt.setText("");
					lastTxt.setText("");
					dobTxt.setText("");
					ssnTxt.setText("");
					addressTxt.setText("");				
					aptTxt.setText("");
					cityTxt.setText("");
					stateTxt.setText("");
					zipTxt.setText("");
					emailTxt.setText("");
					
				}
				else {
					firstClick = true;
					saveBtn.setText("Create");
					univID = 0;
					Employee emp = new Employee(univID, 2);
					if (emp.getDisplay()) {				
						empIDdisp.setText(emp.getEmpID());
						firstTxt.setText(emp.getFirstName());
						middleTxt.setText(emp.getMiddleInitial());
						lastTxt.setText(emp.getLastName());
						dobTxt.setText(emp.getDob());
						ssnTxt.setText(emp.getSsn());
						addressTxt.setText(emp.getAddress());				
						aptTxt.setText(emp.getApt());
						cityTxt.setText(emp.getCity());
						stateTxt.setText(emp.getState());
						zipTxt.setText(emp.getZip());
						emailTxt.setText(emp.getEmail());					
					}
				}
			}
		});
		saveBtn.setBounds(115, 0, 90, 23);
		frame.getContentPane().add(saveBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				univID = Integer.parseInt(empIDdisp.getText());
				System.out.println(univID);
				Employee emp = new Employee(univID, 3);
				if (emp.getDisplay()) {				
					empIDdisp.setText(emp.getEmpID());
					firstTxt.setText(emp.getFirstName());
					middleTxt.setText(emp.getMiddleInitial());
					lastTxt.setText(emp.getLastName());
					dobTxt.setText(emp.getDob());
					ssnTxt.setText(emp.getSsn());
					addressTxt.setText(emp.getAddress());				
					aptTxt.setText(emp.getApt());
					cityTxt.setText(emp.getCity());
					stateTxt.setText(emp.getState());
					zipTxt.setText(emp.getZip());
					emailTxt.setText(emp.getEmail());
				}
				if (!(emp.getDisplay()) && emp.getClearScreen()) {
					empIDdisp.setText("0");
					firstTxt.setText("");
					middleTxt.setText("");
					lastTxt.setText("");
					dobTxt.setText("");
					ssnTxt.setText("");
					addressTxt.setText("");				
					aptTxt.setText("");
					cityTxt.setText("");
					stateTxt.setText("");
					zipTxt.setText("");
					emailTxt.setText("");
				}
			}
		});
		deleteBtn.setBounds(230, 0, 90, 23);
		frame.getContentPane().add(deleteBtn);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				univID = Integer.parseInt(empIDdisp.getText());
				System.out.println(univID);
				Employee emp = new Employee(univID, 4);
				if (emp.getDisplay()) {				
					empIDdisp.setText(emp.getEmpID());
					firstTxt.setText(emp.getFirstName());
					middleTxt.setText(emp.getMiddleInitial());
					lastTxt.setText(emp.getLastName());
					dobTxt.setText(emp.getDob());
					ssnTxt.setText(emp.getSsn());
					addressTxt.setText(emp.getAddress());				
					aptTxt.setText(emp.getApt());
					cityTxt.setText(emp.getCity());
					stateTxt.setText(emp.getState());
					zipTxt.setText(emp.getZip());
					emailTxt.setText(emp.getEmail());
				}
			}
		});
		nextBtn.setBounds(345, 0, 90, 23);
		frame.getContentPane().add(nextBtn);
		
		empIDdisp.setText(emp.getEmpID());
		firstTxt.setText(emp.getFirstName());
		middleTxt.setText(emp.getMiddleInitial());
		lastTxt.setText(emp.getLastName());
		dobTxt.setText(emp.getDob());
		ssnTxt.setText(emp.getSsn());
		addressTxt.setText(emp.getAddress());				
		aptTxt.setText(emp.getApt());
		cityTxt.setText(emp.getCity());
		stateTxt.setText(emp.getState());
		zipTxt.setText(emp.getZip());
		emailTxt.setText(emp.getEmail());
	}
}
