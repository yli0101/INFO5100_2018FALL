package student;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentInformationSystem extends JFrame {

	public JTable studentsTable;
	public JTextField idTextField, firstNameTextField, lastNameTextField, genderTextField;
	public JLabel idLabel, firstNameLabel, lastNameLabel, genderLabel;
	public JButton addNewStudent;
	public Students std;
	public Font font;
	
	public StudentInformationSystem(Students students) {
		std = students;
		StudentsTableModel model = new StudentsTableModel(students);
		studentsTable = new JTable(model);
		JScrollPane jsp = new JScrollPane(studentsTable);
		font = new Font("TimesRoman", Font.PLAIN, 12);
		jsp.setFont(font);	
		
		idTextField = new JTextField(3);
		idTextField.setFont(font);
		firstNameTextField = new JTextField(3);
		firstNameTextField.setFont(font);
		lastNameTextField = new JTextField(3);
		lastNameTextField.setFont(font);
		genderTextField = new JTextField(3);
		genderTextField.setFont(font);
		idLabel = new JLabel("Id: ");
		idLabel.setFont(font);
		firstNameLabel = new JLabel("FirstName: ");
		firstNameLabel.setFont(font);
		lastNameLabel = new JLabel("LastName: ");
		lastNameLabel.setFont(font);
		genderLabel = new JLabel("Gender: ");
		genderLabel.setFont(font);
		
		addNewStudent = new JButton("Add");
		addNewStudent.setFont(font);
		addNewStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student studentToAdd = new Student(Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(), genderTextField.getText());
				StudentInformationSystem.this.std.addStudent(studentToAdd);
				StudentInformationSystem.this.studentsTable.updateUI();
				clearTextField();
			}
		});

		Container con = getContentPane();
		JPanel p = new JPanel();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		p.add(jsp);
		con.add(p);
		
		p = new JPanel();		
		p.add(idLabel);
		p.add(idTextField);
		p.add(firstNameLabel);
		p.add(firstNameTextField);
		p.add(lastNameLabel);
		p.add(lastNameTextField);
		p.add(genderLabel);
		p.add(genderTextField);
		p.add(addNewStudent);
		con.add(p);
		

		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {		
		Students s = new Students();
		StudentInformationSystem studentSystem  = new StudentInformationSystem(s);
		studentSystem.setTitle("Student Information System");
	}
	
	public void clearTextField() {
		idTextField.setText("");
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		genderTextField.setText("");
	}

}

class Students {
	private Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}

class Student {
	int id;
	String firstName;
	String lastName;
	String gender;

	public Student(int id, String firstName, String lastName, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
}

class StudentsTableModel implements TableModel {

	private Students students;

	public StudentsTableModel(Students students) {
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex == 0) return "Id";
		if(columnIndex == 1) return "FirstName";		
		if(columnIndex == 2) return "LastName";
		if(columnIndex == 3) return "Gender";
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.id + "";
				}
				if (columnIndex == 1) {
					return student.firstName;
				}
				if (columnIndex == 2) {
					return student.lastName;
				}
				if (columnIndex == 3) {
					return student.gender;
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
