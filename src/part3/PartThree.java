package part3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
*
* @assignment Homework1 
* @fileName PartThree.java 
* @author Stephen MacNeil and David Mosteller
*
*/


public class PartThree {

	public static void main(String[] args)  {
	
		File file = new File("input/countries-info.txt");
		Map <String, ArrayList<String>> list = readLargeFile(file);
		
		printMap(list);
		
	}
	
	public static void printMap(Map<String, ArrayList<String>> map) {
	    Iterator<Entry<String, ArrayList<String>>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, ArrayList<String>> pairs = it.next();
	        System.out.println(pairs.getKey()+":");
	        System.out.print("     ");
	        
	        
	        ArrayList<String> valueArray = pairs.getValue();
	        Collections.sort(valueArray);
			for (String  ppl : valueArray) {
		        System.out.printf("%s",ppl+",");
			}
			System.out.println();
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}

	private static Map<String, ArrayList<String>> readLargeFile(File file) {
		 try {
		    	Scanner scanner =  new Scanner(file, "UTF-8");	
	            Map <String, ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
	            
	            String line = null;
	            String[] str = new String [20];
	            ArrayList <String> key;
		    	while (scanner.hasNextLine()){
		    		line = scanner.nextLine();
		    		str = line.split(",");    	
		    		
		    		if ((key = list.get(str[0]))==null) {
			    		key = new ArrayList<String>();
			    		key.add(str[1]);
			    		list.put(str[0], key);
		    			
		    		} else {
			    		key = list.get(str[0]);
			    		key.add(str[1]);
		    		}
		    	}
		    	return list;
		    	
		    } catch (Exception ex) {
		    	System.out.println(ex);
		    	return null;
		    }
	}
}
