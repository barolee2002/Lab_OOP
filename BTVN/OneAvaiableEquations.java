import java.util.Scanner;

    public class OneAvaiableEquations {
	public static void main(String[] args) {
		double a, b,x;
		Scanner nhap = new Scanner(System.in);
		System.out.println("ax + b = 0 \n");
		System.out.print("a = ");
		a = nhap.nextDouble();
		System.out.print("b = ");
		b = nhap.nextDouble();
		if (a == 0) {
			if (b == 0)
				System.out.println("pt vo so nghiem");
			else
				System.out.println("pt vo nghiem");
		} else {
			x = -b/a;
			System.out.println("x = " + x);
		}
		nhap.close();
	}
}

