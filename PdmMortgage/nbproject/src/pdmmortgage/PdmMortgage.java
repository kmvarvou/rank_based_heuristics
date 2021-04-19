/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdmmortgage;

/**
 *
 * @author kostis
 */
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
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner; 


/**
 *
 * @author Κωστής
 */
public class PdmMortgage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
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
        int[] sum = new int [13];
        int[] sum2= new int [13];
        double[] deviation = new double [13]; 
        int[] optimal = new int [13];
        int[] success = new int [13];
        int[] failure = new int [13];
        int[] early = new int[13];
        int[] cost_failure = new int[13]; 
        int debug=0;
        int malakies =0;
        PrintWriter[] pw = new PrintWriter[13];
        String[] heuristics = {"Random","Lowest Cost","Shortest Time","Lowest Fail Probability","Root Distance","Cost Distance","Time Distance","Rank-based ","Rank-based Time","Rank-based Combination","Rank-based extended","Rank-Based extended Time","Rank-Based extended Combo"};
        while(y<13)
        {
           String filename = heuristics[y] + ".txt";
           pw[y] = new PrintWriter(new FileWriter(filename));
           y++;
        }
        y=0;
        while(y<10000)
        {
        Integer cost =0,time=0;
        RandomGaussian gaussian = new RandomGaussian();
        double min =0.001, max =1.0;
        
        int minInt=0, maxInt=10;
        Random r = new Random();
        
        HashMap<Integer, String[]> operations = new HashMap();
        
        double random;
        int result;
        
        if(s==1)
        {
            String[] temp = {"B","C","D","A","1","5","0.95"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp[temp.length-1])));
            result = gaussian.getRandInt(Double.parseDouble(temp[temp.length-2]));
            temp[temp.length-1] = String.valueOf(random);
            temp[temp.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp[temp.length-3]));
            temp[temp.length-3] = String.valueOf(result);
            operations.put(1,temp);
            String[] temp2 = {"F","G","H","C","4","5","0.95"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp2[temp2.length-1])));
            temp2[temp2.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp2[temp2.length-2]));
            temp2[temp2.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2((Double.parseDouble(temp2[temp2.length-3])));
            temp2[temp2.length-3] = String.valueOf(result);
            operations.put(2,temp2);
            String[] temp3 = {"H","A","3","9","0.95"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp3[temp3.length-1])));
            temp3[temp3.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp3[temp3.length-2]));
            temp3[temp3.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2((Double.parseDouble(temp3[temp3.length-3])));
            temp3[temp3.length-3] = String.valueOf(result);
            operations.put(3,temp3);
            String[] temp4 = {"E","A","2","2","1"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp4[temp4.length-1])));
            temp4[temp4.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp4[temp4.length-2]));
            temp4[temp4.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2((Double.parseDouble(temp4[temp4.length-3])));
            temp4[temp4.length-3] = String.valueOf(result);
            operations.put(4,temp4);
            String[] temp5 = {"B","0","0","1"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp5[temp5.length-1])));
            temp5[temp5.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp5[temp5.length-2]));
            temp5[temp5.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp5[temp5.length-3]));
            temp5[temp5.length-3] = String.valueOf(result);
            operations.put(5,temp5);
            String[] temp6 = {"D","0","0","1"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp6[temp6.length-1])));
            temp6[temp6.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp6[temp6.length-2]));
            temp6[temp6.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp6[temp6.length-3]));
            temp6[temp6.length-3] = String.valueOf(result);
            operations.put(6,temp6);
            String[] temp7 = {"E","1","1","0.5"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp7[temp7.length-1])));
            temp7[temp7.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp7[temp7.length-2]));
            temp7[temp7.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp7[temp7.length-3]));
            temp7[temp7.length-3] = String.valueOf(result);
            operations.put(7,temp7);
            String[] temp8 = {"F","0","0","1"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp8[temp8.length-1])));
            temp8[temp8.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp8[temp8.length-2]));
            temp8[temp8.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp8[temp8.length-3]));
            temp8[temp8.length-3] = String.valueOf(result);
            operations.put(8,temp8);
            String[] temp9 = {"G","2","0","1"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp9[temp9.length-1])));
            temp9[temp9.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp9[temp9.length-2]));
            temp9[temp9.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp9[temp9.length-3]));
            temp9[temp9.length-3] = String.valueOf(result);
            operations.put(9,temp9);
            String[] temp10 = {"H","10","3","0.85"};
            random = gaussian.getRandProb(1-(Double.parseDouble(temp10[temp10.length-1])));
            temp10[temp10.length-1] = String.valueOf(random);
            result = gaussian.getRandInt(Double.parseDouble(temp10[temp10.length-2]));
            temp10[temp10.length-2] = String.valueOf(result);
            result = gaussian.getRandInt2(Double.parseDouble(temp10[temp10.length-3]));
            temp10[temp10.length-3] = String.valueOf(result);
            operations.put(10,temp10);
        }
        else
        {
            random = ThreadLocalRandom.current().nextDouble(min, max);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            String[] temp = {"B","C","D","A","1","5","0.95"};
            temp[temp.length-1] = String.valueOf(random);
            temp[temp.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp[temp.length-3] = String.valueOf(result);
            operations.put(1,temp);
            String[] temp2 = {"F","G","H","C","4","5","0.95"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp2[temp2.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp2[temp2.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp2[temp2.length-3] = String.valueOf(result);
            operations.put(2,temp2);
            String[] temp3 = {"H","A","3","9","0.95"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp3[temp3.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp3[temp3.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp3[temp3.length-3] = String.valueOf(result);
            operations.put(3,temp3);
            String[] temp4 = {"E","A","2","2","1"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp4[temp4.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp4[temp4.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp4[temp4.length-3] = String.valueOf(result);
            operations.put(4,temp4);
            String[] temp5 = {"B","0","0","1"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp5[temp5.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp5[temp5.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp5[temp5.length-3] = String.valueOf(result);
            operations.put(5,temp5);
            String[] temp6 = {"D","0","0","1"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp6[temp6.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp6[temp6.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp6[temp6.length-3] = String.valueOf(result);
            operations.put(6,temp6);
            String[] temp7 = {"E","1","1","0.5"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp7[temp7.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp7[temp7.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp7[temp7.length-3] = String.valueOf(result);
            operations.put(7,temp7);
            String[] temp8 = {"F","0","0","1"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp8[temp8.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp8[temp8.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp8[temp8.length-3] = String.valueOf(result);
            operations.put(8,temp8);
            String[] temp9 = {"G","2","0","1"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp9[temp9.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp9[temp9.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp9[temp9.length-3] = String.valueOf(result);
            operations.put(9,temp9);
            String[] temp10 = {"H","10","3","0.85"};
            random = ThreadLocalRandom.current().nextDouble(min, max);
            temp10[temp10.length-1] = String.valueOf(random);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp10[temp10.length-2] = String.valueOf(result);
            result = r.nextInt((maxInt - minInt) + 1) + minInt;
            temp10[temp10.length-3] = String.valueOf(result);
            operations.put(10,temp10);
        }
        HashMap<Integer,String[]> operations_graph = (HashMap) operations.clone();
        HashMap<Integer,String[]> operations_opt = (HashMap) operations.clone();
        Iterator print = operations.entrySet().iterator();
        
        String[] complete= {"7 4","10 3","10 9 8 2 5 6 1"};
        int[] path_costs = new int[3];
        int[] check;
        
        for(int i=0;i<complete.length;i++)
        {
            
            String[] temp_op = complete[i].split(" ");
            for(int j=0;j<temp_op.length;j++)
            {
                String[] temp_op2 = operations.get(Integer.parseInt(temp_op[j]));
                path_costs[i] += Integer.parseInt(temp_op2[temp_op2.length-2]);
            }
        }
        
        
        int temp_cost;
        String temp_path;
        for (int i = 0; i <path_costs.length; i++) {     
          for (int j = i+1; j <path_costs.length; j++) {     
              if(path_costs[i] >path_costs[j]) {      //swap elements if not in order
                 temp_cost = path_costs[i];
                 temp_path = complete[i];
                 complete[i] = complete[j];
                 path_costs[i] = path_costs[j];    
                 path_costs[j] = temp_cost;
                 complete[j] = temp_path;
               }     
            }     
        }
        int count = 10;
        int choice =0;
        List<Map<Integer, String[]>> listOfMaps = new ArrayList<Map<Integer, String[]>>();
        int u=0;
         
        
        while(u<13)
        {
           listOfMaps.add((HashMap) operations.clone());
           u++;
          
           
        }
        HashMap<Integer,Integer> productions = new HashMap<Integer,Integer>();
        determineExecutionInstance(operations,productions);
        while(choice<13)
        {
        cost=0;
        time=0;
        operations= (HashMap)listOfMaps.get(choice);
        HashMap<Integer,String[]> executable = new HashMap();
        
        HashSet<String> available = new HashSet();
        HashMap<Integer,Integer> path = new HashMap<Integer,Integer>();
        HashSet<Integer> prune = new HashSet<Integer>();
        
        
        
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
          
           if(executable.isEmpty())//execution has completed since the production of A is no longer possible
           {
               if(choice==0)
               {
                   check = new int[complete.length];
                   for(int i=0;i<check.length;i++)
                   {
                       String optemp = complete[i];
                       String[] optemp2 = optemp.split(" ");
                       for(int j=0;j<optemp2.length;j++)
                       {
                           if(path.containsKey(Integer.parseInt(optemp2[j])))
                           {
                            Integer op = path.get(Integer.parseInt(optemp2[j]));
                            if(op.equals(1))
                            {
                               check[i]+=1;
                            }
                           }
                       }
                   }
                   
                   for(int i=0;i<check.length;i++)
                   {
                       if(check[i]==0)
                       {
                           
                           
                           //break;
                       }
                   }
                   
               }
               
               System.out.println("cost: " + cost + "     time: " + time);
               System.out.println("");
               String filename = heuristics[choice] + ".txt";
               
               //pw[choice].println((y+1)+","+cost+","+time);
               cost_failure[choice] +=cost;
               failure[choice]+=1;
               
              
               break;
           }
           
           int key;
           if(choice==0)
           {
               key=executeRandom(executable,available,operations,path,productions);
               //key=executeLowestCost(executable,available,operations);
               //key=executeShortestTime(executable,available,operations);
               //key=executeLowestFail(executable,available,operations);
               //key=rootDistance(executable,available,operations_graph);
               //key=knockoutPath(executable,available,operations_graph);
               //key=knockoutPathTime(executable,available,operations_graph);
               //key=knockoutPathComb(executable,available,operations_graph); 
               //key=costDistance(executable,available,operations_graph);
               //key=timeDistance(executable,available,operations_graph);
           }
           else if(choice==1)
           {
              key=executeLowestCost(executable,available,operations,path,productions);
             
           }
           else if(choice==2)
           {
              key=executeShortestTime(executable,available,operations,path,productions); 
           }
           else if(choice==3)
           {
              key=executeLowestFail(executable,available,operations,path,productions);
           }
           else if(choice==4)
           {
              key=rootDistance(executable,available,operations_graph,path,productions);
           }
           else if(choice==5)
           {
               key=costDistance(executable,available,operations_graph,path,productions);
               
           }
           else if(choice==6)
           {
               
               key=timeDistance(executable,available,operations_graph,path,productions);
           }
           else if(choice==7)
           {
              key=knockoutPath(executable,available,operations_graph,path,productions,complete);
              
              
           }
           else if(choice==8)
           {
              key=knockoutPathTime(executable,available,operations_graph,path,productions,complete);
              
           }
           else if (choice==9)
           {
               key=knockoutPathComb(executable,available,operations_graph,path,productions);
           }
           else if (choice==10)
           {
              key=knockoutPathPruneBoth(executable,available,operations_graph,path,productions,complete,prune);
           }
           else if(choice== 11)
           {
              key=knockoutPathPruneBothTime(executable,available,operations_graph,path,productions,complete,prune);
           }
           else
           {
               key=knockoutPathPruneBothCombo(executable,available,operations_graph,path,productions,complete,prune);
           }
           //int key=executeRandom(executable,available,operations);
           //int key = executeLowestCost(executable,available,operations);
           //int key = executeShortestTime(executable,available,operations);
           //int key = executeLowestFail(executable,available,operations);
           //int key = rootDistance(executable,available,operations);
           //int key = knockout2Path(executable,available,operations);
           
           String[] temp14 = operations.get(key);
           int cost2 = Integer.valueOf(temp14[temp14.length-2]);
           cost = cost + cost2; //cost of the entire path is calculated in a step by step manner
           int time2 = Integer.valueOf(temp14[temp14.length-3]);
           
           time = time + time2;
           operations.remove(key);//operation is removed from the list of operations as it is no longer available
           if(available.contains("A"))//if A has been produced then the execution is completed
           {
               success[choice]+=1;
              
                   check = new int[complete.length];
                   for(int i=0;i<check.length;i++)
                   {
                       String optemp = complete[i];
                       String[] optemp2 = optemp.split(" ");
                       for(int j=0;j<optemp2.length;j++)
                       {
                           if(productions.containsKey(Integer.parseInt(optemp2[j])))
                           {
                            Integer op = productions.get(Integer.parseInt(optemp2[j]));
                            if(op.equals(1))
                            {
                               check[i]+=1;
                            }
                           }
                           
                       }
                   }
                   
                   int cp =0;
                   int cost_f =0;
                   int cost_opt =0;
                   for(int i=0;i<check.length;i++)
                   {
                       if(check[i]==0)
                       {
                           
                           
                           cp=i;
                           
                           break;
                       }
                   }
                    cost_opt = path_costs[cp];
                    Iterator it_productions = productions.entrySet().iterator();
                    while(it_productions.hasNext())
                    {
                       HashMap.Entry entry = (HashMap.Entry) it_productions.next();
                       if(entry.getValue().equals(1))
                       {
                           
                           String[] operation_temp = (String[]) operations_opt.get((Integer)entry.getKey());
                           
                           //cost_f += Integer.parseInt(operation_temp[operation_temp.length-2]);
                       }
                    }
                    int temp_m = cost_f + cost_opt;
                    optimal[choice] += cost_opt;
                    deviation[choice] += (cost - temp_m);
                   
               
               System.out.println("cost: " + cost + "     time: " + time);
               System.out.println("");
               pw[choice].println(cost+","+time);
               
                   debug++;
               
               sum[choice] += cost;
              sum2[choice] += time;
               break;
           }
           
           
           
           
            
           
            
            
        }
        
        choice++;
        }//neo while
        System.out.println();
        System.out.println();
        y++;
    
    }
       
      for(int i=0;i<13;i++)
      {
       double result = (double) sum[i]/ (double)success[i]; //average execution cost
       pw[i].close();
       double result2 = (double) sum2[i]/ (double)success[i];
       double result3 = (double) deviation[i]/(double)success[i];
       
       System.out.println(heuristics[i] +" cost: " + result +  "  time: " +result2 + "   deviation:  " + result3 );
          
      }
      
      for(int i=0;i<13;i++)
      {
       System.out.println(success[i]);   
      }
      
      
      
      
      System.out.println(debug);
      //double result = (double) sum/ (double)y; //average execution cost
      //System.out.println(result);
      //double result2 = (double) sum2/ (double)y;
      //System.out.println(result2);
     }
    
    private static int getRandomNumberInRange(int min, int max) 
    {
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
    
    private static int executeRandom(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)//Random selection strategy
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
                path.put(key,0);
                available.add(temp13[temp13.length-4]);
                System.out.println("Op" + key+ "," + temp13[temp13.length-4]);
            }
            else //execution was unsuccessful and therefore the element was not produced
            {
                path.put(key,1);
                System.out.println("Op" + key+ "," + temp13[temp13.length-4] + " fail");
            }
            
            
            
            break;
           }
           
           count++;
                   
        }
        
        return key;
    }
    
    private static int executeLowestCost(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)//Lowest Cost selection strategy
    {
        int n = input.size();
        int[][] cost = new int [n][3];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();
          cost[i][0]= (Integer) pair.getKey();
          String[] temp15= (String[]) pair.getValue();
          cost[i][1]= Integer.parseInt(temp15[temp15.length-2]);
          
          i++;
        }
        int key =getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key,0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key,1);
        }
        
        return key;
    }
    
    private static int executeShortestTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations,HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
    {
        int n = input.size();
        int[][] cost = new int [n][3];
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
        int key =getMinValue(cost);
        
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        
        return key;
    }
    
    private static int executeLowestFail(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
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
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        
        return key;
    }
    
    public static int getMinValue(int[][] numbers)
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
                //System.out.println("min ranking " + (numbers[index][0]) );
		return numbers[index][0];
	}
    
    public static int getMinValueDouble(double[][] numbers)
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
                //System.out.println("min ranking " + (numbers[index][0]) );
		return (int) numbers[index][0];
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
    
    
    
    private static int rootDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = 1;
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=1;
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          char tempstring = temp15[temp15.length-4].charAt(0);
          int tempint = tempstring - 'A' +1;
          
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
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        return key;
    }
    
    private static int costDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                graph[i][j]=-1;
            }
        }
        if(operations.size()<10)
        {
            
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[dokimi.length-2]);
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=Integer.parseInt(dokimi[dokimi.length-2]);
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
        
        for(int i=0;i<dist.length;i++)
        {
            //System.out.println("dist: " + dist[i]);
        }
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          char tempstring = temp15[temp15.length-4].charAt(0);
          int tempint = tempstring - 'A' +1;
          
            cost[i][1] = dist[tempint];  //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance 
            //System.out.println("Op:" + tempkey + "  cost: " + cost[i][1]);
          
          i++;
          
        }
        for(int j=0;j<n;j++)
        {
          //System.out.println(cost[j][0] + "cost: " + cost[j][1]);  
        }
        //System.out.println();
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
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        return key;
    }
    
    private static int costDistanceNew(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[9][9];
        double graph2[][] = new double[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                graph[i][j]=-1;
                graph[i][j]=-1;
            }
        }
        if(operations.size()<10)
        {
            
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[dokimi.length-2]);
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=Integer.parseInt(dokimi[dokimi.length-2]);
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath();
        ShortestPathProb sp = new ShortestPathProb();
        int[] dist = s.dijkstra(graph, 1);
        double[] distProb = sp.dijkstra(graph2, 1);
        int[] dist2 = new int[dist.length];
        for(int f=1;f<dist.length;f++)
        {
            prune2(operations,f,graph,dist2);
        }
        for(int f=1;f<dist.length;f++)
        {
           dist[f] += dist2[f];
        }        
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
          int limit =  temp15.length-3; //in the case wherethere are >=1 input elements the one that has the biggest distance represents the distance
            
          if(limit==1)
          {
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;   
          }
            //System.out.println("Op:" + tempkey + "  cost: " + cost[i][1]);
          
          i++;
          
        }
        for(int j=0;j<n;j++)
        {
          //System.out.println(cost[j][0] + "cost: " + cost[j][1]);  
        }
        //System.out.println();
         int key = (int) getMaxValue(cost); // the rule with the lowest value(distance from root) is selected for execution
        //System.out.println(key);
        String[] temp16 = input.get(key);
        double prob = Double.parseDouble(temp16[temp16.length-1]);
        input.remove(key);
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        return key;
    }
    
    private static int timeDistance(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
    {
        int graph[][] = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[dokimi.length-3]);
               
                
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                
                graph[two][one]=Integer.parseInt(dokimi[dokimi.length-3]);
               
                
                
             }
            }
            
        }
        
        
        
        ShortestPath s = new ShortestPath(); 
        int[] dist = s.dijkstra(graph, 1);
       
        
        int n = input.size();
        int[][] cost = new int [n][2];
        Iterator t = input.entrySet().iterator();
        int i=0;
        while(t.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry) t.next();  // takes from the dist array, which contains the distance from root for all operations, the distances
          String[] temp15= (String[]) pair.getValue(); // of the available for execution operations and saves them in the cost array
          int tempkey = (Integer) pair.getKey();
          cost[i][0] = tempkey;
          char tempstring = temp15[temp15.length-4].charAt(0);
          int tempint = tempstring - 'A' +1;
          
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
            path.put(key, 0);
            
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        return key;
    }
    
    
    
    
    
    
    
     
     
   
   
private static int knockoutPath(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions, String[] complete)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            //pruneOperations(operations,key,complete);
        }
        return key;
        
       
   }

private static int knockoutPathPrune(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions, String[] complete, HashSet<Integer> prune)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            prune(operations,key,prune);
        }
        return key;
        
       
   }

  private static int knockoutPathPruneBoth(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions, String[] complete, HashSet<Integer> prune)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int[] dist2 = new int[dist.length];
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            prune(operations,key,prune);
        }
        return key;
        
       
   }
  
  private static int knockoutPathPruneBothTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions, String[] complete, HashSet<Integer> prune)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int[] dist2 = new int[dist.length];
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            prune(operations,key,prune);
        }
        return key;
        
       
   }
  
  private static int knockoutPathPruneBothCombo(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions, String[] complete, HashSet<Integer> prune)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]) + Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]) + Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
        ShortestPathProb tpp = new ShortestPathProb();
        dist = tp.dijkstra(graph, 1);
        distProb = tpp.dijkstra(graph2, 1);
        int[] dist2 = new int[dist.length];
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            prune(operations,key,prune);
        }
        return key;
        
       
   }
   
   
   private static int knockoutPathTime(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions,String[] complete)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
            //System.out.println(input.size() + "     before");
            //pruneOperations(operations,key,prune);
            //System.out.println(prune.size());
            //System.out.println(input.size()+ " after");
        }
        return key;
        
       
   }
   
   private static int knockoutPathComb(HashMap<Integer,String[]> input, HashSet<String> available, HashMap<Integer,String[]> operations, HashMap<Integer,Integer> path, HashMap<Integer,Integer> productions)
   {
        int graph[][] = new int[9][9];
        double graph2[][] = new double [9][9];
        for(int l=0;l<9;l++)
        {
            for(int p=0;p<9;p++)
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
                int two = dokimi[0].charAt(0) - 'A' + 1;
                graph[one][two] = Integer.parseInt(dokimi[limit+1]) + Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                graph2[one][two] = 1 - prob;
            }
            else
            {
             for(int y=0;y<limit-1;y++)
             {
                int one = dokimi[y].charAt(0) - 'A' + 1;
                int two = dokimi[limit-1].charAt(0) - 'A' +1;
                //graph[one][two]=Integer.parseInt(dokimi[limit]);
                graph[two][one]=Integer.parseInt(dokimi[limit+1]) + Integer.parseInt(dokimi[limit]);
                double prob = Double.parseDouble(dokimi[limit+2]);
                //graph2[one][two] = 1 - prob;
                graph2[two][one] = 1 - prob;
                
             }
            }
            
        }
        
        int dist[] = new int[operations.size()+1];
        double distProb[] = new double[operations.size()+1];
        ShortestPath tp = new ShortestPath();
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
           char index = temp15[0].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
           double numerator = distProb[ind];
           cost[i][1] = numerator/denominator;
              
          }
          else
          {
           char index = temp15[limit-1].charAt(0);
           int ind = index - 'A' +1;
           int denominator = dist[ind];
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
        int result = productions.get(key);
        if(result ==1) // the execution was successful and therefore the element is produced and added to the set of available elements
        {
            available.add(temp16[temp16.length-4]);
            System.out.println("Op" + key+ "," + temp16[temp16.length-4]);
            path.put(key, 0);
        }
        else //execution was unsuccessful and therefore the element was not produced
        {
            System.out.println("Op" + key+ "," + temp16[temp16.length-4] + " fail");
            path.put(key, 1);
        }
        return key;
        
       
   }
   
   public static void printD(double mat[]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++) 
        {
            // Loop through all elements of current row 
            System.out.println(mat[i]);
        }
        System.exit(0);
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
   
   private static void prune(HashMap<Integer,String[]> operations, int key, HashSet<Integer> prune)
    {
        Iterator it = operations.entrySet().iterator();
        String[] operation = (String[])operations.get(key);
        String output = operation[operation.length-4];
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
   
   private static void prune2(HashMap<Integer,String[]> operations, int key, int[][] dist, int[] dist2)
    {
        Iterator it = operations.entrySet().iterator();
        String[] operation = (String[])operations.get(key);
        HashSet<Integer> prune = new HashSet();
        String output = getCharForNumber(key);
        
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
              
              int two = cand.charAt(0) - 'A' + 1;
              //System.out.println(two);
              if(dist[0][key]!=-1)
              {
              dist2[two]+=dist[0][key];
              }
              else
              {
              dist2[two]+=findOperationCost(operations,key);
              }
              //int dist3[] = new int[dist2.length];
              //ShortestPath tp = new ShortestPath();
              //dist3 = tp.dijkstra(dist, key);
              //dist2[two]+=dist3[0];
          }
        }
        
        
        
       
    }
   
   private static String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
}
   
private static int findOperationCost(HashMap<Integer,String[]> operations, int key)
   {
       int result=11;
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
    
     
    
}