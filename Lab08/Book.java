package library;

public class Book implements Comparable<Book>{
    private String author;
    private String title;
    private int numPages;

    /**Constructor.
     * 
     * @param author
     * @param title
     * @param numPages
     */
    public Book(String author, String title, int numPages){
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    /**Book author field getter.
     * 
     * @return author
     */
    public String getAuthor(){
        return author;
    }

    /**Book title field getter.
     * 
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**Book numPages getter.
     * 
     * @return numPages
     */
    public int getNumPages(){
        return numPages;
    }

    /**Checks if Sting objs found in author fields and then title fields are equal.
     * 
     * @return boolean
     */
    public boolean equals(Object other){
        Book book = (Book) other;
        return author.equals(book.author) && title.equals(book.title);
    }
    
    /**Finds and returns equivalancy value of author field String objs +
     * equivalancy value of title field String objs
     * 
     * @return int
     */
    public int compareTo(Book book){
        return author.compareTo(book.author) + title.compareTo(book.title);
    }

    /**Turns Book obj into string displaying fields.
     * 
     * @return String
     */
    public String toString(){
        return getAuthor() + ", " + getTitle() + ", " + getNumPages();
    }
}
