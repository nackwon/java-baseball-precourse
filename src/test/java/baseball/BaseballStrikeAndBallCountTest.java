package baseball;

import baseball.model.BaseballStrikeAndBallCount;
import baseball.model.baseballCommonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;


public class BaseballStrikeAndBallCountTest {

    @Test
    @DisplayName("Strike Ball Count Test")
    public void 스트라이크_볼_결과_테스트() {

        String sUserNumber = "497";
        String sComputerNumber = "497";
        BaseballStrikeAndBallCount baseballStrikeAndBallCount = new BaseballStrikeAndBallCount();

        List<Integer> testUserList = baseballCommonUtil.convertList(sUserNumber);
        List<Integer> testComputerList = baseballCommonUtil.convertList(sComputerNumber);

        Map mpResult = baseballStrikeAndBallCount.countBallCount(testUserList, testComputerList);

        assertThat(mpResult).contains( entry("ball", 0), entry("strike", 3));
    }
}
