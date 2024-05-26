import java.util.Scanner;
//                   ......guess the number game......

public class Number_game {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int chances = 7;
    int finals = 0;
    boolean PlayAgain = true;
    System.out.println(" Welcome to  game ");
    System.out.println(" you have about " +  chances  + "  chances to  Win the game ");

    while (PlayAgain) {
        int rand = getrandN(1, 100);
        boolean guess = false;
        for (int i = 0; i < chances; i++) {
            System.out.println(" chance " + (i + 1) + " Enter your guess");
            int user = sc.nextInt();
            if (user == rand) {
                guess = true;
                finals += 1;
                System.out.println("You won it");
                break;
            } else if (user > rand) {
                System.out.println("too high ");
            } else {
                System.out.println("Too Low");
            }
        }
        if (guess == false) {
            System.out.println("Sorry you lost the chances . The  number is " + rand);
        }
        System.out.println("Do You Want to  Play Again (y/n)");
        String pA = sc.next();
        PlayAgain = pA.equalsIgnoreCase("y");
    }
    System.out.println(" Hope you enjoyed it");
    System.out.println(" here is  your score" + finals);
}
    public static  int getrandN(int min,int max){
        return(int)(Math.random()*(max-min+1)+min);
    }
    }
    