/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg404cards;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author lnber
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainMenu();
    }
    
    /**
     * Main menu to begin the game. User can go to the Game Select Menu, Tutorial Select Menu, or to quit
     */
    public static void MainMenu() {
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Select Game\nB. Tutorial\nQ. Quit";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               GameSelectMenu();
               break;
           case "B":
               TutorialMenu();
               break;
           case "Q":
               System.out.println("Have a great day!");
               System.exit(0);
               break;
           default:
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               MainMenu();
       }
    }
    
    /**
     * Menu where the user can pick which Game Menu to go to, or to return to the Main Menu
     */
    public static void GameSelectMenu() {
     Deck deck = new Deck();
     Player player = new Player("Joseph", 1000);
     Bot bot = new Bot("Dior", 1000);
     MoneyPot pot = new MoneyPot();
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Blackjack\nB. Texas Hold 'Em\nQ. Exit to Main Menu";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               BlackJackMenu();
               break;
           case "B":
               Main.HoldEmMenu(pot, deck, player, bot);
               break; 
           case "Q":
               MainMenu();
               break;
           default:
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               GameSelectMenu();
       }
    }
    
    /**
     * Menu where the user can pick which tutorial to view, or go back to the Main Menu
     */
    public static void TutorialMenu() {
     Scanner options = new Scanner(System.in);
     String userOptionsPrompt = "Please enter one of the following options:\nA. Blackjack\nB. Texas Hold 'Em\nQ. Exit to Main Menu";
     System.out.println(userOptionsPrompt);
     String userChoice = options.nextLine();
     userChoice = userChoice.toUpperCase();
       switch (userChoice) {
           case "A":
               MainBJTutorial();
               break;
           case "B":
               HoldEmTutorial();
               break;
           case "Q":
               MainMenu();
               break;
           default:
               System.out.println("---- You did not choose a valid option. Please try again. ----");
               TutorialMenu();
       }
    }
    
    /**
     * User is prompted to pick their starting pot amount, then with a menu to play Blackjack, go to the Blackjack Tutorial, or go to the Main Menu
     */
    public static void BlackJackMenu() {
        Scanner playerPot = new Scanner(System.in);
        BlackJack game = new BlackJack();
        // Creating the user's starting pot amount, ensures that a number is entered
        System.out.println("Please enter the amount which you would like your starting pot to be (please enter a positive whole number)");
        double potAmount = 0;
        boolean check = false;
                    do {
                        if (playerPot.hasNextDouble()) {
                            check = true;
                        } else {
                            check = false;
                            System.out.println("You entered: " + playerPot.next() + " ;Please enter a numerical value.");
                        }
                    } while (check != true);
                    if (check = true) {
                        potAmount = playerPot.nextDouble();
                    }
        int startingPot = (int) potAmount;
        game.playerMoney.SetPot(startingPot);
        
        // Menu for the user to pick where to go
        String userChoice = "";
        while (!userChoice.equals("Q")) {
        Scanner options = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------");
        String userOptionsPrompt = "Please enter one of the following options:\nA. Play Blackjack\nB. BlackJack Tutorial\nQ. Exit to Main Menu";
        System.out.println(userOptionsPrompt);
        userChoice = options.nextLine();
        userChoice = userChoice.toUpperCase();
        switch (userChoice) {
                case "A":
                    // Beginning the Blackjack game. Makes the deck and starting bets/hands.
                    BlackJackDeck deck = new BlackJackDeck();
                    deck.MakeDeck();
                    game.Betting(game.playerBet, game.playerMoney);
                    game.StartDeal(game.playerHand, game.dealerHand, deck.cardHolder);
                    // Checks if the player or dealer have Blackjack, then plays the game as normal if neither do.
                    boolean PBJCheck = false;
                    boolean DBJCheck = false;
                    boolean BJC = false;
                    if (game.playerHand.get(0).GetFace().equals("Ace") && game.playerHand.get(1).GetValue() == 10) {
                        PBJCheck = true;
                        game.playerHand.get(0).SetValue(11);
                    } else if (game.playerHand.get(0).GetValue() == 10 && game.playerHand.get(1).GetFace().equals("Ace")) {
                        PBJCheck = true;
                        game.playerHand.get(1).SetValue(11);
                    }
                    if (game.dealerHand.get(0).GetFace().equals("Ace") && game.dealerHand.get(1).GetValue() == 10) {
                        DBJCheck = true;
                        game.dealerHand.get(0).SetValue(11);
                    } else if (game.dealerHand.get(0).GetValue() == 10 && game.dealerHand.get(1).GetFace().equals("Ace")) {
                        DBJCheck = true;
                        game.dealerHand.get(1).SetValue(11);
                    }
                    game.BlackJackClause(PBJCheck, DBJCheck, game.playerBet, game.playerMoney, deck.cardHolder, game.dealerHand, game.playerHand);
                    break;
                case "B":
                    BJMTutorial();
                    break;
                case "Q":
                    MainMenu();
                    break;
                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");
            }
        }
    }
    
    /**
     * Blackjack tutorial. User is returned to the Blackjack Menu when they enter Q into the output console.
     */
    public static void BJMTutorial() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("When you are done reading the tutorial, please enter \"Q\" to return to the Blackjack Menu.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Rules of Blackjack:");
        System.out.println("The objective of the game is two-fold...");
        System.out.println("1) You want the sum of your cards to be greater than the sum of the Dealer's.");
        System.out.println("2) You have to try to accomplish this without surpassing a total of 21, otherwise you bust.");
        System.out.println("------------------------------------------------------------------------------------------");        
        System.out.println("To begin, place your bet for the round. This amount can be affected by two different decisions later in the game.");
        System.out.println("The Dealer will distribute 4 cards to begin, two to you and to to themselves. You will only be able to see one of the Dealer's cards.");
        System.out.println("Once this has happened, the Dealer checks to see if you have Blackjack (An Ace along with a 10, J, Q, or K).");
        System.out.println("-- If you have Blackjack, you automatically win (barring a scenario in which the dealer also has Blackjack).");
        System.out.println("-- If you have Blackjack and win, you will receive a payout equal to 1.5x your initial bet.");
        System.out.println("If the Dealer is showing an Ace, 10, Jack, Queen, or King, then they will check to ensure that they do not have Blackjack.");
        System.out.println("-- If the Dealer has Blackjack, and you do not, then you automatically lose that hand and your bet, with no opportunity to make an aciton.");
        System.out.println("-- If the Dealer does not have Blackjack, then the game continues as normal.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("At this point, you have options to choose from. You can hit, double down, split (in some cases), or stay.");
        System.out.println("If you HIT, the dealer will give you another card. If the new total of all of your cards is greater than 21, then you bust.");
        System.out.println("-- If you BUST, you automatically lose the hand and lose your bet.");
        System.out.println("If you DOUBLE DOWN, you double your bet for the hand. The dealer gives you one FINAL card and you are stuck with those 3 cards.");
        System.out.println("-- This means that, if you elect to double down, you cannot hit for the remainder of the hand.");
        System.out.println("-- Doubling down can only be done after the initial deal (you cannot hit or split and then double down).");
        System.out.println("If you SPLIT, you take your two cards and make them into two separate hands. The dealer will deal an additional card to each so they have 2 cards each.");
        System.out.println("-- The caveat to this is that you have to match your initial bet with your new hand. However, the bet of each hand functions independently.");
        System.out.println("-- This can only be done after the initial deal, and can only be done if you have two cards with the same face (though they can be different suits).");
        System.out.println("If you STAY, then you stop your turn. The Dealer will now hit until they reach at least 17. If they bust, then you automatically win.");
        System.out.println("-- After the Dealer has at least 17, then you compare your hands. Hands with more than the dealer and less than 21 will win and receive a payout equal to that hands bet.");
        System.out.println("-- If a hand has less than the Dealer, then you lose that hand's bet.");
        System.out.println("-- A doubled-down hand means that you lose 2x your inital bet, as you doubled it when you chose to double down.");
        System.out.println("-- Split hands function independently, meaning you could lose both, win both, or lose one and win the other.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Tips:");
        System.out.println("- If your initial hand is equal to 10 or 11, then you should double down.");
        System.out.println("- If you initial hand is 2 Aces or 2 8s, then you should split your hand.");
        System.out.println("-- It is generally ill-advised to split your hand otherwise.");
        System.out.println("- If the dealer shows a 2 - 6, then you should stay once you have a value of at least 12.");
        System.out.println("- If the dealer shows an Ace or 7-K, then you should hit until you have reached a value of at least 17.");
        String userChoice = "";
        do {
        Scanner options = new Scanner(System.in);
        userChoice = options.nextLine();
        userChoice = userChoice.toUpperCase();
        switch (userChoice) {
            case "Q":
                MainMenu();
                break;
            default:
                System.out.println("---- You did not choose a valid option. Please try again. ----");
        }
        } while(!userChoice.equals("Q"));
    }
    
    /**
     * Blackjack tutorial. User is returned to the Main Menu when they enter Q into the output console.
     */
    public static void MainBJTutorial() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("When you are done reading the tutorial, please enter \"Q\" to return to the Main Menu.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Rules of Blackjack:");
        System.out.println("The objective of the game is two-fold...");
        System.out.println("1) You want the sum of your cards to be greater than the sum of the Dealer's.");
        System.out.println("2) You have to try to accomplish this without surpassing a total of 21, otherwise you bust.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("To begin, place your bet for the round. This amount can be affected by two different decisions later in the game.");
        System.out.println("The Dealer will distribute 4 cards to begin, two to you and to to themselves. You will only be able to see one of the Dealer's cards.");
        System.out.println("Once this has happened, the Dealer checks to see if you have Blackjack (An Ace along with a 10, J, Q, or K).");
        System.out.println("-- If you have Blackjack, you automatically win (barring a scenario in which the dealer also has Blackjack).");
        System.out.println("-- If you have Blackjack and win, you will receive a payout equal to 1.5x your initial bet.");
        System.out.println("If the Dealer is showing an Ace, 10, Jack, Queen, or King, then they will check to ensure that they do not have Blackjack.");
        System.out.println("-- If the Dealer has Blackjack, and you do not, then you automatically lose that hand and your bet, with no opportunity to make an aciton.");
        System.out.println("-- If the Dealer does not have Blackjack, then the game continues as normal.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("At this point, you have options to choose from. You can hit, double down, split (in some cases), or stay.");
        System.out.println("If you HIT, the dealer will give you another card. If the new total of all of your cards is greater than 21, then you bust.");
        System.out.println("-- If you BUST, you automatically lose the hand and lose your bet.");
        System.out.println("If you DOUBLE DOWN, you double your bet for the hand. The dealer gives you one FINAL card and you are stuck with those 3 cards.");
        System.out.println("-- This means that, if you elect to double down, you cannot hit for the remainder of the hand.");
        System.out.println("-- Doubling down can only be done after the initial deal (you cannot hit or split and then double down).");
        System.out.println("If you SPLIT, you take your two cards and make them into two separate hands. The dealer will deal an additional card to each so they have 2 cards each.");
        System.out.println("-- The caveat to this is that you have to match your initial bet with your new hand. However, the bet of each hand functions independently.");
        System.out.println("-- This can only be done after the initial deal, and can only be done if you have two cards with the same face (though they can be different suits).");
        System.out.println("If you STAY, then you stop your turn. The Dealer will now hit until they reach at least 17. If they bust, then you automatically win.");
        System.out.println("-- After the Dealer has at least 17, then you compare your hands. Hands with more than the dealer and less than 21 will win and receive a payout equal to that hands bet.");
        System.out.println("-- If a hand has less than the Dealer, then you lose that hand's bet.");
        System.out.println("-- A doubled-down hand means that you lose 2x your inital bet, as you doubled it when you chose to double down.");
        System.out.println("-- Split hands function independently, meaning you could lose both, win both, or lose one and win the other.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Tips:");
        System.out.println("- If your initial hand is equal to 10 or 11, then you should double down.");
        System.out.println("- If you initial hand is 2 Aces or 2 8s, then you should split your hand.");
        System.out.println("-- It is generally ill-advised to split your hand otherwise.");
        System.out.println("- If the dealer shows a 2 - 6, then you should stay once you have a value of at least 12.");
        System.out.println("- If the dealer shows an Ace or 7-K, then you should hit until you have reached a value of at least 17.");
        String userChoice = "";
        do {
        Scanner options = new Scanner(System.in);
        userChoice = options.nextLine();
        userChoice = userChoice.toUpperCase();
        switch (userChoice) {
            case "Q":
                MainMenu();
                break;
            default:
                System.out.println("---- You did not choose a valid option. Please try again. ----");
        }
        } while(!userChoice.equals("Q"));
    }
    
    /**
     * Method to allow the user to play Texas Hold Em
     * @param pot
     * @param deck
     * @param player
     * @param bot 
     */
    public static void PlayHoldEm(MoneyPot pot, Deck deck, Player player, Bot bot){
        Scanner scanner = new Scanner(System.in);
        HandRanking rank = new HandRanking();
        ArrayList<Card> playerHand = new ArrayList<>();
        ArrayList<Card> botHand = new ArrayList<>();
        ArrayList<Card> communityCards = new ArrayList<>();
        /**
         * Preflop
         */
        System.out.println("--- Preflop ---");
        deck.Shuffle();
        System.out.println("These are your cards");
        //deck.DealCards();
        System.out.println(deck.DisplayPlayerCards(playerHand));
        deck.SetBotCards(botHand);
        pot.SetHighestBet(0);
        player.SetHighestBet(0);
        bot.SetHighestBet(0);
        Player.PlayerOptions(player, bot, pot, deck);
        bot.PreFlopBot(pot, bot, player, deck);
        /**
         * Flop 
         */
        System.out.println("--- Flop ---");
        pot.SetHighestBet(0);
        player.SetHighestBet(0);
        bot.SetHighestBet(0);
        System.out.println(deck.DealFlop(communityCards));
        System.out.println("These are your cards");
        System.out.println(playerHand.toString());
        Player.PlayerOptions(player, bot, pot, deck);
        bot.FlopBot(pot, bot, player, deck);
        /**
         * Turn
         */
        System.out.println("--- Turn ---");
        pot.SetHighestBet(0);
        player.SetHighestBet(0);
        bot.SetHighestBet(0);
        System.out.println(deck.DealTurn(communityCards));
        System.out.println("These are your cards");
        System.out.println(playerHand.toString());
        Player.PlayerOptions(player, bot, pot, deck);
        bot.TurnBot(player, bot, pot, deck);
        /**
         * River
         */
        System.out.println("--- River ---");
        pot.SetHighestBet(0);
        player.SetHighestBet(0);
        bot.SetHighestBet(0);
        System.out.println(deck.DealRiver(communityCards));
        System.out.println("These are your cards");
        System.out.println(playerHand.toString());;
        Player.PlayerOptions(player, bot, pot, deck);
        bot.RiverBot(player, bot, pot, deck);
        /**
         * SHOWDOWN
         */
        System.out.println("The community cards are " + communityCards.toString());
        System.out.println("You had " + playerHand.toString());
        System.out.println("The bot had " + botHand.toString());
        HandRanking.WhoIsWinner(player, bot, pot);
        /**
         * NEXT HAND SETUP
         */
        communityCards.clear();
        playerHand.clear();
        botHand.clear();
        pot.SetAmount(0);
        String entryVariable = "";

        while (entryVariable != "Q") {
            System.out.println("Would You like to play again?\nA. Yes!\nQ. Quit");
            String playAgainChoice = scanner.nextLine();
            switch (playAgainChoice.toUpperCase()) {
                case "A":
                    PlayHoldEm(pot, deck, player, bot);
                    break;
                case "Q":
                    HoldEmMenu(pot, deck, player, bot);
                    break;

                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");
            }
        }
    }
    
    /**
     * User options menu once they went to the Texas Hold Em screen. Can choose to Play THEm, look at the tutorial, or go back to the main menu.
     * @param pot
     * @param deck
     * @param player
     * @param bot 
     */
    public static void HoldEmMenu(MoneyPot pot, Deck deck, Player player, Bot bot){
        Scanner scanner = new Scanner(System.in);
        String entryVariable = "";

        while (entryVariable != "Q") {
                System.out.println("What would you like to do?\nA. Play Texas Hold 'em\nB. View tutorial\nQ. Exit to Main Menu");            
                String playAgainChoice = scanner.nextLine();
            switch (playAgainChoice.toUpperCase()) {
                case "A":
                    Scanner playerPot = new Scanner(System.in);
                    // Creating the user's starting pot amount, ensures that a number is entered
                    System.out.println("Please enter the amount which you would like your starting pot to be (please enter a positive whole number)");
                    double potAmount = 0;
                    boolean check = false;
                                do {
                                    if (playerPot.hasNextDouble()) {
                                        check = true;
                                    } else {
                                        check = false;
                                        System.out.println("You entered: " + playerPot.next() + " ;Please enter a numerical value.");
                                    }
                                } while (check != true);
                                if (check = true) {
                                    potAmount = playerPot.nextDouble();
                                }
                    int startingPot = (int) potAmount;
                    player.SetChipCount(startingPot);
                    PlayHoldEm(pot, deck, player, bot);
                    break;
                case "B":
                    //Source for this tutorial https://www.instructables.com/Learn-To-Play-Poker---Texas-Hold-Em-aka-Texas-Ho/
                    System.out.println("Each player is dealt two private cards (\"Hole Cards\" or \"Pocket Cards\"),\n "
                            + "after which there is a betting round. Then three community cards are dealt face up (the \"Flop\"),\n "
                            + "followed by a second betting round. A fourth community card is dealt face up (the \"Turn\"),\n "
                            + "followed by a third betting round. A fifth community card is dealt face up (the \"River\")and the the fourth and final betting round.\n "
                            + "At the Showdown, each player plays the best five-card hand they can make using any five cards from the two pocket cards and the five community cards (or Board Cards)."
                            + "Each player, when it's their turn, makes their choice and Acts. There are four acts that can be played\n"
                                    + "1) Check - betting zero. \n"
                                    + "2) Bet - wager chips against the algorithm.\n"
                                    + "3) Call - to match a bet or a raise.\n"
                                    + "4) Fold - to discard your hand and forfeit the current pot.\n"
                                    + "5) Raise - to increase the size of the current bet.");
                    break; 
                case "Q":
                    MainMenu();
                    break;

                default:
                    System.out.println("---- You did not choose a valid option. Please try again. ----");

            }
        }
    }
    
    /**
     * Texas Hold Em tutorial. User is returned to the Main Menu when they enter Q into the output console.
     */
    public static void HoldEmTutorial() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("When you are done reading the tutorial, please enter \"Q\" to return to the Main Menu.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Rules of Texas Hold 'Em:");
        System.out.println("Each player is dealt two private cards (\"Hole Cards\" or \"Pocket Cards\"),\n "
                            + "after which there is a betting round. Then three community cards are dealt face up (the \"Flop\"),\n "
                            + "followed by a second betting round. A fourth community card is dealt face up (the \"Turn\"),\n "
                            + "followed by a third betting round. A fifth community card is dealt face up (the \"River\")and the the fourth and final betting round.\n "
                            + "At the Showdown, each player plays the best five-card hand they can make using any five cards from the two pocket cards and the five community cards (or Board Cards)."
                            + "Each player, when it's their turn, makes their choice and Acts. There are four acts that can be played\n"
                                    + "1) Check - betting zero. \n"
                                    + "2) Bet - wager chips against the algorithm.\n"
                                    + "3) Call - to match a bet or a raise.\n"
                                    + "4) Fold - to discard your hand and forfeit the current pot.\n"
                                    + "5) Raise - to increase the size of the current bet.");
        String userChoice = "";
        do {
        Scanner options = new Scanner(System.in);
        userChoice = options.nextLine();
        userChoice = userChoice.toUpperCase();
        switch (userChoice) {
            case "Q":
                MainMenu();
                break;
            default:
                System.out.println("---- You did not choose a valid option. Please try again. ----");
        }
        } while(!userChoice.equals("Q"));
    }
}
