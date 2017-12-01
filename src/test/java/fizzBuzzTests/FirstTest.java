package fizzBuzzTests;

import static fizzBuzz.FizzBuzzer.ConvertToFizzBuzz;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstTest
{

	@Test
	public void Given_1_returns_1() {
		final String result = ConvertToFizzBuzz(1);

		assertEquals("1", result);
	}

	@Test
	public void Given_2_returns_2() {
		final String result = ConvertToFizzBuzz(2);

		assertEquals("2", result);
	}

	@Test
	public void Given_3_returns_Fizz() {
		final String result = ConvertToFizzBuzz(3);

		assertEquals("Fizz", result);
	}

	@Test
	public void Given_5_returns_Buzz() {
		final String result = ConvertToFizzBuzz(5);

		assertEquals("Buzz", result);
	}

	@Test
	public void Given_15_returns_FizzBuzz() {
		final String result = ConvertToFizzBuzz(15);

		assertEquals("FizzBuzz", result);
	}

}
