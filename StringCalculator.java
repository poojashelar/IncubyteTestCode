package com.java.resource;

import java.util.ArrayList;

public class StringCalculator {

	public int Add(String numbers) {
		
		 String delimiter = ",|\n|;";
		 String numbersNoDelimiter = numbers;
		 
		if (numbers.equals(" ") || numbers.equals("")) {
			System.out.println("Input is Empty");
			return -1;
		} 
		
	    if (numbers.startsWith("//")) {
	        if(numbers.contains("[") && numbers.contains("]")) {
	        	int startIndexofBracket = numbers.indexOf('[');
	        	int newLineDelimiterIndex =numbers.indexOf("\n");
		        String delimiterString = numbers.substring(startIndexofBracket, newLineDelimiterIndex);
		        String[] splitedDelimiterString = delimiterString.split("");
		        for (int i = 0; i < splitedDelimiterString.length; i++) {
		        	if(splitedDelimiterString[i].equals("[")) {
						delimiter += "|" + splitedDelimiterString[i]+ splitedDelimiterString[i+1] + "]";
					}
				}
	        }
	        else {
	        	int delimiterIndex = numbers.indexOf("//") + 2;
		        delimiter += "|" + numbers.substring(delimiterIndex, delimiterIndex + 1);
	        }
	        numbersNoDelimiter = numbers.substring(numbers.indexOf("\n") + 1);	        
	    }
		return addition(numbersNoDelimiter, delimiter);
	}

	private static int addition(final String numbers, final String delimiter) {
		int result = 0;
		String[] numbersArr = numbers.split(delimiter);
		ArrayList<Number> negativeNumList = new ArrayList<Number>();
		
		if (numbersArr.length == 0) {
			System.out.println("Input is NOT ok");
			return result;
	} else if (numbersArr.length == 1) {
			System.out.println("Input has only one number");
			return Integer.parseInt(numbersArr[0]);
		} else {
			for (String number : numbersArr) {
				if (!number.trim().isEmpty()) {
					 int numberInt = Integer.parseInt(number.trim());
		                if (numberInt < 0) {
		                    negativeNumList.add(numberInt);
		                } else if (numberInt <= 1000) {
                            result += numberInt;
		                }
				}
			}
		}
		
		if (negativeNumList.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumList.toString());
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
		System.out.println("Add when Strings start with // :" + cal.Add("//;\n1;2"));
		try{
			System.out.println("Add when string contains negative numbers :" + cal.Add("2,-4,6"));
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Add when string contains numbers > 1000: " + cal.Add("82,1004,1000,8"));
		System.out.println("Add when string contains [*][%] delimiter: " + cal.Add("//[***][%]\n1***2***3"));
		System.out.println("Add when string contains multiple delimiter in [] : " + cal.Add("//[***][%%%]\n1***10***3"));
		System.out.println("Add when string contains * delimiter: " + cal.Add("//[***]\n1***2***3"));

	}

}
