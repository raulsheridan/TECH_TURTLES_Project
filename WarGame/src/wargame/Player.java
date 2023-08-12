/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 16474
 */
public class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null; // Handle empty hand gracefully
    }

    public boolean isEmpty() {
        return hand.isEmpty();
    }

    public int getHandSize() {
        return hand.size();
    }

    public boolean canWar() {
        return hand.size() >= 2;
    }

    public void collectCards(Card... cards) {
        for (Card card : cards) {
            if (card != null) {
                hand.add(card);
            }
        }
    }

    public int getTotalCards() {
        return hand.size();
    }
}