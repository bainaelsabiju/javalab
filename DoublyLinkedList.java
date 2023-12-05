package aleena;
import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }

        if (position == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position. Position exceeds the size of the list.");
            return;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }

        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }

        if (position == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position. Position exceeds the size of the list.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from an empty list.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        int choice;
        do {
            System.out.println("1. Insert at start");
            System.out.println("2. Insert at any position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete at start");
            System.out.println("5. Delete at any position");
            System.out.println("6. Delete at end");
            System.out.println("7. Display the list");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at start: ");
                    int insertStartElement = scanner.nextInt();
                    list.insertAtStart(insertStartElement);
                    break;
                case 2:
                    System.out.print("Enter the element to insert: ");
                    int insertElement = scanner.nextInt();
                    System.out.print("Enter the position to insert at: ");
                    int insertPosition = scanner.nextInt();
                    list.insertAtPosition(insertElement, insertPosition);
                    break;
                case 3:
                    System.out.print("Enter the element to insert at end: ");
                    int insertEndElement = scanner.nextInt();
                    list.insertAtEnd(insertEndElement);
                    break;
                case 4:
                    list.deleteAtStart();
                    System.out.println("Deleted element at start.");
                    break;
                case 5:
                    System.out.print("Enter the position to delete: ");
                    int deletePosition = scanner.nextInt();
                    list.deleteAtPosition(deletePosition);
                    System.out.println("Deleted element at position " + deletePosition + ".");
                    break;
                case 6:
                    list.deleteAtEnd();
                    System.out.println("Deleted element at end.");
                    break;
                case 7:
                    System.out.println("Current list:");
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
