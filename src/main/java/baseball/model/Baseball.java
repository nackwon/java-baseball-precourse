package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {

    private static final int RANGE_MAX_NUMBER = 9;
    private static final int RANGE_MIN_NUMBER = 1;
    private static final int MAX_RANGE_LENGTH = 3;

    /**********************
     * 컴퓨터 랜덤 숫자 메소드
     * @return
     **********************/
    public String computerRandomNumbers() {

        String sRandomNumbers = "";

        while(sRandomNumbers.length() < MAX_RANGE_LENGTH) {
            int intNumber = Randoms.pickNumberInRange(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER);

            if(!sRandomNumbers.contains(String.valueOf(intNumber))) {
                sRandomNumbers += String.valueOf(intNumber);
            }
        }

        return sRandomNumbers;
    }

}
