package main.payments;

/**
 * template for many different types of payments
 */
public interface Payment {

    /**
     * method that types of payments use to process the user payments, adding to balance
     * @param amount amount to be added
     * @return String representing payment method and amount to be added
     */
    abstract String processPayment(float amount);


}
