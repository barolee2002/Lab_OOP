import java.util.Scanner;

    public class TwoAvaiableEquations {
	public static void main(String[] args) {
		double a11,a12,b1,a21,a22,b2,x,y;
		Scanner enter = new Scanner(System.in);
		System.out.println("a11.x + a12.y = b1\na21.x + a22.y = b2\\n");
		System.out.print("a11 = ");
		a11 = enter.nextDouble();
		System.out.print("a12 = ");
		a12 = enter.nextDouble();
		System.out.print("a21 = ");
		a21 = enter.nextDouble();
		System.out.print("a22 = ");
		a22 = enter.nextDouble();
		System.out.print("b1 = ");
		b1 = enter.nextDouble();
		System.out.print("b2 = ");
		b2 = enter.nextDouble();
		if(((a11 / a21) == (a12 / a21)) && ((a11 / a21) != (b1 / b2))) {
			System.out.println("This equation has no solution");
		} else if(((a11 / a21) == (a12 / a21)) && ((a11 / a21) == (b1 / b2))) {
			System.out.println("This equation has infinitely many solutions");
		}
		x = (b1 * a21 - b2 * a11) / (a12 * a21 - a22 * a11);

		y = (b1 - a11 * x) / a12;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		enter.close();
	}
}
