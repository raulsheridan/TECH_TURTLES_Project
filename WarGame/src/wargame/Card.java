/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author 16474
 */
public class Card {
    private final String suit;
    private final String rank;

    private static final Map<String, Integer> values = new HashMap<>();

    static {
        values.put("Two", 2);
        values.put("Three", 3);
        values.put("Four", 4);
        values.put("Five", 5);
        values.put("Six", 6);
        values.put("Seven", 7);
        values.put("Eight", 8);
        values.put("Nine", 9);
        values.put("Ten", 10);
        values.put("Jack", 10);
        values.put("Queen", 10);
        values.put("King", 10);
        values.put("Ace", 11);
    }

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int compareValue(Card otherCard) {
        return Integer.compare(values.get(rank), values.get(otherCard.rank));
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}