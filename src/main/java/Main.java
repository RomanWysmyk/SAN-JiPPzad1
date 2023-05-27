public class Main {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i <= 1000; i++) {
            String numberInWords = convertNumberToWords(i);
            int lettersCount = countLetters(numberInWords);
            count += lettersCount;
            System.out.println("Number: " + i + ", Letters Count: " + lettersCount);
        }

        System.out.println("Total Letters Count: " + count);
    }

    public static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        } else if (number < 0) {
            return "minus " + convertNumberToWords(Math.abs(number));
        } else if (number <= 19) {
            String[] units = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            return units[number - 1];
        } else if (number <= 99) {
            //tworze liste dziesiątek. tenWord wylicza index z tablicy 'tens' a unitWord rekurencyjnie przez modulo wylicza liczbę jednostek
            String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
            String tenWord = tens[(number / 10) - 2];
            String unitWord = convertNumberToWords(number % 10);
            return tenWord + " " + unitWord;
        } else if (number <= 999) {
            String hundredWord = convertNumberToWords(number / 100) + " hundred";
            String tenWord = convertNumberToWords(number % 100);
            if (tenWord.equals("zero")) {
                return hundredWord;
            } else {
                return hundredWord + " and " + tenWord;
            }
        } else {
            String thousandWord = convertNumberToWords(number / 1000) + " thousand";
            String hundredWord = convertNumberToWords(number % 1000);
            if (hundredWord.equals("zero")) {
                return thousandWord;
            } else {
                return thousandWord + " " + hundredWord;
            }
        }
    }

    public static int countLetters(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }
}

