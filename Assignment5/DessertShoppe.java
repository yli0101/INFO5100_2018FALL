package assignment;

public class DessertShoppe {
	public float taxRate = 0.1f;
	public static String storeName = "M&M Dessert Shoppe";
	public static int nameSize = 20;
	public static int width = 30;
	
	public static String cents2dollarsAndCentsmethod (int cost) {
		return String.valueOf((float)cost/100);
	}
	
	public static String Space(String name, String cost){
		int Space = width - name.length() - cost.length();
		
		String space = " ";
		
		for (int i=0; i< Space; i++ ){
			
			space+=" ";
		}
		
		return space;
		
	}

}
