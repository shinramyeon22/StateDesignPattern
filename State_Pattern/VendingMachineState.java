package State_Pattern;
interface VendingMachineState {
    void selectItem(VendingMachine machine, String itemCode);
    void insertCoin(VendingMachine machine, double amount);
    void dispenseItem(VendingMachine machine);
    void setOutOfOrder(VendingMachine machine);
}