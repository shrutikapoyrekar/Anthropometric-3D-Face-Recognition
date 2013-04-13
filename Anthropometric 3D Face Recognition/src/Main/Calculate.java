/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Points.*;
import java.sql.*;
import java.util.ArrayList;
public class Calculate 
{
    Connection con;
    Statement stmt;
    Point nose, leftnose,rightnose ,root, rightinner, leftinner,leftouter,rightouter,leftmouth,rightmouth;
    Edge al1,al2,in1, in2, r1, o1,o2,m1,m2;
    public ArrayList nosedist=new ArrayList();
    Calculate(String path)
    {
        ReadFile r = new ReadFile(path);
        
        r.NoseTip();        //r.define_Area_For_Nose_Width();
        r.Nose_Width();
        r.innerEyeCorner();
        r.noseCenter();
        r.outerEyeCorners();
        r.mouthCornerLeft();
        r.mouthCornerRight();
        
         nose =r.nose;
         leftnose=r.al;
         rightnose =r.ar;
         root = r.root;
         leftinner=r.inner1;
         rightinner=r.inner2;
         leftouter=r.outer1;
         rightouter=r.outer2;
         leftmouth=r.mouthl;
         rightmouth =r.mouthr;   
         
          al1=new Edge(nose,leftnose);
         al2=new Edge(nose,rightnose);
         in1=new Edge(nose,leftinner);
         in2=new Edge(nose,rightinner);
         r1=new Edge(nose,root);
         o1=new Edge(nose,leftouter);
         o2=new Edge(nose,rightouter);
         m1=new Edge(nose,leftmouth);
         m2=new Edge(nose,rightmouth);
         //AdddistanceNose(2);
         try
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Connecting....");//not required used just for testing
            con = DriverManager.getConnection("jdbc:oracle:thin:system/123@localhost:1521:XE");
            System.out.println("Connected....");
            stmt = con.createStatement();
        }
        catch(Exception e)
        {
            
        }
         
    }
    public void AdddistanceNose(int ID)
    {
         
        
        nosedist.add(al1.d);
        nosedist.add(al2.d);
        nosedist.add(in1.d);
        nosedist.add(in2.d);
        nosedist.add(r1.d);
        nosedist.add(o1.d);
        nosedist.add(o2.d);
        nosedist.add(m1.d);
        nosedist.add(m2.d);
        
        System.out.println(al1.d);
        System.out.println(al2.d);
        System.out.println(in1.d);
        System.out.println(in2.d);
        System.out.println(r1.d);
        System.out.println(o1.d);
        System.out.println(o2.d);
        System.out.println(m1.d);
        System.out.println(m2.d);
        
        System.out.println("outside try");
        try
        {
            System.out.println(ID);
            String sql ="Insert into NoseTipE (al1, al2, in1, in2, r, o1, o2, m1, m2, REFERENCEID) values (";
            sql=sql+al1.d+","+al2.d+","+in1.d+","+in2.d+","+r1.d+","+o1.d+","+o2.d+","+m1.d+","+m2.d+","+ID+")";
            System.out.println(sql);
            stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        //new Add(nosedist)
    }
    
    public int recognize()
    {
        ResultSet rs ;
        try
        {
            rs = stmt.executeQuery("Select * from NoseTipE");
            while(rs.next())
            {
                float fal1=Math.abs((float) (Float.parseFloat(rs.getString("al1"))-al1.d));
                float fal2=Math.abs((float) (Float.parseFloat(rs.getString("al2"))-al2.d));
                float fin1=Math.abs((float) (Float.parseFloat(rs.getString("in1"))-in1.d));
                float fin2=(float) (Float.parseFloat(rs.getString("in2"))-in2.d);
                float fr=(float) (Float.parseFloat(rs.getString("r"))-r1.d);
                float fo1=(float) (Float.parseFloat(rs.getString("o1"))-o1.d);
                float fo2=(float) (Float.parseFloat(rs.getString("o2"))-o2.d);
                float fm1=(float) (Float.parseFloat(rs.getString("m1"))-m1.d);
                float fm2=(float) (Float.parseFloat(rs.getString("m2"))-m2.d);
                fin2=Math.abs(fin2);
                fr=Math.abs(fr);
                fo1=Math.abs(fo1);
                fo2=Math.abs(fo2);
                fm1=Math.abs(fm1);
                fm2=Math.abs(fm2);
                int id = Integer.parseInt(rs.getString("REFERENCEID"));
                
                if(fal1<1 && fal2<1 && fr<1 && fo1<1 && fo2<1 && fm1<1 && fm2<1 && fin1<1 && fin2<1)
                {
                    System.out.println(id);
                    return id;
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return -1;
    }
    public static void main(String args[])
    {
        new Calculate("C:/Users/Shrutika/Documents/NetBeansProjects/Proj/New folder/2.wrl");
    }
}
