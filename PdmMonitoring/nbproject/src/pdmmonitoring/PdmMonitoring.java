/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdmmonitoring;

/**
 *
 * @author kostis
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



/**
 *
 * @author Κωστής
 */
public class PdmMonitoring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int y=0;
        int s=10;
        while(s !=0 && s != 1)
        {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose distribution for generation of the operations' attributes.");
        System.out.println("Enter 0 for uniform distribution or 1 for gaussian distribution. ");
        try{
        s = scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Unsupported input, please enter either 0 or 1.");
        }
        }
        double[] sum = new double[13];
        double[] sum2 = new double[13];
        int[] success = new int[13];
        int[] failure = new int[13];
        int debug=0;
        FileWriter[] pw = new FileWriter[13];
        String[] heuristics = {"Random","Lowest Cost","Shortest Time","Lowest Fail Probability","Root Distance","Cost Distance","Time Distance","Rank-based ","Rank-based Time","Rank-based Combination","Rank-based extended","Rank-Based extended Time","Rank-Based extended Combo"};
        BufferedWriter[] bw= new BufferedWriter[13];
        while(y<13)
        {
           String filename = heuristics[y] + ".txt";
           File file = new File(filename);
           FileWriter fw = new FileWriter(file);
           bw[y] = new BufferedWriter(fw);
           
           y++;
        }
        y=0;
        while(y<10000)
        {
        double cost =0;
        double time=0;
        double min =0.001, max =1.0;
        int minInt=0, maxInt=10;
        int result;
        double random2;
        RandomGaussian gaussian = new RandomGaussian();
        Random r = new Random();
        HashMap<Integer, String[]> operations = new HashMap();
        if(s==1)
        {
            String[] temp = {"i2","i3","i1","10","0","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp[temp.length-1])));
            temp[temp.length-1] = String.valueOf(random2);
            temp[temp.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp[temp.length-3] = String.valueOf(result);
            operations.put(1,temp);
            String[] temp2 = {"i4","i2","3","6","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp2[temp2.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp2[temp2.length-1])));
            temp2[temp2.length-1] = String.valueOf(random2);
            temp2[temp2.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp2[temp2.length-3]));
            temp2[temp2.length-3] = String.valueOf(result);
            operations.put(2,temp2);
            String[] temp3 = {"i4","i5","i12","0","0","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp3[temp3.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp3[temp3.length-1])));
            //temp3[temp3.length-1] = String.valueOf(random2);
            //temp3[temp3.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp3[temp3.length-3]));
            //temp3[temp3.length-3] = String.valueOf(result);
            operations.put(3,temp3);
            String[] temp4 = {"i5","i2","7","1","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp4[temp4.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp4[temp4.length-1])));
            temp4[temp4.length-1] = String.valueOf(random2);
            temp4[temp4.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp4[temp4.length-3]));
            temp4[temp4.length-3] = String.valueOf(result);
            operations.put(4,temp4);
            String[] temp5 = {"i6","i3","4","1","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp5[temp5.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp5[temp5.length-1])));
            temp5[temp5.length-1] = String.valueOf(random2);
            temp5[temp5.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp5[temp5.length-3]));
            temp5[temp5.length-3] = String.valueOf(result);
            operations.put(5,temp5);
            String[] temp6 = {"i7","i3","2","1","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp6[temp6.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp6[temp6.length-1])));
            temp6[temp6.length-1] = String.valueOf(random2);
            temp6[temp6.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp6[temp6.length-3]));
            temp6[temp6.length-3] = String.valueOf(result);
            operations.put(6,temp6);
            String[] temp7 = {"i8","i10","i13","10","8","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp7[temp7.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp7[temp7.length-1])));
            //temp7[temp7.length-1] = String.valueOf(random2);
            //temp7[temp7.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp7[temp7.length-3]));
            //temp7[temp7.length-3] = String.valueOf(result);
            operations.put(7,temp7);
            String[] temp8 = {"i8","i11","i3","7","6","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp8[temp8.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp8[temp8.length-1])));
            temp8[temp8.length-1] = String.valueOf(random2);
            temp8[temp8.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp8[temp8.length-3]));
            temp8[temp8.length-3] = String.valueOf(result);
            operations.put(8,temp8);
            String[] temp9 = {"i9","i10","i3","7","6","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp9[temp9.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp9[temp9.length-1])));
            temp9[temp9.length-1] = String.valueOf(random2);
            temp9[temp9.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp9[temp9.length-3]));
            temp9[temp9.length-3] = String.valueOf(result);
            operations.put(9,temp9);
            String[] temp10 = {"i9","i11","i14","0","0","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp10[temp10.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp10[temp10.length-1])));
            //temp10[temp10.length-1] = String.valueOf(random2);
            //temp10[temp10.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp10[temp10.length-3]));
            //temp10[temp10.length-3] = String.valueOf(result);
            operations.put(10,temp10);
            String[] temp111 = {"i4","10","2","0.9"};
            result = gaussian.getRandInt(Double.parseDouble(temp111[temp111.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp111[temp111.length-1])));
            temp111[temp111.length-1] = String.valueOf(random2);
            temp111[temp111.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp111[temp111.length-3]));
            temp111[temp111.length-3] = String.valueOf(result);
            operations.put(11,temp111);
            String[] temp112 = {"i5","10","7","0.7"};
            result = gaussian.getRandInt(Double.parseDouble(temp112[temp112.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp112[temp112.length-1])));
            temp112[temp112.length-1] = String.valueOf(random2);
            temp112[temp112.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp112[temp112.length-3]));
            temp112[temp112.length-3] = String.valueOf(result);
            operations.put(12,temp112);
            String[] temp113 = {"i6","10","10","0.7"};
            result = gaussian.getRandInt(Double.parseDouble(temp113[temp113.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp113[temp113.length-1])));
            temp113[temp113.length-1] = String.valueOf(random2);
            temp113[temp113.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp113[temp113.length-3]));
            temp113[temp113.length-3] = String.valueOf(result);
            operations.put(13,temp113);
            String[] temp114 = {"i7","10","8","0.9"};
            result = gaussian.getRandInt(Double.parseDouble(temp114[temp114.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp114[temp114.length-1])));
            temp114[temp114.length-1] = String.valueOf(random2);
            temp114[temp114.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp114[temp114.length-3]));
            temp114[temp114.length-3] = String.valueOf(result);
            operations.put(14,temp114);
            String[] temp115 = {"i8","10","5","0.63"};
            result = gaussian.getRandInt(Double.parseDouble(temp115[temp115.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp115[temp115.length-1])));
            temp115[temp115.length-1] = String.valueOf(random2);
            temp115[temp115.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp115[temp115.length-3]));
            temp115[temp115.length-3] = String.valueOf(result);
            operations.put(15,temp115);
            String[] temp116 = {"i9","10","3","0.7"};
            result = gaussian.getRandInt(Double.parseDouble(temp116[temp116.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp116[temp116.length-1])));
            temp116[temp116.length-1] = String.valueOf(random2);
            temp116[temp116.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp116[temp116.length-3]));
            temp116[temp116.length-3] = String.valueOf(result);
            operations.put(16,temp116);
            String[] temp117 = {"i10","10","3","0.7"};
            result = gaussian.getRandInt(Double.parseDouble(temp117[temp117.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp117[temp117.length-1])));
            temp117[temp117.length-1] = String.valueOf(random2);
            temp117[temp117.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp117[temp117.length-3]));
            temp117[temp117.length-3] = String.valueOf(result);
            operations.put(17,temp117);
            String[] temp118 = {"i11","10","1","0.8"};
            result = gaussian.getRandInt(Double.parseDouble(temp118[temp118.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp118[temp118.length-1])));
            temp118[temp118.length-1] = String.valueOf(random2);
            temp118[temp118.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp118[temp118.length-3]));
            temp118[temp118.length-3] = String.valueOf(result);
            operations.put(18,temp118);
            String[] temp119 = {"i12","i2","8","8","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp119[temp119.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp119[temp119.length-1])));
            temp119[temp119.length-1] = String.valueOf(random2);
            temp119[temp119.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp119[temp119.length-3]));
            temp119[temp119.length-3] = String.valueOf(result);
            operations.put(19,temp119);
            String[] temp120 = {"i13","i3","10","8","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp120[temp120.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp120[temp120.length-1])));
            temp120[temp120.length-1] = String.valueOf(random2);
            temp120[temp120.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp120[temp120.length-3]));
            temp120[temp120.length-3] = String.valueOf(result);
            operations.put(20,temp120);
            String[] temp121 = {"i14","i3","5","5","1"};
            result = gaussian.getRandInt(Double.parseDouble(temp121[temp121.length-2]));
            random2 = gaussian.getRandProb(1-(Double.parseDouble(temp121[temp121.length-1])));
            temp121[temp121.length-1] = String.valueOf(random2);
            temp121[temp121.length-2] = String.valueOf(result);
            result = gaussian.getRandInt(Double.parseDouble(temp121[temp121.length-3]));
            temp121[temp121.length-3] = String.valueOf(result);
            operations.put(21,temp121);
        }
        else
        {
            String[] temp = {"i2","i3","i1","10","0","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 = ThreadLocalRandom.current().nextDouble(min, max);
            temp[temp.length-1] = String.valueOf(random2);
            temp[temp.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp[temp.length-3] = String.valueOf(result);
            operations.put(1,temp);
            String[] temp2 = {"i4","i2","3","6","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp2[temp2.length-1] = String.valueOf(random2);
            temp2[temp2.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp2[temp2.length-3] = String.valueOf(result);
            operations.put(2,temp2);
            String[] temp3 = {"i4","i5","i12","0","0","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            //temp3[temp3.length-1] = String.valueOf(random2);
            //temp3[temp3.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            //temp3[temp3.length-3] = String.valueOf(result);
            operations.put(3,temp3);
            String[] temp4 = {"i5","i2","7","1","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp4[temp4.length-1] = String.valueOf(random2);
            temp4[temp4.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp4[temp4.length-3] = String.valueOf(result);
            operations.put(4,temp4);
            String[] temp5 = {"i6","i3","4","1","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp5[temp5.length-1] = String.valueOf(random2);
            temp5[temp5.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp5[temp5.length-3] = String.valueOf(result);
            operations.put(5,temp5);
            String[] temp6 = {"i7","i3","2","1","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp6[temp6.length-1] = String.valueOf(random2);
            temp6[temp6.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp6[temp6.length-3] = String.valueOf(result);
            operations.put(6,temp6);
            String[] temp7 = {"i8","i10","i13","10","8","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            //temp7[temp7.length-1] = String.valueOf(random2);
            //temp7[temp7.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            //temp7[temp7.length-3] = String.valueOf(result);
            operations.put(7,temp7);
            String[] temp8 = {"i8","i11","i3","7","6","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 = ThreadLocalRandom.current().nextDouble(min, max);
            temp8[temp8.length-1] = String.valueOf(random2);
            temp8[temp8.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp8[temp8.length-3] = String.valueOf(result);
            operations.put(8,temp8);
            String[] temp9 = {"i9","i10","i3","7","6","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp9[temp9.length-1] = String.valueOf(random2);
            temp9[temp9.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp9[temp9.length-3] = String.valueOf(result);
            operations.put(9,temp9);
            String[] temp10 = {"i9","i11","i14","0","0","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            //temp10[temp10.length-1] = String.valueOf(random2);
            //temp10[temp10.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            //temp10[temp10.length-3] = String.valueOf(result);
            operations.put(10,temp10);
            String[] temp111 = {"i4","10","2","0.9"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp111[temp111.length-1] = String.valueOf(random2);
            temp111[temp111.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp111[temp111.length-3] = String.valueOf(result);
            operations.put(11,temp111);
            String[] temp112 = {"i5","10","7","0.7"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp112[temp112.length-1] = String.valueOf(random2);
            temp112[temp112.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp112[temp112.length-3] = String.valueOf(result);
            operations.put(12,temp112);
            String[] temp113 = {"i6","10","10","0.7"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp113[temp113.length-1] = String.valueOf(random2);
            temp113[temp113.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp113[temp113.length-3] = String.valueOf(result);
            operations.put(13,temp113);
            String[] temp114 = {"i7","10","8","0.9"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp114[temp114.length-1] = String.valueOf(random2);
            temp114[temp114.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp114[temp114.length-3] = String.valueOf(result);
            operations.put(14,temp114);
            String[] temp115 = {"i8","10","5","0.63"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp115[temp115.length-1] = String.valueOf(random2);
            temp115[temp115.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp115[temp115.length-3] = String.valueOf(result);
            operations.put(15,temp115);
            String[] temp116 = {"i9","10","3","0.7"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp116[temp116.length-1] = String.valueOf(random2);
            temp116[temp116.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp116[temp116.length-3] = String.valueOf(result);
            operations.put(16,temp116);
            String[] temp117 = {"i10","10","3","0.7"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp117[temp117.length-1] = String.valueOf(random2);
            temp117[temp117.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp117[temp117.length-3] = String.valueOf(result);
            operations.put(17,temp117);
            String[] temp118 = {"i11","10","1","0.8"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp118[temp118.length-1] = String.valueOf(random2);
            temp118[temp118.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp118[temp118.length-3] = String.valueOf(result);
            operations.put(18,temp118);
            String[] temp119 = {"i12","i2","8","8","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 = ThreadLocalRandom.current().nextDouble(min, max);
            temp119[temp119.length-1] = String.valueOf(random2);
            temp119[temp119.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp119[temp119.length-3] = String.valueOf(result);
            operations.put(19,temp119);
            String[] temp120 = {"i13","i3","10","8","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp120[temp120.length-1] = String.valueOf(random2);
            temp120[temp120.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp120[temp120.length-3] = String.valueOf(result);
            operations.put(20,temp120);
            String[] temp121 = {"i14","i3","5","5","1"};
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            random2 =  ThreadLocalRandom.current().nextDouble(min, max);
            temp121[temp121.length-1] = String.valueOf(random2);
            temp121[temp121.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp121[temp121.length-3] = String.valueOf(result);
            operations.put(21,temp121);
            
        }
        
        HashMap<Integer,String[]> operations_graph = (HashMap) operations.clone();
        Iterator print = operations.entrySet().iterator();
       
        
        
        int count = 10;
         List<Map<Integer, String[]>> listOfMaps = new ArrayList<Map<Integer, String[]>>();
        int u=0;
        int choice =0;
        while(u<13)
        {
           listOfMaps.add((HashMap) operations.clone());
           u++;
           
        }
        HashMap<Integer,Integer> productions = new HashMap<Integer,Integer>();
        determineExecutionInstance(operations,productions);
        while(choice<13)
        {
        cost =0;
        time=0;
        HashMap<Integer,String[]> executable = new HashMap();
        
        HashSet<String> available = new HashSet();
        operations = (HashMap)listOfMaps.get(choice);
        HashSet<Integer> prune = new HashSet<Integer>();
        HashMap<String,Integer> failures = new HashMap();
        while(count !=0)
        {
           Iterator it = operations.entrySet().iterator();
           while (it.hasNext()) //calculate executable operations
           {
            
            HashMap.Entry pair = (HashMap.Entry)it.next();
            String[] temp11 = (String[])pair.getValue();
            if(temp11.length==4) //cases where operation has no input elements
            {
                executable.put((Integer)pair.getKey(),(String[]) pair.getValue());
            }
            else //cases where operation has input elements. so each input element is checked for availability
            {
              int temp12 = 0;
              for(int i=0;i<temp11.length-4;i++)
              {
                if(available.contains(temp11[i]))//each input is checked
                {
                    temp12++;
                    
                }
              }
              if(temp12 == temp11.length -4)//if every input is available then the operation is available for execution
              {
                  executable.put((Integer)pair.getKey(),(String[]) pair.getValue());
              }
            }
            //it.remove(); // avoids a ConcurrentModificationException
            
            }
           if(choice==6 || choice==12)
           {
               if(prune.size()>0)
               {
                   for(Integer op : prune)
                   {
                       executable.remove(op);
                   }
               }
           }
           if(executable.size()==0)//execution has completed since the production of A is no longer possible
           {
               System.out.println("Cost: " +  cost + " , Time: " + time);
               System.out.println();
               String filename = heuristics[choice] + ".txt";
               
               //bw[choice].write((y+1)+","+(int)cost+","+(int)time);
               //bw[choice].newLine();
               failure[choice]+=1;
               sum[choice] += cost;
               sum2[choice] +=time;
               if(time==0||cost==0)
               {
                   debug++;
               }
               break;
           }
           int key;
           if(choice==0)
           {
               key=executeRandom(executable,available,operations,productions);
               
           }
           else if(choice==1)
           {
               key=executeLowestCost(executable,available,operations_graph,productions);
           }
           else if(choice==2)
           {
               key=executeShortestTime(executable,available,operations_graph,productions);
           }
           else if(choice==3)
           {
               key=executeLowestFail(executable,available,operations_graph,productions);
           }
           else if(choice==4)
           {
               key=rootDistance(executable,available,operations_graph,productions);
           }
           else if(choice==5)
           {   
               key=costDistance(executable,available,operations_graph,productions);
               
           }
           else if(choice==6)
           {   
               key=timeDistance(executable,available,operations_graph,productions);
               
           }
           else if(choice==7)
           {   
               key=knockoutPath(executable,available,operations_graph,productions);
               
           }
           else if(choice==8)
           {   
               key=knockoutPathTime(executable,available,operations_graph,productions);
               
           }
           else if(choice==9)
           {
               key=knockoutPathCombo(executable,available,operations_graph,productions);
           }
           else if(choice==10)
           {
               key=knockoutPathPruneBoth(executable,available,operations_graph,prune,failures,productions);
           }
           else if(choice==11)
           {
               key=knockoutPathPruneBothTime(executable,available,operations_graph,prune,failures,productions);
           }
           else
           {
               key=knockoutPathPruneBothCombo(executable,available,operations_graph,prune,failures,productions);
           }
               
           
           
           
           String[] temp14 = operations.get(key);
           double cost2 = Double.valueOf(temp14[temp14.length-2]);
           cost = cost + cost2; //cost of the entire path is calculated in a step by step manner
           double time2 = Double.valueOf(temp14[temp14.length-3]);
           time = time + time2;
           operations.remove(key);//operation is removed from the list of operations as it is no longer available
           if(available.contains("i1"))//if A has been produced then the execution is completed
           {
               System.out.println("Cost: " +  cost + " , Time: " + time);
               System.out.println();
               String filename = heuristics[choice] + ".txt";
               
               bw[choice].write((int)cost+","+(int)time);
               bw[choice].newLine();
               //sum[choice] += cost;
               //sum2[choice] += time;
               success[choice] +=1;
               if(time==0 || cost==0)
               {
                   debug++;
               }
               break;
           }
           
           
           
           
            
           
            
            
        }
        choice++;
        }//choice
        System.out.println();
        System.out.println();
        y++;
    
    }
      for(int u=0;u<13;u++)
      {
      double result = (double) sum[u]/ (double)failure[u]; //average execution cost
      double result2 = (double) sum2[u] /(double)failure[u];
      System.out.println(heuristics[u]+"    cost: " +result +"      time: " + result2);
      bw[u].close();
      }
      System.out.println();
      for(int i=0;i<13;i++)
      {
          System.out.println(success[i]);
      }
      System.out.println(debug);
      System.out.println(y);
     }
    
    private static int getRandomNumberInRange(int min, int max) {

		if (min > max)
                {
		   throw new IllegalArgumentException("max must be greater than min");
		}
                if(min==max)
                {
                    return 1;
                }

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
    
    private static int executeRandom(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)//Random selection strategy
    {
        int next = getRandomNumberInRange(1,input.size()) -1;
        int count =0;
        int key=0;
        Iterator it2 = input.entrySet().iterator();
        
        while(it2.hasNext())
        {
           HashMap.Entry pair2 = (HashMap.Entry)it2.next();
           if(count==next)
           {
            key =  (Integer) pair2.getKey();
            String[] temp13 = (String []) pair2.getValue();
            
            //operations.remove(key);
            input.remove(key);
            double prob = Double.parseDouble(temp13[temp13.length-1]);
            int result = productions.get(key);
            if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
            {
                available.add(temp13[temp13.length-4]);
                System.out.println("Op" + key+ "," + temp13[temp13.length-4]);
            }
            else //execution was unsuccessful and therefore the element was not produced
            {
                System.out.println("Op" + key+ "," + temp13[temp13.length-4] + " fail");
            }
            
            
            
            break;
           }
           
           count++;
                   
        }
        
        return key;
    }
    
    private static int executeLowestCost(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)//Lowest Cost selection strategy
    {
        int n = input.size();
        double[][] cost = new double [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= Double.valueOf((Integer)pair.getKey());
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Double.parseDouble(temp15[temp15.length-2]);
          
          i++;
        }
        int key = (int) getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeShortestTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
        int n = input.size();
        double[][] cost = new double [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Integer.parseInt(temp15[temp15.length-3]);
          
          i++;
        }
        int key = (int)getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeLowestFail(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
        int n = input.size();
        double[][] cost = new double [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Double.parseDouble(temp15[temp15.length-1]);
          
          i++;
        }
        int key = (int)getMaxValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    public static double getMinValue(double[][] numbers)
    {
                
        double minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                
		return numbers[index][0];
	}
    
    public static int getMinIntValue(int[][] numbers)
    {
                
        int minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                
		return numbers[index][0];
	}
    
    public static double getMaxValue(double[][] numbers)
    {
                
        double maxValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] > maxValue)
           {
                maxValue = numbers[i][1];
                index =i;
           }
		}
                
		return numbers[index][0];
	}
    
    public static int getMinValue2(int[][] numbers)
    {
                
        int minValue = numbers[0][1];
        int index=0;
        for(int i=1;i<numbers.length;i++)
        {
         if(numbers[i][1] < minValue)
           {
                minValue = numbers[i][1];
                index =i;
           }
		}
                
		return minValue;
	}
    
    private static int execution(double prob)// function that takes the input the success probability of a rule and executes it
    {
        Random r = new Random();
        double result = r.nextDouble();
        if(result>prob)
        {
          return 0; //failure
        }
        else
        {
          return 1;//success
        }
    }
    
    private static int rootDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[15][15];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph.length;j++)
            {
                graph[i][j]=-1;
            }
        }
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = 1;
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                
                if(Integer.parseInt(dokimi[dokimi.length-2])==0)
                {
                 graph[two][one]=0;
                }
                else
                {
                 graph[two][one]=1;
                }
               
                
             }
            }
            
        }
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        double[][] cost = new double [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          String tempstring = temp15[temp15.length-4].replace("i",""); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
          int tempint = Integer.parseInt(tempstring);
          cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int costDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[15][15];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph.length;j++)
            {
                graph[i][j]=-1;
            }
        }
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Integer.parseInt(dokimi[limit+1]);
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]);
               
                
             }
            }
            
        }
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        double[][] cost = new double [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          String tempstring = temp15[temp15.length-4].replace("i",""); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
          int tempint = Integer.parseInt(tempstring);
          cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int costDistanceNew(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
       double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
       
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        double[] dist2 = new double[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }    
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0]; //operation with zero input elements, therefore its output is the first element of the String[]
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
           if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          { // !!!!!!!!!!!!!! used to have temp15[0] i.e. use the ranking of the first input element as the ranking of an operation, POSSIBLY MADE NO SENSE
           String index = temp15[limit-1];//operation with >=1 input elements, therefore its output is the last non-attribute element of the String[]
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
           
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
       
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
           
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
       
    }
    
    private static int timeDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[15][15];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph.length;j++)
            {
                graph[i][j]=-1;
            }
        }
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Integer.parseInt(dokimi[limit]);
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit]);
               
                
             }
            }
            
        }
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        double[][] cost = new double [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          String tempstring = temp15[temp15.length-4].replace("i",""); //for formatting reasons the "i" prefix is removed so that the element key can be extracted
          int tempint = Integer.parseInt(tempstring);
          cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance
          
          
          i++;
        }
        int key = (int) getMinValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
     
      
      
   private static int knockoutPath(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                
                graph[two][one]=Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int n = input.size();
        double[][] cost = new double[n][2];
        
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
           
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           //int add = Integer.parseInt(temp15[limit+1]);
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
           System.out.println(cost[i][0] + ":    " + cost[i][1]); 
          
          }
         
          
          i++;
        }
        
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int knockoutPathPrune(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashSet<Integer> prune, HashMap<String,Integer> failures, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                
                graph[two][one]=Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        double[] dist2 = new double[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }    
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            String[] output =(String[]) operations.get(key);
            String output2 = output[output.length-4];
            if(failures.containsKey(output2))
            {
                
                Integer count =  failures.get(output2);
                count +=1;
                failures.put(output2, count);
            }
            else
            {
                failures.put(output2,1);
            }
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            prune(operations,key,prune,failures);
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBoth(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashSet<Integer> prune, HashMap<String,Integer> failures, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                
                graph[two][one]=Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        
        
        double[] dist2 = new double[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }    
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            String[] output =(String[]) operations.get(key);
            String output2 = output[output.length-4];
            if(failures.containsKey(output2))
            {
                
                Integer count =  failures.get(output2);
                count +=1;
                failures.put(output2, count);
            }
            else
            {
                failures.put(output2,1);
            }
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            prune(operations,key,prune,failures);
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBothTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashSet<Integer> prune, HashMap<String,Integer> failures, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                
                graph[two][one]=Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        
        
        double[] dist2 = new double[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }    
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            String[] output =(String[]) operations.get(key);
            String output2 = output[output.length-4];
            if(failures.containsKey(output2))
            {
                
                Integer count =  failures.get(output2);
                count +=1;
                failures.put(output2, count);
            }
            else
            {
                failures.put(output2,1);
            }
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            prune(operations,key,prune,failures);
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBothCombo(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashSet<Integer> prune, HashMap<String,Integer> failures, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit+1]) + Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
               
                graph[two][one]=Double.parseDouble(dokimi[limit+1]) + Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        
        
        
        double[] dist2 = new double[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }    
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
       
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            String[] output =(String[]) operations.get(key);
            String output2 = output[output.length-4];
            if(failures.containsKey(output2))
            {
                
                Integer count =  failures.get(output2);
                count +=1;
                failures.put(output2, count);
            }
            else
            {
                failures.put(output2,1);
            }
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            prune(operations,key,prune,failures);
        }
        return key;
        
       
   }
    
    
   private static int knockoutPathTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
                
                graph[two][one]=Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   
   private static int knockoutPathCombo(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
   {
        double graph[][] = new double[15][15];
        double graph2[][] = new double [15][15];
        for(int l=0;l<15;l++)
        {
            for(int p=0;p<15;p++)
            {
                graph2[l][p]=-1;
                graph[l][p]=-1;
            }
        }
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry) it.next(); 
            String[] dokimi = (String[]) pair.getValue();
            int limit = dokimi.length-3;
            String[] te = new String[limit];
            
            if(limit==1)
            {
                int one = 0;
                String index = dokimi[0].replace("i", "");
                int two = Integer.parseInt(index);
                graph[one][two] = Double.parseDouble(dokimi[limit])+Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                String index = dokimi[y].replace("i","");
                int one = Integer.parseInt(index);
                String index2 = dokimi[limit-1].replace("i","");
                int two = Integer.parseInt(index2);
               
                
                graph[two][one]=Double.parseDouble(dokimi[limit])+Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
               
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[15];
        double distProb[] = new double[15];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int n = input.size();
        double[][] cost = new double[n][2];
        
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          int limit = temp15.length-3;
          if(limit==1)
          {
           String index = temp15[0];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator,numerator;
            if(graph[0][ind]!=-1)
           {
             denominator = dist[ind] + graph[0][ind];
           }
           else
           {
             denominator = dist[ind];  
           }
           if(graph2[0][ind]!=-1)
           {
             numerator = distProb[ind] * (1-graph2[0][ind]);
           }
           else
           {
             numerator = distProb[ind];  
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static void pruneOperations(HashMap<Integer,String[]> operations, int key, HashSet<Integer> prune)
   {
        String[] entry = (String []) operations.get(key);
        String output = entry[entry.length-4];
        System.out.println(output);
        
        Iterator it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry entry2 = (HashMap.Entry) it.next();
            String[] compare = (String[]) entry2.getValue();
            for(int i=0;i<compare.length-4;i++)
            {
                if(compare[i].equals(output))
                {
                    prune.add((Integer)entry2.getKey());
                }
            }
        }
        
        
       
   }
   
  private static void prune(HashMap<Integer,String[]> operations, int key, HashSet<Integer> prune, HashMap<String,Integer> failures)
    {
        Iterator it = operations.entrySet().iterator();
        String[] operation = (String[])operations.get(key);
        String output = operation[operation.length-4];
        int count=0;
        while(it.hasNext())
        {
            HashMap.Entry entry = (HashMap.Entry) it.next();
            String compare[] = (String[]) entry.getValue();
            if(compare[compare.length-4].equals(output))
            {
                count+=1;
            }
        }
        int check = failures.get(output);
        if(check!=count)
        {
            return;
        }
        HashSet<String> candidates = new HashSet();
        HashSet<String> prune2 = new HashSet();
        it = operations.entrySet().iterator();
        while(it.hasNext())
        {
            HashMap.Entry entry = (HashMap.Entry) it.next();
            String[] compare = (String[]) entry.getValue();
            for(int i=0;i<compare.length-4;i++)
            {
                if(compare[i].equals(output))
                {
                 for(int j=0;j<compare.length-4;j++)
                 {
                     
                     if(j!=i)
                     {
                         
                         candidates.add(compare[j]);
                     }
                 }
                }
            }
        }
        
        int sum_cand=0;
        int sum_out=0;
        for(String cand : candidates)
        {
          ;
          sum_cand=0;
          sum_out=0;
          it = operations.entrySet().iterator();
          while(it.hasNext())
          {
           HashMap.Entry entry = (HashMap.Entry) it.next();
           
           String[] compare = (String[]) entry.getValue();
           for(int i=0;i<compare.length-4;i++)
           {
            if(compare[i].equals(cand))
            {
                sum_cand+=1;
                
             for(int j=0;j<compare.length-4;j++)
             {
                 
              if(compare[j].equals(output))
              {
                  
                  sum_out+=1;
              }   
             }   
            }   
           }
          }
          
          if(sum_cand==sum_out)
          {
              
              prune2.add(cand);
          }
        }
        
        for(String c : prune2)
        {
             it=operations.entrySet().iterator();
             while(it.hasNext())
             {
               HashMap.Entry entry = (HashMap.Entry) it.next();
               String compare[] = (String[]) entry.getValue();
               if(compare[compare.length-4].equals(c))
               {
                   
                   prune.add((Integer)entry.getKey());
               }
             }
            
        }
        
       
    }
    
    private static void prune2(HashMap<Integer,String[]> operations, int key,double[][] dist, double[] dist2)
    {
        Iterator it = operations.entrySet().iterator();
        String[] operation = (String[])operations.get(key);
        HashSet<Integer> prune = new HashSet();
        String output;
        if(key<10)
        {
           output = "i0".concat(String.valueOf(key));
        }
        else
        {
            output = "i".concat(String.valueOf(key));
        }
        
        
        HashSet<String> candidates = new HashSet();
        HashSet<String> prune2 = new HashSet();
        while(it.hasNext())
        {
            HashMap.Entry entry = (HashMap.Entry) it.next();
            String[] compare = (String[]) entry.getValue();
            for(int i=0;i<compare.length-4;i++)
            {
                if(compare[i].equals(output))
                {
                   
                 for(int j=0;j<compare.length-4;j++)
                 {
                     
                     if(j!=i)
                     {
                         
                         candidates.add(compare[j]);
                     }
                 }
                }
            }
        }
        
        int sum_cand=0;
        int sum_out=0;
        for(String cand : candidates)
        {
          
          sum_cand=0;
          sum_out=0;
          it = operations.entrySet().iterator();
          while(it.hasNext())
          {
           HashMap.Entry entry = (HashMap.Entry) it.next();
           
           String[] compare = (String[]) entry.getValue();
           for(int i=0;i<compare.length-4;i++)
           {
            if(compare[i].equals(cand))
            {
                sum_cand+=1;
                
             for(int j=0;j<compare.length-4;j++)
             {
                 
              if(compare[j].equals(output))
              {
                 
                  sum_out+=1;
              }   
             }   
            }   
           }
          }
          
          if(sum_cand==sum_out)
          {
              prune2.add(cand);
              String output2 = cand.replace("i","");
              int two = Integer.parseInt(output2);
              
              if(dist[0][key]!=-1)
              {
              dist2[two]+=dist[0][key];
              }
              else
              {
              dist2[two]+=findOperationCost(operations,key);
              }
              prune.add(two);
          }
        }
        if(prune2.isEmpty())
        {
            
        }
        
        
       
    }
    
    private static int findOperationCost(HashMap<Integer,String[]> operations, int key)
   {
       int result=11;
       String output;
        if(key<10)
        {
           output = "i".concat(String.valueOf(key));
        }
        else
        {
            output = "i".concat(String.valueOf(key));
        }
       Iterator it = operations.entrySet().iterator();
       while(it.hasNext())
       {
           HashMap.Entry entry = (HashMap.Entry) it.next();
           String[] operation = (String[]) entry.getValue();
           if(operation[operation.length-4].equals(output))
           {
               if(Integer.parseInt(operation[operation.length-2])<result)
               {
                   result = Integer.parseInt(operation[operation.length-2]);
               }
           }
           
       }
       if(result==11)
       {
           //System.out.println(key);
       }
       return result;
   }
    
   private static int determineExecutionInstance(HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions)
   {
       Iterator it = operations.entrySet().iterator();
       while(it.hasNext())
       {
           HashMap.Entry temp = (HashMap.Entry) it.next();
           int key = (Integer) temp.getKey();
           String[] value = (String[]) temp.getValue();
           double prob = Double.parseDouble(value[value.length-1]);
           int result = execution(prob);
           productions.put(key, result);
       }
             
       return 1;
   }
    
     
    
}