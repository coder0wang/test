package test;

public class One extends O {
	int i = 0;

	public static void main(String[] args) {
		One one = new One();
		one.start(one);
		one.start(one, 2);
//		one.end(one);
		System.out.println(one.i);
	}

	public void start(One one) {
		one.i = 5;
		one.i = one.i++;
		One one1 = new One();
		one1.i = 9;
		one = one1;
	}

	public void start(One one, int j) {
		if (j > 0 | one.i++ > 0) {
			one.i = one.i + 5;
		}
	}

	public void end(One one) {
		one.i = one.i + 5;
	}
}

class O {
	public void end(One one) {
		one.i = one.i + 5 + 5;
	}
}