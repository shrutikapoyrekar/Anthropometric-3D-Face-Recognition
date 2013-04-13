/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Points;

/**
 *
 * @author Shrutika
 */
public class Edge 
{
    public Point p1, p2;
    public double d;
    public Edge(Point a, Point b)
    {
        p1=a;
        p2=b;
        float x = (p1.x-p2.x)*(p1.x-p2.x);
        float y = (p1.y-p2.y)*(p1.y-p2.y);
        float z = (p1.z-p2.z)*(p1.z-p2.z);
        
        float t= x+y+z;
        d=Math.sqrt(t);
        
    }
}
