package Extra;

public class Reverse {
	public static String reverse(String s) {
		String[] str = s.split("\\s++");
		StringBuilder result = new StringBuilder();
		for(int i = str.length - 1; i > 0; i--)
			result.append(str[i] + " ");
		result.append(str[0]);
		return result.toString();
	}
	
	public static void main(String args[]) {
		String s = reverse("The sky is blue");
		System.out.println(s);
	}
}
