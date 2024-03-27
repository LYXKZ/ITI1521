public abstract class AbstractSeries implements Series {

    public double[] take( int k ) {
        double[] tuple;
        tuple = new double[ k ];
        for ( int i=0; i<k; i++ ) {
            tuple[ i ] = next();
        }
        return tuple;
    }

}
