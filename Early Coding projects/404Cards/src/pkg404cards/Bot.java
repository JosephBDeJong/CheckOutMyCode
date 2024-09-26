/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.Random;
import java.util.Scanner;
import static pkg404cards.Main.PlayHoldEm;

/**
 *
 * @author josephdejong
 */
public class Bot {
    //==========================================================================
    //PROPERTIES
    //==========================================================================
    private String name = "";
    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }
    
    private int chipCount = 0;
    public int GetChipCount() { return chipCount; }
    public void SetChipCount(int chipCount) { this.chipCount = chipCount; }
    
    private int handValue = 0;
    public int GetHandValue() {return handValue;}
    public void SetHandValue(int handValue) {this.handValue = handValue;}
    
    public int highestBet = 0;
    public int GetHighestBet() { return highestBet; }
    public void SetHighestBet(int highestBet) { this.highestBet = highestBet; }
    //==========================================================================
    //CONSTUCTORS
    //==========================================================================
    /**
     * Default constructor
     */
    public Bot(){}
    
    /**
     * Constructor accepting name and chip count
     * @param name
     * @param chipCount 
     */
    public Bot(String name, int chipCount){
        SetName(name);
        SetChipCount(chipCount);
    }
    
    //A bot class that is very straightforward and simple.
    //Uses the hand ranking class in order to tell the bot to fold, call, or raise
    //This uses set values given by the hand rankings
    //The code will say that if hand ranking is less than or equal to 1(just example) then the bot will fold
    //If hand ranking is over 5 then the bot will raise and in between it will call
    //Extends player class in order to use the same properties
    
   
    //==========================================================================
    //Methods
    //==========================================================================
    /**
     * Method to allow the bot to call
     * @param pot
     * @param bot
     * @param player
     * @param deck 
     */
    public void BCall(MoneyPot pot, Bot bot, Player player, Deck deck){
        if(player.GetHighestBet() != 0){
            SetChipCount(GetChipCount() - player.GetHighestBet());
            SetHighestBet(player.GetHighestBet());
            System.out.println("The bot has called");
            
        }
        else{
            BRaise(pot, bot, deck, player);
            System.out.println("The bot has raised to " + GetHighestBet() + " chips");
        }
    }
   
    /**
     * Method to allow the bot to raise
     * @param pot
     * @param bot
     * @param deck
     * @param player 
     */
    public void BRaise(MoneyPot pot, Bot bot, Deck deck, Player player){
        player.SetChipCount(player.GetHighestBet() + player.GetChipCount());
        pot.SetAmount(pot.GetAmount() - player.GetHighestBet());
        System.out.println("PLAYERCHIPCOUNT = " + player.GetChipCount());
        int betAmount = player.GetHighestBet() + 20;
        if (betAmount > GetChipCount()){
            betAmount = GetChipCount();
            System.out.println("The bot is all in");
        }
        else {   
        SetChipCount(GetChipCount() - betAmount);
        pot.SetHighestBet(betAmount);
        bot.SetHighestBet(betAmount);
            System.out.println("You have been raised to " + betAmount);
    }
    }
   
    /**
     * Method to allow the bot to fold
     * @param player
     * @param pot
     * @param deck
     * @param bot 
     */
    public void BFold(Player player, MoneyPot pot, Deck deck, Bot bot) {
        System.out.println("Your opponent has folded. You Win!");
        player.SetChipCount(pot.GetAmount() + player.GetChipCount());
        System.out.println("You now have " + player.GetChipCount() + " chips!");
        String entryVariable = "";

        while (entryVariable != "Q") {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would You like to play again?\nA. Yes!\nQ. Quit");
            String playAgainChoice = scanner.nextLine();
            switch (playAgainChoice.toUpperCase()) {
                case "A":
                    PlayHoldEm(pot, deck, player, bot);
                    break;
                case "B":
                    System.out.println("This is only for Junit!");
                    break;
                case "Q":
                    System.out.println("Ending Program");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    
    /**
     * Method to allow the bot to check
     * @param pot
     * @param bot
     * @param player
     * @param deck 
     */
    public void BCheck(MoneyPot pot, Bot bot, Player player, Deck deck){
        if(player.GetHighestBet() == 0){
            System.out.println("Your opponent has checked.");
        }else {
            BCall(pot, bot, player, deck);
        }
    }
   
    /**
    * Method telling the bot how to play during the preflop period
    * @param pot
    * @param bot
    * @param player
    * @param deck 
    */
    public void PreFlopBot(MoneyPot pot, Bot bot, Player player, Deck deck) {
        BCheck(pot, bot, player, deck);
        pot.IsPotGood(player, bot, pot, deck);
    }

    /**
     * Method telling the bot how to play during the flop period
     * @param pot
     * @param bot
     * @param player
     * @param deck 
     */
    public void FlopBot(MoneyPot pot, Bot bot, Player player, Deck deck) {
        Random random = new Random();
        int int_random = random.nextInt(11);
        if (int_random == 0) {
            if(player.GetHighestBet() == 0){
                BCheck(pot, bot, player, deck);
            }
            else{
            BFold(player, pot, deck, bot); 
            }
        } else if (int_random >= 1 && int_random <= 5) {
            BCheck(pot, bot, player, deck);
        } else if (int_random > 5 && int_random <= 7) {
            BCall(pot, bot, player, deck);
        } else if (int_random > 7) {
            BRaise(pot, bot, deck, player);
        }
        pot.IsPotGood(player, bot, pot, deck);
    }

    /**
     * Method telling the bot how to play during the turn period
     * @param player
     * @param bot
     * @param pot
     * @param deck 
     */
    public void TurnBot(Player player, Bot bot, MoneyPot pot, Deck deck) {
        Random random = new Random();
        int int_random = random.nextInt(11);
        if (GetChipCount() == 0) {
            System.out.println("The Bot is All in");
        } else {
            if (int_random == 1) {
                if (player.GetHighestBet() == 0) {
                    BCheck(pot, bot, player, deck);
                } else {
                    BFold(player, pot, deck, bot);
                }
            } else if (int_random > 1 && int_random <= 2) {
                BCheck(pot, bot, player, deck);
            } else if (int_random == 3) {
                BCall(pot, bot, player, deck);
            } else if (int_random >= 4) {
                BRaise(pot, bot, deck, player);
            }
        }
        pot.IsPotGood(player, bot, pot, deck);
    }

    /**
     * Method telling the bot how to play during the river period
     * @param player
     * @param bot
     * @param pot
     * @param deck 
     */
    public void RiverBot(Player player, Bot bot, MoneyPot pot, Deck deck) {
        Random random = new Random();
        int int_random = random.nextInt(11);
        if (GetChipCount() == 0) {
            System.out.println("The Bot is All in");
        } else {
            if (int_random <= 2) {
                if (player.GetHighestBet() == 0) {
                    BCheck(pot, bot, player, deck);
                } else {
                    BFold(player, pot, deck, bot);
                }
            } else if (int_random > 2 && int_random <= 4) {
                BCheck(pot, bot, player, deck);
            } else if (int_random == 5) {
                BCall(pot, bot, player, deck);
            } else if (int_random > 5) {
                BRaise(pot, bot, deck, player);
            }
        }
        pot.IsPotGood(player, bot, pot, deck);
    }
}
