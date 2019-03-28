/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Business extends Software{
    private String kindOfSoftware;
    
    /**
     * Defines all Business and Software fields
     * @param q Quantity in stock
     * @param n Name of software
     * @param d Description of software
     * @param k Kind of software
     */
    public Business(int q, String n, String d, String k){
        super.setQuantity(q);
        super.setName(n);
        super.setDescription(d);
        kindOfSoftware = k;
    }
    /**
     * Defines the kindOfSoftware field.
     * @param k Kind of software
     * @return Whether the kindOfSoftware field was filled successfully
     */
    public boolean setKindOfSoftware(String k){
        if (k.equals(" ")){
            return false;
        }else{
            kindOfSoftware = k;
            return true;
        }
    }
    /**
     * Returns the kindOfSoftware field
     * @return Kind of software
     */
    public String getKindOfSoftware(){
        return kindOfSoftware;
    }
}
