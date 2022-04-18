package baseball;

import baseball.model.Baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    @Test
    @DisplayName("컴퓨터 랜덤 숫자 리스트_숫자")
    public void 컴퓨터_랜덤_숫자리스트_숫자() {

        Baseball baseball = new Baseball();

        String sRandomNumbers = baseball.computerRandomNumbers();
        String[] arrayNumbers = sRandomNumbers.split("");

        assertThat(arrayNumbers).allMatch(arrayNumber -> arrayNumber.matches("[1-9]"));
    }

    @Test
    @DisplayName("컴퓨터 랜덤 숫자 리스트_길이")
    public void 컴퓨터_랜덤_숫자리트스_길이() {
        Baseball baseball = new Baseball();

        String sRandomNumbers = baseball.computerRandomNumbers();

        assertThat(sRandomNumbers).hasSize(3);
    }

    @Test
    @DisplayName("컴퓨터 랜덤 숫자 리트스_중복")
    public void 컴퓨터_랜덤_숫자리스트_중복() {
        Baseball baseball = new Baseball();

        String sRandomNumbers = baseball.computerRandomNumbers();
        Set<String> setNumbers = new HashSet<String>(Arrays.asList(sRandomNumbers.split("")));

        assertThat(sRandomNumbers.length()).isEqualTo(setNumbers.size());
    }
}
