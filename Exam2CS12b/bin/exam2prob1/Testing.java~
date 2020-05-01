package lesson25;

public class Testing {

	public Testing() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Marketer chad = new Marketer(1);
		printInfo("chad",chad);
		
		Secretary joe = new LegalSecretary(13);
		printInfo("joe",joe);
		joe.takeDictation("Write me a letter...");
		
		LegalSecretary joey = new LegalSecretary(7);
		printInfo("joey",joey);
		//joey.takeDictation("Write me a letter...");
		joey.fileLegalBriefs();
		
		Lawyer yasuko = new Lawyer(4);
		printInfo("yasuko",yasuko);
		yasuko.sue("Tim Hickey");
		
		Marketer caitlin = new Marketer(5);
		printInfo("caitlin",caitlin);
		caitlin.advertise();
		
		Consultant tai = new Consultant();
		
		Intern stu = new Intern();
		
		Staff[] staff = {chad,joe,joey, yasuko,caitlin,tai};
		HR[] hr = {chad,joe,joey, yasuko,caitlin,stu};
		
		printStaff(staff);
		printHR(hr);
		
	}
	
	public static void printStaff(Staff[] staff) {
		System.out.println("The staff is:");
		System.out.printf("%20s %10s%n","title","salary");
		for(Staff person: staff) {
			System.out.printf("%20s %10.2f%n", 
					person.getTitle(),person.getSalary());
		}
	}
	
	public static void printHR(HR[] hr) {
		System.out.println("The HR qualifing staff is:");
		System.out.printf("%5s %10s%n","hours","vacation");
		for(HR person: hr) {
			System.out.printf("%5d %5d%n", 
					person.getHours(),person.getVacationDays());
		}
	}
	
	public static void printInfo(String name,Employee e) {
		System.out.println("\n Info on employee "+e);
		System.out.println(name+" has " + e.getHours() + " hours of work per week.");
		System.out.println(name+" has a salary of " + e.getSalary() + ".");
		System.out.println(name+" has " + e.getVacationDays() + " vacations days.");
		System.out.println(name+" vacation day form is " + e.getVacationForm() + ".");
		System.out.println(e.getTitle());
	}

}
