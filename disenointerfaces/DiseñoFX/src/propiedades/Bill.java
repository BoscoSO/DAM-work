/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propiedades;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Bill {
    private DoubleProperty amountDue = new SimpleDoubleProperty();
    // Define a getter for the property's value
public final double getAmountDue(){return amountDue.get();}
// Define a setter for the property's value
public final void setAmountDue(double value){amountDue.set(value);}
// Define a getter for the property itself
public DoubleProperty amountDueProperty() {return amountDue;}
}
