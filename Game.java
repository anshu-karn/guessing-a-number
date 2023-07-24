import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String play = "yes";
        int attempt = 0;

        while (play.equals("yes")) {
            Random rand = new Random();
            int rand_num = rand.nextInt(100);
            int guess = -1;
            
            boolean validInput = false;

            while (guess != rand_num) {
                System.out.print("Guess the number between 1 and 100 (enter 0 to quit): ");

                try {
                    guess = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    input.next(); // Consume the invalid input
                    continue; // Continue to the next iteration of the inner while loop
                }

                if (guess == 0) {
                    play = "no";
                    break; // Exit the inner while loop
                }

                attempt++;
                validInput = true;

                if (guess == rand_num) {
                    System.out.println("Awesome! you guessed the number & it took " + attempt + " attempt");
                    System.out.println("Would you like to continue? If yes, enter yes; otherwise, enter no");
                    play=input.next().toLowerCase();
                } else if (guess > rand_num) {
                    System.out.println("Too high, try again!");
                } else if (guess < rand_num) {
                    System.out.println("Too low, try again!");
                }
            }

            if (!validInput) {
                continue; // Continue to the next iteration of the outer while loop
            }
        }
        
        if(attempt<=3){
            System.out.println("\n Congratulations!! excellent performace you earned gold badges");
        }
        else if(attempt<=6){
            System.out.println("\n Really played well!! excellent performace you earned silver badges");
        }
        else if(attempt>6){
            System.out.println("\n Sorry!! you took too many attempts");

        input.close();
        }
    }
}
