import java.util.Scanner;

class Q6 {
	public static void main(String[] args) {
        double[] myArray = new double[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 11; i++) {
            System.out.println("Entrez la note " + i + ":");
            myArray[i - 1] = scanner.nextDouble();
        }

  	    System.out.println("La moyenne est: " + calculateAverage(myArray));
        System.out.println("La mediane est: " + calculateMedian(myArray));
        System.out.println("Le nombre d'échecs est: " + calculateNumberFailed(myArray));
        System.out.println("Le nombre de personnes qui passent est: " + calculateNumberPassed(myArray));


	}

	public static double calculateAverage(double[] notes) {
	    double x = 0;
        for (int i = 0; i < notes.length; i++) {
            x += notes[i];
        }
        x = x / notes.length;
        return x;
	}

	public static double calculateMedian(double[] notes) {
        
	    double x = 0;
        int i, j, argMin;
        double tmp;

        for (i = 0; i < notes.length - 1; i++) {
        	argMin = i;
        	for (j = i + 1; j < notes.length; j++) {
        	    if (notes[j] < notes[argMin]) {
        	        argMin = j;
        	    }
        	}
        	tmp = notes[argMin];
        	notes[argMin] = notes[i];
        	notes[i] = tmp;           
	    }
        if (notes.length % 2 == 0) {
            x = ((notes[notes.length/2-1]) + (notes[notes.length/2]))/2;
            return x;
        } else {
            x = notes[(notes.length-1)/2];
            return x;
        }

	}

	public static int calculateNumberFailed(double[] notes) {
        int x = 0;
	    for (int i = 0; i < notes.length; i++) {
            if (notes[i] < 50) {
                x++;
            }
        }
        return x;
	}

	public static int calculateNumberPassed(double[] notes) {
	    int x = 0;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] >= 50) {
                x++;
            }
        }
        return x;
	}

}