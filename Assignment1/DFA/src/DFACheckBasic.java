
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class DFACheckBasic {
	public static String data;
	public static int arrSize;
	public static Map<String, String> collected = new HashMap<>();
	public static Stack<Character> el = new Stack<Character>();
	public static boolean boo;

	public static void main(String[] args) {
		String fName = "";
		if (0 < args.length) {
			   fName = args[0];
			} else {
			   System.err.println("Invalid arguments count:" + args.length);
			   System.exit(0);
			}
		ArrayList<String> listData = fileReader(fName);

		for (String str : listData) {
			data = str;
			Start s = new Start(data);
		}

		System.out.println("NOTE: I USED HASHMAP TO STORE DATA, DISPLAYED CONTENT MIGHT NOT BE IN ORDER AS FROM FILE...");
		for (String key : collected.keySet()) {
			System.out.println(key + " " + collected.get(key));
		}

	}

	public static void add_elements_to_stack(String str) {
		char[] elements = str.toCharArray();
		// For loop to reverse the given string and adding to stack
		for (int i = elements.length - 1; i >= 0; i--) {
			el.push(elements[i]);
		}
	}

	public static String acceptable() {
		return "accepted";
	}

	public static String reject() {
		return "rejected";
	}

	// Checks if stack is empty, if stack is empty, program will return to main
	public static boolean stack_a_status() {
		if (el.isEmpty()) {
			collected.put(data, acceptable());
			return true;
		}
		return false;
	}

	public static boolean stack_r_status() {
		collected.put(data, reject());
		return true;
	}

	public static ArrayList<String> fileReader(String fName) {
		// write your code here
		ArrayList<String> data = new ArrayList<>();
		String str;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			FileInputStream file = new FileInputStream(fName);
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				str = myReader.nextLine();
				data.add(str);
			}

			reader.close();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File do not exist");
		} catch (IOException e) {
			System.out.print(e);
		} catch (NullPointerException e) {
			System.out.println("Null pointer");
		}
		return data;
	}
}

class Start {

	Start(String str) {
		DFACheckBasic.add_elements_to_stack(str);

		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			B b = new B();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			C c = new C();
		}
	}
}

class B {
	B() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			B b = new B();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			E e = new E();
		}
	}

}

class C {
	C() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			D d = new D();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			C c = new C();
		}
	}

}

class D {
	D() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			B b = new B();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			G g = new G();
		}
	}
}

class E {
	E() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			F f = new F();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			C c = new C();
		}
	}
}

class F {
	F() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			B b = new B();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			I i = new I();
		}
	}
}

class G {
	G() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			H h = new H();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			C c = new C();
		}
	}
}

class H {
	H() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			B b = new B();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			J j = new J();
		}
	}
}

class I {
	I() {
		DFACheckBasic.boo = DFACheckBasic.stack_a_status();
		if (DFACheckBasic.boo) {
			return;
		}
		if (DFACheckBasic.el.peek().equals('0')) {
			DFACheckBasic.el.pop();
			J j = new J();
		} else if (DFACheckBasic.el.peek().equals('1')) {
			DFACheckBasic.el.pop();
			C c = new C();
		}
	}

}

class J {
	J() {
		DFACheckBasic.stack_r_status();
		return;
	}
}
