import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("What is your first name?");
		String fName = scanner.nextLine();
		
		System.out.println("What is your last name?");
		String lName = scanner.nextLine();
		
		System.out.println(fName + " " + lName);
		
		int age = 0;
		
		while(age <= 0){
			System.out.println("How old are you?");
			age = scanner.nextInt();
			if(age <= 0){
			System.out.println("Invalid Age!");
			if(age < 20 && age > 12){
				System.out.println("You are a teenager!");
		}
	}
}			
		if(age < 20 && age > 12){
			System.out.println("You are a teenager!");
		} else if (age < 13) {
			System.out.println("You are a child!");
		} else System.out.println("You are an Adult!");
		
		System.out.println(fName + " " + lName);
	scanner.close();	
	}

}
