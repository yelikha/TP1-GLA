package com.tp1_java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JunitTestGestionTache.class, rechercheMembreTestJunit.class, rechercheTacheTestJunit.class })
public class AllTests {

}
