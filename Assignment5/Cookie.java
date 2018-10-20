package assignment;

public class Cookie extends DessertItem {
	int number;
	int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen) {
		this.name = name;
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	};
	
	public int getCost(){
		double total = number*pricePerDozen/12;
		return (int) Math.round(total);
	}
	
	public String toString() {
		DessertShoppe dessertShoppe = new DessertShoppe();
		String totalCost = dessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return String.valueOf(number)+" @ "+dessertShoppe.cents2dollarsAndCentsmethod(pricePerDozen)+"/dz"+ "\n" + getName()+ dessertShoppe.Space(name,totalCost)+ totalCost + "\n";
		
	}

}
