/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project7_6;

/**
 *
 * @author 14dscharff
 */
public class Converter {
    double radius = 0, pi = 3.14159265359, radiusSquared = 0, radiusCubed = 0;
    public Converter(){};
    
    public void setRadius(String x){
        double r = Double.parseDouble(x);
        radius = r;
        radiusSquared = r * r;
        radiusCubed = r * r * r;
    }
     
    public double getArea(){
        double area = pi * radiusSquared;
        return area;
    }
    
    public double getSurface(){
        double surface = 4 * pi * radiusSquared;
        return surface;
    }
    
    public double getVolume(){
        double volume = (1.333) * pi * radiusCubed;
        return volume;
    }
}
