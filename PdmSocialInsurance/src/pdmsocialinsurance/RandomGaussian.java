/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdmsocialinsurance;

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
      //double MEAN = 0.132; 
      double VARIANCE = 0.119; //0.119, (PBWS) 0.0216
      double result = 1 - getGaussian(MEAN, VARIANCE);
      if(result<0)
      {
          result = 1 - getGaussian(MEAN, VARIANCE);
         
      }
      return result;
  }
  
  public double getRandInt(double MEAN){ //original 0.42
      
      double VARIANCE=1.626; //original 1.626
      double result = getGaussian(MEAN, VARIANCE);
      return result;
  }
  
  public double getRandInt2(double MEAN){ //
      
      double VARIANCE=1.626; //
      double result = getGaussian(MEAN, VARIANCE);
      return result;
  }
  
  private double getGaussian(double aMean, double aVariance){
    return abs(aMean + fRandom.nextGaussian() * aVariance);
  }

  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
} 