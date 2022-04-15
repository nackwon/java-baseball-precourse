package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballStrikeAndBallCount {

    private static final int MAX_RANGE_LENGTH = 3;

    /**
     * Strike Count , Ball Count 구하는 Method
     * @param userNumberList
     * @param computerNumberList
     */
    public Map countBallCount(List<Integer> userNumberList, List<Integer> computerNumberList) {

        Map mpResult = new HashMap();

        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<MAX_RANGE_LENGTH; ++i) {

            boolean isCheckCount = true;
            int intUserNumber = userNumberList.get(i);
            if(isCheckStrike(computerNumberList, i, intUserNumber)) {
                strikeCount++;
                isCheckCount = false;
            }

            // 나중에 수정 필요
            if(isCheckCount) {
                if(isCheckBall(computerNumberList, intUserNumber)) {
                    ballCount++;
                }
            }
        }

        mpResult.put("strike", strikeCount);
        mpResult.put("ball", ballCount);

        return mpResult;
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
