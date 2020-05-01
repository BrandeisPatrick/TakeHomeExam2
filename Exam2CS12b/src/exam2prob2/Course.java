package exam2prob2;

import java.util.Scanner;

public class Course {
    String subject;
    String code;
    String section;
    String term;
    int enrolled;
    String instructor;
    String name;



    public Course readCourse(Scanner in){
    	try {
    		this.subject = in.next();
    		this.code = in.next();
    		this.section = in.next();
    		this.term = in.next();
    		this.enrolled = makeInt(in.next());
    		this.instructor = in.next();
    		this.name = in.nextLine();
    	} catch(Exception e) {
    		System.out.println("Exception: "+e);
    	}
        return this;
    }

    private int makeInt(String s) {
    	try {
    		return Integer.parseInt(s);
    	} catch (Exception e) {
    		System.out.println("Exception: "+s+": "+ e);
    		return 0;
    	}
    }
    public String toString(){
	return String.format(
            "%s: %s %s '%s' (%s) %d %s%n",
    	this.subject,
    	this.code,
	    this.section,
	    this.name,
	    this.term,
	    this.enrolled,
	    this.instructor);

	
    }

}