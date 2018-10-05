package Question1;

public class Test {
	public static void main(String[] args) {
		Student student1 = new Student("Ching","A01");
		Course course1 = new Course("Info 5100");
		course1.registerStudent(student1);
		Student[] students = course1.getStudents();
		
		for(int i = 0; i < 10; i++) {
			course1.registerStudent(student1);
			System.out.println(students[i].getName());
		}
	}
}
