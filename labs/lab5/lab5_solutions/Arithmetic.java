public class Arithmetic extends AbstractSeries {

    private double sum = 0.0;
    private double index = 1.0;

    public double next() {
        sum = sum + index;
        index = index + 1.0;
        return sum;
    }
}
