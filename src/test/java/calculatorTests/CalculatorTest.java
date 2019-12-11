package calculatorTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import calculator.Calculator;
import calculator.ICalculator;
import calculator.PopularCalculator;
import calculator.UsingSomeCalculator;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest
{
	@Mock
	private ICalculator mockedCalculator;

	@InjectMocks
    private final UsingSomeCalculator target = new UsingSomeCalculator("InjectMocks");

	@Test
	public void firstUseOfMock() {
		final ICalculator test = mock(Calculator.class);

		when(test.add(2, 3)).thenReturn(5);

		final int result = test.add(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void secondUseOfMock() {
		final ICalculator test = mock(ICalculator.class);
        final UsingSomeCalculator sut = new UsingSomeCalculator("secondUseOfMock::new");
		sut.setCalculator(test);

		when(test.add(2, 3)).thenReturn(5);

		final int result = sut.specialAdd(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void thirdUseOfMock() {
        // die Besonderheit hier ist, dass das von target verwendete Interface
        // dem target nicht explizit per set zugewiesen wurde,
        // sondern dass die Annotationen oben @mock, @InjectMocks automatisch
        // dafür gesorgt haben, dass das gemockte Objekt an unsere zu
        // testende Klasse übergeben wird.
        //
        @SuppressWarnings("unused")
        final ICalculator secondCalculator = mock(ICalculator.class);

        // das geht und überschreibt den injecteden mock und führt zum Scheitern
        // des Tests
        //
        // target.setCalculator(secondCalculator);

		when(mockedCalculator.add(2, 3)).thenReturn(5);

		final int result = target.specialAdd(2, 3);

		assertEquals(5, result);
	}

	@Test
	public void useOfInjectedMockInSecondTest() {
		when(mockedCalculator.add(2, 3)).thenReturn(7);

		// same params but different result
		int result = target.specialAdd(2, 3);
		assertEquals(7, result);

        // other params no when: dann liefert specialAdd vom Mock den
        // Defaultwert (0)
		result = target.specialAdd(4, 8);
		assertEquals(0, result);

		when(mockedCalculator.add(4, 8)).thenReturn(12);
		result = target.specialAdd(4, 8);
		assertEquals(12, result);
	}

	@Test
	public void mockOfClassWithoutInterface() {

        // arrange
        final PopularCalculator test = mock(PopularCalculator.class);
		when(test.add(2, 3)).thenReturn(5);

        // act
		final int result = test.add(2, 3);

        // assert
		verify(test, atLeastOnce()).add(2, 3);
		verify(test, atLeastOnce()).add(anyInt(), anyInt());

		assertEquals(5, result);
	}
}
