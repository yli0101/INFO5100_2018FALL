package question1;

public class MyIndexOutOfBoundException {
	public static int index;
	public static int lowestBound;
	public static int highestBound;

	
	public static void main(String[] arg0) throws indexOutOfBoundException {
		index = 10;
		lowestBound = 0;
		highestBound = 9;
		
		if(index > highestBound || index < lowestBound)
			throw new indexOutOfBoundException(lowestBound, highestBound, index);
	}
}

class indexOutOfBoundException extends Exception {
	public int lowestBound;
	public int highestBound;
	public int index;
	
	indexOutOfBoundException(int lowestBound, int highestBound, int index){
		this.lowestBound = lowestBound;
		this.highestBound = highestBound;
		this.index = index;
	}
	public String toString() {
		return "Error Message: Index: " + index + ", but Lower bound: " + lowestBound + ", Upper bound: " + highestBound;
	}
}
