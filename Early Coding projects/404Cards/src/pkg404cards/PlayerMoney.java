/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg404cards;

/**
 *
 * @author lnber
 */
public class PlayerMoney extends BlackJackBet {
     //==========================================================================
    // PROPERTIES (INSTANCE VARIABLES)
    //==========================================================================
    private int pot = 0;
    public int GetPot() { return pot; }
    public void SetPot(int pot) { this.pot = pot; }
    
    //==========================================================================
    // CONSTRUCTORS
    //==========================================================================
    /**
     * Default Constructor
     */
    public PlayerMoney() {}
    
    /**
     * Full Constructor
     * @param pot 
     */
    public PlayerMoney(int pot) {
        SetPot(pot);
    }
    
    //==========================================================================
    // METHODS
    //==========================================================================
    
}
