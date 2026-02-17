package State_Pattern;

class VendingMachine {
    private VendingMachineState currentState;

    // Business data
    private double balance = 0.0;
    private int itemInventory;          // for simplicity - total items (or use Map<String, Integer>)
    private String selectedItem = null; // null = no item selected
    private double itemPrice = 0.0;     // price of currently selected item

    public VendingMachine(int initialInventory) {
        this.itemInventory = initialInventory;
        this.currentState = new IdleState();  // start in Idle
    }

    // State transition helper methods (called by states)
    public void changeState(VendingMachineState newState) {
        this.currentState = newState;
        System.out.println("→ State changed to: " + newState.getClass().getSimpleName());
    }

    // Getters/Setters for state-dependent data
    public double getBalance() {
        return balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void resetBalance() {
        this.balance = 0.0;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String itemCode, double price) {
        this.selectedItem = itemCode;
        this.itemPrice = price;
    }

    public void clearSelection() {
        this.selectedItem = null;
        this.itemPrice = 0.0;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public boolean hasInventory() {
        return itemInventory > 0;
    }

    public void decreaseInventory() {
        if (itemInventory > 0) {
            itemInventory--;
        }
    }

    // Public API - delegates to current state
    public void selectItem(String itemCode) {
        currentState.selectItem(this, itemCode);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    // For demo purposes
    public String getStatus() {
        return "State: " + currentState.getClass().getSimpleName() +
                " | Balance: ₱" + String.format("%.2f", balance) +
                " | Selected: " + (selectedItem != null ? selectedItem : "None") +
                " | Inventory: " + itemInventory;
    }
}