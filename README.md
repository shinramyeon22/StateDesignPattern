# Vending Machine - State Pattern Implementation

This project demonstrates the **State Pattern** to manage the behavior of a vending machine across different states: **Idle**, **ItemSelected**, **Dispensing**, and **OutOfOrder**.  
The pattern eliminates large conditional blocks in the main class by encapsulating state-specific logic in separate classes, making the code more maintainable, extensible, and easier to understand.

## Problem Description

A vending machine needs to manage different states with specific rules and restrictions for allowed operations.  
It also maintains attributes such as item inventory and user balance.

### Requirements by State

1. **Idle State**  
   - Allow: item selection  
   - Disallow: inserting coins, dispensing items  

2. **ItemSelected State**  
   - Allow: inserting coins, dispensing items  
   - Disallow: item selection (another selection)  

3. **Dispensing State**  
   - Allow: no operations (transient state)  
   - Automatically transitions back to **Idle** after dispensing completes  

4. **OutOfOrder State**  
   - Disallow: all operations (selection, coin insertion, dispensing)  

### Current Issues (before refactoring)

The system currently relies on conditional statements within the VendingMachine class to check the machine state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.


## Implement the State Pattern to improve code maintainability and flexibility:


1. **Define VendingMachine States:**
- Create separate classes representing different machine states: IdleState, ItemSelectedState, DispensingState, and OutOfOrderState.

2. **Implement State Interface:**  
- Implement State Interface:

3. **Implement State Behaviors:**  
- Each concrete state class implements the VendingMachineState interface, providing specific behavior for its respective state. For example, the IdleState class would allow item selection, while the OutOfOrderState wouldn't allow any operations.
  
4. **Update VendingMachine Class:**  
- Include attributes for item inventory and balance.
- Remove state-specific logic from the VendingMachine class.
- Introduce a reference to the current VendingMachineState object.
- Delegate actions like selectItem, insertCoin, dispenseItem, and setOutOfOrder to the current state object through its corresponding methods.


## UML Diagram
![alt text](https://github.com/shinramyeon22/AdapterPattern/blob/main/UML.png)

