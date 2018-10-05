package Question1;

public class Course {
	private String title;
	private int numberOfStudent;
	private Student[] students = new Student[10];
	
	public Course(String title) {
		this.title = title;
		this.numberOfStudent = 0;
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	
	public boolean isFull() {
		return numberOfStudent >= 10;
	}
	
	public void registerStudent(Student student) {
		if (!isFull()) {
			students[numberOfStudent] = student;
			numberOfStudent++;
			System.out.println("Course was successfully added.");
		}
		else {
			System.out.println("Course added unsuccessful, Reason: No more space");
		}
	}
}
