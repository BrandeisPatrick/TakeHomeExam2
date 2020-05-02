package exam2prob2;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Accesses data from the registrar for courses offered from Fall 2018 to Spring 2020
 * @throws FileNotFoundException
 */

public class Registrar {
	public static String[] numlist = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "night", "ten",
													"eleven", "twelve", "thirteen", "fourteen", "fifteen"};
    ArrayList<Course> courses = new ArrayList<>();
    Map<String, Set<Course>> coursesByEmail;
	Map<String, Set<Course>> coursesBySubject;
	Map<String, Set<Course>> coursesByID;
	Map<Integer, String> numbers;

	public Registrar() {
		coursesByEmail = new HashMap<String, Set<Course>>();
		coursesBySubject = new HashMap<String, Set<Course>>();
		coursesByID = new HashMap<String, Set<Course>>();
		numbers = new HashMap<Integer, String>();
		for(int i=1; i<=15; i++){ numbers.put(i,numlist[i-1]);}
	}

	/**
     * read course information in from a file
     * and store it in the courses ArrayList
     * @throws FileNotFoundException
     */
    public void readCourses() throws FileNotFoundException {
		String filename = "Exam2CS12b/courses2020.csv";
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

			setCoursesByEmail(c);
			setCoursesBySubject(c);
			setCoursesByID(c);

		    linein.close();
		    if (counter++%100==0) {
		    	//System.out.println(counter+": "+c);
		    }
		}
		in.close();
    }


    /**
	 * @author Patrick
	 * create a set of Courses for each key value (Email address)
	 * add Course c to Map<String, Set<Course>>coursesByEmail
     */
	public void setCoursesByEmail(Course c) {
		String[] emailBuffer = c.instructor.split(" ");
		String email = emailBuffer[emailBuffer.length-1];

		if(!coursesByEmail.containsKey(email)){
			Set<Course> set = new HashSet<Course>();
			coursesByEmail.put(email,set);
		}
		coursesByEmail.get(email).add(c);
    }

	/**
	 * @author Patrick
	 * create a set of Courses for each key value (Subject)
	 * add Course c to Map<String, Set<Course>>coursesBySubject
	 */
	public void setCoursesBySubject(Course c) {
		String subject = c.subject;
		if(!coursesBySubject.containsKey(subject)){
			Set<Course> set = new HashSet<Course>();
			coursesBySubject.put(subject,set);
		}
		coursesBySubject.get(subject).add(c);
	}

	/**
	 * @author Patrick
	 * create a set of Courses for each key value (ID)
	 * add Course c to Map<String, Set<Course>>coursesByID
	 */
	public void setCoursesByID(Course c) {
		String id = c.code;
		if(!coursesByID.containsKey(id)){
			Set<Course> set = new HashSet<Course>();
			coursesByID.put(id,set);
		}
		coursesByID.get(id).add(c);
	}

	public void search(){
		System.out.println("How do you want to search? (email/id/subject)");
		Scanner sc = new Scanner(System.in);
		String searchtype = sc.next();
		String input = sc.nextLine().substring(1);
		Set<Course> answer;
		if(searchtype.equals("email")){
			answer = getCoursesByEmail(input);
		}else if(searchtype.equals("id")){
			answer = getCoursesByID(input);
		}else if(searchtype.equals("subject")){
			answer = getCoursesBySubject(input);
		}else{
			System.out.println("invalid input");
			answer = null;
		}
		StringBuilder builder = new StringBuilder();
		if(answer != null) {
			if(answer.size() > 15) {
				builder.append("There were ").append(answer.size()).append(" courses were taught by ").append(input).append("\n");
			}else{
				builder.append("There were ").append(numbers.get(answer.size())).append(" courses were taught by ").append(input).append("\n");
			}
			Iterator<Course> itr = answer.iterator();
			int counter = 1;
			while (itr.hasNext()) {
				Course courseNext = itr.next();
				builder.append(String.format("%d. %s section%s %s in term %s with %s students \n taught by %s \n\n",
						counter++,
						courseNext.code,
						courseNext.section,
						courseNext.name.substring(1),
						courseNext.term,
						courseNext.enrolled,
						courseNext.instructor));
			}
			System.out.println(builder);
		}
	}

	public Set<Course> getCoursesByEmail(String input){
		return coursesByEmail.get(input);
	}

	public Set<Course> getCoursesBySubject(String input){
		return coursesBySubject.get(input);
	}

	public Set<Course> getCoursesByID(String input){
		return coursesByID.get(input);
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
    	r.search();
    }
    
    
}