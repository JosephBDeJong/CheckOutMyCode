/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author josephdejong
 */
public class HandRanking {
    //--------------------------------------------------------------------------
    // Properties
    //--------------------------------------------------------------------------
    private int straightFlush = 9;
    public int GetstraightFlush() {return straightFlush;}
    public void SetstraightFlush(int straightFlush) {this.straightFlush = straightFlush;}
    
    private int fourOfaKind = 8;
    public int GetfourOfaKind() {return fourOfaKind;}
    public void SetfourOfaKind(int fourOfaKind) {this.fourOfaKind = fourOfaKind;}
    
    private int fullHouse = 7;
    public int GetfullHouse() {return fullHouse;}
    public void SetfullHouse(int fullHouse) {this.fullHouse = fullHouse;}
    
    private int flush = 6;
    public int GetFlush() {return flush;}
    public void SetFlush(int flush) {this.flush = flush;}
    
    private int straight = 5;
    public int GetStraight() {return straight;}
    public void SetStraight(int straight) {this.straight = straight;}
    
    private int threeOfaKind = 4;
    public int GetthreeOfaKind() {return threeOfaKind;}
    public void SetthreeOfaKind(int threeOfaKind) {this.threeOfaKind = threeOfaKind;}
    
    private int twoPair = 3;
    public int GettwoPair() {return twoPair;}
    public void SettwoPair(int twoPair) {this.twoPair = twoPair;}
    
    private int pair = 2;
    public int GetPair() {return pair;}
    public void SetPair(int pair) {this.pair = pair;}
    
    private int highCard = 1;
    public int GethighCard() {return highCard;}
    public void SethighCard(int highCard) {this.highCard = highCard;}
    
//    private int handValue = 1;
//    public int GetHandValue() {return handValue;}
//    public void SetHandValue(int handValue) {this.handValue = handValue;}
    //ArrayList<Card> card = new ArrayList<Card>();
    //--------------------------------------------------------------------------
    //Constructors
    //--------------------------------------------------------------------------
    /**
     * Default constructor
     */
    public HandRanking() {}
    
