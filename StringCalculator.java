package com.java.resource;

public class StringCalculator {

	public int Add(String numbers) {
		String numberArr[];
		int result = 0;

		if (numbers.equals(" ") || numbers.equals("") || numbers.equals(null)) {
			System.out.println("Input is Empty");
			return -1;
		} else
			numberArr = numbers.split(",|;|\n");

		if (numberArr.length == 0) {
			System.out.println("Input is NOT ok");
			return result;
		} else if (numberArr.length == 1) {
			System.out.println("Input has only one number");
			return Integer.parseInt(numberArr[0]);
		} else {
			for (String string : numberArr) {
				System.out.println("String : " + string);
				result += Integer.parseInt(string);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StringCalculator cal = new StringCalculator();
		
		 System.out.println("Add With Empty String" + cal.Add(" "));
		 System.out.println("Add With Only one number" + cal.Add("2"));
		 System.out.println("Add With two numbers" + cal.Add("2,7"));
		 
		System.out.println("Add With only delimiters " + cal.Add(",\n"));
		System.out.println("Add With multiple numbers " + cal.Add("2,7\n8,9\n8"));
		System.out.println("Add With ';' as delimiter " + cal.Add("1;2"));

	}

}
