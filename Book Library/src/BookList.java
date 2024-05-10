import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * BookList class is Linked List class that could create a list of Nodes of Book Objects
 */
public class BookList {

    private int length;
    private Node head;
    private Node end;


    /**
     * Default Constructor
     */
    public BookList() {  // default Constructor
        this.head = null;
        this.end = null;
        this.length = 0;
    }


    /**
     * AddObjectsToStart is allowing you to talk a Book Object as a parameter and add that object to you BookList
     * @param bookObject
     */
    public void addObjectsToStart(Book bookObject){  // here we have created all our Node of Books Objects
        head = new Node(bookObject, head);
    }


    /**
     * A method that will display Your Entire BookList
     */
    public void displayBooks() {
        if (head == null) {
            System.out.println("This Linked List is Empty!");
        } else {
            Node tempPosition = head;
            do {
                System.out.println(tempPosition.getBookObject().toString());
                tempPosition = tempPosition.getNextNode();
            } while (tempPosition != head && tempPosition != null);
        }
    }


    /**
     * it converts the list from singular linear to singular circular list
     * @param arrayOfBookObjects
     */
    public void createCircularLinkedList(ArrayList<Book> arrayOfBookObjects) {

        if (arrayOfBookObjects.size() > 0) {
            for (int i = 0; i < arrayOfBookObjects.size(); i++) { // we have created every Node we need.
                addObjectsToStart(arrayOfBookObjects.get(i));
            }

            // Find the last node in the LinkedList
            Node lastNode = head;
            while (lastNode.getNextNode() != null) {
                lastNode = lastNode.getNextNode();
            }

            // Make the LinkedList circular by setting the nextNode of the last node to the head
            lastNode.setNextNode(head);

        } else {
            System.out.println("You Have Passed an Empty Array. No createCircularLinkedList was Created!");
        }

    }


