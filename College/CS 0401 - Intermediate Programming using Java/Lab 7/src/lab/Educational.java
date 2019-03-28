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
public class Educational extends Software{
    private String subject;
    private String level;
    
    /**
     * Defines all Educational and Software fields.
     * @param q Quantity in stock
     * @param n Name of software
     * @param d Description of software
     * @param subject Subject of software
     * @param level Grade level of software
     */
    public Educational(int q, String n, String d, String subject, String level){
        super.setQuantity(q);
        super.setName(n);
        super.setDescription(d);
        this.subject = subject;
        this.level = level;
    }
    /**
     * Defines the subject field.
     * @param s Subject of book
     * @return Whether subject field was filled with valid input (health, literature, math, science, or social studies)
     */
    public boolean setSubject(String s){
        if (s.equalsIgnoreCase("health") || s.equalsIgnoreCase("literature") || s.equalsIgnoreCase("math") || s.equalsIgnoreCase("science") || s.equalsIgnoreCase("social studies")){
            subject = s;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Returns the subject field.
     * @return The subject field
     */
    public String getSubject(){
        return subject;
    }
    /**
     * Defines the level field.
     * @param l Suggested grade level of the book
     * @return Whether level field was filled with valid input (kindergarten, elementary, middle school, high school, or college)
     */
    public boolean setLevel(String l){
        if (l.equalsIgnoreCase("kindergarten") || l.equalsIgnoreCase("elementary") || l.equalsIgnoreCase("middle school") || l.equalsIgnoreCase("high school") || l.equalsIgnoreCase("college")){
            level = l;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Returns the level field.
     * @return The level field
     */
    public String getLevel(){
        return level;
    }
}
