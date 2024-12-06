/****************************** Edmon Low Library System ****************************
* Library Operations such as book management, borrowing, and availability checks.
* @author Will Thompson
****************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class EdmonLowLibrary {

    private String address;
    private String openHours;

    private static ArrayList<String> books = new ArrayList<>();

    public EdmonLowLibrary(String address, String openHours) {
        this.address = address;
        this.openHours = openHours;
    }

    public void printLibraryInfo() {
        System.out.println("Edmon Low Library:");
        System.out.println("    Open Hours: " + openHours);
        System.out.println("    Address: " + address);
        System.out.println();
    }

    public void addBook(String title) {
        books.add(title);
        System.out.println("Someone has just returned '" + title +  "' to the library.");
        System.out.println();
    }

    public void isBorrowed(String bookTitle) {
        if (books.contains(bookTitle)) {
            books.remove(bookTitle);
            System.out.println("Someone requested '" + bookTitle + "', which is currently available and ready to get picked!");
            System.out.println();
        } else {
            System.out.println("Someone requested '" + bookTitle + "', which is not currently available!");
            System.out.println();
        }
    }

    public void printAvailableBooks() {
        System.out.println("Available books:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        EdmonLowLibrary edmonLowLibrary = new EdmonLowLibrary("216 Library, Oklahoma State University, Stillwater, OK 74078", "9 am - 5 pm");

        Scanner scanner = new Scanner(System.in);
        System.out.println("An Edmon Low librarian is adding six books to the library system...");
        for (int i = 0; i < 6; i++) {
            System.out.print("Type a book title: ");
            String bookTitle = scanner.nextLine();
            books.add(bookTitle);
        }
        System.out.println();

        edmonLowLibrary.printLibraryInfo();

        edmonLowLibrary.isBorrowed("The Lord of the Rings");

        edmonLowLibrary.isBorrowed("The Hobbit");

        edmonLowLibrary.printAvailableBooks();

        edmonLowLibrary.addBook("The Lord of the Rings");

        edmonLowLibrary.isBorrowed("A Tale of Two Cities");

        edmonLowLibrary.printAvailableBooks();
    }
}
