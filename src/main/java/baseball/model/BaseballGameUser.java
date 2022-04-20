package baseball.model;

import java.util.List;

public class BaseballGameUser {

    private final String sUserNumbers;

    public BaseballGameUser(String sUserNumbers) {
        BaseballValidation.isCheckCommonNumber(sUserNumbers);
        this.sUserNumbers = sUserNumbers;
    }

    public List<Integer> userNumberConvertList() {
        return baseballCommonUtil.convertList(sUserNumbers);
    }
}
