package calculator;

public class Calculator implements ICalculator {
    @Override
	public int add(final int a, final int b) {
		return a + b;
	}

    @Override
	public int sub(final int a, final int b) {
		return a - b;
	}

}
