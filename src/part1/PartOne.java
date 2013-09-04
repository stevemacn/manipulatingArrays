package part1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @assignment Homework1 
 * @fileName PartOne.java 
 * @author Stephen MacNeil and David Mosteller
 *
 */

public class PartOne {
	
	public static void main(String[] args) throws IOException  {
		File file = new File("input/packets.txt");
		Map<String, Integer> list = readLargeFile(file);
    	List<Entry<String, Integer>> sorted = orderMapByValue(list);
        //System.out.println(sorted);

        int count=1;
        System.out.println("#: type : freq");
		for (Entry<String, Integer>  sort : sorted) {
	        System.out.println(count + ": "+sort.getKey() + " : "+sort.getValue());
	        if (count++==10) { break;}
		}	
	}
	
	private static Map<String, Integer> readLargeFile(File file) throws IOException {
	    try {
	    	Scanner scanner =  new Scanner(file, "UTF-8");	
            Map <String, Integer> list = new HashMap<String, Integer>();
            
            String line = null;
            String[] str = new String [20];
            
	    	while (scanner.hasNextLine()){
	    		line = scanner.nextLine();
	    		str = line.split(",");
	    		Integer count = list.get(str[1]+" "+str[2]);
	    		list.put(str[1]+" "+str[2], count != null ? count+1 : 0);		    	
	    	}
	    	
	    	return list;
	    	
	    } catch (Exception ex) {
	    	System.out.println(ex);
	    	return null;
	    }
	}
	
	static List<Entry<String, Integer>> orderMapByValue(Map<String, Integer> map) {

	    List<Map.Entry<String, Integer>> list = 
	        new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

	    // Sort list by integer values
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });

	    return list;
	}	
}