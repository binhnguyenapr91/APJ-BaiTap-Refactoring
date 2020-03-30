public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";

    public static String getScore(int player1Score, int player2Score) {
        String score = "";
        if (player1Score == player2Score) {
            score = getString(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getStringScore1(player1Score, player2Score);
        } else {
            score = getStringScore(player1Score, player2Score);
        }
        return score;
    }

    private static String getStringScore1(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getStringScore(int player1Score, int player2Score) {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String getString(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = LOVE + "-" + ALL;
                break;
            case 1:
                score = FIFTEEN + "-" + ALL;
                break;
            case 2:
                score = THIRTY + "-" + ALL;
                break;
            case 3:
                score = FORTY + "-" + ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }
}
