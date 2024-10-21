package project02pm;

import java.io.Console;
import java.util.*;

public class MasterMind {

    public static void main(String[] args) {

        // 1. Use random function to generate 4 digits number between 1111 and 6666.
        // a. 4 random number generator to generate each digit (1 – 6).
        Random random = new Random();
        int min = 1, max = 6;
        int number1 = random.nextInt(max - min + 1) + min;
        int number2 = random.nextInt(max - min + 1) + min;
        int number3 = random.nextInt(max - min + 1) + min;
        int number4 = random.nextInt(max - min + 1) + min;

        String guessNumber = String.valueOf(number1) + String.valueOf(number2) + String.valueOf(number3)
                + String.valueOf(number4);
        System.out.println("the number to guess: " + guessNumber);

        List<String> gameInputs = new ArrayList<>();

        Boolean userWins = false;
        String keyboardInput = "";
        Console console = System.console();
        while (!keyboardInput.equals("quit")) {

            // 2. Use console to prompt for 4 digits input.
            // a. This should be inside a while loop.
            keyboardInput = console.readLine("Enter your guess (4 digits between 1 and 6): ");

            if (keyboardInput.toLowerCase().equals("quit")) {
                break;
            }

            // 3. Check for invalid input (e.g. input not between 1111 and 6666).
            for (int i = 0; i < 4; i++) {
                if (!((keyboardInput.charAt(i) >= 49) && (keyboardInput.charAt(i) <= 54))) {
                    System.err.println("Invalid character detected...");
                    break;
                }
            }

            // 4. Use a for loop for check
            // a. Check the digit at each index using atChar(index) match position & number.
            // i. Increment CP by one if match number & position.
            // b. Check whether the input digit occurs in other positions
            // i. If point a fulfills, no need to perform this point b.
            // ii. Loop through to check if there are matching number.
            // iii. Increment C if number matches but position doesn’t match.
            int cp = 0;
            int c = 0;
            for (int j = 0; j < 4; j++) {
                if (String.valueOf(keyboardInput.charAt(j)).equals(String.valueOf(guessNumber.charAt(j)))) {
                    cp++;
                } else {
                    // check with the other 3 positions
                    for (int k = 0; k < 4; k++) {
                        if (j != k) {
                            if (String.valueOf(keyboardInput.charAt(j)).equals(String.valueOf(guessNumber.charAt(k)))) {
                                c++;
                                break; // break the for loop
                            }
                        }
                    }
                }
            }

            gameInputs.add(keyboardInput + "," + String.valueOf(cp) + "," + String.valueOf(c));

            // print the output 
            System.out.println("1\t2\t3\t4\t\tcp\tc");
            System.out.println("-----------------------------------------------------");
            // System.out.printf("%c\t%c\t%c\t%c\t\t%d\t%d\r\n", keyboardInput.charAt(0), keyboardInput.charAt(1), keyboardInput.charAt(2), keyboardInput.charAt(3), cp, c);
            for(String pastInput : gameInputs) {
                String splitData[] = pastInput.split(",");
                System.out.printf("%c\t%c\t%c\t%c\t\t%d\t%d\r\n", splitData[0].charAt(0), splitData[0].charAt(1), splitData[0].charAt(2), splitData[0].charAt(3), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]));
            }

            // 5. Repeat 4 until solution matches.
            // a. Allow up to 12 tries
            // you can do that yourself.

            // 6. Display whether you win or lose.
            if (cp == 4) {
                System.out.println("You win...");
                userWins = true;
                gameInputs.clear();
            }

            // 7. Repeat the game.
            // userWins = true;
            if (userWins) {
                random = new Random();
                number1 = random.nextInt(max - min + 1) + min;
                number2 = random.nextInt(max - min + 1) + min;
                number3 = random.nextInt(max - min + 1) + min;
                number4 = random.nextInt(max - min + 1) + min;

                guessNumber = String.valueOf(number1) + String.valueOf(number2) + String.valueOf(number3)
                        + String.valueOf(number4);
                userWins = false;
            }
        }

        System.out.println("Bye!!! Come back again...");
    }

}
