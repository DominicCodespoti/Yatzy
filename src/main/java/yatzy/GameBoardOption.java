package yatzy;

public interface GameBoardOption {
    int calculateScoreFromGivenDice(Dice dice);
    String optionName();
}
