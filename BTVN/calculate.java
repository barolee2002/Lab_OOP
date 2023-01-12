import javax.swing.JOptionPane;

public class calculate {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, "please input the first number: ", "Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "please input the second number: ", "Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		double difference = num1 - num2;
		double produc = num1 * num2;
		double quotien = num1 / num2;
		JOptionPane.showMessageDialog(null,
				"sum: " + sum + "\ndifference: " + difference + "\nproduc: " + produc + "\nquotien: " + quotien);
		System.exit(0);

	}
}
