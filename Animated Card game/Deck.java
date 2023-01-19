public class Deck {
    //instance vars (this references a specific object on which a method is called, TLDR: use this to refer to instance variables if you're confused)
    // an array of card shaped objects
    public Card[] deck;
    //an index variable for the next card dealt (since java is a 0 index language)
    private int cardIndex;
    //create a constant total number of cards
    private final int totalCards = 52;
    //initialize  of deck
    private static int deckSize;

    public Deck() {
        //set deck size
        deckSize = 52;
        //create deck with 52 card objects
        deck = new Card[totalCards];
        //set index to 0/first card dealt is at 0th position
        cardIndex = 51;
        //fill deck by going through each index/card of the array and creating a card
        for (int suits = 0; suits <= 3; suits++) {
            for (int ranks = 1; ranks <= 13; ranks++) {
                deck[(13 * suits) + (ranks - 1)] = new Card(suits, ranks);
            }
        }
        //shuffle deck
        shuffle();
    }

    //convert deck ot string
    public String toString() {
        String deckString = deckSize + " cards remain in the deck." + "\n";
        return deckString;
    }

    public int size() {
        return deckSize;
    }

    //use temp card to swap location of cards using Fisher Yates shuffle
    public void shuffle() {
        for (int i = 51; i >= 1; i--) {
            int j = (int) (Math.random() * totalCards);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    //get a hand if there are enough cards and subtract cards from deckSize + decrement index
    public Hand getHand(int n) {
        if (deckSize < n) {
            System.err.println("No more cards to draw :(");
            System.exit(1);
        }
        Hand hand = new Hand(n);
        deckSize = deckSize - n;
        for (int dealamnt = 0; dealamnt < n; dealamnt++) {
            hand.addCard(deck[cardIndex]);
            cardIndex--;
        }
        return hand;
    }
}