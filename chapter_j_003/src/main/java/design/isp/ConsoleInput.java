package design.isp;

import java.util.Scanner;

public class ConsoleInput implements MenuInput{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int input(String ask) {
        int result = 0;
        System.out.print(ask);
        while (result == 0){
            try {
                result = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Enter a number greater than 0!");
            }
        }
        return result;
    }
}
