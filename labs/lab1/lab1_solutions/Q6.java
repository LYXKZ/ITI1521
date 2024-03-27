import java.util.Scanner;

public class Q6{

    public static void main(String[] args){

        int sizeClass = 10;
        double[] studentGrades;
        Scanner sc;

        studentGrades = new double[sizeClass];
        sc = new Scanner(System.in);


        for(int i =0 ; i < sizeClass ; i++){
            System.out.print("Please enter the grade of student " + (i+1)+":");
            studentGrades[i] = sc.nextDouble();
        }

        System.out.println("The average is " + calculateAverage(studentGrades));
        System.out.println("The number of students who have failed is " + calculateNumberFailed(studentGrades));
        System.out.println("The number of students who have passed is " + calculateNumberPassed(studentGrades));
        System.out.println("The median is " + calculateMedian(studentGrades));

    }

    public static double calculateAverage(double[] notes){
        double result;

        result = 0;
        for(int i = 0; i < notes.length; i++){
            result += notes[i];
        }

        return result / notes.length;
    }

    public static double calculateMedian(double[] notesIn) {

        double[] notes;
        notes = new double[notesIn.length];

        for (int i=0; i<notesIn.length; i++) {
            notes[i] = notesIn[i];
        }

        // first sort the array
        for(int i = 0; i < notes.length - 1; i++){
            int argMin = i;
            for(int j = i + 1; j < notes.length; j++){
                if(notes[j]<notes[argMin]) {
                    argMin = j;
                }
            }

            double tmp = notes[argMin];
            notes[argMin] = notes[i];
            notes[i] = tmp;
        }

        if (notes.length %2 == 1) {
            // if odd, the median is the middle value
            return (notes[notes.length/2]);
        } else {
            // if even, the median is the average of the two middle values
            return ((notes[notes.length/2]+notes[(notes.length-1)/2])/2);
        }
    }

    public static int calculateNumberFailed(double[] notes){
        int result;

        result = 0;
        for (int i = 0; i < notes.length; i++) {
            if(notes[i] < 50) {
                result++;
            }
        }

        return result;
    }

    public static int calculateNumberPassed(double[] notes) {
        int result;

        result = notes.length - calculateNumberFailed(notes);

        return result;
    }

}
