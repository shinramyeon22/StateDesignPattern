package State_Pattern;

class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        if (!machine.hasInventory()) {
            System.out.println("Cannot select: Out of stock.");
            return;
        }
        // For simplicity we assume item exists and has fixed price ₱45
        double price = 45.0;
        machine.setSelectedItem(itemCode, price);
        System.out.println("Selected item: " + itemCode + " (₱" + price + ")");
        machine.changeState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now OUT OF ORDER.");
        machine.changeState(new OutOfOrderState());
    }
}