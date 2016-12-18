package fizzBuzz;

public class FizzBuzzer {
	public static String ConvertToFizzBuzz(int number) {
		String result = "";
		if (isDividableByThree(number)) {
			result = "Fizz";
		}
		if (isDividableByFive(number)) {
			result = result + "Buzz";
		}
		if (result == "") {
			result = String.valueOf(number);
		}

		return result;
	}

	private static boolean isDividableByFive(int number) {
		return number % 5 == 0;
	}

	private static boolean isDividableByThree(int number) {
		return number % 3 == 0;
	}
}
