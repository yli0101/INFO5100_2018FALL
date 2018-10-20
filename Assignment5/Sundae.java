package assignment;

public class Sundae extends IceCream{
	String nameOfTopping;
	int costOfTopping;

	public Sundae(String name, int costOfIceCream, String nameOfTopping, int costOfTopping) {
		super(name, costOfIceCream);
		this.nameOfTopping = nameOfTopping;
		this.costOfTopping = costOfTopping;		
	}
	
	public String getNameOfTopping(){
		return nameOfTopping;
	}
	
	public int getCost(){
		int cost = costOfIceCream + costOfTopping;
		return cost;
	}
	
	public String toString() {
		DessertShoppe dessertShoppe = new DessertShoppe();
		String totalCost = dessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return getNameOfTopping()+ "Sundae with" + getName() + dessertShoppe.Space(name,totalCost)+ totalCost + "\n";
		
	}
}