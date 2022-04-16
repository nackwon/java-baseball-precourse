package baseball.model;

public class BaseballValidation {

    private static int MAX_INPUT_NUMBER_LENGTH = 3;


    /**
     * 사용자 입력 시 입력 값 관련 Validation 체크
     * @param inputNumber
     * @return
     */
    public static boolean isCheckCommonNumber(String inputNumber) {

        if (!isCheckWord(inputNumber)) {
            return false;
        }

        if(!isCheckNumberLength(inputNumber)) {
            return false;
        }

        if(isCheckZeroNumber(inputNumber)) {
            return false;
        }

        if(isCheckDuplicateNumbers(inputNumber)) {
            return false;
        }
        return true;
    }

    /**
     * 입력된 숫자 3자리 인지 체크
     * @return
     */
    public static boolean isCheckNumberLength(String inputNumber) {
        if(inputNumber.length() == MAX_INPUT_NUMBER_LENGTH)
            return true;

        return false;
    }

    /**
     * 숫자 0 을 포함하는지 체크
     * @param inputNumber : 입력된 3자리 숫자
     * @return
     */
    public static boolean isCheckZeroNumber(String inputNumber) {
        return inputNumber.contains("0");
    }

    /**
     * 입력된 값이 숫자로 이루어져 있는지 체크
     * @param inputNumber : 입력된 3자리 숫자
     * @return
     */
    public static boolean isCheckWord(String inputNumber) {

        int intSize = inputNumber.length();

        for (int i=0; i<intSize; ++i) {
            if(!Character.isDigit(inputNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    /**
     * 중복된 값이 존재하는지 체크
     * @param inputNumber
     * @return
     */
    public static boolean isCheckDuplicateNumbers(String inputNumber) {

        String[] arrNumbers = inputNumber.split("");

        int intSize = arrNumbers.length;

        for (int i=0; i<intSize-1; ++i) {
            if(arrNumbers[i].equals(arrNumbers[i+1])) {
                return true;
            }
        }
        return false;
    }
}
