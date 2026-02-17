package State_Pattern;
class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Cannot insert coins while dispensing.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing " + machine.getSelectedItem() + "...");
        machine.decreaseInventory();

        double price = machine.getItemPrice();
        double change = machine.getBalance() - price;
        if (change > 0) {
            System.out.println("Change returned: ₱" + String.format("%.2f", change));
        }

        machine.resetBalance();
        machine.clearSelection();

        System.out.println("Thank you! Enjoy your item.");

        // Auto-transition back to Idle (or OutOfOrder if inventory = 0)
        if (machine.hasInventory()) {
            machine.changeState(new IdleState());
        } else {
            System.out.println("Inventory depleted → Out of Order");
            machine.changeState(new OutOfOrderState());
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine will go out of order after current dispense.");
        // For simplicity we complete current dispense first
    }
}