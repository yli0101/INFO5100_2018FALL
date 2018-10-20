package assignment;

import java.util.Vector;

public class CheckOut {
	private Vector<DessertItem> dessert;
	
	public CheckOut() {
		dessert = new Vector<DessertItem>();
	}
	
	public int numberOfItems() {
		return dessert.size();
	}
	
	public void enterItem(DessertItem item) {
		dessert.add(item);
	}
	
	public void clear() {
		dessert.clear();
	}
	
	public int totalCost() {
		if(dessert.isEmpty())
			return 0;
		int total = 0;
		
		for(DessertItem item: dessert) {
			total += item.getCost();
		}
		
		return total;
	}
	
	public int totalTax() {
		DessertShoppe dessertShoppe = new DessertShoppe();
		return (int)(totalCost() * dessertShoppe.taxRate);
	}
	
	public String toString() {
		String Name= DessertShoppe.storeName;
		String dash="--------------------";
		
		int total = totalCost()+totalTax();	
		String totalTax= DessertShoppe.cents2dollarsAndCentsmethod(totalTax());
		String totalCost= DessertShoppe.cents2dollarsAndCentsmethod(total);
		String Purchased = " ";
		for (DessertItem item:dessert){
			Purchased += item.toString();
		}
		
		String receipt = Name + "\n"+ dash + "\n"+ Purchased + "tax" + DessertShoppe.Space("tax", totalTax)+totalTax + "\n" + "Total Cost"+DessertShoppe.Space("Total Cost", totalCost)+totalCost;
		return receipt;
	}

}
