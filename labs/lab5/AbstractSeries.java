public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        double[] myArray = new double[k]; 
		for (int i = 0; i < myArray.length; i++){
			myArray[i] = next();
		}
		return myArray; 
        
    }

}
