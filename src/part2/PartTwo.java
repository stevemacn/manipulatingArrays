package part2;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
*
* @assignment Homework1 
* @fileName PartTwo.java 
* @author Stephen MacNeil and David Mosteller
*
*/

public class PartTwo {
	
	private static Set <Person> resultSet = new HashSet<Person>();
	
	public static void main(String[] args) throws IOException  {

		File file = new File("input/userList1.txt");
		File file2 = new File("input/userList1New.txt");
		
		Set<Person> sorted = new HashSet<Person>();;
		Set<Person> list = readLargeFile(file, sorted, false);

        int count=1;
		list = readLargeFile(file2, list, true);
	
		
		Set<Person> treeSet = new TreeSet<Person>(
				new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                       Integer a1 = o1.getAge();
                       Integer a2 = o2.getAge();
                       if (a1==a2) {
                    	   return a1;
                       }
                       
                       return (a1).compareTo(o2.getAge());
                    }
                });
				
		treeSet.addAll(getResultSet());
		System.out.println(getResultSet().size() + " unique results.");
		
        count=1;
		for (Person  ppl : treeSet) {
	        System.out.println(count++ + ": "+ppl.toString());
		}
	}
	
	private static Set<Person> readLargeFile(File file, Set<Person>prs, boolean compare) throws IOException {
	    try {
	    	Scanner scanner =  new Scanner(file, "UTF-8");	            
            String line = null;
            String[] str = new String [20];
    		Person person;
	    	while (scanner.hasNextLine()){
	    		line = scanner.nextLine();
	    		str = line.split(",");
	    		person = new Person(str[0], str[1], str[2], Integer.parseInt(str[3]), str[4], str[5]);
	    		if (prs.add(person)) {
	    			if (compare) { getResultSet().add(person); } 
	    		}
	    	}
	    	
	    	return prs;// list;
	    	
	    } catch (Exception ex) {
	    	System.out.println(ex);
	    	return null;
	    }
	}

	public static Set <Person> getResultSet() {
		return resultSet;
	}

	public void setResultSet(Set <Person> resultSet) {
		PartTwo.resultSet = resultSet;
	}
}
