package assignment;

public class IceCream extends DessertItem {
	int costOfIceCream;
	
	public IceCream(String name, int costOfIceCream) {
		this.name = name;
		this.costOfIceCream = costOfIceCream;
	};
	
	public int getCost(){
		return costOfIceCream;
	}
	
	public String toString() {
		DessertShoppe dessertShoppe = new DessertShoppe();
		String totalCost = dessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return getName()+ dessertShoppe.Space(name,totalCost)+ totalCost + "\n";
		
	}

}
