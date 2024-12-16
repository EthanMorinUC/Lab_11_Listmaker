import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args)
    {
        boolean running = true;
        while (running)
        {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter a command", "[AaDdIiPpQq]");

            if (choice.equalsIgnoreCase("A")) {
                addItem();
            } else if (choice.equalsIgnoreCase("D")) {
                deleteItem();
            } else if (choice.equalsIgnoreCase("I")) {
                insertItem();
            } else if (choice.equalsIgnoreCase("P")) {
                printList();
            } else if (choice.equalsIgnoreCase("Q")) {
                running = quitProgram();
            }
        }
    }

    private static void displayMenu()
    {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print (i.e. display) the list");
        System.out.println("Q – Quit the program");
    }

    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter an item to add");
        myArrList.add(item);
    }

    private static void deleteItem()
    {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
        } else {
            int index = SafeInput.getRangedInt(scanner, "Enter the index of the item to delete", 1, myArrList.size());
            myArrList.remove(index - 1);
        }
    }

    private static void insertItem()
    {
        if (myArrList.isEmpty())
        {
            System.out.println("The list is empty. Use the Add option to add the first item.");
        } else
        {
            int index = SafeInput.getRangedInt(scanner, "Enter the index to insert the item at", 1, myArrList.size() + 1);
            String item = SafeInput.getNonZeroLenString(scanner, "Enter an item to insert");
            myArrList.add(index - 1, item);
        }
    }

    private static void printList()
    {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
        } else
        {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ": " + myArrList.get(i));
            }
        }
    }

    private static boolean quitProgram()
    {
        return !SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
}
