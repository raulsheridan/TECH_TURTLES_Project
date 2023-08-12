/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 16474
 */
public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private final String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
    private final String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                    "Ten", "Jack", "Queen", "King", "Ace"};

    public Deck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card dealCard() {
        if (!isEmpty()) {
            return cards.remove(0);
        }
        return null; // Handle empty deck gracefully
    }
}