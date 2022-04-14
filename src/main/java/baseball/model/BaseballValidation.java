package baseball.model;

import java.util.Collections;
import java.util.List;

public class BaseballValidation {

    /**
     * 3 자리 입력 체크
     * @return
     */
    public static boolean checkCommonNumbers(String inputNumber) {

        if(inputNumber.length() > 3) {
            return false;
        }
        return true;
    }

    /**
     * 중복된 값이 존재하는지 체크
     * @param inputNumberList
     * @return
     */
    public static boolean checkDuplicateNumbers(List<Integer> inputNumberList, int number) {

        if(inputNumberList.contains(number)) {
            return false;
        }
        return true;
    }
    /**
     * Game 재 시작 시 숫자 체크
     * @param number
     * @return
     */
    public static boolean checkGameRestartNumber(int number) {
        
        if(number == 1 || number == 2) {
            return true;
        }
        return false;
    }


}
