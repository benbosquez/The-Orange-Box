// MathLab02st.java
// The Rational Class Program I
// This is the student, starting version of the MathLab02 assignment.

import javax.swing.JOptionPane;

public class MathLab02st {
	public static void main(String args[]) {
		String strNbr1 = JOptionPane.showInputDialog("Enter Numerator ");
		String strNbr2 = JOptionPane.showInputDialog("Enter Denominator ");

		int num = Integer.parseInt(strNbr1);
		int den = Integer.parseInt(strNbr2);

		Rational r = new Rational(num, den);
		JOptionPane.showMessageDialog(null, r.getRational() + " equals " + r.getDecimal());

		System.exit(0);
	}
}

class Rational {
	private int num, den, firstNum, firstDen;

	// Rational
	public Rational(int n, int d) {
		firstNum = num =n;
		firstDen = den = d;
		reduce();
	}

	// getNum
	public int getNum()
	{
		return num;
	}
	// getDen
	public int getDen()
	{
		return den;
	}

	// getDecimal
	public double getDecimal() {
		return (double)num / den;

	}
	// getRational
	public String getRational()
	{
		return num + "/" + den;
	}

	// getOriginal
	public String getOriginal()
	{
		return firstNum +"/"+ firstDen;
	}

	// reduce
	public void reduce() 
	{
		int gcf = getGCF(firstNum, firstDen);
		num = firstNum/gcf;
		int gcd = getGCF(firstNum, firstDen);
		den = firstNum/gcf;
		
	}
	
	private int getGCF(int firstNum, int firstDen) {
		int rem = 0;
		int gcf = 0;
		do {
			rem = firstNum % firstDen;
			if (rem == 0)
				gcf = firstDen;
			else {
				firstNum = firstDen;
				firstDen = rem;
			}
		} while (rem != 0);
		return gcf;
	}
}
 