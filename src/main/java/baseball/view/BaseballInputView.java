package baseball.view;

import baseball.model.Baseball;
import baseball.model.BaseballValidation;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballInputView {

    private static String USER_INPUT_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private static String USER_GAME_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    /**
     * 게임 시작 시 사용자 숫자 입력
     */
    public List<Integer> userInputNumbers() {
        System.out.print(USER_INPUT_NUMBERS_MSG);

        String inputNumber = Console.readLine();

        return Baseball.convertList(inputNumber);
    }

    /**
     * 컴퓨터 랜덤 숫자 메소드
     * @return
     */
    public List<Integer> computerRandomNumbers() {

        List<Integer> listInputNumber = new ArrayList<>();

        while(listInputNumber.size() > 3) {
            int playerNumber = Randoms.pickNumberInRange(1,9);

            boolean isDuplicateCheck = BaseballValidation.checkDuplicateNumbers(listInputNumber, playerNumber);

            if(isDuplicateCheck) {
                listInputNumber.add(playerNumber);
            }
        }
        return listInputNumber;
    }

    /**
     * 숫자 모두 맞출 경우
     * 게임 재시작 or 종료
     */
    public void restartGame() {

        System.out.println(USER_GAME_RESTART_MSG);
        int inputGameStaterNumber = Integer.parseInt(Console.readLine());

        boolean checkNumber = BaseballValidation.checkGameRestartNumber(inputGameStaterNumber);

        if(!checkNumber) {
            //throw new Exception();
        }

        if(inputGameStaterNumber == 1) {
            // GameRestart();
        }
        if(inputGameStaterNumber == 2) {
            // GameOver();
        }
    }
}
