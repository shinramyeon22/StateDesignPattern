package State_Pattern;

class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Out of Order - cannot select item.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Out of Order - coin rejected.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Out of Order - cannot dispense.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Already out of order.");
    }
}