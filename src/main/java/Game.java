public class Game {
    private int[] rolls = new int[21];
    private int roll = 0;

    public void roll(int pins) {
        rolls[roll++] = pins;
    }

    public Integer score() {
        int score = 0;
        int firstInFrame = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isStrike(firstInFrame)){
                score += 10 + strikeBonus(firstInFrame);
                firstInFrame++;
            } else if(isSpare(firstInFrame)){
                score += 10 + spareBonus(firstInFrame);
                firstInFrame+=2;
            } else {
                score += scoreFrame(firstInFrame);
                firstInFrame+=2;
            }
        }
        return score;
    }

    private int spareBonus(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int scoreFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1];
    }

    private int strikeBonus(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1] == 10;
    }
}
