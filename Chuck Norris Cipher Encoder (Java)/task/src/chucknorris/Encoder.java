package chucknorris;

public class Encoder {

    public static String decodeChuckNorris(String message) throws IllegalArgumentException {
        String binary = fromChuckNorrisToBinary(message);

        if ((binary.length() % 7) != 0) {
            throw new IllegalArgumentException("Encoded string is not valid.");
        }

        StringBuilder result = new StringBuilder();

        int numberOfCharacters = binary.length() /7;

        for (int  i = 0; i < numberOfCharacters; i++) {
            String substring = binary.substring(i * 7, i * 7 + 7);
            char c = (char) Integer.parseInt(substring, 2);
            result.append(c);
        }

        return result.toString();

    }

    private static String fromChuckNorrisToBinary(String message) throws IllegalArgumentException {

        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != '0' && message.charAt(i) != ' ') {
                throw new IllegalArgumentException("Encoded string is not valid.");
            }
        }

        String[] zeros = message.split(" ");

        if ((!"0".equals(zeros[0]) && !"00".equals(zeros[0])) ||
                (zeros.length % 2) != 0) {
            throw new IllegalArgumentException("Encoded string is not valid.");
        }

        for (int i = 0; i < zeros.length - 1; i = i + 2) {

            char c = ' ';

            if ("0".equals(zeros[i])) {
                c = '1';
            } else if ("00".equals(zeros[i])){
                c = '0';
            } else {
                throw new IllegalArgumentException("Encoded string is not valid.");
            }

            //count how many 0s or 1s need to be added
            int n = zeros[i + 1].length();

            //add 0s or 1s
            for (int j = 0; j < n; j++) {
                binary.append(c);
            }
        }

        return binary.toString();
    }



    public static String encodeChuckNorris(String message) {

        StringBuilder result = new StringBuilder();

        String binary = getBinary(message);

        if (binary.length() == 0) {
            return "";
        } else {

            char lastChar = binary.charAt(0);
            int n = 1;

            for (int i = 1; i <= binary.length(); i++) {

                //print if all characters are processed
                if (i == binary.length()) {
                    result.append(printZeros(lastChar, n));
                } else if (binary.charAt(i) == lastChar) {
                    n++;
                } else {
                    //characters changed
                    result.append(printZeros(lastChar, n) + " ");
                    lastChar = binary.charAt(i);
                    n = 1;
                }
            }
        }

        return result.toString();
    }

    private static String printZeros(char c, int n) {

        StringBuilder result = new StringBuilder();

        if (c == '0') {
            result.append("00 ");
        } else {
            result.append("0 ");
        }

        for (int i = 0; i < n; i++) {
            result.append("0");
        }

        return result.toString();
    }

    private static String getBinary(String message) {
        StringBuilder result = new StringBuilder();

        for (char c: message.toCharArray()) {
            int decimal = (int) c;
            String binaryString = Integer.toBinaryString(decimal);
            String formattedBinaryString = String.format("%07d", Integer.parseInt(binaryString));
            result.append(formattedBinaryString);
        }

        return result.toString();
    }

}




