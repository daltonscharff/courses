/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interest;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Continuous extends Account{
    public Continuous(double i, double p, double t){
        interestRate = i;
        principle = p;
        time = t;
        finalAmount = principle * Math.pow(Math.E, time * interestRate);
    }
}
