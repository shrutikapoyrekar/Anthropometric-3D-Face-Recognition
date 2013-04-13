/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Shrutika
 */

import Points.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class ReadFile 
{
    ArrayList list=new ArrayList();
    ArrayList edges=new ArrayList();
    Point nose;
    Point al,ar;
    float d1=(float) 0.0;
    float d2=(float) 0.0;
    Point inner1=null,inner2=null;
    Point root=null;
    Point mouthl=null,mouthr=null;
    Point outer1=inner1,outer2=inner2;
    public ReadFile(String path) throws java.util.regex.PatternSyntaxException
    {
        try
        {
              FileInputStream fstream = new FileInputStream(path);
              // Get the object of DataInputStream
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader br = new BufferedReader(new InputStreamReader(in));
              String s="";                          
              //now read the file              
              while((s=br.readLine())!=null)
              {
                  //System.out.println(s);
                  if(s.contains("Coordinate "))
                  {
                      //System.out.println(s);
                      
                      //next line onwards i get points
                      String a=br.readLine();
                      //System.out.println(a);
                      if(a!=null)
                      {
                          a=a.trim();
                          //System.out.println(a);
                          String t1[]=a.split(" ");
                          //t1[2]=t1[2].trim();
                          //System.out.println(t1[5]);  // the character are 3,4,5 :)
                          float x,y,z;
                          x=Float.parseFloat(t1[3]);
                          y=Float.parseFloat(t1[4]);
                          String t2[]=t1[5].split(",");
                          z=Float.parseFloat(t2[0]);
                          //System.out.println(x+" "+y+" "+z);
                          Point p = new Point(x,y,z);
                          list.add(p);
                          //break;
                      }
                      while((a=br.readLine())!=null)
                      {
                          a=a.trim();
                          String t1[]=a.split(" ");
                          //t1[2]=t1[2].trim();
                          //System.out.println(t1[5]);  // the character are 3,4,5 :)
                          float x,y,z;
                          x=Float.parseFloat(t1[0]);
                          y=Float.parseFloat(t1[1]);
                          String t2[]=t1[2].split(",");
                          z=Float.parseFloat(t2[0]);
                         // System.out.println(x+" "+y+" "+z);
                          Point p = new Point(x,y,z);
                          list.add(p);
                          
                          if(a.contains("]"))
                          {
                              break;
                          }
                      }
                      
                  }
                  
                  
                  if(s.contains("coordIndex"))
                  {
                      //System.out.println(s);
                      
                      //next line onwards i get points
                      String a=s;
                      //System.out.println(a);
                      if(a!=null)
                      {
                          a=a.trim();
                          //System.out.println(a);
                          String t[]=a.split(",");
                          //int a1=Integer.parseInt(t[0].trim());
                          int a2=Integer.parseInt(t[1].trim());
                          int a3=Integer.parseInt(t[2].trim());
                          
                          
                          String t1[]=t[0].split(" ");
                         // System.out.println(t1[1]);
                          char a11=t1[1].charAt(1);
                          String c=""+a11;
                          int a1=Integer.parseInt(c.trim());
                          //System.out.println(a1+" "+a2+" "+a3);
                          
                         Point p1 = (Point) list.get(a1); 
                          Point p2 = (Point) list.get(a2); 
                          Point p3 = (Point) list.get(a3); 
                          
                          //System.out.println(p1.x+" "+p1.y+" "+p1.z);
                          Edge e1 = new Edge(p1,p2);
                          edges.add(e1);
                          Edge e2 = new Edge(p2,p3);
                          edges.add(e2);
                          //break;
                      }
                      while((a=br.readLine())!=null)
                      {
                          a=a.trim();
                          //System.out.println(a);
                          String t[]=a.split(",");
                          int a1=Integer.parseInt(t[0].trim());
                          int a2=Integer.parseInt(t[1].trim());
                          int a3=Integer.parseInt(t[2].trim());
                          
                          
                          
                          //System.out.println(a1+" "+a2+" "+a3);
                          
                         Point p1 = (Point) list.get(a1); 
                          Point p2 = (Point) list.get(a2); 
                          Point p3 = (Point) list.get(a3); 
                          
                          
                          boolean flag;
                          flag=p1.check(p2);
                          
                          if(flag==false)
                          {
                              Edge e1 = new Edge(p1,p2);
                              p1.addedge(e1);
                              p2.addedge(e1);
                              edges.add(e1);
                          }
                          
                          
                          flag=p2.check(p3);
                          
                          if(flag==false)
                          {
                              Edge e1 = new Edge(p2,p3);
                              p3.addedge(e1);
                              p2.addedge(e1);
                              edges.add(e1);
                          }
                          //Edge e1 = new Edge(p1,p2);
                          
                          //p1.connector.contains(t);
                          
                          //edges.add(e1);
                          //boolean flag=true;
                          //edges.contains(p1,p2);
                          //p1.addedge(e1);
                          //p2.addedge(e1);
                          
                          if(a.contains("]"))
                          {
                              //System.out.println(a);
                              break;
                          }
                      }
                      break;
                  }
              }      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }
    
    public Point NoseTip()
    {
        Point p=(Point) list.get(0);
        
        float max=(float) -100000.0000;
        float max1=(float) -100000.0000;
        int k=0;
        Point z = null;
        for(int i=0;i<list.size();i++)
        {
            Point temp = (Point) list.get(i);
            if(temp.z>max)
            {
                max=temp.z;
                k=i;
                p=temp;
            }
            if(temp.y>max1)
            {
                max1=temp.y;
                //k=i;
                z=temp;
            }
        }
        System.out.println(p.x+" "+p.y+" "+p.z);
        System.out.println(p.z +" "+k);
        
        System.out.println(z.x+" "+z.y+" "+z.z);
        //System.out.println(p.z +" "+k);
        float dist =z.y-p.y;
        
        System.out.println(dist);
        d1=z.y-dist/3;
        d2=d1-dist/3;
        
        System.out.println("\nRange\n"+d1+" "+d2);
        nose=p;
        return p;
    }
    
    
    
    boolean leftcoonectors(Point p)
    {
        ArrayList temp =p.connected_Points(p);
        
        for(int i=0;i<temp.size();i++)
        {
            Point t = (Point)temp.get(i);
            //System.out.println(t.x+ " "+t.y+" "+t.z);
            
            float diff=p.x-t.x;
            //float diffy=nose.y-t.y;
            //diffy = Math.abs(diffy);
            if(diff>0 )
            {
                return true;
                //System.out.println(t.x+ " "+t.y+" "+t.z);
            }
           // System.out.println(t.x+ " "+t.y+" "+t.z);
        }
        
        return false;
    }
    
    void Nose_Width()
    {
        
        
        Point p = nose;
        
        int i= list.indexOf(p);
        
        System.out.println("\n\n"+i);
        Point l,m,n;
        ArrayList po=new ArrayList();
        while(true)
        {
            Point x=(Point) list.get(i);
            
            float xd = Math.abs((x.x-p.x));
            float xz = Math.abs((x.z-p.z));
            if(xd<1.0)
            {
                po.add(x);
                System.out.println(x.x+" "+x.y+" "+x.z);
            }
            if(xd<1.0 && xz >6.0)
            {
                
                Point z = x;
                System.out.println("\n\n"+z.x+" "+z.y+" "+z.z);
                System.out.println(list.indexOf(z));
                break;
            }
            i--;
        }
        
        Point c= (Point) po.get(po.size()-2);
        System.out.println("C:\n\n"+c.x+" "+c.y+" "+c.z);
        System.out.println(list.indexOf(c));
        
        i=list.indexOf(c);
        //float temp=(float) 0.0;
        //i--;
        Point al1=c;
        //int n1=1;
        
        while(true)
        {
            Point x=(Point) list.get(i);
            //Point z =(Point) list.get(i-1);
            System.out.println((c.z-x.z));
            
            if(Math.abs(c.z-x.z)>15)
            {
                System.out.println("\n\nIn IF..");
                al1=x;
                System.out.println(""+al1.x+" "+al1.y+" "+al1.z);
                System.out.println(list.indexOf(al1));
                break;
            }
            i--;
        }
        i=list.indexOf(c)+1;
        Point al2=c;
        //int n1=1;
        System.out.println("Right");
        while(true)
        {
            Point x=(Point) list.get(i);
            //Point z =(Point) list.get(i-1);
            System.out.println((c.z-x.z));
            
            if(Math.abs(c.z-x.z)>20)
            {
                System.out.println("\n\nIn IF..");
                al2=x;
                System.out.println(""+al2.x+" "+al2.y+" "+al2.z);
                System.out.println(list.indexOf(al2));
                break;
            }
            i++;
        }
        
        al=al1;
        ar=al2;
        //float temp=(float) 0.0;
        //i++;
       // Point al2=c;
        
    }
    public void innerEyeCorner()
    {
        //writing for left inner corner
        Point p=al;
        
        ArrayList li = new ArrayList();
        
        for(int i=0;i<list.size();i++)
        {
            Point a= (Point) list.get(i);
            float xx = a.x-p.x;
            xx=Math.abs(xx);
            //System.out.println(xx+" "+a.y);
            if(xx<0.5 && a.y<(d1-30) && a.y>(p.y+20))
            {
                //System.out.println(" in sie the if"+xx+" "+a.y);
                li.add(a);
            }
        }
        
        float min = (float) 100000.0;
        Point in1=null;
        System.out.println(li.size());
        for(int i=0;i<li.size();i++)
        {
            Point a= (Point) li.get(i);
            //System.out.println();
            if(a.z<min)
            {
                //System.out.println("Inside if");
                min = a.z;
                in1 =a;
            }
        }
        
        System.out.println("\n\nInner Eye Corner\n"+in1.x+" "+in1.y+" "+in1.z);
        System.out.println("\n\nInner Eye Corner\n"+p.x+" "+p.y+" "+p.z);
        System.out.println(list.indexOf(in1));
        
        li.clear();
        
        for(int i=0;i<list.size();i++)
        {
            Point a= (Point) list.get(i);
            float xx = a.x-ar.x;
            xx=Math.abs(xx);
            //System.out.println(xx+" "+a.y);
            if(xx<1.5 && a.y<(d1-30) && a.y>(ar.y+20))
            {
                //System.out.println(" in sie the if"+xx+" "+a.y);
                li.add(a);
            }
        }
        
        Point in2=null;
        System.out.println(li.size());
        for(int i=0;i<li.size();i++)
        {
            Point a= (Point) li.get(i);
            //System.out.println();
            if(a.z<min)
            {
                //System.out.println("Inside if");
                min = a.z;
                in2 =a;
            }
        }
        
        System.out.println("\n\nInner Eye Corner\n"+in2.x+" "+in2.y+" "+in2.z);
        System.out.println("\n\nInner Eye Corner\n"+p.x+" "+p.y+" "+p.z);
        System.out.println(list.indexOf(in2));
        
        inner1=in1;
        inner2=in2;
        
    }
    
    
    public void noseCenter()
    {
        float d=inner2.x-inner1.x;
        d=d/2;
        int n1 = list.indexOf(inner1);
        int n2=list.indexOf(inner2);
        if(n2<n1)
        {
            n2=n1;
            n1=list.indexOf(inner2);
            
        }
        ArrayList l = new ArrayList();
        float q;
        if(inner1.y>inner2.y)
            q=inner1.y;
        else
            q=inner2.y;
        System.out.println("q = "+q);
        for(int i=0;i<list.size();i++)
        {
            Point t = (Point)list.get(i);
            if(t.x>(inner1.x + d-1) && t.x<(inner2.x-d+1) && t.y<(d1-30) && t.y>q)
            {
                l.add(t);
            }
        }        
        float max=-100000;
        Point cen=null;
        System.out.println(l.size());
        //Point a = (Point)l.get(0);
        for(int i=0;i<l.size();i++)
        {
            Point t=(Point) l.get(i);
            //System.out.println("done");
            if(t.z>max  && Math.abs(t.x-d) >0.5)
            {
                //System.out.println("Entered IF");
                max=t.z;
                cen=t;
            }
        }
        
        System.out.println(cen.x+" "+cen.y+" "+cen.z);
        System.out.println(list.indexOf(cen)); 
        root=cen;
    }
    
    public void outerEyeCorners()
    {
        //For Left eye
        
        
        float dist = inner2.x-inner1.x;
        
        float xl=inner1.x-dist;
        float xr=inner2.x+dist;
        
        float yl=inner1.y;
        float yr=inner2.y;
        
        float minl=10000;
        float minr=10000;
        Point ol=null;
        Point or=null;
        ol = inner1;
        ol.x= inner1.x-15;
        or=inner2;
        or.x=inner2.x+15;
        for(int i=0;i<list.size();i++)
        {
            Point t=(Point)list.get(i);
            if(t.z<minl && t.x<(xl+1.0) && t.x>(xl-1.0) && t.y<(yl+1.0) && t.y>(yl-1.0))
            {
                minl=t.z;
                ol=t;
            }
            if(t.z<minr && t.x<(xr+1.0) && t.x>(xr-1.0) && t.y<(yr+0.5) && t.y>(yr-0.5))
            {
                minr=t.z;
                or=t;
            }
        }
      
//        System.out.println("\nLeft Outer Eye Corner\n"+ol.x+" "+ol.y+" "+ol.z);
        System.out.println(list.indexOf(ol));
        System.out.println(dist);
        outer1=ol;
    //    System.out.println("\nRight Outer Eye Corner\n"+or.x+" "+or.y+" "+or.z);
        System.out.println(list.indexOf(or));
        outer2=or;
    }
    
    public void mouthCornerLeft()
    {
        float dis = inner1.y-al.y;
        dis=Math.abs(dis);
        
        Point p=al;
        int n= list.indexOf(p);
        System.out.println("\n\n\n "+(al.y-dis)+" "+al.y);
        Point t = (Point)list.get(n-10);;
        for(int i=n-10;i>0;i--)
        {
            Point t1 = (Point)list.get(i);
            
            float d1 = t1.z-t.z;
            
            //d=Math.abs(d1);
            if(t1.x<p.x+0.15 && t1.x>p.x-0.15 && t1.y>(al.y-dis))
            {
                //System.out.println(t.y+" "+t.z +" "+list.indexOf(t)+" "+(t1.z-t.z));
                //System.out.println("\nNew point\n"+t.y+" "+t.z +" "+list.indexOf(t)+"\n");
                
                //System.out.println(t1.y+" "+t1.z +" "+list.indexOf(t1));
                
                //System.out.println(t.z-t1.z);
                if((t.z-t1.z)>0.0)
                    break;
                t=t1;
                
            }
            if(t.y>0)
                break;
        }
        
        System.out.println("\nRange");
        System.out.println(t.y+" "+t.z +" "+list.indexOf(t));
        float min=1000;
        Point m=null;
        for(int i=0;i<list.size();i++)
        {
            Point t1 = (Point)list.get(i);
            if(t1.x<t.x+1 && t1.x>t.x-5 && t1.y<t.y+1.5 && t1.y>t.y-5)
            {
                System.out.println("in if..");
                if(t.z<min)
                {
                    min = t1.z;
                    m=t1;
                }
            }
        }
        
        System.out.println("\n"+m.y+" "+m.z +" "+list.indexOf(m));
        mouthl=m;
    }
    
    
    public void mouthCornerRight()
    {
        float dis = inner2.y-ar.y;
        dis=Math.abs(dis);
        
        Point p=ar;
        int n= list.indexOf(p);
        System.out.println("\n\n\n "+(ar.y-dis)+" "+ar.y);
        Point t = (Point)list.get(n-20);
        //System.out.println(t.x+" "+t.y+" "+t.z);
        System.out.println(ar.x+" "+ar.y+" "+ar.z+"\n"+list.indexOf(t)+"\n");
        for(int i=n-20;i>0;i--)
        {
            Point k = (Point)list.get(i);
            
            //float d1 = t1.z-t.z;
            //System.out.println("hi");
            //d=Math.abs(d1);
            //System.out.println(k.x+" "+k.y+" "+k.z +" "+list.indexOf(k));
            if(k.x<ar.x+5.5 && k.x>ar.x  && k.y>(ar.y-dis))
            {
                //System.out.println();
                System.out.println(t.x+" "+t.y+" "+t.z +" "+list.indexOf(t)+" "+(k.z-t.z));
                //System.out.println("\nNew point\n"+t.y+" "+t.z +" "+list.indexOf(t)+"\n");
                
                //System.out.println(k.y+" "+k.z +" "+list.indexOf(k));
                
                //System.out.println(t.z-k.z);
                if((t.z-k.z)>2.0 && t!=(Point)list.get(n-20))
                    break;
                t=k;
                
            }
            if(t.y>0)
                break;
        }
        
        System.out.println("\nRange");
        System.out.println(t.y+" "+t.z +" "+list.indexOf(t));
        float min=1000;
        Point m=null;
        for(int i=0;i<list.size();i++)
        {
            Point t1 = (Point)list.get(i);
            if(t1.x<t.x+20 && t1.x>t.x && t1.y<t.y && t1.y>t.y-10 && t1.x>inner2.x+3)
            {
                //System.out.println("in if..");
                if(t.z<min)
                {
                    min = t1.z;
                    m=t1;
                }
            }
        }
        
        System.out.println("\n"+m.x+" "+m.y+" "+m.z +" "+list.indexOf(m));
        mouthr=m;
    }
    
    public static void main(String args[])
    {
        ReadFile r = new ReadFile("C:/Users/Shrutika/Documents/NetBeansProjects/Proj/New folder/2.wrl");
        r.NoseTip();        //r.define_Area_For_Nose_Width();
        r.Nose_Width();
        r.innerEyeCorner();
        r.noseCenter();
        r.outerEyeCorners();
        r.mouthCornerLeft();
        r.mouthCornerRight();
    }
}
