package question3;

public class Pet {
	private String petName, ownerName, color;
	protected int sex;
	public static final int MALE=1, FEMALE=2, SPAYED=3, NEUTERED=4;
	
	public Pet(String petName, String ownerName, String color) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setSex(int sexid) {
		sex = sexid;
	}
	
	public String getSex() {
		if (this.sex == MALE){
			return "Male";
		}
		
		else if (this.sex == FEMALE){
			return "Female";
		}
		
		else if (this.sex == SPAYED ){
			return "Spayed";
		}
		else if (this.sex == NEUTERED){
			return "Neutered";
		}
		return null;
	}
	
	public String toString() {
		return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex();
	}
	
	//TEST
	public static void main(String[] args) {
		Pet pet = new Pet("Spot", "Mary", "Black and White");
		pet.setSex(MALE);
		System.out.println(pet.toString());
	}

}
