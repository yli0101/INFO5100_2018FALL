package assignment;

public class Candy extends DessertItem{
	double weight;
	int pricePerPound;
	
	public Candy(String name, double weight, int pricePerPound) {
		this.name = name;
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	};
	
	public int getCost(){
		double total = weight*pricePerPound;
		return (int) Math.round(total);
	}
	
	public String toString() {
		DessertShoppe dessertShoppe = new DessertShoppe();
		String totalCost = dessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return String.valueOf(weight)+"lbs. @"+dessertShoppe.cents2dollarsAndCentsmethod(pricePerPound)+"/lbs"+"\n"+ getName()+dessertShoppe.Space(name,totalCost)+totalCost + "\n";
		
	}

}
