package com.tp1_java;

import static org.junit.Assert.*;

import org.junit.Test;

public class rechercheMembreTestJunit {

	@Test
	public void test() {
		Gestionnaire_taches Test = new Gestionnaire_taches();
		Membres output = Test.recherche("SYLLA");
		assertEquals(1,"SYLLA",output);
	}
	private void assertEquals(int i, String string, Membres output) {
		// TODO Auto-generated method stub
		
	}
}
