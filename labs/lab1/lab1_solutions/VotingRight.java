import java.util.Scanner;

public class VotingRight{
	public static void main(String[] args){
		Scanner sc;
		int age;

		sc = new Scanner(System.in);

		System.out.print("How old are you? ");
		age = sc.nextInt();
		if(age >= 18) {
			System.out.println("You have the right to vote!");
		} else{
			System.out.print("You will be allowed to vote in " + (18-age));
			if(age == 17) {
				System.out.println(" year.");
			} else {
				System.out.println(" years.");
			}
		}
	}

}