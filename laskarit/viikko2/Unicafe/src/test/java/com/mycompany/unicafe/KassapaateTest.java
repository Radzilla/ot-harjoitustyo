/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sillaras
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti korttiRahaa;
    Maksukortti korttiEiRahaa;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        korttiRahaa = new Maksukortti(1000);
        korttiEiRahaa = new Maksukortti(50);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaKassanSaldonOikein() {
        
        
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void konstruktoriAsettaaKassanMyydytMaukkaatOikein() {
        
        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void konstruktoriAsettaaKassanMyydytEdullisetOikein() {
        
        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void kateisostoToimiiEdullisella() {
        
        
        assertEquals(260, kassa.syoEdullisesti(500));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(200, kassa.syoEdullisesti(200));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    @Test
    public void kateisostoToimiiMaukkaalla() {
        
        
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(200, kassa.syoMaukkaasti(200));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
        
    }
    @Test
    public void korttiostoToimiiEdullisella() {
        
        
        assertEquals(true, kassa.syoEdullisesti(korttiRahaa));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(760, korttiRahaa.saldo());
        assertEquals(false, kassa.syoEdullisesti(korttiEiRahaa));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(50, korttiEiRahaa.saldo());
        
    }
    @Test
    public void korttiostoToimiiMaukkaalla() {
        
        
        assertEquals(true, kassa.syoMaukkaasti(korttiRahaa));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(600, korttiRahaa.saldo());
        assertEquals(false, kassa.syoMaukkaasti(korttiEiRahaa));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(50, korttiEiRahaa.saldo());
        
    }
    
    @Test
    public void Toimii() {
        
        kassa.lataaRahaaKortille(korttiRahaa,2000);
        assertEquals(102000, kassa.kassassaRahaa());
        assertEquals(3000, korttiRahaa.saldo());
        kassa.lataaRahaaKortille(korttiRahaa,-2000);
        assertEquals(102000, kassa.kassassaRahaa());
        assertEquals(3000, korttiRahaa.saldo());
        
    }
}
