/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wargame;
import java.util.Scanner;
/**
 *
 * @author 16474
 */
public class WarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the War Card Game!");
        System.out.println("=============================");

        System.out.print("Enter name for player 1: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Enter name for player 2: ");
        Player player2 = new Player(scanner.nextLine());

        System.out.print("Enter 'start' to begin or 'exit' to quit: ");
        String input = scanner.nextLine();

        int player1Score = 0, player2Score = 0;

        if (input.equals("start")) {
            int numRounds = 3;

            for (int round = 1; round <= numRounds; round++) {
                System.out.println("Round " + round + "\n-------------");

                Deck deck = new Deck();
                deck.shuffle();

                while (!deck.isEmpty()) {
                    player1.drawCard(deck.dealCard());
                    player2.drawCard(deck.dealCard());
                }

                System.out.println("Game Starts!\n");

                while (!player1.isEmpty() && !player2.isEmpty()) {
                    System.out.print("Press enter to play or 'exit' to quit: ");
                    String roundInput = scanner.nextLine();

                    if (roundInput.equals("exit")) {
                        System.out.println("Exiting the game.");
                        scanner.close();
                        return;
                    }

                    Card card1 = player1.playCard();
                    Card card2 = player2.playCard();

                    System.out.println(player1.getName() + " plays: " + card1);
                    System.out.println(player2.getName() + " plays: " + card2);

                    int comparison = card1.compareValue(card2);

                    if (comparison > 0) {
                        player1.collectCards(card1, card2);
                        System.out.println(player1.getName() + " wins this round!");
                        player1Score++;
                    } else if (comparison < 0) {
                        player2.collectCards(card1, card2);
                        System.out.println(player2.getName() + " wins this round!");
                        player2Score++;
                    } else {
                        System.out.println("It's a tie! War!");

                        if (player1.canWar() && player2.canWar()) {
                            player1.playCard();
                            player2.playCard();

                            Card warCard1 = player1.playCard();
                            Card warCard2 = player2.playCard();

                            System.out.println(player1.getName() + " plays: " + warCard1);
                            System.out.println(player2.getName() + " plays: " + warCard2);

                            int warComparison = warCard1.compareValue(warCard2);

                            if (warComparison > 0) {
                                player1.collectCards(card1, card2, warCard1, warCard2);
                                System.out.println(player1.getName() + " wins the war!");
                                player1Score++;
                            } else if (warComparison < 0) {
                                player2.collectCards(card1, card2, warCard1, warCard2);
                                System.out.println(player2.getName() + " wins the war!");
                                player2Score++;
                            } else {
                                System.out.println("War result is a tie again! Continuing...");
                            }
                        } else {
                            System.out.println("Not enough cards for war. Game Over.");
                            break;
                        }
                    }

                    System.out.println("End of Round " + round + "\n-------------\n");
                }
            }

            // Display points table and final result
            System.out.println("=============================");
            System.out.println("        Points Table");
            System.out.println("=============================");
            System.out.printf("%-15s | %-10s | %-10s%n", "Player", "Points", "Status");
            System.out.println("=============================");
            System.out.printf("%-15s | %-10d | %s%n", player1.getName(), player1Score, (player1Score > player2Score) ? "Winner" : "");
            System.out.printf("%-15s | %-10d | %s%n", player2.getName(), player2Score, (player2Score > player1Score) ? "Winner" : "");
            System.out.println("=============================");

            if (player1Score > player2Score) {
                System.out.println(player1.getName() + " wins the game!");
            } else if (player2Score > player1Score) {
                System.out.println(player2.getName() + " wins the game!");
            } else {
                System.out.println("It's a tie game!");
            }
            System.out.println("=============================");
        } else if (input.equals("exit")) {
            System.out.println("Exiting the game.");
        } else {
            System.out.println("Invalid input. Exiting the game.");
        }

        scanner.close();
    }
}