/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Scanner;
import static pkg404cards.Main.PlayHoldEm;

/**
 *
 * @author josephdejong
 */
public class Player {
    //==========================================================================
    //PROPERTIES
    //==========================================================================
    private String name = "";
    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }
    
    private int chipCount = 0;
    public int GetChipCount() { return chipCount; }
    public void SetChipCount(int chipCount) { this.chipCount = chipCount; }
    
    public int highestBet = 0;
    public int GetHighestBet() {
        return highestBet;
    }
    public void SetHighestBet(int highestBet) {
        this.highestBet = highestBet;
        if (highestBet > GetChipCount()) {
            highestBet = GetChipCount();
        }
    }

    private int handValue = 1;
    public int GetHandValue() {return handValue;}
    public void SetHandValue(int handValue) {this.handValue = handValue; }
    
    
    //==========================================================================
    //CONSTRUCTORS
    //==========================================================================
    /**
     * Default constructor
     */
    public Player(){}
    
    /**
     * Constructor accepting name and chip count
     * @param name
     * @param chipCount 
     */
    public Player(String name, int chipCount){
        SetName(name);
        SetChipCount(chipCount);
    }
    //==========================================================================
    //METHODS
    //==========================================================================
    /**
     * Method allowing the user to Call
     * @param pot
     * @param player
     * @param bot
     * @param deck 
     */
    public void Call(MoneyPot pot, Player player, Bot bot, Deck deck){
        if(player.GetChipCount() <= 0){
            System.out.println("You ran out of money. Since this is an educational tool we have restocked your chip count to 1000.");
            SetChipCount(1000);
            Call(pot, player, bot, deck);
        }
        else{
        if(bot.GetHighestBet() != 0){
            SetChipCount(GetChipCount() - bot.GetHighestBet());
            SetHighestBet(bot.GetHighestBet());
            pot.SetAmount(bot.GetHighestBet() + GetHighestBet() + pot.GetAmount());
            System.out.println("You have called the bots bet of " + bot.GetHighestBet() + " chips");
        }
        else{
            System.out.println("---- You did not choose a valid option. Please try again. ----");
            System.out.println("Make another choice\nA. Bet/Raise\nC. Check\nD. Fold");
            Scanner reprompt = new Scanner(System.in);
            String repromptAns = reprompt.nextLine();
            switch(repromptAns.toUpperCase().trim()){
                case "A":
                    Raise(pot, bot);
                    break;
                case "C":
                    Check(pot, player, bot, deck);
                    break;
                case "D":
                    Fold(pot, bot, player, deck);
                    break;
                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");
                    Call(pot, player, bot, deck);
                    break;
            }
        }
    }
    }
    /**
     * Method allowing the user to check
     * @param pot
     * @param player
     * @param bot
     * @param deck 
     */
    public void Check(MoneyPot pot, Player player, Bot bot, Deck deck){
        if(GetChipCount() <= 0){
            System.out.println("You ran out of money. Since this is an educational tool we have restocked your chip count to 1000.");
            SetChipCount(1000);
        }
        if(bot.GetHighestBet() == 0){
            System.out.println("You have checked");
        }
        else{
            System.out.println("You cannot Check");
            System.out.println("Make another choice\nA. Bet/Raise\nB. Call\nD. Fold");
            Scanner reprompt = new Scanner(System.in);
            String repromptAns = reprompt.nextLine();
            switch(repromptAns.toUpperCase().trim()){
                case "A":
                    Raise(pot, bot);
                    break;
                case "B":
                    Call(pot, player, bot, deck);
                    break;
                case "D":
                    Fold(pot, bot, player, deck);
                    break;
                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");
                    Call(pot, player, bot, deck);
                    break;
        }
    }
    }
    /**
     * Method allowing the user to raise
     * @param pot
     * @param bot 
     */
    public void Raise(MoneyPot pot, Bot bot){
        if(GetChipCount() <= 0){
            System.out.println("You ran out of money. Since this is an educational tool we have restocked your chip count to 1000.");
            SetChipCount(1000);
        }
        System.out.println("How much would you like to bet?");
        Scanner bet = new Scanner(System.in);
        String betAmount = bet.nextLine();
        
        if(Integer.parseInt(betAmount) == bot.GetHighestBet()){
            SetChipCount(GetChipCount() - Integer.parseInt(betAmount));
            pot.SetAmount(Integer.parseInt(betAmount) + pot.GetAmount());
            pot.SetHighestBet(Integer.parseInt(betAmount));
            SetHighestBet(Integer.parseInt(betAmount));
        }
        else if(Integer.parseInt(betAmount) > bot.GetHighestBet()){
            SetHighestBet(Integer.parseInt(betAmount)); 
            pot.SetAmount(Integer.parseInt(betAmount) + pot.GetAmount());
            SetChipCount(GetChipCount() - Integer.parseInt(betAmount));
            System.out.println("You have bet " + GetHighestBet() + " chips");
        }
        else{
            System.out.println("That number is too low\nEnter a value higher than " + bot.GetHighestBet());
            Raise(pot, bot);
        } 
    }
    
    /**
     * Method for when the user chooses to folds
     * @param pot
     * @param bot
     * @param player
     * @param deck 
     */
    public void Fold(MoneyPot pot, Bot bot, Player player, Deck deck){
        bot.SetChipCount(pot.GetAmount());
        System.out.println("You have folded\n");
        System.out.println("You now have " + player.GetChipCount() + " chips!");
        String entryVariable = "";

        while (entryVariable != "Q") {
            System.out.println("Would You like to play again?\nA. Yes!\nQ. Quit");
            Scanner scanner = new Scanner(System.in);
            String playAgainChoice = scanner.nextLine();
            switch (playAgainChoice.toUpperCase()) {
                case "A":
                    PlayHoldEm(pot, deck, player, bot);
                    break;
                case "B":
                    System.out.println("This was only for the test!");
                    break;
                case "Q":
                    Main.HoldEmMenu(pot, deck, player, bot);
                    break;

                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");
            }
        }
    }
    
    /**
     * Player options menu allowing them to choose what to do
     * @param player
     * @param bot
     * @param pot
     * @param deck 
     */
    public static void PlayerOptions(Player player, Bot bot, MoneyPot pot, Deck deck){
        Scanner menu = new Scanner(System.in);
        System.out.println("It is your turn");
        System.out.println("A. Bet\nB. Call\nC. Check\nD. Fold");
        String menuChoice = menu.nextLine();
        switch (menuChoice.toUpperCase().trim()) {
            case "A":
               player.Raise(pot, bot);
               break;
               
            case "B":
                player.Call(pot, player, bot, deck);
                break;
            
            case "C":
                player.Check(pot, player, bot, deck);
                break;
            
            case "D":
                player.Fold(pot, bot, player, deck);
                break;
                
            case "Q":
                Main.HoldEmMenu(pot, deck, player, bot);
                break;
                
            default:
                System.out.println("---- You did not choose a valid option. Please try again. ----");
        }   
    }
}
