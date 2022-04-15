package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballInputView {

    private static String USER_INPUT_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private static String USER_GAME_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    /**
     * 게임 시작 시 입력 View
     */
    public static String userInputNumbers() {
        System.out.print(USER_INPUT_NUMBERS_MSG);
        return Console.readLine();
    }

    /**
     * 게임 재 시작 View
     */
    public static String restartGame() {
        System.out.println(USER_GAME_RESTART_MSG);
        return Console.readLine();
    }
}
