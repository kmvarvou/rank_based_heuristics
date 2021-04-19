/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdmsocialinsurance;

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
public class PdmSocialInsurance {

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
        int[] success = new int [13];
        int[] failure = new int [13];
        int[] early = new int[13];
       
        
       
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
        int minInt=1, maxInt=10;
        Random r = new Random();
        RandomGaussian gaussian = new RandomGaussian();
        double result, random2;
        HashMap<Integer, String[]> operations = new HashMap();
        if(s==0)
        {
         String[] temp = {"i25","i27","i01","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp[temp.length-1] = String.valueOf(random2);
        temp[temp.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp[temp.length-3] = String.valueOf(result);
        operations.put(1,temp);
        String[] temp2 = {"i25","i37","i02","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp2[temp2.length-1] = String.valueOf(random2);
        temp2[temp2.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp2[temp2.length-3] = String.valueOf(result);
        operations.put(2,temp2);
        String[] temp3 = {"i33","i37","i03","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp3[temp3.length-1] = String.valueOf(random2);
        temp3[temp3.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp3[temp3.length-3] = String.valueOf(result);
        operations.put(3,temp3);
        String[] temp4 = {"i33","i37","i04","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        //random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp4[temp4.length-1] = String.valueOf(random2);
        temp4[temp4.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp4[temp4.length-3] = String.valueOf(result);
        operations.put(4,temp4);
        String[] temp5 = {"i37","i45","i05","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp5[temp5.length-1] = String.valueOf(random2);
        temp5[temp5.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp5[temp5.length-3] = String.valueOf(result);
        operations.put(5,temp5);
        String[] temp6 = {"i21","i37","i06","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp6[temp6.length-1] = String.valueOf(random2);
        temp6[temp6.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp6[temp6.length-3] = String.valueOf(result);
        operations.put(6,temp6);
        String[] temp7 = {"i24","i37","i07","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp7[temp7.length-1] = String.valueOf(random2);
        temp7[temp7.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp7[temp7.length-3] = String.valueOf(result);
        operations.put(7,temp7);
        String[] temp8 = {"i23","i37","i08","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp8[temp8.length-1] = String.valueOf(random2);
        temp8[temp8.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp8[temp8.length-3] = String.valueOf(result);
        operations.put(8,temp8);
        String[] temp9 = {"i24","i39","i09","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp9[temp9.length-1] = String.valueOf(random2);
        temp9[temp9.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp9[temp9.length-3] = String.valueOf(result);
        operations.put(9,temp9);
        String[] temp10 = {"i13","i14","i34","i37","i42","i10","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp10[temp10.length-1] = String.valueOf(random2);
        temp10[temp10.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp10[temp10.length-3] = String.valueOf(result);
        operations.put(10,temp10);
        String[] temp111 = {"i31","i11","0","60","0.85"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp111[temp111.length-1] = String.valueOf(random2);
        temp111[temp111.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp111[temp111.length-3] = String.valueOf(result);
        operations.put(11,temp111);
        String[] temp112 = {"i16","i15","0","0","0.997"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp112[temp112.length-1] = String.valueOf(random2);
        temp112[temp112.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp112[temp112.length-3] = String.valueOf(result);
        operations.put(12,temp112);
        String[] temp113 = {"i17","i15","0","0","0.003"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp113[temp113.length-1] = String.valueOf(random2);
        temp113[temp113.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp113[temp113.length-3] = String.valueOf(result);
        operations.put(13,temp113);
        String[] temp114 = {"i16","i17","i51","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp114[temp114.length-1] = String.valueOf(random2);
        temp114[temp114.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp114[temp114.length-3] = String.valueOf(result);
        operations.put(14,temp114);
        String[] temp115 = {"i25","i30","i35","i36","i44","i16","0","561","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp115[temp115.length-1] = String.valueOf(random2);
        temp115[temp115.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp115[temp115.length-3] = String.valueOf(result);
        operations.put(15,temp115);
        String[] temp116 = {"i25","i30","i17","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp116[temp116.length-1] = String.valueOf(random2);
        temp116[temp116.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp116[temp116.length-3] = String.valueOf(result);
        operations.put(16,temp116);
        String[] temp117 = {"i01","i18","0","0","0.009"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp117[temp117.length-1] = String.valueOf(random2);
        temp117[temp117.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp117[temp117.length-3] = String.valueOf(result);
        operations.put(17,temp117);
        String[] temp118 = {"i02","i18","0","0","0.013"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp118[temp118.length-1] = String.valueOf(random2);
        temp118[temp118.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp118[temp118.length-3] = String.valueOf(result);
        operations.put(18,temp118);
        String[] temp119 = {"i08","i18","0","0","0.016"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp119[temp119.length-1] = String.valueOf(random2);
        temp119[temp119.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp119[temp119.length-3] = String.valueOf(result);
        operations.put(19,temp119);
        String[] temp120 = {"i09","i18","0","0","0.002"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp120[temp120.length-1] = String.valueOf(random2);
        temp120[temp120.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp120[temp120.length-3] = String.valueOf(result);
        operations.put(20,temp120);
        String[] temp121 = {"i10","i18","0","0","0.068"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp121[temp121.length-1] = String.valueOf(random2);
        temp121[temp121.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp121[temp121.length-3] = String.valueOf(result);
        operations.put(21,temp121);
        String[] temp122 = {"i11","i18","0","0","0.079"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp122[temp122.length-1] = String.valueOf(random2);
        temp122[temp122.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp122[temp122.length-3] = String.valueOf(result);
        operations.put(22,temp122);
        String[] temp123 = {"i15","i18","0","0","0.21"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp123[temp123.length-1] = String.valueOf(random2);
        temp123[temp123.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp123[temp123.length-3] = String.valueOf(result);
        operations.put(23,temp123);
        String[] temp124 = {"i09","i11","i15","i50","0","0","1"};
        operations.put(24,temp124);
        String[] temp125 = {"i25","i37","i28","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp125[temp125.length-1] = String.valueOf(random2);
        temp125[temp125.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp125[temp125.length-3] = String.valueOf(result);
        operations.put(25,temp125);
        String[] temp126 = {"i25","i30","i35","i36","i29","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp126[temp126.length-1] = String.valueOf(random2);
        temp126[temp126.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp126[temp126.length-3] = String.valueOf(result);
        operations.put(26,temp126);
        String[] temp127 = {"i32","i37","i43","i30","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp127[temp127.length-1] = String.valueOf(random2);
        temp127[temp127.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp127[temp127.length-3] = String.valueOf(result);
        operations.put(27,temp127);
        String[] temp128 = {"i29","i40","i48","i31","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp128[temp128.length-1] = String.valueOf(random2);
        temp128[temp128.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp128[temp128.length-3] = String.valueOf(result);
        operations.put(28,temp128);
        String[] temp129 = {"i01","i02","i03","i04","i05","i06","i07","i08","i10","i27","i28","i32","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp129[temp129.length-1] = String.valueOf(random2);
        temp129[temp129.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp129[temp129.length-3] = String.valueOf(result);
        operations.put(29,temp129);
        String[] temp130 = {"i36","i37","i41","i34","0","420","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp130[temp130.length-1] = String.valueOf(random2);
        temp130[temp130.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp130[temp130.length-3] = String.valueOf(result);
        operations.put(30,temp130);
        String[] temp131 = {"i39","i41","i40","0","30","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp131[temp131.length-1] = String.valueOf(random2);
        temp131[temp131.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp131[temp131.length-3] = String.valueOf(result);
        operations.put(31,temp131);
        String[] temp132 = {"i47","i42","0","30","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp132[temp132.length-1] = String.valueOf(random2);
        temp132[temp132.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp132[temp132.length-3] = String.valueOf(result);
        operations.put(32,temp132);
        String[] temp133 = {"i39","i49","i43","0","60","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp133[temp133.length-1] = String.valueOf(random2);
        temp133[temp133.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp133[temp133.length-3] = String.valueOf(result);
        operations.put(33,temp133);
        String[] temp134 = {"i13","0","8","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp134[temp134.length-1] = String.valueOf(random2);
        temp134[temp134.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp134[temp134.length-3] = String.valueOf(result);
        operations.put(34,temp134);
        String[] temp135 = {"i14","0","8","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp135[temp135.length-1] = String.valueOf(random2);
        temp135[temp135.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp135[temp135.length-3] = String.valueOf(result);
        operations.put(35,temp135);
        String[] temp136 = {"i21","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp136[temp136.length-1] = String.valueOf(random2);
        temp136[temp136.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp136[temp136.length-3] = String.valueOf(result);
        operations.put(36,temp136);
        String[] temp137 = {"i23","0","67","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp137[temp137.length-1] = String.valueOf(random2);
        temp137[temp137.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp137[temp137.length-3] = String.valueOf(result);
        operations.put(37,temp137);
        String[] temp138 = {"i24","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp138[temp138.length-1] = String.valueOf(random2);
        temp138[temp138.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp138[temp138.length-3] = String.valueOf(result);
        operations.put(38,temp138);
        String[] temp139 = {"i25","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp139[temp139.length-1] = String.valueOf(random2);
        temp139[temp139.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp139[temp139.length-3] = String.valueOf(result);
        operations.put(39,temp139);
        String[] temp140 = {"i27","0","8","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp140[temp140.length-1] = String.valueOf(random2);
        temp140[temp140.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp140[temp140.length-3] = String.valueOf(result);
        operations.put(40,temp140);
        String[] temp141 = {"i33","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp141[temp141.length-1] = String.valueOf(random2);
        temp141[temp141.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp141[temp141.length-3] = String.valueOf(result);
        operations.put(41,temp141);
        String[] temp142 = {"i35","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp142[temp142.length-1] = String.valueOf(random2);
        temp142[temp142.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp142[temp142.length-3] = String.valueOf(result);
        operations.put(42,temp142);
        String[] temp143 = {"i36","0","1","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp143[temp143.length-1] = String.valueOf(random2);
        temp143[temp143.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp143[temp143.length-3] = String.valueOf(result);
        operations.put(43,temp143);
        String[] temp144 = {"i37","0","167","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp144[temp144.length-1] = String.valueOf(random2);
        temp144[temp144.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp144[temp144.length-3] = String.valueOf(result);
        operations.put(44,temp144);
        String[] temp145 = {"i39","0","17","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp145[temp145.length-1] = String.valueOf(random2);
        temp145[temp145.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp145[temp145.length-3] = String.valueOf(result);
        operations.put(45,temp145);
        String[] temp146 = {"i41","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp146[temp146.length-1] = String.valueOf(random2);
        temp146[temp146.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp146[temp146.length-3] = String.valueOf(result);
        operations.put(46,temp146);
        String[] temp147 = {"i44","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp147[temp147.length-1] = String.valueOf(random2);
        temp147[temp147.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp147[temp147.length-3] = String.valueOf(result);
        operations.put(47,temp147);
        String[] temp148 = {"i45","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp148[temp148.length-1] = String.valueOf(random2);
        temp148[temp148.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp148[temp148.length-3] = String.valueOf(result);
        operations.put(48,temp148);
        String[] temp149 = {"i47","0","33","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp149[temp149.length-1] = String.valueOf(random2);
        temp149[temp149.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp149[temp149.length-3] = String.valueOf(result);
        operations.put(49,temp149);
        String[] temp150 = {"i48","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp150[temp150.length-1] = String.valueOf(random2);
        temp150[temp150.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp150[temp150.length-3] = String.valueOf(result);
        operations.put(50,temp150);
        String[] temp151 = {"i49","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp151[temp151.length-1] = String.valueOf(random2);
        temp151[temp151.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp151[temp151.length-3] = String.valueOf(result);
        operations.put(51,temp151);
        String[] temp152 = {"i50","i18","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp152[temp152.length-1] = String.valueOf(random2);
        temp152[temp152.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp152[temp152.length-3] = String.valueOf(result);
        operations.put(52,temp152);
        String[] temp153 = {"i51","i15","0","0","1"};
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        random2 = ThreadLocalRandom.current().nextDouble(min, max);
        temp153[temp153.length-1] = String.valueOf(random2);
        temp153[temp153.length-2] = String.valueOf(result);
        result = r.nextInt((maxInt - minInt) + 1) + minInt;
        temp153[temp153.length-3] = String.valueOf(result);
        operations.put(53,temp153);
        }
        else
        {
            
        
        String[] temp = {"i25","i27","i01","0","0","1"};
        
        
        result = gaussian.getRandInt(Double.parseDouble(temp[temp.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp[temp.length-1])));
        
        temp[temp.length-1] = String.valueOf(random2);
        temp[temp.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp[temp.length-3]));
        temp[temp.length-3] = String.valueOf(result);
        operations.put(1,temp);
        String[] temp2 = {"i25","i37","i02","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp2[temp2.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp2[temp2.length-1])));
        temp2[temp2.length-1] = String.valueOf(random2);
        temp2[temp2.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp2[temp2.length-3]));
        temp2[temp2.length-3] = String.valueOf(result);
        operations.put(2,temp2);
        String[] temp3 = {"i33","i37","i03","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp3[temp3.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp3[temp3.length-1])));
        temp3[temp3.length-1] = String.valueOf(random2);
        temp3[temp3.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp3[temp3.length-3]));
        temp3[temp3.length-3] = String.valueOf(result);
        operations.put(3,temp3);
        String[] temp4 = {"i33","i37","i04","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp4[temp4.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp4[temp4.length-1])));
        temp4[temp4.length-1] = String.valueOf(random2);
        temp4[temp4.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp4[temp4.length-3]));
        temp4[temp4.length-3] = String.valueOf(result);
        operations.put(4,temp4);
        String[] temp5 = {"i37","i45","i05","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp5[temp5.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp5[temp5.length-1])));
        temp5[temp5.length-1] = String.valueOf(random2);
        temp5[temp5.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp5[temp5.length-3]));
        temp5[temp5.length-3] = String.valueOf(result);
        operations.put(5,temp5);
        String[] temp6 = {"i21","i37","i06","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp6[temp6.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp6[temp6.length-1])));
        temp6[temp6.length-1] = String.valueOf(random2);
        temp6[temp6.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp6[temp6.length-3]));
        temp6[temp6.length-3] = String.valueOf(result);
        operations.put(6,temp6);
        String[] temp7 = {"i24","i37","i07","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp7[temp7.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp7[temp7.length-1])));
        temp7[temp7.length-1] = String.valueOf(random2);
        temp7[temp7.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp7[temp7.length-3]));
        temp7[temp7.length-3] = String.valueOf(result);
        operations.put(7,temp7);
        String[] temp8 = {"i23","i37","i08","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp8[temp8.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp8[temp8.length-1])));
        temp8[temp8.length-1] = String.valueOf(random2);
        temp8[temp8.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp8[temp8.length-3]));
        temp8[temp8.length-3] = String.valueOf(result);
        operations.put(8,temp8);
        String[] temp9 = {"i24","i39","i09","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp9[temp9.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp9[temp9.length-1])));
        temp9[temp9.length-1] = String.valueOf(random2);
        temp9[temp9.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp9[temp9.length-3]));
        temp9[temp9.length-3] = String.valueOf(result);
        operations.put(9,temp9);
        String[] temp10 = {"i13","i14","i34","i37","i42","i10","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp10[temp10.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp10[temp10.length-1])));
        temp10[temp10.length-1] = String.valueOf(random2);
        temp10[temp10.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp10[temp10.length-3]));
        temp10[temp10.length-3] = String.valueOf(result);
        operations.put(10,temp10);
        String[] temp111 = {"i31","i11","0.6","0.6","0.85"};
        result = gaussian.getRandInt(Double.parseDouble(temp111[temp111.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp111[temp111.length-1])));
        temp111[temp111.length-1] = String.valueOf(random2);
        temp111[temp111.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp111[temp111.length-3]));
        temp111[temp111.length-3] = String.valueOf(result);
        operations.put(11,temp111);
        String[] temp112 = {"i16","i15","0","0","0.997"};
        result = gaussian.getRandInt(Double.parseDouble(temp112[temp112.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp112[temp112.length-1])));
        temp112[temp112.length-1] = String.valueOf(random2);
        temp112[temp112.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp112[temp112.length-3]));
        temp112[temp112.length-3] = String.valueOf(result);
        operations.put(12,temp112);
        String[] temp113 = {"i17","i15","0","0","0.003"};
        result = gaussian.getRandInt(Double.parseDouble(temp113[temp113.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp113[temp113.length-1])));
        temp113[temp113.length-1] = String.valueOf(random2);
        temp113[temp113.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp113[temp113.length-3]));
        temp113[temp113.length-3] = String.valueOf(result);
        operations.put(13,temp113);
        String[] temp114 = {"i16","i17","i51","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp114[temp114.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp114[temp114.length-1])));
        temp114[temp114.length-1] = String.valueOf(random2);
        temp114[temp114.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp114[temp114.length-3]));
        temp114[temp114.length-3] = String.valueOf(result);
        operations.put(14,temp114);
        String[] temp115 = {"i25","i30","i35","i36","i44","i16","5.61","5.61","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp115[temp115.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp115[temp115.length-1])));
        temp115[temp115.length-1] = String.valueOf(random2);
        temp115[temp115.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp115[temp115.length-3]));
        temp115[temp115.length-3] = String.valueOf(result);
        operations.put(15,temp115);
        String[] temp116 = {"i25","i30","i17","6.1","6.1","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp116[temp116.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp116[temp116.length-1])));
        temp116[temp116.length-1] = String.valueOf(random2);
        temp116[temp116.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp116[temp116.length-3]));
        temp116[temp116.length-3] = String.valueOf(result);
        operations.put(16,temp116);
        String[] temp117 = {"i01","i18","0","0","0.009"};
        result = gaussian.getRandInt(Double.parseDouble(temp117[temp117.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp117[temp117.length-1])));
        temp117[temp117.length-1] = String.valueOf(random2);
        temp117[temp117.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp117[temp117.length-3]));
        temp117[temp117.length-3] = String.valueOf(result);
        operations.put(17,temp117);
        String[] temp118 = {"i02","i18","0","0","0.013"};
        result = gaussian.getRandInt(Double.parseDouble(temp118[temp118.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp118[temp118.length-1])));
        temp118[temp118.length-1] = String.valueOf(random2);
        temp118[temp118.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp118[temp118.length-3]));
        temp118[temp118.length-3] = String.valueOf(result);
        operations.put(18,temp118);
        String[] temp119 = {"i08","i18","0","0","0.016"};
        result = gaussian.getRandInt(Double.parseDouble(temp119[temp119.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp119[temp119.length-1])));
        temp119[temp119.length-1] = String.valueOf(random2);
        temp119[temp119.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp119[temp119.length-3]));
        temp119[temp119.length-3] = String.valueOf(result);
        operations.put(19,temp119);
        String[] temp120 = {"i09","i18","0","0","0.002"};
        result = gaussian.getRandInt(Double.parseDouble(temp120[temp120.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp120[temp120.length-1])));
        temp120[temp120.length-1] = String.valueOf(random2);
        temp120[temp120.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp120[temp120.length-3]));
        temp120[temp120.length-3] = String.valueOf(result);
        operations.put(20,temp120);
        String[] temp121 = {"i10","i18","0","0","0.068"};
        result = gaussian.getRandInt(Double.parseDouble(temp121[temp121.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp121[temp121.length-1])));
        temp121[temp121.length-1] = String.valueOf(random2);
        temp121[temp121.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp121[temp121.length-3]));
        temp121[temp121.length-3] = String.valueOf(result);
        operations.put(21,temp121);
        String[] temp122 = {"i11","i18","0","0","0.079"};
        result = gaussian.getRandInt(Double.parseDouble(temp122[temp122.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp122[temp122.length-1])));
        temp122[temp122.length-1] = String.valueOf(random2);
        temp122[temp122.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp122[temp122.length-3]));
        temp122[temp122.length-3] = String.valueOf(result);
        operations.put(22,temp122);
        String[] temp123 = {"i15","i18","0","0","0.21"};
        result = gaussian.getRandInt(Double.parseDouble(temp123[temp123.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp123[temp123.length-1])));
        temp123[temp123.length-1] = String.valueOf(random2);
        temp123[temp123.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp123[temp123.length-3]));
        temp123[temp123.length-3] = String.valueOf(result);
        operations.put(23,temp123);
        String[] temp124 = {"i09","i11","i15","i50","0","0","1"};
        operations.put(24,temp124);
        String[] temp125 = {"i25","i37","i28","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp125[temp125.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp125[temp125.length-1])));
        temp125[temp125.length-1] = String.valueOf(random2);
        temp125[temp125.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp125[temp125.length-3]));
        temp125[temp125.length-3] = String.valueOf(result);
        operations.put(25,temp125);
        String[] temp126 = {"i25","i30","i35","i36","i29","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp126[temp126.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp126[temp126.length-1])));
        temp126[temp126.length-1] = String.valueOf(random2);
        temp126[temp126.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp[temp126.length-3]));
        temp126[temp126.length-3] = String.valueOf(result);
        operations.put(26,temp126);
        String[] temp127 = {"i32","i37","i43","i30","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp127[temp127.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp127[temp127.length-1])));
        temp127[temp127.length-1] = String.valueOf(random2);
        temp127[temp127.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp127[temp127.length-3]));
        temp127[temp127.length-3] = String.valueOf(result);
        operations.put(27,temp127);
        String[] temp128 = {"i29","i40","i48","i31","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp128[temp128.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp128[temp128.length-1])));
        temp128[temp128.length-1] = String.valueOf(random2);
        temp128[temp128.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp128[temp128.length-3]));
        temp128[temp128.length-3] = String.valueOf(result);
        operations.put(28,temp128);
        String[] temp129 = {"i01","i02","i03","i04","i05","i06","i07","i08","i10","i27","i28","i32","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp129[temp129.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp129[temp129.length-1])));
        temp129[temp129.length-1] = String.valueOf(random2);
        temp129[temp129.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp129[temp129.length-3]));
        temp129[temp129.length-3] = String.valueOf(result);
        operations.put(29,temp129);
        String[] temp130 = {"i36","i37","i41","i34","4.2","4.2","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp130[temp130.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp130[temp130.length-1])));
        temp130[temp130.length-1] = String.valueOf(random2);
        temp130[temp130.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp130[temp130.length-3]));
        temp130[temp130.length-3] = String.valueOf(result);
        operations.put(30,temp130);
        String[] temp131 = {"i39","i41","i40","0.30","0.30","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp131[temp131.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp131[temp131.length-1])));
        temp131[temp131.length-1] = String.valueOf(random2);
        temp131[temp131.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp131[temp131.length-3]));
        temp131[temp131.length-3] = String.valueOf(result);
        operations.put(31,temp131);
        String[] temp132 = {"i47","i42","0.30","0.30","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp132[temp132.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp132[temp132.length-1])));
        temp132[temp132.length-1] = String.valueOf(random2);
        temp132[temp132.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp132[temp132.length-3]));
        temp132[temp132.length-3] = String.valueOf(result);
        operations.put(32,temp132);
        String[] temp133 = {"i39","i49","i43","0.60","0.60","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp133[temp133.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp133[temp133.length-1])));
        temp133[temp133.length-1] = String.valueOf(random2);
        temp133[temp133.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp133[temp133.length-3]));
        temp133[temp133.length-3] = String.valueOf(result);
        operations.put(33,temp133);
        String[] temp134 = {"i13","0.08","0.08","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp134[temp134.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp134[temp134.length-1])));
        temp134[temp134.length-1] = String.valueOf(random2);
        temp134[temp134.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp134[temp134.length-3]));
        temp134[temp134.length-3] = String.valueOf(result);
        operations.put(34,temp134);
        String[] temp135 = {"i14","0.08","0.08","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp135[temp135.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp135[temp135.length-1])));
        temp135[temp135.length-1] = String.valueOf(random2);
        temp135[temp135.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp135[temp135.length-3]));
        temp135[temp135.length-3] = String.valueOf(result);
        operations.put(35,temp135);
        String[] temp136 = {"i21","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp136[temp136.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp136[temp136.length-1])));
        temp136[temp136.length-1] = String.valueOf(random2);
        temp136[temp136.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp136[temp136.length-3]));
        temp136[temp136.length-3] = String.valueOf(result);
        operations.put(36,temp136);
        String[] temp137 = {"i23","0.67","0.67","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp137[temp137.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp137[temp137.length-1])));
        temp137[temp137.length-1] = String.valueOf(random2);
        temp137[temp137.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp137[temp137.length-3]));
        temp137[temp137.length-3] = String.valueOf(result);
        operations.put(37,temp137);
        String[] temp138 = {"i24","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp138[temp138.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp138[temp138.length-1])));
        temp138[temp138.length-1] = String.valueOf(random2);
        temp138[temp138.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp138[temp138.length-3]));
        temp138[temp138.length-3] = String.valueOf(result);
        operations.put(38,temp138);
        String[] temp139 = {"i25","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp139[temp139.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp139[temp139.length-1])));
        temp139[temp139.length-1] = String.valueOf(random2);
        temp139[temp139.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp139[temp139.length-3]));
        temp139[temp139.length-3] = String.valueOf(result);
        operations.put(39,temp139);
        String[] temp140 = {"i27","0.08","0.08","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp140[temp140.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp140[temp140.length-1])));
        temp140[temp140.length-1] = String.valueOf(random2);
        temp140[temp140.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp140[temp140.length-3]));
        temp140[temp140.length-3] = String.valueOf(result);
        operations.put(40,temp140);
        String[] temp141 = {"i33","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp141[temp141.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp141[temp141.length-1])));
        temp141[temp141.length-1] = String.valueOf(random2);
        temp141[temp141.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp141[temp141.length-3]));
        temp141[temp141.length-3] = String.valueOf(result);
        operations.put(41,temp141);
        String[] temp142 = {"i35","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp142[temp142.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp142[temp142.length-1])));
        temp142[temp142.length-1] = String.valueOf(random2);
        temp142[temp142.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp142[temp142.length-3]));
        temp142[temp142.length-3] = String.valueOf(result);
        operations.put(42,temp142);
        String[] temp143 = {"i36","1","1","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp143[temp143.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp143[temp143.length-1])));
        temp143[temp143.length-1] = String.valueOf(random2);
        temp143[temp143.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp143[temp143.length-3]));
        temp143[temp143.length-3] = String.valueOf(result);
        operations.put(43,temp143);
        String[] temp144 = {"i37","1.67","1.67","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp144[temp144.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp144[temp144.length-1])));
        temp144[temp144.length-1] = String.valueOf(random2);
        temp144[temp144.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp144[temp144.length-3]));
        temp144[temp144.length-3] = String.valueOf(result);
        operations.put(44,temp144);
        String[] temp145 = {"i39","0.17","0.17","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp145[temp145.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp145[temp145.length-1])));
        temp145[temp145.length-1] = String.valueOf(random2);
        temp145[temp145.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp145[temp145.length-3]));
        temp145[temp145.length-3] = String.valueOf(result);
        operations.put(45,temp145);
        String[] temp146 = {"i41","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp146[temp146.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp146[temp146.length-1])));
        temp146[temp146.length-1] = String.valueOf(random2);
        temp146[temp146.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp146[temp146.length-3]));
        temp146[temp146.length-3] = String.valueOf(result);
        operations.put(46,temp146);
        String[] temp147 = {"i44","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp147[temp147.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp147[temp147.length-1])));
        temp147[temp147.length-1] = String.valueOf(random2);
        temp147[temp147.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp147[temp147.length-3]));
        temp147[temp147.length-3] = String.valueOf(result);
        operations.put(47,temp147);
        String[] temp148 = {"i45","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp148[temp148.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp148[temp148.length-1])));
        temp148[temp148.length-1] = String.valueOf(random2);
        temp148[temp148.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp148[temp148.length-3]));
        temp148[temp148.length-3] = String.valueOf(result);
        operations.put(48,temp148);
        String[] temp149 = {"i47","0.33","0.33","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp149[temp149.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp149[temp149.length-1])));
        temp149[temp149.length-1] = String.valueOf(random2);
        temp149[temp149.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp149[temp149.length-3]));
        temp149[temp149.length-3] = String.valueOf(result);
        operations.put(49,temp149);
        String[] temp150 = {"i48","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp150[temp150.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp150[temp150.length-1])));
        temp150[temp150.length-1] = String.valueOf(random2);
        temp150[temp150.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp150[temp150.length-3]));
        temp150[temp150.length-3] = String.valueOf(result);
        operations.put(50,temp150);
        String[] temp151 = {"i49","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp151[temp151.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp151[temp151.length-1])));
        temp151[temp151.length-1] = String.valueOf(random2);
        temp151[temp151.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp151[temp151.length-3]));
        temp151[temp151.length-3] = String.valueOf(result);
        operations.put(51,temp151);
        String[] temp152 = {"i50","i18","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp152[temp152.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp152[temp152.length-1])));
        temp152[temp152.length-1] = String.valueOf(random2);
        temp152[temp152.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp152[temp152.length-3]));
        temp152[temp152.length-3] = String.valueOf(result);
        operations.put(52,temp152);
        String[] temp153 = {"i51","i15","0","0","1"};
        result = gaussian.getRandInt(Double.parseDouble(temp153[temp153.length-2]));
        random2 = gaussian.getRandProb(1-(Double.parseDouble(temp153[temp153.length-1])));
        temp153[temp153.length-1] = String.valueOf(random2);
        temp153[temp153.length-2] = String.valueOf(result);
        result = gaussian.getRandInt(Double.parseDouble(temp153[temp153.length-3]));
        temp153[temp153.length-3] = String.valueOf(result);
        operations.put(53,temp153);
        }
        HashMap<Integer,String[]> operations_graph = (HashMap) operations.clone();
        Iterator print = operations.entrySet().iterator();
        
        while(print.hasNext())
        {
            HashMap.Entry entryprint = (HashMap.Entry) print.next();
            String[] printtemp = (String[]) entryprint.getValue();
            //System.out.println(printtemp[printtemp.length-3] + "     cost " + printtemp[printtemp.length-2] + "      prob" + printtemp[printtemp.length-1]);
        }
        
        
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
        double[][] graph_time = new double[52][52];
        createArrayTime(operations,graph_time);
        double[][] graph_cost = new double [52][52];
        createArrayCost(operations,graph_cost);
        int[][] graph_root = new int[52][52];
        createArrayRoot(operations,graph_root);
        while(choice<13)
        {
        cost =0;
        time=0;
        HashMap<Integer,String[]> executable = new HashMap();
        
        HashSet<String> available = new HashSet();
        HashSet<Integer> path = new HashSet();
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
           if(choice==6 || choice ==12)
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
               System.out.println(cost);
               System.out.println();
               String filename = heuristics[choice] + ".txt";
               failure[choice]+=1;
               //bw[choice].write((y+1)+","+cost+","+time);
               //bw[choice].newLine();
               //sum[choice] += cost;
               //sum2[choice] +=time;
               if(time==0||cost==0)
               {
                   debug++;
               }
               break;
           }
           int key;
           if(choice==0)
           {
               key=executeRandom(executable,available,operations,productions,path);
               //key=executeLowestCost(executable,available,operations);
               //key=executeShortestTime(executable,available,operations);
               //key=executeLowestFail(executable,available,operations);
               //key=rootDistance2(executable,available,operations_graph);
               //key=knockoutPath(executable,available,operations_graph);
               //key=knockoutPathTime(executable,available,operations_graph);
               //key=knockoutPathCombo(executable,available,operations_graph); 
               //key=costDistance(executable,available,operations_graph);
               //key=timeDistance(executable,available,operations_graph);
           }
           else if(choice==1)
           {
               key=executeLowestCost(executable,available,operations_graph,productions,path);
           }
           else if(choice==2)
           {
               key=executeShortestTime(executable,available,operations_graph,productions,path);
           }
           else if(choice==3)
           {
               key=executeLowestFail(executable,available,operations_graph,productions,path);
               
           }
           else if(choice==4)
           {
               key=rootDistance(executable,available,operations_graph,graph_root,productions,path);
           }
           else if(choice==5)
           {
               key=costDistance(executable,available,operations_graph,graph_cost,productions,path);
           }
           else if(choice==6)
           {
               key=timeDistance(executable,available,operations_graph,graph_time,productions,path);
           }
           else if(choice==7)
           {
               key=knockoutPathOld(executable,available,operations_graph,productions,path);
               
           }
           else if(choice==8)
           {
               key=knockoutPathTime(executable,available,operations_graph,productions,path);
               
           }
           else if(choice==9)
           {
              key=knockoutPathCombo(executable,available,operations_graph,productions,path);
           }
           else if(choice==10)
           {
               key=knockoutPathPruneBoth(executable,available,operations_graph,productions,prune,failures,path);
           }
           else if(choice==11)
           {
               key=knockoutPathPruneBothTime(executable,available,operations_graph,productions,prune,failures,path);
           }
           else
           {
               key=knockoutPathPruneBothCombo(executable,available,operations_graph,productions,prune,failures,path);
           }
               
           //int key=executeRandom(executable,available,operations);
           //int key = executeLowestCost(executable,available,operations);
           //int key = rootDistance2(executable,available,operations);
           //int key = executeKnockout2(executable,available,operations);
           //int key = knockoutPath(executable,available,operations);
           
           
           String[] temp14 = operations.get(key);
           double cost2 = Double.valueOf(temp14[temp14.length-2]);
           cost = cost + cost2; //cost of the entire path is calculated in a step by step manner
           double time2 = Double.valueOf(temp14[temp14.length-3]);
           time = time + time2;
           operations.remove(key);//operation is removed from the list of operations as it is no longer available
           if(available.contains("i18"))//if A has been produced then the execution is completed
           {
               System.out.println(cost);
               System.out.println();
               String filename = heuristics[choice] + ".txt";
               success[choice] +=1;
               double roundOff = Math.round(cost * 100.0) / 100.0;
               double roundOff2 = Math.round(time * 100.0) / 100.0;
               bw[choice].write(roundOff+","+roundOff2);
               bw[choice].newLine();
               sum[choice] += cost;
               sum2[choice] += time;
               if(time==0 || cost==0)
               {
                   debug++;
               }
               break;
           }
           
           
           
           
            
           
            
            
        }
        choice++;
        System.out.println();
        System.out.println("next");
        }//choice
        System.out.println();
        System.out.println();
        y++;
    
    }
      for(int u=0;u<13;u++)
      {
      double result = (double) sum[u]/ (double)success[u]; //average execution cost
      double result2 = (double) sum2[u] /(double)success[u];
      double result3 = (result) /(double) 100;
      double result4 = (result2) / (double) 100;
      System.out.println(heuristics[u]+"    cost: " +result +"      time: " + result2);
      bw[u].close();
      }
      System.out.println(debug);
      System.out.println(y);
      System.out.println();
      System.out.println();
      for(int i=0;i<13;i++)
      {
          System.out.println(success[i]);
      }
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
    
    private static int executeRandom(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)//Random selection strategy
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
            path.add(key);
            double prob = Double.parseDouble(temp13[temp13.length-1]);
            int result = productions.get(key);
            if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
            {
                available.add(temp13[temp13.length-4]);
                //System.out.println("Op" + key+ "," + temp13[temp13.length-4]);
            }
            else //execution was unsuccessful and therefore the element was not produced
            {
                //System.out.println("Op" + key+ "," + temp13[temp13.length-4] + " fail");
            }
            
            
            
            break;
           }
           
           count++;
                   
        }
        
        return key;
    }
    
    private static int executeLowestCost(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)//Lowest Cost selection strategy
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
        path.add(key);
        int result = productions.get(key);
        
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeShortestTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,HashMap<Integer,Integer> productions, HashSet<Integer> path)
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
          cost[i][1]= Double.parseDouble(temp15[temp15.length-3]);
          
          i++;
        }
        int key = (int)getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        
        return key;
    }
    
    private static int executeLowestFail(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)
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
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
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
    
     private static int executionOld(double prob)// function that takes the input the success probability of a rule and executes it
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
    
    private static int rootDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,int [][] graph, HashMap<Integer,Integer> productions, HashSet<Integer> path)
    {
        
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 18);
        
        
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
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int costDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,double [][] graph, HashMap<Integer,Integer> productions, HashSet<Integer> path)
    {
        
        
        ShortestPathDouble s = new ShortestPathDouble(); 
        double[] dist = s.dijkstra(graph, 18);
        
        
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
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
    private static int costDistanceNew(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)
    {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
        
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
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
          
    }
    
     
    
    private static int timeDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,double[][] graph, HashMap<Integer,Integer> productions, HashSet<Integer> path)
    {
        
        
        ShortestPathDouble s = new ShortestPathDouble(); 
        double[] dist = s.dijkstra(graph, 18);
        
        
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
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
    }
    
     
      
      
   private static int knockoutPath(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions,HashSet<Integer> prune, HashMap<String,Integer> failures, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
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
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
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
            prune(operations,key,prune,failures);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBoth(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions,HashSet<Integer> prune, HashMap<String,Integer> failures, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
        
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
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
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
            prune(operations,key,prune,failures);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBothTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions,HashSet<Integer> prune, HashMap<String,Integer> failures, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
        
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
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
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
            prune(operations,key,prune,failures);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int knockoutPathPruneBothCombo(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions,HashSet<Integer> prune, HashMap<String,Integer> failures, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Double.parseDouble(dokimi[limit+1]) + Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
        
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
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           String index = temp15[limit-1];
           int ind = Integer.parseInt(index.replace("i",""));
           double denominator = dist[ind];
           double numerator = distProb[ind];
           if(denominator==0 && numerator !=0)
           {
               
               denominator=1;
           }
           cost[i][1] = numerator/denominator;   
          }
          
          
          i++;
        }
        int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
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
            prune(operations,key,prune,failures);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   
   
   private static int knockoutPathOld(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)
   {
    double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
        //w
        
        //w
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
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
          
   }
    
    
   private static int knockoutPathTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                graph[two][one]=Double.parseDouble(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
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
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   
   private static int knockoutPathCombo(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> productions, HashSet<Integer> path)
   {
        double graph[][] = new double[52][52];
        double graph2[][] = new double [52][52];
        for(int l=0;l<52;l++)
        {
            for(int p=0;p<52;p++)
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
                //graph[one][two]=Double.parseDouble(dokimi[limit]);
                
                graph[two][one]=Double.parseDouble(dokimi[limit])+Double.parseDouble(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        double dist[] = new double[52];
        double distProb[] = new double[52];
        ShortestPathDouble tp = new ShortestPathDouble();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 18);
        distProb = tpp.dijkstra(graph2, 18);
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
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        path.add(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            //System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
        }
        return key;
        
       
   }
   
   private static int createArrayRoot(HashMap<Integer,String[]> operations,int[][] graph)
   {
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
                
                if(Double.parseDouble(dokimi[dokimi.length-2])==0)
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
        return 1;
   }
   
    private static int createArrayCost(HashMap<Integer,String[]> operations,double[][] graph)
   {
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
                graph[one][two] = Double.parseDouble(dokimi[limit+1]);
                
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
               
                
             }
            }
            
        }
       
        return 1;
   }
    
   private static int createArrayTime(HashMap<Integer,String[]> operations,double[][] graph)
   {
        
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
                graph[one][two] = Double.parseDouble(dokimi[limit]);
                
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
                graph[two][one]=Double.parseDouble(dokimi[limit]);
               
                
             }
            }
            
        }
       
       
        return 1;
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
           int result = executionOld(prob);
           productions.put(key, result);
       }
             
       return 1;
   }
   
    private static void pruneOperations(HashMap<Integer,String[]> operations, int key, HashSet<Integer> prune)
   {
        String[] entry = (String []) operations.get(key);
        String output = entry[entry.length-4];
        //System.out.println(output);
        
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
            //System.out.println(count + " na doume");
            return;
        }
        else
        {
            
               // System.out.println(count + ",   " + output);
            
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
          //System.out.println(cand);
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
                  //System.out.println(entry.getKey());
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
                   //System.out.println((Integer)entry.getKey());
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
          //System.out.println(cand);
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
                  //System.out.println(entry.getKey());
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
              //System.out.println(two);
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
            //System.out.println("na doume");
        }
        
        
       
    }
  
  private static double findOperationCost(HashMap<Integer,String[]> operations, int key)
   {
       double result=11;
       String output;
        if(key<10)
        {
           output = "i0".concat(String.valueOf(key));
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
               if(Double.parseDouble(operation[operation.length-2])<result)
               {
                   result = Double.parseDouble(operation[operation.length-2]);
               }
           }
           
       }
       if(result==11)
       {
           System.out.println(key);
       }
       return result;
   }
    
    
    
}