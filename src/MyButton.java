/*
 * File: MyButton.java
 * ---------------------
 * This class is a custom button class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *  Last modified: Aug 3, 2022
 */


import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;


public class MyButton extends GCompound {

    private static final String FONT = "SansSerif-bold-64";
    private GRect key;
    private GLabel keyText;

    public MyButton(double x, double y, double width, double height, String text) {
        // This method draws the Button object which is composed of GRect and GLabel objects
        /* YOUR CODE HERE */
    }

    public String getText() {
        // This method returns the text associated with the button
        /* YOUR CODE HERE */
        return "";
    }

    private double getCenterX(double width, double labelWidth) {
        // No need to modify this method
        return (width - labelWidth) / 2.0f;
    }

    private double getCenterY(double height, double ascent) {
        // No need to modify this method
        return (ascent + (height - ascent) / 2.0f);
    }

    public void setText(String text) {
        // This method modifies the keyText of the button
        /* YOUR CODE HERE */
    }
}
