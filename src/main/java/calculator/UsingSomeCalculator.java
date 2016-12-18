package calculator;

//Using of ICalculator as Instance, cos of mocking tests
public class UsingSomeCalculator {
	private ICalculator calculator;

	public void setCalculator(ICalculator calculator) {
		this.calculator = calculator;
	}

	public int specialAdd(int a, int b) {
		return calculator.add(a, b);
	}
}
