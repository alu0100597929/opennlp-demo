/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fogbeam.example.opennlp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Manuel Ramos Perez
 */
public class TokenizerMainTest {
    
    public TokenizerMainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class TokenizerMain.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        TokenizerMain.main(args);
    }

    /**
     * Test of readFile method, tokens file, of class TokenizerMain.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        String filename = "demo_tokens/tokens.txt";
        String expResult = "Hello World!How are you?My name is Jon Snow";
        String result = TokenizerMain.readFile(filename);
        result = result.replace("\n", "");
        assertEquals(expResult, result);
    }
     /**
     * Test of readFile method, tokens2 file, of class TokenizerMain.
     */
    @Test
    public void testReadFile2() {
        System.out.println("readFile");
        String filename = "demo_tokens/tokens2.txt";
        String expResult = "To beornot to be";
        String result = TokenizerMain.readFile(filename);
        result = result.replace("\n", "");
        assertEquals(expResult, result);
    }
}
