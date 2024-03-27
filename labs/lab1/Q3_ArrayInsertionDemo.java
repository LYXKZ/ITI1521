public class Q3_ArrayInsertionDemo{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
        int size = beforeArray.length + 1;
        int[] newArray = new int[size];
        boolean checked = true;

        for (int i = 0; i < size; i++) {
            if (i == indexToInsert) {
                newArray[i] = valueToInsert;
                checked = false;
            } else if (checked) {
                newArray[i] = beforeArray[i];
            } else {
                newArray[i] = beforeArray[i - 1];
            }
        }
        return newArray;
    }

    public static void main(String[] args){
        int[] beforeArray = {1, 5, 4, 7, 9, 6};
        int indexToInsert = 3;
        int valueToInsert = 15;
        System.out.println("Array avant l'insertion:");
        for (int i = 0; i < beforeArray.length; i++) {
            System.out.println(beforeArray[i]);
        }
        int[] newArray = insertIntoArray(beforeArray, indexToInsert, valueToInsert);
        System.out.println("Array après l'insertion de 15 à position 3:");
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }
}
