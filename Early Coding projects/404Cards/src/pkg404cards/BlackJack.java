/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Scanner;

// https://minich.com/education/wyo/java/lecture_notes/arraylists.php
// Using ArrayLists as a class property

// https://entertainment.howstuffworks.com/blackjack4.htm
// BlackJack rules

/**
 *
 * @author lnber
 */
public class BlackJack extends BlackJackDeck {
    //==========================================================================
    // PROPERTIES (INSTANCE VARIABLES)
    //==========================================================================
    protected ArrayList<BlackJackCard> dealerHand;
    
    protected ArrayList<BlackJackCard> playerHand;
    
    protected BlackJackBet playerBet;
    
    protected PlayerMoney playerMoney;
    
    protected boolean playerBust = false;
    public boolean GetPlayerBust() { return playerBust; }
    public void SetPlayerBust(boolean playerBust) { this.playerBust = playerBust; }
    
    //==========================================================================
    // CONSTRUCTORS
    //==========================================================================
    /**
     * Default Constructor for BlackJack
     */
    public BlackJack() {
        dealerHand = new ArrayList<BlackJackCard>();
        playerHand = new ArrayList<BlackJackCard>();
        playerMoney = new PlayerMoney(0);
        playerBet = new BlackJackBet(0);
        SetPlayerBust(false);
    }
    
    //==========================================================================
    // METHODS
    //==========================================================================
    /**
     * Calling the Bet method within this class, so that it can be used as an instance level method for a BlackJack instance.
     * @param playerBet
     * @param playerMoney 
     */
    public void Betting(BlackJackBet playerBet, PlayerMoney playerMoney) {
        BlackJackBet.Bet(playerBet, playerMoney);
    }
    
