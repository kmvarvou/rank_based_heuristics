/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdmmonitoring;

import static java.lang.Math.abs;
import java.util.Random;

/** 
 Generate pseudo-random floating point values, with an 
 approximately Gaussian (normal) distribution.

 Many physical measurements have an approximately Gaussian 
 distribution; this provides a way of simulating such values. 
*/
public final class RandomGaussian {

  

  private  Random fRandom = new Random();

  public  double getRandProb(double MEAN){
      //double MEAN = 0.1094; 
      double VARIANCE = 0.02; // original = 0.02
      double result = 1 - getGaussian(MEAN, VARIANCE);
      if(result<0)
      {
          result = 1 - getGaussian(MEAN, VARIANCE);
         
      }
      return result;
  }
  
  public int getRandInt(double MEAN){ //original 4.5
      
      double VARIANCE=9.44; //original 9.44
      int result = (int)getGaussian(MEAN, VARIANCE);
      return result;
  }
  
  public int getRandInt2(double MEAN){ //7.94
      
      double VARIANCE=7.58; //original 7.58
      int result = (int)getGaussian(MEAN, VARIANCE);
      return result;
  }
  
  private double getGaussian(double aMean, double aVariance){
    return abs(aMean + fRandom.nextGaussian() * aVariance);
  }

  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
} 