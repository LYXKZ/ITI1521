public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		// note: you should normaly ensure that the call is valid (array not null,
		// insertion point inside the array)

		int[] afterArray;

		// increase the size of the array by one
		afterArray = new int[beforeArray.length + 1];

		// copy beforeArray into afterArray up to the instertion point
		for(int i = 0; i < indexToInsert; i++){
			afterArray[i] = beforeArray[i];
		}

		// insert new element
		afterArray[indexToInsert] = valueToInsert;

		// copy the rest of beforeArray into afterArray
		for(int i = indexToInsert; i < beforeArray.length; i++){
			afterArray[i+1] = beforeArray[i];
		}

		return afterArray;
	}

	public static void main(String[] args){
		int[] valuesArray;
		valuesArray = new int[]{1,5,4,7,9,6};
		System.out.println("Array before insertion:");
		for(int i = 0 ; i < valuesArray.length; i++){
			System.out.println(valuesArray[i]);
		}

		// call the method and store the result into the same reference variable
		// two distinct reference variables could have been used, but that is not necessary
		valuesArray = insertIntoArray(valuesArray,3,15);
		System.out.println("Array after insertion of 15 at position 3:");
		for(int i = 0 ; i < valuesArray.length; i++){
			System.out.println(valuesArray[i]);
		}

	}
}