    /**
     * it takes a year as a parameter, and it goes to find that year from the book file to file it separately
     * @param year
     */
    public void takeYearToFile(int year){
        Node tempPosition = head;
        PrintWriter pr = null;

        try{
            pr = new PrintWriter(new FileOutputStream(Integer.toString(year) + ".txt"), true);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }

        if (head != null){
            if (tempPosition.getBookObject().getYear() == year){
                pr.println(tempPosition.getBookObject());
                pr.flush();
                while(tempPosition.getNextNode() != head){
                    if (tempPosition.getNextNode().getBookObject().getYear() == year){
                        pr.println(tempPosition.getNextNode().getBookObject());
                        pr.flush();
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            }else {
                while(tempPosition.getNextNode() != head){
                    if (tempPosition.getNextNode().getBookObject().getYear() == year){
                        pr.println(tempPosition.getNextNode().getBookObject());
                        pr.flush();
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            }
        }
    }


    /**
     * it deleted any repeated Nodes from a BookList
     */
    public void deleteRepeatedNodes() {
        // create an ArrayList of Book objects from the circular linked list
        ArrayList<Book> books = new ArrayList<>();
        Node currentNode = head;
        if (currentNode != null) {
            books.add(currentNode.getBookObject());
            while (currentNode.getNextNode() != head) {
                currentNode = currentNode.getNextNode();
                books.add(currentNode.getBookObject());
            }
        }

        // remove duplicates from the ArrayList
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            for (int j = i + 1; j < books.size(); j++) {
                if (currentBook.equals(books.get(j))) {
                    books.remove(j);
                    j--;
                }
            }
        }

        // create a new circular linked list from the non-duplicated Book objects
        BookList newList = new BookList();
        newList.createCircularLinkedList(books);

        // update the current linked list with the non-duplicated Book objects
        head = newList.getHead();
    }


    /**
     * it gives you the size of your LinkedList
     */
    public void linkedListSize(){
        int counter = 0;
        Node tempPosition = head;
        if (head != null){
            counter++;
            while(tempPosition.getNextNode() != head ){
                counter++;
                tempPosition = tempPosition.getNextNode();
            }
        }
        System.out.println("The size of your Linked List is " + counter);
    }


    /**
     * if you want to find specific Node of Book Object in your BookList
     * @param bookObject
     */
    public void findNode(Book bookObject){
        int counter = 1;
        if (bookObject == null){
            System.out.println("The bookObject Passed is Empty!");
        }else{
            Node tempPosition = head;
            if (tempPosition == null){
                System.out.println("The LinkedList is Empty!");
            }else {
                if (head.getBookObject().equals(bookObject)){ // checks the first element
                    System.out.println("Your Passed Object been Found in Node " + counter);
                }else {
                    while(tempPosition.getNextNode() != head){
                        counter++;
                        if (tempPosition.getBookObject().equals(bookObject)){
                            System.out.println("Your Passed Object been Found in Node " + counter);
                            System.out.println(tempPosition.getBookObject());
                        }
                        tempPosition = tempPosition.getNextNode();
                    }
                }
            }
        }
    }


    /**
     * it Extracts any passed Author from a BookList and display it
     * @param targetedAuthor
     */
    public void extractAuthList(String targetedAuthor){
        BookList newAuthList = new BookList();
        ArrayList<Book> array = new ArrayList<>();
        Node tempPosition = head;

        if (head != null){
            if (tempPosition.getBookObject().getAuthors().equals(targetedAuthor)){ // the first element
                newAuthList.addObjectsToStart(tempPosition.getBookObject());
                array.add(tempPosition.getBookObject());
                while(tempPosition.getNextNode() != head){
                    if (tempPosition.getNextNode().getBookObject().getAuthors().equals(targetedAuthor)){ // the rest of the elements
                        newAuthList.addObjectsToStart(tempPosition.getBookObject());
                        array.add(tempPosition.getNextNode().getBookObject());
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            }else {
                while(tempPosition.getNextNode() != head){
                    if (tempPosition.getNextNode().getBookObject().getAuthors().equals(targetedAuthor)){ // the rest of the elements
                        newAuthList.addObjectsToStart(tempPosition.getBookObject());
                        array.add(tempPosition.getNextNode().getBookObject());
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            }
            newAuthList.createCircularLinkedList(array);

            for (int i = 0; i < array.size(); i++){
                System.out.println(array.get(i));
            }

        }else {
            System.out.println("Your BookList Object is Empty!");
        }
    }


    /**
     * It takes isbn to be found to insert before it a Node of Book Object that been passed to the method
     * @param isbn
     * @param bookObject
     */
    public void insertBefore(String isbn, Book bookObject) {
        Node tempPosition = head;
        Node newNode = new Node(bookObject);

        if (tempPosition != null) {
            if (tempPosition.getBookObject().getIsbn().equals(isbn)) {
                newNode.setNextNode(tempPosition);
                head = newNode;
            } else {
                while (tempPosition.getNextNode() != head) {
                    if (tempPosition.getNextNode().getBookObject().getIsbn().equals(isbn)) {
                        newNode.setNextNode(tempPosition.getNextNode());
                        tempPosition.setNextNode(newNode);
                        break; // Break the loop after inserting the new node
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            }
        } else {
            System.out.println("The BookList is Empty!");
        }
    }


    /**
     * It checks if the passed two ISBN passed are existed respectively
     * @param isbnOne
     * @param isbnTwo
     * @return
     */
    public boolean insertInBetweenChecker(String isbnOne, String isbnTwo) {
        Node tempPosition = head;
        if (tempPosition != null) {
            do {
                if (tempPosition.getBookObject().getIsbn().equals(isbnOne)
                        && tempPosition.getNextNode().getBookObject().getIsbn().equals(isbnTwo)) {
                    return true;
                }
                tempPosition = tempPosition.getNextNode();
            } while (tempPosition != head);
        } else {
            System.out.println("The BookList is Empty!");
        }
        return false;
    }


    /**
     * if the two respictively ISBN passed Exist, the method would create a Node of Book Object
     * @param isbnOne
     * @param isbnTwo
     * @param bookObject
     */
    public void insertIbBetween(String isbnOne, String isbnTwo, Book bookObject) {
        Node tempPosition = head;
        Node newNode = new Node(bookObject);

        if (head != null) {
            if (insertInBetweenChecker(isbnOne, isbnTwo)) {
                while (tempPosition.getNextNode() != head) {
                    if (tempPosition.getBookObject().getIsbn().equals(isbnOne)
                            && tempPosition.getNextNode().getBookObject().getIsbn().equals(isbnTwo)) {
                        newNode.setNextNode(tempPosition.getNextNode());
                        tempPosition.setNextNode(newNode);
                        return;
                    }
                    tempPosition = tempPosition.getNextNode();
                }
            } else {
                System.out.println("The ISBNs don't match!");
            }
        } else {
            System.out.println("The BookList is Empty!");
        }
    }


    /**
     * it finds the two passed ISBNs and swap them
     * @param isbnOne
     * @param isbnTwo
     * @return a New Swapped BookList
     */
    public BookList swapTwoNodeBasedOnISBN(String isbnOne, String isbnTwo){
        Node tempPosition = head;
        ArrayList<Book> arrayOfBooks = new ArrayList<>();
        BookList newBookList = new BookList();

        if (head != null){
            arrayOfBooks.add(tempPosition.getBookObject());
            while(tempPosition.getNextNode() != head){
                arrayOfBooks.add(tempPosition.getNextNode().getBookObject());
                tempPosition = tempPosition.getNextNode();
            }
        }
        System.out.println(arrayOfBooks.size());
        swap(arrayOfBooks, isbnOne, isbnTwo);
        newBookList.createCircularLinkedList(arrayOfBooks);
        newBookList.displayBooks();
        return newBookList;
    }


    /**
     * it swaps two Book Objects elements
     * @param arrayOfBooks
     * @param isbnOne
     * @param isbnTwo
     */
    public static void swap(ArrayList<Book> arrayOfBooks, String isbnOne, String isbnTwo){ // swapping books based on their Isbn
        for (int i = 0; i < arrayOfBooks.size(); i++){
            if (arrayOfBooks.get(i).getIsbn().equals(isbnOne)){
                for (int j = 0; j < arrayOfBooks.size(); j++){
                    if (arrayOfBooks.get(j).getIsbn().equals(isbnTwo)){
                        Book temp = arrayOfBooks.get(i);
                        arrayOfBooks.set(i, arrayOfBooks.get(j));
                        arrayOfBooks.set(j, temp);
                    }
                }
            }
        }
    }


    /**
     * To String a List.
     * @return
     */
    public ArrayList<Book> toStringBookList(){
        Node tempPosition = head;
        ArrayList<Book> array = new ArrayList<>();

        if (head != null){
            array.add(tempPosition.getBookObject());
            while(tempPosition.getNextNode() != head){
                array.add(tempPosition.getNextNode().getBookObject());
                tempPosition = tempPosition.getNextNode();
            }
        }else {
            System.out.println("Your List is Empty!");
            return null;
        }
        return array;
    }


    ////////////////////////////// Setters & Getters ////////////////////////////////

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }



    ///////////////////////// Node Inner Class ///////////////////////////

    /**
     * Node Inner Class
     */
    public class Node {

        private Book bookObject;
        private Node nextNode;


        /**
         * Node Default Constructor
         */
        public Node() {
            bookObject = null;
        }


        /**
         * Parametrized Constructor
         * @param bookObject
         */
        public Node(Book bookObject){
            this.bookObject = bookObject;
        }


        /**
         * Parametrized Constructor
         * @param bookObject
         * @param nextNode
         */
        public Node(Book bookObject, Node nextNode) {
            this.bookObject = bookObject;
            this.nextNode = nextNode;
        }


        public Book getBookObject() {
            return bookObject;
        }

        public void setBookObject(Book bookObject) {
            this.bookObject = bookObject;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            if (nextNode != null && nextNode != this) {
                this.nextNode = nextNode;
            } else {
                this.nextNode = head;
            }
        }


        /**
         * it Compares Two Nodes
         * @param NodeObject
         * @return
         */
        public boolean equals(Object NodeObject){
            if (this == null || this.getClass() != NodeObject.getClass()){
                return false;
            }else {
                Node x = (Node) NodeObject;
                return this.bookObject == x.bookObject;
            }
        }
    }


}
