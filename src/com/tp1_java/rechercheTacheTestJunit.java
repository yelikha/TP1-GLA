package com.tp1_java;

import static org.junit.Assert.*;

import org.junit.Test;

public class rechercheTacheTestJunit {

	@Test
	public void test() {
Gestionnaire_taches Test = new Gestionnaire_taches();
		
		Taches output1 = Test.rechercheTache("VENDEUR");
		
		assertEquals(13,"NOBBY",output1);
	}

	private void assertEquals(int i, String string, Taches output1) {
		// TODO Auto-generated method stub
		
	}

	

}
