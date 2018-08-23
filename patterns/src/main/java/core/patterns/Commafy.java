package core.patterns;

public class Commafy {

    public static void main(String[] args) {
        String test1 = "1";
        String test2 = "-34.56";
        String test3 = "353";
        String test4 = "3332";
        String test5 = "43535";
        String test6 = "444333";
        String test7 = "4443335";
        String test8 = "-44433362";
        String test9 = "444333464";
        String test10 = "333246246";
        String test11 = "3332462462";

        System.out.println(regexCommafy(test1));
        System.out.println(regexCommafy(test2));
        System.out.println(regexCommafy(test3));
        System.out.println(regexCommafy(test4));
        System.out.println(regexCommafy(test5));
        System.out.println(regexCommafy(test6));
        System.out.println(regexCommafy(test7));
        System.out.println(regexCommafy(test8));
        System.out.println(regexCommafy(test9));
        System.out.println(regexCommafy(test10));
        System.out.println(regexCommafy(test11));
    }

    private static final String THREE_DIGITS_DELIMITER = ",";

    private static String regexCommafy(String inputNum) {
        String everyThreeDigitsRegex = "(\\d)(?=(\\d{3})+$)";
        String commafiedInput = inputNum.replaceAll(everyThreeDigitsRegex, "$1" + THREE_DIGITS_DELIMITER);
        boolean minusPresent = isMinusPresent(inputNum);
        StringBuilder result = new StringBuilder();
        if (minusPresent) {
            String commafiedInputWithoutMinus = commafiedInput.substring(1, commafiedInput.length());

            result.append("-").append("$").append(commafiedInputWithoutMinus);
        } else {
            result.append("$").append(commafiedInput);
        }
        return result.toString();
    }

    private static boolean isMinusPresent(String input) {
        return input.contains("-");
    }

}