    /**
     * Begins the game and deals the initial cards to the player and Dealer.
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void StartDeal(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
        // Clearing the hands and dealing tow cards to both the player and dealer.
        playerHand.clear();
        dealerHand.clear();
        boolean DBJCheck = false;
        boolean PBJCheck = false;
        Deal(playerHand, cardHolder);
        Deal(dealerHand, cardHolder);
        Deal(playerHand, cardHolder);
        Deal(dealerHand, cardHolder);
        // For loops are used to increase the value of the Aces to 11 in the initial deal.
        int playerTotal = HandTotal(playerHand);
        int playerHandSize = playerHand.size();
        for (int i = 0; i < playerHandSize; i++ ) {
            if (playerTotal < 12 && playerHand.get(i).GetFace().equals("Ace") ) {
                playerHand.get(i).SetValue(11);
                playerTotal = HandTotal(playerHand);
            }
        }
        int dealerTotal = HandTotal(dealerHand);
        int dealerHandSize = dealerHand.size();
        for (int i = 0; i < dealerHandSize; i++ ) {
            if (dealerTotal < 12 && dealerHand.get(i).GetFace().equals("Ace") ) {
                dealerHand.get(i).SetValue(11);
                dealerTotal = HandTotal(dealerHand);
            }
        }
        System.out.println("You currently have: " + playerHand + " for a total amount of: " + HandTotal(playerHand));
        System.out.println("The Dealer is currently showing a(n) " + dealerHand.get(1).GetFace());
    }
    
    /**
     * If/else statement to decide which options menu the user should be presented with.
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void TotalOptionsMenu(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
        // If they can split (first turn), give them the split menu. If its the first turn and they can't split, double down menu. Else, base menu.
        if (playerHand.size() == 2 && playerHand.get(0).GetFace().equals(playerHand.get(1).GetFace())) {
            BlackJackOptionsSplit(playerHand, dealerHand, cardHolder);
        } else if (playerHand.size() == 2) {
            BlackJackOptionsDD(playerHand, dealerHand, cardHolder);
        } else {
            BlackJackOptions(playerHand, dealerHand, cardHolder);
        }
    }
    
    /**
     * Main options menu. Allows the user to Hit or Stay
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void BlackJackOptions(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Hit\nB. Stay";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               // If the player hits, it checks to see if they busted. If they did, then it goes to the end (dealer hitting). If not, they get the menu again.
               Hit(playerHand, cardHolder, playerBet);
               if (GetPlayerBust() == true) {
                   PlayerBust();
               } else {
                   BlackJackOptions(playerHand, dealerHand, cardHolder);
               }
               break;
           case "B":
               // If the player stays, then it goes to the end (dealer hitting).
               Stay(playerHand, dealerHand, playerBet, cardHolder);
               break;
           default:
               // Catch
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               BlackJackOptions(playerHand, dealerHand, cardHolder);
       }
    }
    
    /**
     * Options menu for the first turn of the game, if the player is unable to split their hand.
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void BlackJackOptionsDD(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Hit\nB. Stay\nC. Double Down";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               // If the player hits, it checks to see if they busted. If they did, then it goes to the end (dealer hitting). If not, they get the menu again.
               Hit(playerHand, cardHolder, playerBet);
               if (GetPlayerBust() == true) {
                   PlayerBust();
               } else {
                   BlackJackOptions(playerHand, dealerHand, cardHolder);
               }
               break;
           case "B":
               // If the player stays, then it goes to the end (dealer hitting).
               Stay(playerHand, dealerHand, playerBet, cardHolder);
               break;
           case "C":
               // If the player doubles down, then they are given a card and their bet is doubled, then it goes to the end (dealer hitting).
               DoubleDown(playerHand, cardHolder, dealerHand);
               break;
           default:
               // Catch
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               BlackJackOptionsDD(playerHand, dealerHand, cardHolder);
       }
    }
    
    public void BlackJackOptionsSplit(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Hit\nB. Stay\nC. Split your hand\nD. Double Down";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               // If the player hits, it checks to see if they busted. If they did, then it goes to the end (dealer hitting). If not, they get the menu again.
               Hit(playerHand, cardHolder, playerBet);
               if (GetPlayerBust() == true) {
                   PlayerBust();
               } else {
                   BlackJackOptions(playerHand, dealerHand, cardHolder);
               }
               break;
           case "B":
               // If the player stays, then it goes to the end (dealer hitting).
               Stay(playerHand, dealerHand, playerBet, cardHolder);
               break;
           case "C":
               // If the player Splits, then it goes into two hands that each get their own options. Each hand gets their own bet of the original amount.
               SplitHand(playerHand, dealerHand, cardHolder);
               break;
           case "D":
               // If the player doubles down, then they are given a card and their bet is doubled, then it goes to the end (dealer hitting).
               DoubleDown(playerHand, cardHolder, dealerHand);
               break;    
           default:
               // Catch
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               BlackJackOptionsSplit(playerHand, dealerHand, cardHolder);
       }
    }
    
    /**
     * Method to give the user another card. Ensures Aces are the right value. Checks to see if user busts.
     * @param playerHand
     * @param cardHolder
     * @param playerBet 
     */
    public void Hit(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> cardHolder, BlackJackBet playerBet) {
        // Giving the user another card
        System.out.println("You chose to hit");
        System.out.println("You got a(n) " + cardHolder.get(0).GetFace());
        Deal(playerHand, cardHolder);
        System.out.println("Your hand is currently: " + playerHand);
        // Changing the value of Aces
        // Making sure its 11 if their hand total prior to the ace is 10 or less, and 1 if their hand total prior to the ace was 11 or more
        int total = (int) HandTotal(playerHand);
        int handSize = playerHand.size();
        SetPlayerBust(false);
        for (int i = 0; i < handSize; i++ ) {
            if (total < 12 && playerHand.get(i).GetFace().equals("Ace") ) {
            playerHand.get(i).SetValue(11);
            total = HandTotal(playerHand);
            }
        }
        for (int i = 0; i < handSize; i++ ) {
            if (total > 21 && playerHand.get(i).GetFace().equals("Ace") ) {
            playerHand.get(i).SetValue(1);
            total = HandTotal(playerHand);
            }
        }
        // Checks if the player busts
        if (total > 21) {
            SetPlayerBust(true);
        }
        System.out.println("The total of your hand is now: " + HandTotal(playerHand));
    }
    
    /**
     * Decreases the player's pot if they bust
     */
    public void PlayerBust() {
        System.out.println("You busted! You lost: $" + playerBet.GetAmount());
        int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
        playerMoney.SetPot(newAmount);
    }
    
