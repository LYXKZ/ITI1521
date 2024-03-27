public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int[] x = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = i*i;
        }
        return x;
	}

	public static void main(String[] args){
        int n = 13;
		int[] x = createArray(13);
        for (int i = 0; i < n; i++) {
            System.out.println("The square of " + i + " is " + x[i]);
        }
	}
}
