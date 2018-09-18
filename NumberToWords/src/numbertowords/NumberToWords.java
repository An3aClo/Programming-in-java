package numbertowords;

import java.text.DecimalFormat;

public class NumberToWords {

    private static final String[] tensNames = {
        "", "ten", "twenty", "thirty", "forty", "fifty", "sixty",
        "seventy", "eighty", "ninety"
    };

    private static final String[] numNames = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
        "tewlve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eightteen", "nineteen"
    };

    private NumberToWords(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;

        } else {

            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;

        }
        //  if (number = = 0) return soFar;
        // return numNames[number]+"hundred"+soFar;

    }

    public static String convert(long number) {
        if (number == 0) {
            return "zero";
        }
        String snumber = Long.toString(number);
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(0, 3));
        int millions = Integer.parseInt(snumber.substring(3, 6));
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + "billion";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + "billion";

        }

    }

    public static void main(String[] args) {

    }

}