    /**
     * Method for the Dealer to hit until they have at least 17. Ensures Aces are the right value. Checks to see if user busts.
     * @param dealerHand
     * @param cardHolder
     * @param total 
     */
    public void DealerHit(ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder, int total) {
        System.out.println("The Dealer flips his face down card. They currently have a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace() + 
                " for a total amount of: " + HandTotal(dealerHand));
        // Makes sure that the Dealer hits until they have at least 17
        while (total < 17) {
            System.out.println("The Deadler has hit and got a(n) " + cardHolder.get(0).GetFace());
            Deal(dealerHand, cardHolder);
            // Changes the value of Aces as needed
            int handSize = dealerHand.size();
            int dealerHandSize = dealerHand.size();
            for (int i = 0; i < dealerHandSize; i++ ) {
                if (total < 12 && dealerHand.get(i).GetFace().equals("Ace") ) {
                dealerHand.get(i).SetValue(11);
                total = HandTotal(dealerHand);
                }
            }
            for (int i = 0; i < handSize; i++ ) {
                if (total > 21 && dealerHand.get(i).GetFace().equals("Ace") ) {
                dealerHand.get(i).SetValue(1);
                total = HandTotal(dealerHand);
                }
            }
            System.out.println("The total of the Dealer's hand is now: " + HandTotal(dealerHand));
            total = (int) HandTotal(dealerHand);
            System.out.println("---------------------------------------------------------------------------");
        }
    }
    
