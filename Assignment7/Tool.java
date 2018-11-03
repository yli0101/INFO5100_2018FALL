package question3;

public class Tool {
	protected int strength;
	protected char type;
	
	public void setStrength(int strength) {
		this.strength=strength;
	}	
}


/* Implement class Scissors */
class Scissors extends Tool {
	public Scissors(int strength) {
		this.strength = strength;
		this.type = 's';
	}
	
	public boolean fight(Tool tool) {
		int cur = strength;
		if(tool.type == 'r') 
			cur = cur/2;
		
		if(tool.type == 'p')
			cur = cur*2;
		
		if(cur > tool.strength)
			return true;
		
		return false;
	}
}

/* Implement class Paper */
class Paper extends Tool {
	public Paper(int strength) {
		this.strength = strength;
		this.type = 'p';
	}
	
	public boolean fight(Tool tool) {
		int cur = strength;
		if(tool.type == 'r') 
			cur = cur*2;
		
		if(tool.type == 's')
			cur = cur/2;
		
		if(cur > tool.strength)
			return true;
		
		return false;
	}
	
}


/* Implement class Rock */
class Rock extends Tool {
	public Rock(int strength) {
		this.strength = strength;
		this.type = 'r';
	}
	
	public boolean fight(Tool tool) {
		int cur = strength;
		if(tool.type == 's') 
			cur = cur*2;
		
		if(tool.type == 'p')
			cur = cur/2;
		
		if(cur > tool.strength)
			return true;
		
		return false;
	}
}

// Test
class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}
