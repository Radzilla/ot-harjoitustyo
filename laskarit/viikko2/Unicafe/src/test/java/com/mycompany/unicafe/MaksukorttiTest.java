package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        
        
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void lataaminenKasvattaaSaldonOikein() {
        
        kortti.lataaRahaa(500);
        assertEquals("saldo: 15.0", kortti.toString());
    }
    @Test
    public void ottaminenVahentaaSaldonOikein() {
        
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    @Test
    public void yliSaldonOttaminenEiVahenna() {
        
        kortti.otaRahaa(1500);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void ottaminenPalauttaaTrueJosRahatRiittavat() {
        
        kortti.otaRahaa(500);
        assertEquals(true, kortti.otaRahaa(250));
        assertEquals(false, kortti.otaRahaa(500));
        
    }
    
    
    
    
}
