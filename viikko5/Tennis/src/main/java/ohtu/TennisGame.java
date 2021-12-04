package ohtu;

public class TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String firstPlayer, String secondPlayer) {
        this.playerOneName = firstPlayer;
        this.playerTwoName = secondPlayer;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOneName) {
            playerOneScore++;
        }
        if (playerName == playerTwoName) {
            playerTwoScore++;
        }
    }

    public String getScore() {
        String scoreString = "";
        if (playerOneScore == playerTwoScore) {
            scoreString = getEvenScoreString();
        } else if (playerOneScore>=4 || playerTwoScore>=4) {
            scoreString = getAdvantageOrWinScoreString();
        } else {
            scoreString = getRegularScoreString();
        }
        return scoreString;
    }

    public String getEvenScoreString() {
        switch (this.playerOneScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
               return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public String getAdvantageOrWinScoreString() {
        if (playerOneScore - playerTwoScore == 1) {
            return "Advantage player1";
        } else if (playerTwoScore - playerOneScore == 1) {
            return "Advantage player2";
        } else if (playerOneScore > playerTwoScore) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String getRegularScoreString() {
        return getPartialScoreString(this.playerOneScore) + '-' + getPartialScoreString(this.playerTwoScore);
    }

    public String getPartialScoreString(int playerScore) {
        switch(playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}