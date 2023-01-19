public class Game {
    //Rules
    //------------------------------------------------------------------------------------------------------------------
    //1. There are 2 to 4 players
    //2. Each player receives a hand of 7 cards
    //3. There are no community cards
    //Value Conditions
    //1. Each card is ranked based on how subjectively cool I think it's rank and suit are (See switch cases for ranking)
    //2. The player with the highest summative value wins the game
    //3. If two players have the same coolness value the most recent one will win
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        //if there are no args print that there need to be players
        if (args.length > 1) {
            System.err.println("Invalid argument amount!");
            System.exit(1);
        }
        //make sure player amount fits rules
        int playerAmount = Integer.parseInt(args[0]);
        if (playerAmount > 4 || playerAmount < 2) {
            System.err.println("Invalid player amount!");
            System.exit(1);
        }
        Hand[] playerh = new Hand[playerAmount];
        //calculate and print winning index
        int winner = getWinner(playerh, playerAmount);
        //draw text
        System.out.print("\nPlayer " + (winner + 1) + " Wins! \n");
        StdDraw.show();
    }

    public static int getWinner(Hand[] x, int playerAmount) {
        //create a shuffled deck
        Deck deck = new Deck();
        //create an empty array of hands with room for each player's hand
        Hand[] playerHands = new Hand[playerAmount];
        //array of player scores
        int[] scores = new int[playerAmount];
        //double coordinate array for drawing cards
        double coordinate[] = new double[2];
        //first x value for both hands
        coordinate[0] = 0.15;
        //second x value for second two hands
        coordinate[1] = 0.75;
        System.out.print("\n-----------------------------\n");
        for (int i = 0; i < playerAmount; i++) {
            double xpos = 0;
            double ypos = 0;
            if (i == 0 || i == 1) {
                ypos = coordinate[0];
            }
            if (i == 2 || i == 3) {
                ypos = coordinate[1];
            }
            if (i == 0 || i == 2) {
                xpos = coordinate[0];
            }
            if (i == 1 || i == 3) {
                xpos = coordinate[1];
            }

            //create a hand for each player with 7 cards
            Hand playerHand = deck.getHand(7);
            playerHands[i] = playerHand;
            //print the hand
            System.out.println("Player " + (i + 1) + "'s" + " hand contains: " + playerHands[i]);
            //score variables to store each player's score
            int playersuitScore = 0;
            int playerrankScore = 0;
            //going through each card and increment player score based on the card values
            for (int c = 0; c < playerHand.capacity(); c++) {
                //switch case should add to a score for i player based on their cards (suit and rank)
                switch (playerHand.getCard(c).getSuit()) {
                    //clubs
                    case 0 -> playersuitScore += 1;
                    //diamonds
                    case 1 -> playersuitScore += 0;
                    //spades
                    case 2 -> playersuitScore += 3;
                    //hearts
                    case 3 -> playersuitScore += 2;
                }
                switch (playerHand.getCard(c).getRank()) {
                    //Non-existing card
                    case 0 -> playerrankScore += 0;
                    //Ace coolness rank
                    case 1 -> playerrankScore += 1;
                    // 2 coolness rank
                    case 2 -> playerrankScore += 12;
                    //3 coolness rank
                    case 3 -> playerrankScore += 13;
                    //4 coolness rank
                    case 4 -> playerrankScore += 7;
                    //5 coolness rank
                    case 5 -> playerrankScore += 6;
                    //6 coolness rank
                    case 6 -> playerrankScore += 5;
                    //7 coolness rank
                    case 7 -> playerrankScore += 4;
                    //8 coolness rank
                    case 8 -> playerrankScore += 3;
                    //9 coolness rank
                    case 9 -> playerrankScore += 11;
                    //10 coolness rank
                    case 10 -> playerrankScore += 10;
                    //Jack coolness rank
                    case 11 -> playerrankScore += 9;
                    //Queen coolness rank
                    case 12 -> playerrankScore += 8;
                    //King coolness rank
                    case 13 -> playerrankScore += 2;
                }
            }
            StdDraw.enableDoubleBuffering();
            for (int h = 0; h < playerHand.capacity(); h++) {
                StdDraw.show();
                String[] temp = String.valueOf(playerHand.getCard(h)).split(" ");
                String cardName = "CardPNGs\\"+temp[0] + temp[2] + ".png";
                StdDraw.picture(xpos, ypos, cardName, .15, .2);
                StdDraw.pause(500);
                xpos += .01;
                ypos += .01;
            }
            StdDraw.text(xpos - .005, ypos + .113, "Player " + (i + 1) + "");
            int playerScore = playersuitScore + playerrankScore;
            scores[i] = playerScore;
            //put player scores into the array
            System.out.println("\nPlayer score: " + playerScore + "\n" + "\n-------------------------------");
        }
        //print deck so that you can verify that get card is working correctly
        System.out.print(deck);
        //set variable to store the index of the largest player score
        int maxValue = scores[0];
        int winDex = 0;
        for (int w = 0; w < playerAmount; w++) {
            //make an if statement that compares a value at an array position with the maximum value
            if (scores[w] > maxValue) {
                //if the maximum value is equal to the score reassign the max value index to make it larger
                maxValue = scores[w];
                //assign the value
                winDex = w;
                //if there is a tie
            } else if (scores[w] == maxValue) {
                //the first hand to have the highest value automatically wins
                maxValue = scores[w];
                //assign the value
                winDex = w;
            }
        }
        StdDraw.text(.5, .5, "\nPlayer " + (winDex + 1) + " Wins!" + "\n");
        return winDex;
    }
}
