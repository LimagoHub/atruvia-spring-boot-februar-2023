package math;

public class CalculatorImpl implements Calculator{

    // RoleAllowedAdmin
    @Override
    public double add(double a, double b) {
        return a + b;
    }


    // RunAsAdmin
    // RoleAllowedGast
    @Override
    public double sub(double a, double b) {
        return this.add(a, -b);
    }
}
