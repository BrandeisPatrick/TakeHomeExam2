package exam2prob1;

public abstract class Secretary extends Employee {
	
	public Secretary(int years) {
		super(years);
	}
	
	public void takeDictation(String text) {
		System.out.println("Taking dictation of text: "+text);
	}
	
	public int getSeniorityBonus() {
		return 0;
	}
	/*
	public String getTitle() {
		return "Secretary";
	}
	*/

}
