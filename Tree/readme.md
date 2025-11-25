# Binary Search Tree (BST) in Java

This project implements a basic Binary Search Tree (BST) in Java using a menu–driven console interface.
Users can insert nodes, perform tree traversals, count nodes, and find minimum and maximum values.

---

## Features

### Insert Node

Adds a new node into the BST following BST insertion rules.

### Traversals

* Preorder (Root → Left → Right)
* Inorder (Left → Root → Right)
* Postorder (Left → Right → Root)

### Node Count

Displays the total number of nodes inserted.

### Minimum and Maximum

Finds the minimum and maximum values stored in the BST.

### Menu-Driven Interface

Provides an interactive console-based menu.

---

## Project Structure

```
BST (Main Class)
└── node (Tree Node + Operations)
    ├── create()        → Insert a new node
    ├── preOrder()      → Preorder traversal
    ├── inOrder()       → Inorder traversal
    ├── postOrder()     → Postorder traversal
    ├── showCount()     → Display total nodes
    ├── showMin()       → Find minimum value
    ├── showMax()       → Find maximum value
```

---

## How It Works

The program begins by asking the user to input the root node value, then displays a menu:

```
[1] Add Node
[2] Preorder Traversal
[3] Inorder Traversal
[4] Postorder Traversal
[5] Show Count
[6] Show Minimum
[7] Show Maximum
[8] Exit
```

Users can choose operations repeatedly until they exit.

---

## How to Run

1. Save the code in a file named `BST.java`
2. Compile:

   ```
   javac BST.java
   ```
3. Run:

   ```
   java BST
   ```

---

## Sample Output

```
Enter root data: 50

--- MENU ---
[1] Add Node
[2] Preorder Traversal
[3] Inorder Traversal
[4] Postorder Traversal
[5] Show Count
[6] Show Minimum
[7] Show Maximum
[8] Exit
Enter your choice: 1
Enter your Data: 30
Data is at left.

Enter your choice: 1
Enter your Data: 70
Data is at right.

Enter your choice: 3
Inorder Traversal:
30    50    70
```

---

## Future Improvements

* Add node deletion
* Add search functionality
* Refactor classes for cleaner design
* Optionally create a GUI version

---

## License

This project is for educational use.

