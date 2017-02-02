
public class Tester {

	public static void main(String[] args) {
		
		ResizableArray tester = new ResizableArray();
		/*
		data.add(5);
		data.add(10);
		data.add(15);

		String dataList = data.toString();
		int size = data.size();
		int removeZero = data.remove(0);
		System.out.println("removeZero = " + removeZero);
		System.out.println(dataList);
		System.out.println("size = " + size);
		
		int remove = data.remove(0);
		System.out.println("removed = " + remove);
		
		System.out.println("Index of 15: " + data.indexOf(15));
		*/
		
		tester.add(1);
		tester.add(3);
		tester.add(5);
		tester.add(7);
		tester.add(9);
		tester.add(11);
		tester.add(13);
		tester.insert(0,0);
		tester.insert(2,2);
		tester.insert(4,4);
		tester.insert(6,6);
		tester.insert(8,8);
		tester.insert(10,10);
		tester.insert(12,12);
		int val = tester.get(1);
		tester.set(0,val);
		
		tester.remove(4);
		tester.remove(5);
		tester.remove(5);
		tester.remove(6);
		tester.remove(6);
		tester.remove(6);
		tester.remove(6);

		System.out.println(tester);
		
	}

}
