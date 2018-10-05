package Question2;

public class PsychiatristObject {
	public void examine(MoodyObject moodyObject) {
		System.out.println("How are you feeling today?");
		moodyObject.queryMood();
		moodyObject.expressFeelings();
	}
	
	public void observe(MoodyObject moodyObject) {
		System.out.println("Observation: " + moodyObject.toString());
	}

}
