/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.Scanner;

/**
 *
 * @author josephdejong
 */
public class MoneyPot {
    //==========================================================================
    //PROPERTIES
    //==========================================================================
    private int amount = 0;
    public int GetAmount() { return amount; }
    public void SetAmount(int amount) { this.amount = amount; }
    
    private int highestBet = 0;
    public int GetHighestBet() { return highestBet; }
    public void SetHighestBet(int highestBet) { this.highestBet = highestBet; }
    
    //==========================================================================
    //CONSTRUCTORS
    //==========================================================================
    /**
     * Default constructor
     */
    public MoneyPot(){}
    
    //==========================================================================
    //METHOD
    //==========================================================================
    /**
     * This checks weather the player and Bot have entered the same amount of chips before showing more cards
     * @param player
     * @param bot
     * @param pot
     * @param deck 
     */
    public void IsPotGood(Player player, Bot bot, MoneyPot pot, Deck deck){
        Scanner scanner = new Scanner(System.in);
        if(bot.GetHighestBet() != player.GetHighestBet()){
            player.SetChipCount(player.GetChipCount() + player.GetHighestBet());
            System.out.println("The bot has bet " + bot.GetHighestBet() + " chips.");
            System.out.println("What would you like to do\nA. Call\nB. Raise\nC. Fold");
            String answer = scanner.nextLine();
            switch(answer.toUpperCase()){
                case "A":
                    player.Call(pot, player, bot, deck);
                    //pot.SetAmount(pot.GetAmount() + bot.GetHighestBet());
                    System.out.println("Betting round finished");
                    System.out.println("There are " + pot.GetAmount() + " chips in the pot");
                    break;
                case "B":
                    player.Raise(pot, bot);
                    bot.BCall(pot, bot, player, deck);
                    pot.IsPotGood(player, bot, pot, deck);
                    //pot.SetAmount(pot.GetAmount() + bot.GetHighestBet());
                    
                    break;
                case "C":
                    player.Fold(pot, bot, player, deck);
                    break;
            }
        }
        else{
            pot.SetAmount(pot.GetAmount() + bot.GetHighestBet());
            System.out.println("Betting round finished");
            System.out.println("There are " + pot.GetAmount() + " chips in the pot");
        }
    }
}
