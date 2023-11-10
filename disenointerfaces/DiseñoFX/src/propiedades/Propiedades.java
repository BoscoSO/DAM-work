/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propiedades;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class Propiedades {

    public static void main(String[] args) {
        Bill electricBill = new Bill();
        electricBill.amountDueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal,
                    Object newVal) {
                System.out.println("Electric bill has changed!");
            }
        });
        electricBill.setAmountDue(100.00);
        electricBill.setAmountDue(300.00);
    }
}
