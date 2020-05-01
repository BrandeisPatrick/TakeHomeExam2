package lesson25;

public abstract class Employee implements Staff,HR{
	
	private int years;
	
	public Employee(int initialYears) {
		this.years = initialYears;
	}
	
	public int getYears() {
		return this.years;
	}
	
	public int getHours() {
		return 40;
	}
	
	public double getSalary() {
		return 40000.0;
	}
	
	public int getVacationDays() {
		return 10+ this.getSeniorityBonus();
	}
	
	public int getSeniorityBonus() {
		return 2*this.years;
	}
	
	public String getVacationForm() {
		return "yellow";
	}
	
	
	public abstract String getTitle(); 

}
