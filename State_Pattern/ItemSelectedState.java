package State_Pattern;

class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Item already selected. Please complete payment or cancel.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid coin amount.");
            return;
        }
        machine.addToBalance(amount);
        System.out.println("Inserted ₱" + amount + ". Current balance: ₱" + machine.getBalance());

        double price = machine.getItemPrice();
        if (machine.getBalance() >= price) {
            System.out.println("Payment sufficient. Dispensing...");
            machine.changeState(new DispensingState());
            machine.dispenseItem();  // trigger dispense immediately
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please insert enough coins first (need ₱" + machine.getItemPrice() + ")");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Cancelling selection due to out-of-order.");
        machine.clearSelection();
        machine.resetBalance();
        machine.changeState(new OutOfOrderState());
    }
}