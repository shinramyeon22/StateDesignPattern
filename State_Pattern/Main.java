package State_Pattern;
public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(3);  // 3 items left

        System.out.println(vm.getStatus());
        // → State: IdleState | Balance: ₱0.00 | Selected: None | Inventory: 3

        vm.insertCoin(20);           // rejected
        vm.selectItem("A1");         // accepted → ItemSelectedState
        vm.selectItem("A2");         // rejected (already selected)

        vm.insertCoin(10);
        vm.insertCoin(50);           // total 60 → enough → DispensingState → IdleState

        System.out.println(vm.getStatus());

        vm.dispenseItem();           // no item selected

        vm.setOutOfOrder();          // → OutOfOrderState

        vm.insertCoin(100);
        vm.selectItem("A3");
        vm.dispenseItem();
    }
}