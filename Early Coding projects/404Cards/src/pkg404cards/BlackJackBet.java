/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author lnber
 */
public class BlackJackBet {
    //==========================================================================
    // PROPERTIES (INSTANCE VARIABLES)
    //==========================================================================
    private int amount = 0;
    public int GetAmount() { return amount; }
    public void SetAmount(int amount) { this.amount = amount; }
    
    protected PlayerMoney playerMoney;
    
    //==========================================================================
    // CONSTRUCTORS
    //==========================================================================
    /**
     * Default Constructor
     */
    public BlackJackBet() {}
    
    /**
     * Full Constructor
     * @param amount 
     */
    public BlackJackBet(int amount) {
        SetAmount(amount);
    }
    
    //==========================================================================
    // METHODS
    //==========================================================================
    /** 
     * Method to allow the user to bet what they want, makes sure that it is not more than what they have available.
     * @param bet
     * @param playerMoney
     * @return 
     */
    public static int Bet(BlackJackBet bet, PlayerMoney playerMoney) {
        int playerBet = 0;
        double betDouble = 0.00;
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Please type the amount of your bet now. Please only use positive whole numbers.");
        Scanner itemA = new Scanner(System.in);
        // Catch to make sure that the user entered a positive whole number.
        String check = "X";
        do {
            if (itemA.hasNextInt()) {
                check = "A";
                playerBet = itemA.nextInt();
            } else if (itemA.hasNextDouble()) {
                check = "B";
                betDouble = itemA.nextDouble();
                Math.floor(betDouble);
                playerBet = (int) betDouble;
            } else {
                check = "X";
                System.out.println("You entered: " + itemA.next() + " ; Please enter a positive whole number.");
            }
        } while (check.equals("X"));
        // Making sure the user entered a value equal to or less than their pot. If they entered something more, then they are told they bet too much and are now all-in.
        if (playerBet <= playerMoney.GetPot()) {
            bet.SetAmount(playerBet);
        } else {
            System.out.println("You have attempted to bet more money than you had. You are now all-in.");
            bet.SetAmount(playerMoney.GetPot());
        }
        System.out.println("You bet: $" + bet.GetAmount());
        return bet.GetAmount();
    }
}
