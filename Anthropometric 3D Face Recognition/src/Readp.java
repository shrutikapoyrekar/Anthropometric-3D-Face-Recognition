/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shrutika
 */
import java.io.*;
public class Readp {
    public static void main(String args[])
  {
       String m="";
  try
  {
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("C:/Users/Shrutika/Desktop/points.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  
   FileWriter fstream1 = new FileWriter("out1.txt");
  BufferedWriter out = new BufferedWriter(fstream1);
  
  //int i=0;
 
  int n=0;
  while ((strLine = br.readLine()) != null)   
  {
      String s[]=strLine.split(",");
      
     
     m+=s[0]+";";
     n++;
      
  // Print the content on the console
  //System.out.println (strLine);
  }
  //Close the input stream
  in.close();
  
  //out.close();
  
  System.out.println("DOne");
  String s[]=m.split(";");
        double ar[][]=new double[s.length][3];
  double x[]=new double[s.length];
  for(int i=0;i<s.length;i++)
  {
      s[i]=s[i].trim();
      String t[]=s[i].split(" ");
      ar[i][0]=Double.parseDouble(t[0]);
      ar[i][1]=Double.parseDouble(t[1]);
      ar[i][2]=Double.parseDouble(t[2]);
      out.write(ar[i][2]+" ");
      out.newLine();
      x[i]=Double.parseDouble(t[2]);
  }
  double max=-10000;
  int ink=0;
  for( int j=0;j<s.length;j++)
      if(x[j]>max)
      {
          max=x[j];
          ink=j;
      }
  
  System.out.println(max+" "+in);
  out.close();
  
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  
  }
    
}
