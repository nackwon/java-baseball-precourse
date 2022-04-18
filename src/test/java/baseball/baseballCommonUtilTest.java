package baseball;

import baseball.model.baseballCommonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class baseballCommonUtilTest {

    @Test
    @DisplayName("String convert List")
    public void 리턴값_테스트 () {

        String sTestNumber = "346";

        List<Integer> listNumbers = baseballCommonUtil.convertList(sTestNumber);

        assertThat(listNumbers).allMatch(listNumber -> listNumber.toString().matches("[1-9]"));
    }
}
