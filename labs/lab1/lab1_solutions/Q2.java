public class Q2 {

    public static void main(String[] args) {

        for (int i = 1; i <= 30; i++) {
            if(i%15 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if(i%3 == 0) {
                System.out.println(i + " Fizz");
            } else if (i%5 == 0) {
                System.out.println(i + " Buzz");
            }
        }

        // Alternate implementation using a "while" loop

        int i = 1;
        while (i < 31){
            if(i%15 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if(i%3 == 0) {
                System.out.println(i + " Fizz");
            } else if (i%5 == 0) {
                System.out.println(i + " Buzz");
            }
            i++;
        }
    }
}
