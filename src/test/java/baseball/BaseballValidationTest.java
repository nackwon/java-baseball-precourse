package baseball;

import baseball.model.BaseballValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballValidationTest {
    
    @DisplayName("입력값 Validation Test 길이")
    @ParameterizedTest
    @ValueSource(strings = {"233"})
    public void 입력값_길이_테스트(String input) {

        assertThat(BaseballValidation.isCheckNumberLength(input)).isTrue();
    }

    @DisplayName("입력값 Validation Test 제로")
    @ParameterizedTest
    @ValueSource(strings = {"136", "298"})
    public void 입력값_제로_테스트(String input) {

        assertThat(BaseballValidation.isCheckZeroNumber(input)).isTrue();
    }

    @DisplayName("입력값 Validation Test 문자")
    @ParameterizedTest
    @ValueSource(strings = {"421"})
    public void 입력값_문자_테스트(String input) {
        assertThat(BaseballValidation.isCheckWord(input)).isTrue();
    }

    @DisplayName("입력값 Validation Test 중복")
    @ParameterizedTest
    @ValueSource(strings = {"158"})
    public void 입력값_중복_테스트(String input) {
        assertThat(BaseballValidation.isCheckDuplicateNumbers(input)).isTrue();
    }

    @DisplayName("입력값 Validation 공통 Test")
    @ParameterizedTest
    @ValueSource(strings = {"238"})
    public void 입력값_전체_테스트(String input) {
        assertThat(BaseballValidation.isCheckCommonNumber(input)).isTrue();
    }
}
