package chucknorris;

import java.util.Scanner;

public class TextUI {

    private Scanner scanner;

    public TextUI() {
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String action = scanner.nextLine();

            if ("exit".equals(action)) {

                System.out.println("Bye!");
                break;

            } else if ("encode".equals(action)) {

                String toEncode = getToEncode();
                printEncoded(toEncode);

            } else if ("decode".equals(action)) {

                String toDecode = getToDecode();
                printDecoded(toDecode);


            } else {
                System.out.println("There is no '" + action + "' operation\n");
            }
        }
    }

    private String getToDecode() {
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        return input;
    }

    private void printDecoded(String message) {

        try {

            String result = Encoder.decodeChuckNorris(message);

            System.out.println("Decoded string:");
            System.out.println(result + "\n");


        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

    }

    private String getToEncode() {
        System.out.println("Input string: ");
        String input = scanner.nextLine();
        return input;
    }

    private void printEncoded(String message) {
        System.out.println("Encoded string:");
        System.out.println(Encoder.encodeChuckNorris(message) + "\n");
    }


}


