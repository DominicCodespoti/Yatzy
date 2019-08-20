import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface GameBoardOptions {
    int calculateScoreFromGivenDice(Dice dice);

    String calculateStringForScoreBoard(Dice givenDice);

    String optionName();

    class Ones implements GameBoardOptions {
        public String optionName() {
            return "Ones";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 1).count();
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Ones               |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Ones               |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Twos implements GameBoardOptions {
        public String optionName() {
            return "Twos";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 2).count() * 2;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Twos               |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Twos               |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Threes implements GameBoardOptions {
        public String optionName() {
            return "Threes";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 3).count() * 3;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Threes             |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Threes             |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Fours implements GameBoardOptions {
        public String optionName() {
            return "Fours";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 4).count() * 4;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Fours              |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Fours              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Fives implements GameBoardOptions {
        public String optionName() {
            return "Fives";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 5).count() * 5;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Fives              |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Fives              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Sixes implements GameBoardOptions {
        public String optionName() {
            return "Sixes";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return (int) Arrays.stream(dice.getAllDiceValues()).filter(diceValue -> diceValue == 6).count() * 6;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Sixes              |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Sixes              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class OnePair implements GameBoardOptions {
        @Override
        public String optionName() {
            return "One Pair";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            Map<Integer, Integer> diceValueOccurrenceCounts;
            diceValueOccurrenceCounts = Arrays.stream(dice.getAllDiceValues()).boxed().collect(Collectors.toMap(diceValue -> diceValue, diceValue -> diceValue, (oldValue, newValue) -> newValue + 1));
            List<Integer> pairs = diceValueOccurrenceCounts.entrySet().stream().filter(entry -> entry.getValue() == entry.getKey() + 1).map(Map.Entry::getKey).collect(Collectors.toList());
            return pairs.stream().reduce(0, Math::max) * 2;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|One Pair           |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|One Pair           |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class TwoPair implements GameBoardOptions {
        @Override
        public String optionName() {
            return "Two Pair";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            Map<Integer, Integer> diceValueCounts;
            diceValueCounts = Arrays.stream(dice.getAllDiceValues()).boxed().collect(Collectors.toMap(diceValue -> diceValue, diceValue -> diceValue, (oldValue, newValue) -> newValue + 1));
            List<Integer> pairs = diceValueCounts.entrySet().stream().filter(entry -> entry.getValue() == entry.getKey() + 1).map(Map.Entry::getKey).collect(Collectors.toList());
            if (pairs.isEmpty())
                return 0;
            try {
                return pairs.get(0) * 2 + pairs.get(1) * 2;
            } catch (Exception e) {
                return 0;
            }
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Two Pair           |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Two Pair           |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class ThreeOfAKind implements GameBoardOptions {
        public String optionName() {
            return "Three of a Kind";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            Map<Integer, Integer> diceValueCounts;
            diceValueCounts = Arrays.stream(dice.getAllDiceValues()).boxed().collect(Collectors.toMap(diceValue -> diceValue, diceValue -> diceValue, (oldValue, newValue) -> oldValue + 1));
            List<Integer> threeOfAKind = diceValueCounts.entrySet().stream().filter(entry -> entry.getValue() == entry.getKey() + 2).map(Map.Entry::getKey).collect(Collectors.toList());
            if (threeOfAKind.isEmpty())
                return 0;
            return threeOfAKind.get(0) * 3;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Three of a Kind    |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Three of a Kind    |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class FourOfAKind implements GameBoardOptions {
        public String optionName() {
            return "Four of a Kind";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            Map<Integer, Integer> diceValueCounts;
            diceValueCounts = Arrays.stream(dice.getAllDiceValues()).boxed().collect(Collectors.toMap(diceValue -> diceValue, diceValue -> diceValue, (oldValue, newValue) -> oldValue + 1));
            List<Integer> fourOfAKind = diceValueCounts.entrySet().stream().filter(entry -> entry.getValue() == entry.getKey() + 3).map(Map.Entry::getKey).collect(Collectors.toList());
            if (fourOfAKind.isEmpty())
                return 0;
            return fourOfAKind.get(0) * 4;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Four of a Kind     |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Four of a Kind     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class SmallStraight implements GameBoardOptions {
        public String optionName() {
            return "Small Straight";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            int calculatedScore = 0;
            int[] givenDice = dice.getAllDiceValues();
            if (givenDice[0] == 1 && givenDice[1] == 2 && givenDice[2] == 3 && givenDice[3] == 4 && givenDice[4] == 5) {
                calculatedScore = 15;
            }
            return calculatedScore;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Small Straight     |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Small Straight     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class LargeStraight implements GameBoardOptions {
        public String optionName() {
            return "Large Straight";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            int calculatedScore = 0;
            int[] givenDice = dice.getAllDiceValues();
            if (givenDice[0] == 2 && givenDice[1] == 3 && givenDice[2] == 4 && givenDice[3] == 5 && givenDice[4] == 6) {
                calculatedScore = 20;
            }
            return calculatedScore;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Large Straight     |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Large Straight     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Chance implements GameBoardOptions {
        public String optionName() {
            return "Chance";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            return Arrays.stream(dice.getAllDiceValues()).reduce(0, Integer::sum);
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Chance             |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Chance             |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class FullHouse implements GameBoardOptions {
        public String optionName() {
            return "Full House";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            HashMap<Integer, Integer> diceValueCounts = new HashMap<>();
            for (int diceValue : dice.getAllDiceValues())
                diceValueCounts.put(diceValue, diceValueCounts.getOrDefault(diceValue, 0) + 1);

            List<Integer> pairs = diceValueCounts.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
            List<Integer> threeOfAKind = diceValueCounts.entrySet().stream().filter(entry -> entry.getValue() > 2).map(Map.Entry::getKey).collect(Collectors.toList());
            if (pairs.isEmpty() || threeOfAKind.isEmpty())
                return 0;
            if (pairs.get(0).equals(threeOfAKind.get(0)))
                return 0;
            return pairs.get(0) * 2 + threeOfAKind.get(0) * 3;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Full House         |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Full House         |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }

    class Yatzy implements GameBoardOptions {
        public String optionName() {
            return "Yatzy";
        }

        public int calculateScoreFromGivenDice(Dice dice) {
            int calculatedScore = 0;
            int[] givenDice = dice.getAllDiceValues();
            if (givenDice[0] == givenDice[1] && givenDice[0] == givenDice[2] && givenDice[0] == givenDice[3] && givenDice[0] == givenDice[4])
                calculatedScore = 50;
            return calculatedScore;
        }

        public String calculateStringForScoreBoard(Dice givenDice) {
            if (calculateScoreFromGivenDice(givenDice) >= 10 && calculateScoreFromGivenDice(givenDice) <= 99)
                return "|Yatzy              |" + calculateScoreFromGivenDice(givenDice) + "         |";
            else
                return "|Yatzy              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
}

