package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrimesFast(Integer.MAX_VALUE));
  }
  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE -2));
  }
  @Test(enabled = false)
  public void testNonPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }

}