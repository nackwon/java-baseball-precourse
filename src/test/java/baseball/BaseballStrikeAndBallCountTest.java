package baseball;

import baseball.model.BaseballStrikeAndBallCount;
import baseball.model.baseballCommonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseballStrikeAndBallCountTest {

    @Test
    @DisplayName("Strike  Count Test")
    public void 스트라이크_카운트_결과_테스트() {

        String sUserNumber = "497";
        String sComputerNumber = "479";
        BaseballStrikeAndBallCount baseballStrikeAndBallCount = new BaseballStrikeAndBallCount();

        List<Integer> testUserList = baseballCommonUtil.convertList(sUserNumber);
        List<Integer> testComputerList = baseballCommonUtil.convertList(sComputerNumber);

        int intResult = baseballStrikeAndBallCount.countStrike(testUserList, testComputerList);

        assertThat(intResult).isEqualTo(1);
    }

    @Test
    @DisplayName("Ball count Test")
    public void 볼_카운트_결과_테스트() {

        String sUserNumber = "497";
        String sComputerNumber = "947";
        BaseballStrikeAndBallCount baseballStrikeAndBallCount = new BaseballStrikeAndBallCount();

        List<Integer> testUserList = baseballCommonUtil.convertList(sUserNumber);
        List<Integer> testComputerList = baseballCommonUtil.convertList(sComputerNumber);

        int intResult = baseballStrikeAndBallCount.countBall(testUserList, testComputerList);

        assertThat(intResult).isEqualTo(3);
    }
}
