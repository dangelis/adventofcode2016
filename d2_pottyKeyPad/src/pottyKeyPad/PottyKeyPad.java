package pottyKeyPad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class PottyKeyPad {
	
	static KeyPad keypad = null;
	static Key currentKey = null;
	static ArrayList<String> keyCode = new ArrayList<String>();
	
	public static void main (String[] args) {
		//Read in values
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if(args.length > 1 && args[1].contains("2")) {
			System.out.println("Using keypad 2");
			keypad = createKeyPad2();
		} else {
			System.out.println("Using keypad 1");
			keypad = createKeyPad1();
		}
		
		// Set the starting key
		currentKey = keypad.pad.get("5");
		
		// Parse
		in.lines().forEach(l -> {
			l.chars().mapToObj(i -> (char)i).forEach(c -> traversKeys(c));
			keyCode.add(currentKey.name);
		});		
		
		System.out.println("Key code:");
		for(String s : keyCode) {
			System.out.println(s);
		}
	}

	static void traversKeys (char c) {
		if(c == 'U') {
			currentKey = currentKey.goUp();
		} else if (c == 'R') {
			currentKey = currentKey.goRt();
		} else if (c == 'L') {
			currentKey = currentKey.goLt();
		} else if (c == 'D') {
			currentKey = currentKey.goDn();
		} else {
			// Shouldn't get here
		}
	}

	private static KeyPad createKeyPad1() {
		
		KeyPad keypad = new KeyPad();
		// Create key pad keys
		//|1|2|3|
		//|4|5|6|
		//|7|8|9|
		Key key1 = new Key("1");
		Key key2 = new Key("2");
		Key key3 = new Key("3");
		Key key4 = new Key("4");
		Key key5 = new Key("5");
		Key key6 = new Key("6");
		Key key7 = new Key("7");
		Key key8 = new Key("8");
		Key key9 = new Key("9");
		
		// Assign mappings (linked list like)
		key1.setUp(key1);
		key1.setRt(key2);
		key1.setLt(key1);
		key1.setDn(key4);
		
		key2.setUp(key2);
		key2.setRt(key3);
		key2.setLt(key1);
		key2.setDn(key5);
		
		key3.setUp(key3);
		key3.setRt(key3);
		key3.setLt(key2);
		key3.setDn(key6);
		
		key4.setUp(key1);
		key4.setRt(key5);
		key4.setLt(key4);
		key4.setDn(key7);

		key5.setUp(key2);
		key5.setRt(key6);
		key5.setLt(key4);
		key5.setDn(key8);

		key6.setUp(key3);
		key6.setRt(key6);
		key6.setLt(key5);
		key6.setDn(key9);

		key7.setUp(key4);
		key7.setRt(key8);
		key7.setLt(key7);
		key7.setDn(key7);

		key8.setUp(key5);
		key8.setRt(key9);
		key8.setLt(key7);
		key8.setDn(key8);

		key9.setUp(key6);
		key9.setRt(key9);
		key9.setLt(key8);
		key9.setDn(key9);
		
		keypad.pad.put("1", key1);
		keypad.pad.put("2", key2);
		keypad.pad.put("3", key3);
		keypad.pad.put("4", key4);
		keypad.pad.put("5", key5);
		keypad.pad.put("6", key6);
		keypad.pad.put("7", key7);
		keypad.pad.put("8", key8);
		keypad.pad.put("9", key9);
		
		return keypad;
	}
	
	private static KeyPad createKeyPad2() {
		
		KeyPad keypad = new KeyPad();
		// Create key pad keys
		//		  |1|
		//		|2|3|4|
		//	  |5|6|7|8|9|
		//		|A|B|C|
		//		  |D|
		Key key1 = new Key("1");
		Key key2 = new Key("2");
		Key key3 = new Key("3");
		Key key4 = new Key("4");
		Key key5 = new Key("5");
		Key key6 = new Key("6");
		Key key7 = new Key("7");
		Key key8 = new Key("8");
		Key key9 = new Key("9");
		Key keyA = new Key("A");
		Key keyB = new Key("B");
		Key keyC = new Key("C");
		Key keyD = new Key("D");
		
		// Assign mappings (linked list like)
		key1.setUp(key1);
		key1.setRt(key1);
		key1.setLt(key1);
		key1.setDn(key3);
		
		key2.setUp(key2);
		key2.setRt(key3);
		key2.setLt(key2);
		key2.setDn(key6);
		
		key3.setUp(key1);
		key3.setRt(key4);
		key3.setLt(key2);
		key3.setDn(key7);
		
		key4.setUp(key4);
		key4.setRt(key4);
		key4.setLt(key3);
		key4.setDn(key8);

		key5.setUp(key5);
		key5.setRt(key6);
		key5.setLt(key5);
		key5.setDn(key5);

		key6.setUp(key2);
		key6.setRt(key7);
		key6.setLt(key5);
		key6.setDn(keyA);

		key7.setUp(key3);
		key7.setRt(key8);
		key7.setLt(key6);
		key7.setDn(keyB);

		key8.setUp(key4);
		key8.setRt(key9);
		key8.setLt(key7);
		key8.setDn(keyC);

		key9.setUp(key9);
		key9.setRt(key9);
		key9.setLt(key8);
		key9.setDn(key9);
		
		keyA.setUp(key6);
		keyA.setRt(keyB);
		keyA.setLt(keyA);
		keyA.setDn(keyA);
		
		keyB.setUp(key7);
		keyB.setRt(keyC);
		keyB.setLt(keyA);
		keyB.setDn(keyD);
		
		keyC.setUp(key8);
		keyC.setRt(keyC);
		keyC.setLt(keyB);
		keyC.setDn(keyC);
		
		keyD.setUp(keyB);
		keyD.setRt(keyD);
		keyD.setLt(keyD);
		keyD.setDn(keyD);
		
		keypad.pad.put("1", key1);
		keypad.pad.put("2", key2);
		keypad.pad.put("3", key3);
		keypad.pad.put("4", key4);
		keypad.pad.put("5", key5);
		keypad.pad.put("6", key6);
		keypad.pad.put("7", key7);
		keypad.pad.put("8", key8);
		keypad.pad.put("9", key9);
		keypad.pad.put("A", keyA);
		keypad.pad.put("B", keyB);
		keypad.pad.put("C", keyC);
		keypad.pad.put("D", keyD);
		
		return keypad;
	}
}
