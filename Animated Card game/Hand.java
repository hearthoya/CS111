import javax.annotation.processing.SupportedSourceVersion;

public class Hand {
    //instance vars
    //total number of cards in hand
    public static int n;
    //size of hand
    public static int s;
    //next card in hand
    public static int handIndex = 0;
    //creating n card objects for hand
    public static Card[] hand;

    //methods
    public Hand(int n) {
        //important differentiation between int n and n within hand
        this.n = n;
        s = 0;
        //hand is an array of cards with n cards
        hand = new Card[n];
    }

    //max number of cards that can be added to this hand when there aren't cards
    int capacity() {
        return n;
    }

    public int size() {
        return s;
    }

    //change size of hand if a card can be gotten
    public void addCard(Card c) {
        if (size() == n) {
            System.err.print("No more cards to draw :(");
            System.exit(1);
        }
        hand[s] = c;
        s++;
    }

    //get a card if there are cards to draw still
    public Card getCard(int i) {
        if (size() <= i) {
            System.err.println("Not enough cards :(");
            System.exit(1);
        }
        return hand[i];
    }

    //convert results to string
    public String toString() {
        String handString = "\n";
        for (int j = 0; j < n; j++) {
            handString = handString + "\n " + hand[j];
        }
        return handString;
    }
}
