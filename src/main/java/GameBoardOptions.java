public interface GameBoardOptions
{
    int calculateScoreFromGivenDice(int[] givenDice);
    String calculateStringForScoreBoard(int[] givenDice);
    String calculateBoardOptionID();

    class Ones implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "ones";
        }
        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 1)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Ones               |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Twos implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "twos";
        }
        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 2)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Twos               |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Threes implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "threes";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 3)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Threes             |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Fours implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "fours";
        }
        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 4)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Fours              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Fives implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "fives";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 5)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Fives              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Sixes implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "sixes";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                if (givenDice[diceIterator] == 6)
                    calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Sixes              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class OnePair implements GameBoardOptions
    {
        @Override
        public String calculateBoardOptionID ()
        {
            return "one pair";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                for (int diceIteratorTwo = 1; diceIteratorTwo < 5; diceIteratorTwo++)
                    if (diceIterator == diceIteratorTwo)
                        calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|One Pair           |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class TwoPair implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "two pair";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Two Pair           |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class ThreeOfAKind implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "three of a kind";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Four of a Kind     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class FourOfAKind implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "four of a kind";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Four of a Kind     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class SmallStraight implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "small straight";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Small Straight     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class LargeStraight implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "large straight";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Large Straight     |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Chance implements GameBoardOptions
    {
        public String calculateBoardOptionID ()
        {
            return "chance";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Chance             |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class FullHouse implements GameBoardOptions
    {
        @Override
        public String calculateBoardOptionID ()
        {
            return "full house";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            for (int diceIterator = 0; diceIterator < 5; diceIterator++)
                calculatedScore += givenDice[diceIterator];
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Full House         |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
    class Yatzy implements GameBoardOptions
    {
        @Override
        public String calculateBoardOptionID ()
        {
            return "yatzy";
        }

        public int calculateScoreFromGivenDice(int[] givenDice)
        {
            int calculatedScore = 0;
            if (givenDice[0] == givenDice[1] && givenDice[0] == givenDice[2] && givenDice[0] == givenDice[3] && givenDice[0] == givenDice[4] && givenDice[0] == givenDice[5])
                calculatedScore = 50;
            return calculatedScore;
        }
        public String calculateStringForScoreBoard (int[] givenDice)
        {
            return "|Yatzy              |" + calculateScoreFromGivenDice(givenDice) + "          |";
        }
    }
}

