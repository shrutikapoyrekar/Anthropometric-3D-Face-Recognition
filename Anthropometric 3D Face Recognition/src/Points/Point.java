/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Points;

import java.util.ArrayList;

/**
 *
 * @author Shrutika
 */
public class Point 
{
    public float x;
    public float y;
    public float z;
    //Connector c;
    public ArrayList connector = new ArrayList();
   // public ArrayList Points = new ArrayList();
    public Point (float a, float b, float c)
    {
        x=a;
        y=b;
        z=c;
    }
    public void addedge(Edge e)
    {
        
        
       connector.add(e);    
       //Points.add(p);
    }
    public ArrayList connected_Points(Point p)
    {
        ArrayList l=new ArrayList();
        for(int i=0;i<connector.size();i++)
        {
            Edge e = (Edge) p.connector.get(i);
            if(e.p1==p)
                l.add(e.p2);
            else
                l.add(e.p1);
            
        }
        
        return l;
    }
    
    public boolean check(Point p2)
    {
        //boolean flag=false;
        
        for(int i=0;i<connector.size();i++)
        {
            Edge e = (Edge) connector.get(i);
            
            if(e.p1==p2 || e.p2==p2)
                return true;
        }
        
        return false;
    }
}
