package interfaces;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @auther 薛晨
 * @date 2019/12/21
 * @time 15:00
 * @description
 */
public class StandardDeck implements Deck {

    private List<Card> entireDeck;

    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }

    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }

    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }

    public int size() {
        return entireDeck.size();
    }

    public List<Card> getCards() {
        return entireDeck;
    }

    public void addCard(Card card) {
        entireDeck.add(card);
    }

    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }


    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }

    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    public Map<Integer, Deck> deal(int players, int numberOfCards)
            throws IllegalArgumentException {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException(
                    "Number of players (" + players +
                            ") times number of cards to be dealt (" + numberOfCards +
                            ") is greater than the number of cards in the deck (" +
                            sizeOfDeck + ").");
        }

        Map<Integer, List<Card>> dealtDeck = entireDeck
                .stream()
                .collect(
                        Collectors.groupingBy(
                                card -> {
                                    int cardIndex = entireDeck.indexOf(card);
                                    if (cardIndex >= cardsDealt) return (players + 1);
                                    else return (cardIndex % players) + 1;
                                }));

        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();

        for (int i = 1; i <= (players + 1); i++) {
            Deck currentDeck = deckFactory();
            currentDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currentDeck);
        }
        return mapToReturn;
    }

    public String deckToString() {
        return this.entireDeck
                .stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * 主要展示了由于默认方法和静态方法的加入使Compartor接口增强了，你只要指定排序的内容，而不用考虑如何排序
     *
     * @param args
     */
    public static void main(String... args) {
        StandardDeck myDeck = new StandardDeck();
        System.out.println("Creating deck:");
        myDeck.sort();
        System.out.println("Sorted deck");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("Sorted by rank, then by suit");
        System.out.println(myDeck.deckToString());
        myDeck.shuffle();
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .thenComparing(Card::getSuit));
        System.out.println("Sorted by rank, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .reversed()
                        .thenComparing(Card::getSuit));
        //看不懂的时候就想想遍历的例子是如何一步一步进化的，如下1
        myDeck.sort(
                Comparator.comparing(new Function<Card, Card.Rank>() {

                    @Override
                    public Card.Rank apply(Card card) {
                        return card.getRank();
                    }
                })
                        .reversed()
                        .thenComparing(Card::getSuit));
        //2
        myDeck.sort(
                Comparator.comparing((Function<Card, Card.Rank>) card -> card.getRank())
                        .reversed()
                        .thenComparing(Card::getSuit));
        //3
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .reversed()
                        .thenComparing(Card::getSuit));
        System.out.println("Sorted by rank reversed, then by suit " +
                "with static and default methods");
        System.out.println(myDeck.deckToString());
    }
}
