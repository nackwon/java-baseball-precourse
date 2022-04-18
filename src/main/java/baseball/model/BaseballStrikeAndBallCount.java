package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballStrikeAndBallCount {

    private static final int MAX_RANGE_LENGTH = 3;

    /**
     * Strike Count 구하는 Method
     * @param userNumberList
     * @param computerNumberList
     */
    public int countStrike(List<Integer> userNumberList, List<Integer> computerNumberList) {
        int intStrikeCount = 0;

        for (int i=0; i<MAX_RANGE_LENGTH; ++i) {
            if(isCheckStrike(computerNumberList, i, userNumberList.get(i))) {
                intStrikeCount++;
            }
        }
        return intStrikeCount;
    }

    /**
     * Ball Count 구하는 Method
     * @param userNumberList
     * @param computerNumberList
     */
    public int countBall(List<Integer> userNumberList, List<Integer> computerNumberList) {

        int intBallCount = 0;
        for (int i=0; i<MAX_RANGE_LENGTH; ++i) {
            if(isCheckBall(computerNumberList, userNumberList.get(i))) {
                intBallCount++;
            }
        }
        return intBallCount;
    }

    /**
     * 같은 위치에 같은 수일 경우 Strike
     * @param computerNumberList : Computer Random 숫자
     * @param index : 숫자 위치
     * @param number : user 숫자
     * @return
     */
    private boolean isCheckStrike(List<Integer> computerNumberList, int index, int number) {
        return computerNumberList.get(index).equals(number);
    }

    /**
     * 해당 숫자를 포함만 하고 있으면 Ball
     * @param computerNumberList : Computer Random 숫자
     * @param number : user 숫자
     * @return
     */
    private boolean isCheckBall(List<Integer> computerNumberList, int number) {
        return computerNumberList.contains(number);
    }
}
