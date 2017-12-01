package calculator;

//Using of ICalculator as Instance, cos of mocking tests
public class UsingSomeCalculator {
	private ICalculator calculator;

    public UsingSomeCalculator(final String calledFrom)
    {
        System.out.println("UsingSomeCalculator::ctor: " + calledFrom);
    }

	public void setCalculator(final ICalculator calculator) {
        System.out.println("UsingSomeCalculator::setCalculator");
		this.calculator = calculator;
	}

	public int specialAdd(final int a, final int b) {
        System.out.println("UsingSomeCalculator::specialAdd");
        if (calculator == null)
        {
            return 0;
        }

		return calculator.add(a, b);
	}
}
