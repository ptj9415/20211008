package co.taejoon.prj;

public class ggdan {

	public static void main(String[] args) {
		int n = 1;
		for (int j = 2; j < 10; j++) {
			System.out.print("   " + j + "´Ü\t\t");
		}
		System.out.println();
		for (int k = 1; k < 10; k++) {
			for (int i = 2; i < 10; i++) {
				n = i * k;
				System.out.print(i + " * " + k + " = " + n +"\t");
				
			}System.out.println();
		}
	}

}
