/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guithermo;

/**
 *
 * @author 14dscharff
 */
public class Thermometer {
    private double degreesCelsius;
    public Thermometer(){};
    
    public void setCelsius(double degrees){
        degreesCelsius = degrees;
    }
    
    public void setFahrenheit(double degrees){
        degreesCelsius = (degrees - 32.0) * 5.0 / 9.0;
    }
    
    public double getCelsius(){
       return degreesCelsius;
    }
    
    public double getFahrenheit(){
        return degreesCelsius * 9.0 / 5.0 + 32;
    }
}
