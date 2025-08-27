package library;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import storage.SortedLinkedList;

public class BookReader{
    private Scanner fileIn;
    private SortedLinkedList<Book> books;

    public BookReader(String filename){
        setFileIn(new Scanner(filename));
        books = new SortedLinkedList<Book>();
        readLines();
    }

    public void setFileIn(Scanner fileIn){
        this.fileIn = fileIn;
    }

    public void readLines(){
        while (fileIn.hasNextLine()){
            //books.add(new Book(fileIn.next(","), fileIn.next(","), fileIn.nextInt()));

            String line = fileIn.nextLine();
            String[] strArr = line.split(",");

            if (strArr.length == 3){
                String author = strArr[0];
                String title = strArr[1];
                int numPages = Integer.parseInt(strArr[2]);

                Book book = new Book(author, title, numPages);
                books.add(book);
            }
        }
        fileIn.close();
    }
    public SortedLinkedList<Book> getBooks(){
        return books;
    }
    public void printMoreThan300(){
        for (Book book : books) {
            if (book.getNumPages() > 300){
                System.out.println(book.toString());
            }
        }
    }
    public double averagePages(){
        double sum = 0;
        for (Book book : books) {
            sum += book.getNumPages();
        }
        return sum / books.getLength();
    }
    public void removeLessThan200(){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getNumPages() < 200){
                iterator.remove();
            }
        }
    }
}
