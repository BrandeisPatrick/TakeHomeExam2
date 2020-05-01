package exam2prob2;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Accesses data from the registrar for courses offered from Fall 2018 to Spring 2020
 * @throws FileNotFoundException
 */

public class Registrar {
    ArrayList<Course> courses = new ArrayList<>();

    /**
     * read course information in from a file
     * and store it in the courses ArrayList
     * @throws FileNotFoundException
     */
    public void readCourses() throws FileNotFoundException {
		String filename = "courses2020.csv";
		File courseFile = new File(filename);
		Scanner in = new Scanner(courseFile);
		int counter=0;
		while (in.hasNext()) {
			String line = in.nextLine();
		    Scanner linein = new Scanner(line);
		    linein.useDelimiter(",");
		    Course c = new Course();
		    c.readCourse(linein);
		    this.courses.add(c);
		    linein.close();
		    if (counter++%100==0) {
		    	System.out.println(counter+": "+c);
		    }
		}
		in.close();
    }
    
    /**
     * interact with user and print out courses
     * by instructor, department, or courseid
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	Registrar r = new Registrar();
    	r.readCourses();

    	
    }
    
    
}