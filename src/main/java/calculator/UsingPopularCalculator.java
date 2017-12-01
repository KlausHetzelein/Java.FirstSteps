package calculator;


public class UsingPopularCalculator
{
    private PopularCalculator popularCalcuator;// = new PopularCalculator();

    public UsingPopularCalculator()
    {
        popularCalcuator = new PopularCalculator();
    }

    public int add(final int a, final int b)
    {
        return popularCalcuator.add(a, b);
    }

    public int sub(final int a, final int b)
    {
        return popularCalcuator.sub(a, b);
    }
}
