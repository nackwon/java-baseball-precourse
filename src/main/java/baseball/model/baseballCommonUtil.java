package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class baseballCommonUtil {

    /**
     * 숫자를 List 에 담아서 리턴 Method
     * @param inputNumbers
     * @return
     */
    public static List<Integer> convertList(String inputNumbers) {

        List<Integer> listNumbers = new ArrayList<>();

        for(String number : inputNumbers.split("")) {
            listNumbers.add(Integer.parseInt(number));
        }

        return listNumbers;
    }
}