    /**
     * Method for the player to stay, has the dealer hit, then compares the hands & gives or takes money as needed.
     * @param playerHand
     * @param dealerHand
     * @param playerBet
     * @param cardHolder 
     */
    public void Stay(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, BlackJackBet playerBet, ArrayList<BlackJackCard> cardHolder) {
        int playerTotal = HandTotal(playerHand);
        int dealerTotal = HandTotal(dealerHand);
        System.out.println("You chose to stay with a hand of: " + playerHand + ". This totals to a value of: " + playerTotal);
        // Having the dealer hit until they get 17
        if (dealerTotal < 17) {
            DealerHit(dealerHand, cardHolder, dealerTotal);
        }
        dealerTotal = HandTotal(dealerHand);   
        // Comparing the Dealer's and User's hands. Taking or giving money as needed.
        if (dealerTotal > 21) {
            System.out.println("The dealer busted! You won: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (playerTotal > dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("You won! You won: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (playerTotal < dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("The dealer won! You lost your bet of: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("You and the Dealer push! You did not lost or win any money.");
        }
    }
    
    /**
     * Method for the player to Double Down. Doubles their bet and gives them one card, then has the dealer hit and compares hands.
     * After the double down portion, it is effectively the same as the Stay method.
     * @param playerHand
     * @param cardHolder
     * @param dealerHand 
     */
    public void DoubleDown(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> cardHolder, ArrayList<BlackJackCard> dealerHand) {
        // Deals one card to the player and doubles their bet
        Deal(playerHand, cardHolder);
        int betAmount = playerBet.GetAmount(); 
        betAmount = (int) Math.floor(betAmount * 2);
        playerBet.SetAmount(betAmount);
        System.out.println("You chose to double down. Your bet has been doubled to $" + playerBet.GetAmount());
        int playerTotal = HandTotal(playerHand);
        System.out.println("Your final hand is: " + playerHand + ". For a final total of: " + playerTotal);
        // Bust check for the player
        if (playerTotal > 21) {
            SetPlayerBust(true);
        }
        if (GetPlayerBust() == true) {
            PlayerBust();
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else {
            // Has the Dealer bet until they have at least 17, compares hands, gives or takes money as needed.
            int dealerTotal = HandTotal(dealerHand);
            DealerHit(dealerHand, cardHolder, dealerTotal);
            if (playerTotal > dealerTotal) {
                System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
                System.out.println("You won! You won: $" + playerBet.GetAmount());
                int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
                playerMoney.SetPot(newAmount);
                System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
            } else if (playerTotal < dealerTotal) {
                System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
                System.out.println("The dealer won! You lost your bet of: $" + playerBet.GetAmount());
                int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
                playerMoney.SetPot(newAmount);
                System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
            } else {
                System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
                System.out.println("You and the Dealer push! You did not lost or win any money.");
            }    
        }
    }
    
    /**
     * Method to split the User's hand into two hands.
     * Checks for Blackjack for each hand, has independent hitting. After second hand is done, the Dealer hits until they have 17.
     * Once the Dealer is done hitting, it compares each hand individually then takes/gives money as needed.
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void SplitHand(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
        // Splitting the User's hand into two hands & checking for Blackjack in each.
        System.out.println("You chose to split your hand");
        ArrayList<BlackJackCard> playerHandOne = new ArrayList<BlackJackCard>();
        ArrayList<BlackJackCard> playerHandTwo = new ArrayList<BlackJackCard>();
        Deal(playerHandOne, playerHand);
        Deal(playerHandTwo, playerHand);
        Deal(playerHandOne, cardHolder);
        Deal(playerHandTwo, cardHolder);
        System.out.println("Hand #1 has " + playerHandOne + " for a total of: " + HandTotal(playerHandOne));
        boolean playerOneBJC = false;
        if (playerHandOne.get(0).GetValue() == 1 && playerHandOne.get(1).GetValue() == 10) {
            playerOneBJC = true;
            playerHandOne.get(0).SetValue(11);
        } else if (playerHandOne.get(0).GetValue() == 10 && playerHandOne.get(1).GetValue() == 1) {
            playerOneBJC = true;
            playerHandOne.get(1).SetValue(11);
        }        
        System.out.println("Hand #2 has " + playerHandTwo + " for a total of: " + HandTotal(playerHandTwo));
        boolean playerTwoBJC = false;
        if (playerHandTwo.get(0).GetValue() == 1 && playerHandTwo.get(1).GetValue() == 10) {
            playerTwoBJC = true;
            playerHandTwo.get(0).SetValue(11);
        } else if (playerHandTwo.get(0).GetValue() == 10 && playerHandTwo.get(1).GetValue() == 1) {
            playerTwoBJC = true;
            playerHandTwo.get(1).SetValue(11);
        }
        boolean DBJCheck = false;
        BlackJackClauseSplit(playerOneBJC, DBJCheck, playerBet, playerMoney, cardHolder, dealerHand, playerHand);
        BlackJackClauseSplit(playerTwoBJC, DBJCheck, playerBet, playerMoney, cardHolder, dealerHand, playerHand);
        
        // Making sure the Aces in each hand are worth the proper amount
        int h1Total = (int) HandTotal(playerHandOne);
        int h1Size = playerHandOne.size();
        for (int i = 0; i < h1Size; i++ ) {
            if (h1Total < 12 && playerHandOne.get(i).GetFace().equals("Ace") ) {
            playerHandOne.get(i).SetValue(11);
            h1Total = HandTotal(playerHandOne);
            }
        }
        for (int i = 0; i < h1Size; i++ ) {
            if (h1Total > 21 && playerHandOne.get(i).GetFace().equals("Ace") ) {
            playerHandOne.get(i).SetValue(1);
            h1Total = HandTotal(playerHandOne);
            }
        }
        int h2Total = (int) HandTotal(playerHandTwo);
        int h2Size = playerHandTwo.size();
        for (int i = 0; i < h2Size; i++ ) {
            if (h2Total < 12 && playerHandTwo.get(i).GetFace().equals("Ace") ) {
            playerHandTwo.get(i).SetValue(11);
            h2Total = HandTotal(playerHandTwo);
            }
        }
        for (int i = 0; i < h2Size; i++ ) {
            if (h2Total > 21 && playerHandTwo.get(i).GetFace().equals("Ace") ) {
            playerHandTwo.get(i).SetValue(1);
            h2Total = HandTotal(playerHandTwo);
            }
        }
        // Options for the first hand
        String firstHandPrompt = "Please enter one of the following options for your FIRST hand:\nA. Hit\nB. Stay";
        System.out.println(firstHandPrompt);
        AfterSplitOptions(playerHandOne, dealerHand, cardHolder);
        h1Total = HandTotal(playerHandOne);
        if (h1Total > 21) {
            System.out.println("Your first hand busted!");
        }
        // Options for the second hand
        String secondHandPrompt = "Please enter one of the following options for your SECOND hand:\nA. Hit\nB. Stay";
        System.out.println(secondHandPrompt);
        AfterSplitOptions(playerHandTwo, dealerHand, cardHolder);
        h2Total = HandTotal(playerHandTwo);
        if (h2Total > 21) {
            System.out.println("Your second hand busted!");
        }
        // Having the Dealer hit, so long as at least one of the two hands didn't bust
        int dealerTotal = HandTotal(dealerHand);
        if (h1Total < 22 && h2Total < 22) {
            DealerHit(dealerHand, cardHolder, dealerTotal);
        } else if (h1Total < 22 && h2Total > 21) {
            DealerHit(dealerHand, cardHolder, dealerTotal);
        } else if (h1Total > 21 && h2Total < 22) {
            DealerHit(dealerHand, cardHolder, dealerTotal);
        }
        dealerTotal = HandTotal(dealerHand);  
        // Comparing the first hand with the dealer and taking or giving money as needed.
        if (h1Total > 21 && h2Total > 21) {
            System.out.println("That's tough!");
        } else if (h1Total > 21 && h2Total < 22) {
            System.out.println("Reminder that your first hand busted! You lost: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (dealerTotal > 21) {
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (h1Total > dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("Your hand #1 won! You won: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (h1Total < dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("The dealer beat your hand #1! You lost your bet of: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("Your hand #1 pushed with the Dealer! You did not lost or win any money.");
        }
        // Comparing the second hand with the dealer and taking or giving money as needed.
        if (h1Total > 21 && h2Total > 21) {
            System.out.println("Both of your hands busting caused you to lose a total of: $" + (playerBet.GetAmount()*2));
            int newAmount = (int) playerMoney.GetPot() - (int) (playerBet.GetAmount()*2);
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (h2Total > 21 && h1Total < 22) {
            System.out.println("Reminder that your second hand busted! You lost: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (dealerTotal > 21) {
            System.out.println("The dealer busted! You won: $" + (playerBet.GetAmount()*2) + " from your combined hands!");
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (h2Total > dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("Your hand #2 won! You won: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() + (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else if (h2Total < dealerTotal) {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("The dealer beat your hand #2! You lost your bet of: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("Your new pot amount is: $" + playerMoney.GetPot());
        } else {
            System.out.println("The Dealer had: " + dealerHand + " for a total of " + HandTotal(dealerHand) + ".");
            System.out.println("Your hand #2 pushed with the Dealer! You did not lost or win any money.");
        }
        
    }
    
    /**
     * Options menu for after the User decided to split their hand.
     * @param playerHand
     * @param dealerHand
     * @param cardHolder 
     */
    public void AfterSplitOptions(ArrayList<BlackJackCard> playerHand, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> cardHolder) {
        Scanner options = new Scanner(System.in);
        String userChoice = options.nextLine();
        userChoice = userChoice.toUpperCase();
          switch (userChoice) {
              case "A":
                  // Allows the user to hit as long as they don't bust.
                  SetPlayerBust(false);
                  Hit(playerHand, cardHolder, playerBet);
                  if (GetPlayerBust() == false) {
                      System.out.println("Select one of the following options:\nA. Hit\nB. Stay");
                      AfterSplitOptions(playerHand, dealerHand, cardHolder);
                  }
                  break;
              case "B":
                  // Tells the user that they chose to stay.
                  int playerTotal = HandTotal(playerHand);
                  System.out.println("You chose to stay with a hand of: " + playerHand + ". This totals to a value of: " + playerTotal);
                  break;
              default:
                  // Catch
                  System.out.println("---- You did not choose a valid option. Please try again. ----");
                  AfterSplitOptions(playerHand, dealerHand, cardHolder);
        }
    }
    
    /**
     * Takes adds the top card from the deck to the hand, then removes said card from the deck.
     * @param hand
     * @param deck 
     */
    public static void Deal(ArrayList<BlackJackCard> hand, ArrayList<BlackJackCard> deck) {
        hand.add(deck.get(0));
        deck.remove(0);
    }
    
    /**
     * Sums the values of all cards in the hand
     * @param hand
     * @return 
     */
    public static int HandTotal(ArrayList<BlackJackCard> hand) {
        int sum = 0;
        for(int i = 0; i < hand.size(); i++) {
            sum += hand.get(i).GetValue();
        }
        return sum;
    }
    
    /**
     * Clauses for if the user has Blackjack, dealer has Blackjack, both have it, or neither has it.
     * If neither have Blackjack, it takes the user to the appropriate options menu through the TotalOptionsMenu method.
     * @param PBJCheck
     * @param DBJCheck
     * @param playerBet
     * @param playerMoney
     * @param cardHolder
     * @param dealerHand
     * @param playerHand 
     */
    public void BlackJackClause(boolean PBJCheck, boolean DBJCheck, BlackJackBet playerBet, PlayerMoney playerMoney, ArrayList<BlackJackCard> cardHolder, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> playerHand) {
        if (PBJCheck == true && DBJCheck == true) {
            System.out.println("You have BlackJack! The Dealer will now show their hand.");
            System.out.println("The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace());
            System.out.println("You and the Dealer BOTH have BlackJack! The hand is a push.");
        } else if (PBJCheck == true && DBJCheck == false) {
            System.out.println("You have BlackJack! The Dealer will now show their hand.");
            System.out.println("The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace());
            int newAmount = (int) playerMoney.GetPot() + (int) ((1.5)*playerBet.GetAmount());
            playerMoney.SetPot(newAmount);
            System.out.println("The Dealer did not have BlackJack! You win and receive $" + ((1.5)*playerBet.GetAmount()) + "!");
            System.out.println("The new total of your pot is: $" + playerMoney.GetPot());
        } else if (PBJCheck == false && DBJCheck == true) {
            System.out.println("The Dealer had a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace() + ". This means they had BlackJack!");
            System.out.println("You lost your bet of: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("The new total of your pot is: $" + playerMoney.GetPot());
        } else {
            TotalOptionsMenu(playerHand, dealerHand, cardHolder);     
        }
    }
    
    /**
     * Clauses for if the user has Blackjack, dealer has Blackjack, both have it, or neither has it.
     * If neither has it, then nothing happens and it keeps running the code from where it left off.
     * @param PBJCheck
     * @param DBJCheck
     * @param playerBet
     * @param playerMoney
     * @param cardHolder
     * @param dealerHand
     * @param playerHand 
     */
    public void BlackJackClauseSplit(boolean PBJCheck, boolean DBJCheck, BlackJackBet playerBet, PlayerMoney playerMoney, ArrayList<BlackJackCard> cardHolder, ArrayList<BlackJackCard> dealerHand, ArrayList<BlackJackCard> playerHand) {
        if (PBJCheck == true && DBJCheck == true) {
            System.out.println("You have BlackJack! The Dealer will now show their hand.");
            System.out.println("The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace());
            System.out.println("You and the Dealer BOTH have BlackJack! The hand is a push.");
        } else if (PBJCheck == true && DBJCheck == false) {
            System.out.println("You have BlackJack! The Dealer will now show their hand.");
            System.out.println("The Dealer has a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace());
            int newAmount = (int) playerMoney.GetPot() + (int) ((1.5)*playerBet.GetAmount());
            playerMoney.SetPot(newAmount);
            System.out.println("The Dealer did not have BlackJack! You win and receive $" + ((1.5)*playerBet.GetAmount()) + "!");
            System.out.println("The new total of your pot is: $" + playerMoney.GetPot());
        } else if (PBJCheck == false && DBJCheck == true) {
            System.out.println("The Dealer had a(n) " + dealerHand.get(0).GetFace() + " and a(n) " + dealerHand.get(1).GetFace() + ". This means they had BlackJack!");
            System.out.println("You lost your bet of: $" + playerBet.GetAmount());
            int newAmount = (int) playerMoney.GetPot() - (int) playerBet.GetAmount();
            playerMoney.SetPot(newAmount);
            System.out.println("The new total of your pot is: $" + playerMoney.GetPot());
        }
    }
}
