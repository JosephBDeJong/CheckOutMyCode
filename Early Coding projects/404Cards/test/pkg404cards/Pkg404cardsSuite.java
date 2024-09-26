/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package pkg404cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author lnber
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({pkg404cards.BlackJackBetTest.class, pkg404cards.BlackJackTest.class, pkg404cards.BlackJackDeckTest.class, pkg404cards.PlayerMoneyTest.class, pkg404cards.BlackJackCardTest.class, pkg404cards.MainTest.class})
public class Pkg404cardsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
