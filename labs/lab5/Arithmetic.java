public class Arithmetic extends AbstractSeries {

    private int x = 0;
    private double y = 0;

    public double next() {
        x++; 
        y += x; 
        return y;       
    }
}