    /**
     * Full constructor
     * @param straightFlush
     * @param fourOfaKind
     * @param fullHouse
     * @param flush
     * @param straight
     * @param threeOfaKind
     * @param twoPair
     * @param pair
     * @param highCard 
     */
    public HandRanking(int straightFlush, int fourOfaKind, int fullHouse, int flush, int straight, int threeOfaKind, int twoPair, int pair,int highCard) {
        SetstraightFlush(straightFlush);
        SetfourOfaKind(fourOfaKind);
        SetfullHouse(fullHouse);
        SetFlush(flush);
        SetStraight(straight);
        SetthreeOfaKind(threeOfaKind);
        SettwoPair(twoPair);
        SetPair(pair);
        SethighCard(highCard);
                }
    //--------------------------------------------------------------------------
    //Methods
    //--------------------------------------------------------------------------
    // Method to determine the rank of a hand
    /**
     * THIS METHOD IS UNUSED IN THE CURRENT STATE OF THE GAME; HOWEVER, IT IS LEFT IN THIS VERSION FOR FUTURE DEVELOPEMENT
     * @param hand
     * @param player
     * @return 
     */
    public int RankPlayerHand(ArrayList<Card> hand, Player player) {
        // Sort the cards in the hand                                                                       
        //Collections.sort(hand);
        // Set some flags and counters to track the different kinds of hands
        boolean flushCheck = true, straightCheck = false;
        int pairs = 0, threeOfAKind = 0, fourOfAKind = 0;
        int lastValue = -1, straightStart = -1;
        // Loop through the cards in the hand
        for (Card card : hand) {
            // Check for flush
            if (lastValue != -1) {
                if (card.GetCardSuit() != hand.get(0).GetCardSuit()) {
                    flushCheck = false;
                }
                // Check for pairs, three of a kind, and four of a kind
                if (Integer.parseInt(card.GetCardValue()) == lastValue) {
                    pair++;
                    if (pair == 1) {
                        threeOfAKind++;
                    } else if (pair == 2) {
                        if (threeOfAKind > 0) {
                            pair--;
                            threeOfAKind--;
                            fourOfAKind++;
                        } else {
                            twoPair++;
                        }
                    } else if (pair == 3) {
                        pair--;
                        fourOfAKind++;
                    }
                // Check for straights
                } else {
                    if (straightStart == -1) {
                        straightStart = lastValue;
                    }
                    if (Integer.parseInt(card.GetCardValue()) == lastValue + 1) {
                        if (Integer.parseInt(card.GetCardValue()) == 14 && lastValue == 5) {
                            straightCheck = true;
                        } else if (straightStart == lastValue - 1) {
                            straightCheck = true;
                        }
                    } else {
                        straightStart = -1;
                    }
                }
            }
            lastValue = Integer.parseInt(card.GetCardValue());
        }
        // Determine the rank of the hand based on the flags and counters                   //Alley oop from StackOverflow
        if (flushCheck && straightCheck) {
            player.SetHandValue(straightFlush);
            return straightFlush;
        } else if (fourOfAKind > 0) {
            player.SetHandValue(fourOfaKind);
            return fourOfaKind;
        } else if (threeOfaKind > 0 && pairs > 0) {
            player.SetHandValue(fullHouse);
            return fullHouse;
        } else if (flushCheck) {
            player.SetHandValue(fullHouse);
            return flush;
        } else if (straightCheck) {
            player.SetHandValue(fullHouse);
            return straight;
        } else if (threeOfaKind > 0) {
            player.SetHandValue(threeOfaKind);
            return threeOfaKind;
        } else if (twoPair > 0) {
            player.SetHandValue(twoPair);
            return twoPair;
        } else if (pair > 0) {
            player.SetHandValue(pair);
            return pair;
        } else {
            player.SetHandValue(highCard);
            return highCard;
        }
        
    }
    /**
     * THIS METHOD IS UNUSED IN THE CURRENT STATE OF THE GAME; HOWEVER, IT IS LEFT IN THIS VERSION FOR FUTURE DEVELOPEMENT
     * @param hand
     * @param bot
     * @return 
     */
    public int RankBotHand(ArrayList<Card> hand, Bot bot) {
        // Sort the cards in the hand                                                                       
        //Collections.sort(hand);
        // Set some flags and counters to track the different kinds of hands
        boolean flushCheck = true, straightCheck = false;
        int pairs = 0, threeOfAKind = 0, fourOfAKind = 0;
        int lastValue = -1, straightStart = -1;
        // Loop through the cards in the hand
        for (Card card : hand) {
            // Check for flush
            if (lastValue != -1) {
                if (card.GetCardSuit() != hand.get(0).GetCardSuit()) {
                    flushCheck = false;
                }
                // Check for pairs, three of a kind, and four of a kind
                if (Integer.parseInt(card.GetCardValue()) == lastValue) {
                    pair++;
                    if (pair == 1) {
                        threeOfAKind++;
                    } else if (pair == 2) {
                        if (threeOfAKind > 0) {
                            pair--;
                            threeOfAKind--;
                            fourOfAKind++;
                        } else {
                            twoPair++;
                        }
                    } else if (pair == 3) {
                        pair--;
                        fourOfAKind++;
                    }
                // Check for straights
                } else {
                    if (straightStart == -1) {
                        straightStart = lastValue;
                    }
                    if (Integer.parseInt(card.GetCardValue()) == lastValue + 1) {
                        if (Integer.parseInt(card.GetCardValue()) == 14 && lastValue == 5) {
                            straightCheck = true;
                        } else if (straightStart == lastValue - 1) {
                            straightCheck = true;
                        }
                    } else {
                        straightStart = -1;
                    }
                }
            }
            lastValue = Integer.parseInt(card.GetCardValue());
        }
        // Determine the rank of the hand based on the flags and counters                   //Alley oop from StackOverflow
        if (flushCheck && straightCheck) {
            bot.SetHandValue(straightFlush);
            return straightFlush;
        } else if (fourOfAKind > 0) {
            bot.SetHandValue(fourOfaKind);
            return fourOfaKind;
        } else if (threeOfaKind > 0 && pairs > 0) {
            bot.SetHandValue(fullHouse);
            return fullHouse;
        } else if (flushCheck) {
            bot.SetHandValue(fullHouse);
            return flush;
        } else if (straightCheck) {
            bot.SetHandValue(fullHouse);
            return straight;
        } else if (threeOfaKind > 0) {
            bot.SetHandValue(threeOfaKind);
            return threeOfaKind;
        } else if (twoPair > 0) {
            bot.SetHandValue(twoPair);
            return twoPair;
        } else if (pair > 0) {
            bot.SetHandValue(pair);
            return pair;
        } else {
            bot.SetHandValue(highCard);
            return highCard;
        }
        
    }
    /**
     * Method for the player to determine who the winner of the hand is
     * @param player
     * @param bot
     * @param pot 
     */
    public static void WhoIsWinner(Player player, Bot bot, MoneyPot pot){
        Scanner whoWon = new Scanner(System.in);
        System.out.println("Who Won?\nSelect 1 for Yourself" + "\nSelect 2 for " + bot.GetName() + "\nFor a tie select 3");
        int winner = whoWon.nextInt();
        
        if(winner == 1){
            System.out.println("You win!!!!!");
            player.SetChipCount(pot.GetAmount() + player.GetChipCount());
            System.out.println("You now have " + player.GetChipCount() + (" chips"));
        }
        else if(winner == 2){
            System.out.println("You lose :(");
            bot.SetChipCount(pot.GetAmount() + bot.GetChipCount());
            System.out.println("You now have " + player.GetChipCount() + (" chips"));
        }
        else if (winner==3){
            System.out.println("You tied with the bot!");
            player.SetChipCount((pot.GetAmount() / 2));
            bot.SetChipCount((pot.GetAmount() / 2));
            System.out.println("You now have " + player.GetChipCount() + (" chips"));
        }
    }
    // This is for future developement
//    public static void WhoIsWinner(Player player, Bot bot, MoneyPot pot){
//        if(player.GetHandValue() > bot.GetHandValue()){
//            System.out.println("You win!!!!!");
//            player.SetChipCount(pot.GetAmount() + player.GetChipCount());
//            System.out.println("You now have " + player.GetChipCount() + (" chips"));
//        }
//        else if(player.GetHandValue() < bot.GetHandValue() ){
//            System.out.println("You lose :(");
//            bot.SetChipCount(pot.GetAmount() + bot.GetChipCount());
//            System.out.println("You now have " + player.GetChipCount() + ("chips"));
//        }
//        else{
//            System.out.println("You tied with the bot!");
//            player.SetChipCount((pot.GetAmount() / 2));
//            bot.SetChipCount((pot.GetAmount() / 2));
//            System.out.println("You now have " + player.GetChipCount() + ("chips"));
//        }
//    }
}
    
    


