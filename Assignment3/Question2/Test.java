package Question2;

public class Test {
	public static void main(String args[]) {
		PsychiatristObject psychiatris = new PsychiatristObject();
		MoodyObject happy = new HappyObject();
		MoodyObject sad = new SadObject();
		psychiatris.examine(happy);
		psychiatris.observe(happy);
		psychiatris.examine(sad);
		psychiatris.observe(sad);
	}

}
