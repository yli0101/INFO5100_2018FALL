package question1;

import java.util.*;

public class Mreview implements Comparable <Mreview>{
	private String title;
	private ArrayList<Integer> ratings;
	
	public Mreview() {
		title = "";
		ratings = new ArrayList<>();
	}
	
	public Mreview(String ttl) {
		title = ttl;
		ratings = new ArrayList<>();
	}
	
	public Mreview(String ttl, int firstRating) {
		title = ttl;
		ratings = new ArrayList<>(firstRating);
		ratings.add(firstRating);
	}
	
	public void addRating(int r) {
		ratings.add(r);
	}
	
	public double aveRating() {
		double avg = 0.0;
		for(int rating: ratings) {
			avg += rating;
		}
		return avg/ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		return this.title.compareTo(obj.title);
	}
	
	public boolean equals(Object obj) {
		if(this.title.equals(obj)) obj = new Mreview();
		return this.title.equals(obj);
	}
	
	public String getTitle() {
		return title;
	}
	
	public int numRatings() {
		return ratings.size();
	}
	
	public String toString() {
		return (getTitle() + ", average " + aveRating() + " out of " + numRatings() + " ratings");
	}
	
	//Test
	public static void main(String[] args) {
        Mreview review = new Mreview("Kill Bill", 3);
        review.addRating(3);
        review.addRating(4);
        review.addRating(3);
        System.out.println(review);
        System.out.println("Avg Rating: " + review.aveRating());
	}
	
}