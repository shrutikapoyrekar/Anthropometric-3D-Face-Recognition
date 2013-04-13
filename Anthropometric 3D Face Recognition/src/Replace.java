/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shrutika
 */
import java.io.*;
public class Replace 
{
    public static void main (String args[])
    {
        try
          {
          // Open the file that is the first 
          // command line parameter
          FileInputStream fstream = new FileInputStream("C:/Users/Shrutika/Documents/NetBeansProjects/Proj/New folder/2.wrl");
          // Get the object of DataInputStream
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          //Read File Line By Line

           FileWriter fstream1 = new FileWriter("out1.wrl");
          BufferedWriter out = new BufferedWriter(fstream1);

          //int i=0;

          int n=1;
          int k=5605;
          while ((strLine = br.readLine()) != null)   
          {
             if(strLine.contains("Color { "))
             {
                 
                 n++;
                 while ((strLine = br.readLine()) != null)  
                 {
                     n++;
                     if(n==k)
                     {
                         System.out.println(strLine);
                         out.write("\t\t\t0 0 0,");
                         out.newLine();
                         break;

                     }
                     else
                         out.write(strLine);

                     out.newLine();
                 }
             }
             out.write(strLine);
             
             out.newLine();
          }
          //Close the input stream
          in.close();
          out.close();

            }catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
          }
    }
}
