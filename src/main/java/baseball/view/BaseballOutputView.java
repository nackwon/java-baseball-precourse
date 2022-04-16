package baseball.view;

public class BaseballOutputView {

    private static String BASEBALL_STRIKE = "스트라이크";
    private static String BASEBALL_BALL = "볼";
    private static String BASEBALL_NOTHING = "낫씽";
    private static String BASEBALL_RESULT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    /**
     * 사용자 숫자 입력 후 결과 값 리턴하는 Method
     * @param strikeCount : 스트라이크 갯수
     * @param ballCount : 볼 갯수
     * @return
     */
    public static void resultStrikeAndBallCount(int strikeCount, int ballCount) {

        if(strikeCount != 0 && ballCount != 0) {
            System.out.println( strikeCount + BASEBALL_STRIKE + ballCount + BASEBALL_BALL);
        }

        if(strikeCount != 0) {
            System.out.println(strikeCount + BASEBALL_STRIKE);
        }

        if(ballCount != 0) {
            System.out.println(ballCount + BASEBALL_BALL);
        }
    }

    /********************
     * 승리 시 호출 Method
     *******************/
    public static void winningMSG() {
        System.out.println(BASEBALL_RESULT);
    }

    /********************
     * 낫씽 시 호출 Method
     *******************/
    public static void nothingMSG() {
        System.out.println(BASEBALL_NOTHING);
    }
}
