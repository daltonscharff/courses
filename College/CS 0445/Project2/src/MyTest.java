/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class MyTest {
    public static void main(String[] args)
	{
            InfiniteIntegerInterface current = new LInfiniteInteger("0");
            InfiniteIntegerInterface temp = new LInfiniteInteger("-500");
            
            System.out.println(current.multiply(temp));
            //System.out.println(temp.multiply(current));


        }
}