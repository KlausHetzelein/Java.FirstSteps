package fizzBuzzTests;

import static fizzBuzz.FizzBuzzer.ConvertToFizzBuzz;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class firstTests {

	@Test
	public void Given_1_returns_1() {
		String result = ConvertToFizzBuzz(1);

		assertEquals("1", result);
	}

	@Test
	public void Given_2_returns_2() {
		String result = ConvertToFizzBuzz(2);

		assertEquals("2", result);
	}

	@Test
	public void Given_3_returns_Fizz() {
		String result = ConvertToFizzBuzz(3);

		assertEquals("Fizz", result);
	}

	@Test
	public void Given_5_returns_Buzz() {
		String result = ConvertToFizzBuzz(5);

		assertEquals("Buzz", result);
	}

	@Test
	public void Given_15_returns_FizzBuzz() {
		String result = ConvertToFizzBuzz(15);

		assertEquals("FizzBuzz", result);
	}

}
