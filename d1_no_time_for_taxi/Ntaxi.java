import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javafx.util.Pair;

public class Ntaxi {

	static Integer y = 0;
	static Integer x = 0;
	// Orientation, where North is 0, E -> 1, S -> 2, W -> 3
	static Integer o = 0;
	
	// Target location as defined by problem
	static Integer tx = null;
	static Integer ty = null;
	
	// Look up Map, the value is useless, but use the key to detect hitting a block again
	static HashMap<String, String> coordMap = new HashMap<String, String>();
	
    public static void main(String[] args) throws IOException {
    	
	    //Read in values
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Fun with stream and lambdas
		Arrays.stream(in.readLine().split(",")).forEach(e -> {
			computeElement(e.trim());
		});
		
		System.out.println("Final coords: (" + x + "," + y + ")");
		Integer final_shortest_taxi_path = x + y;
		System.out.println("Shortest taxi path: " + final_shortest_taxi_path);
		System.out.println("target: " + tx + "," + ty + " dist: " + (tx + ty));
	}

    // Non-elegant route traversal
	private static void computeElement(String e) {
		String rl = e.substring(0, 1);
		String dist = e.substring(1);
		
		if(rl.contains("R")) {
			if(o == 0) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					x++;
					storeNcheck();
				}
				o = 1;
			} else if (o == 1) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					y--;
					storeNcheck();
				}
				 o = 2;
			} else if (o == 2) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					x--;
					storeNcheck();
				}
				 o = 3;
			} else if (o == 3) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					y++;
					storeNcheck();
				}
				 o = 0;
			} else {
				 // shouldn't get here
			}
		} else { // L
			if(o == 0) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					x--;
					storeNcheck();
				}
				o = 3;
			} else if (o == 1) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					y++;
					storeNcheck();
				}
				 o = 0;
			} else if (o == 2) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					x++;
					storeNcheck();
				}
				 o = 1;
			} else if (o == 3) {
				for(int i = 0; i < Integer.parseInt(dist); i++) {
					y--;
					storeNcheck();
				}
				 o = 2;
			} else {
				// shouldn't get here
			}
		}
	}
	
	private static void storeNcheck() {
		String coordStr = x.toString() + "," + y.toString();
		
		if(tx == null && coordMap.put(coordStr, "blah") != null)
		{
			System.out.println("Found first re visit at " + x + "," + y);
			tx = x;
			ty = y;
		}
	}
	
}
