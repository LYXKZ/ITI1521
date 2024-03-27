public class Q3_SquareArray{

	public static int[] createArray(int size) {

		// local variable, a reference to an array of integer is declared
		int[] theArray;

		// creation of the actual array, of size "size".
		theArray = new int[size];

		// each elements is assigned the square of its index;
		for(int i = 0; i < size; i++){
			theArray[i] = i*i;
		}

		// result is returned
		return theArray;
	}

	public static void main(String[] args){

		// local variable, a reference to an array of integer is declared.
		// Even trough it has the same name as the local variable in the
		// method "createArray", these are two different variables. They
		// have different scopes

		int[] theArray;

		// call the methos "createArray" for a size 13, and stores the result
		// in the variable "theArray"
		theArray = createArray(13);


		for(int i = 0; i < theArray.length; i++){
			System.out.println("The square of " + i + " is: " + theArray[i]);
		}

	}
}
