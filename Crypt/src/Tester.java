import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		
		Crypt c = new Crypt();
		
		c.encrypt("test.txt", "testEncrypted.txt", "FEATHER");
		
		c.decrypt("testEncrypted.txt", "testDecrypted.txt", "FEATHER");
	
		
		
	}

}
