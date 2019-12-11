package calculatorTests;

import calculator.PopularCalculator;
import calculator.UsingPopularCalculator;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsingPopularCalculatorTest
{
    @Mock
    private PopularCalculator populalarCalculatorMock;

    // unser UsingPopular hat von aussen keine Möglichkeit den PopularCalc zu
    // setzen
    // dennoch schafft es Mockito das zu injecten und zwar ohne dass unser
    // new Popular... im ctor von Using das kaputt macht
    // ???
    // Mockito ersetzt das field wohl nach dem ctor !!!
    // geht aber nicht, wenn field final ist !!!
    @InjectMocks
    private final UsingPopularCalculator sut = new UsingPopularCalculator();

    @Test
    public void testAddWithoutAnyMocks()
    {
        final UsingPopularCalculator calculator = new UsingPopularCalculator();

        final int result = calculator.add(1, 3);

        assertEquals(4, result);
    }

    @Test
    public void testAddWithAutoMocks()
    {
        when(populalarCalculatorMock.add(2, 3)).thenReturn(7).thenReturn(5);

        assertEquals(7, sut.add(2, 3));
        assertEquals(5, sut.add(2, 3));

        verify(populalarCalculatorMock, times(2)).add(anyInt(), anyInt());
        verifyNoMoreInteractions(populalarCalculatorMock);
    }
}
