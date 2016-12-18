package calculatorTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import calculator.Calculator;
import calculator.ICalculator;
import calculator.PopularCalculator;
import calculator.UsingSomeCalculator;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTests {
	@Mock
	private ICalculator mockedCalculator;
	@InjectMocks
	private UsingSomeCalculator target = new UsingSomeCalculator();

	@Test
	public void firstUseOfMock() {
		ICalculator test = mock(Calculator.class);

		when(test.add(2, 3)).thenReturn(5);

		int result = test.add(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void secondUseOfMock() {
		ICalculator test = mock(ICalculator.class);
		UsingSomeCalculator sut = new UsingSomeCalculator();
		sut.setCalculator(test);

		when(test.add(2, 3)).thenReturn(5);

		int result = sut.specialAdd(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void thirdUseOfMock() {
		when(mockedCalculator.add(2, 3)).thenReturn(5);

		int result = target.specialAdd(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void useOfInjectedMockInSecondTest() {
		when(mockedCalculator.add(2, 3)).thenReturn(7);

		// same params but different result
		int result = target.specialAdd(2, 3);
		assertEquals(7, result);

		// other params no when
		result = target.specialAdd(4, 8);
		assertEquals(0, result);

		when(mockedCalculator.add(4, 8)).thenReturn(12);
		result = target.specialAdd(4, 8);
		assertEquals(12, result);
	}

	@Test
	public void mockOfClassWithoutInterface() {
		PopularCalculator test = mock(PopularCalculator.class);

		when(test.add(2, 3)).thenReturn(5);

		int result = test.add(2, 3);
		verify(test, atLeastOnce()).add(2, 3);
		verify(test, atLeastOnce()).add(anyInt(), anyInt());

		assertEquals(5, result);
	}
}
