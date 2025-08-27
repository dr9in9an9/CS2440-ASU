package storage;

/**DoubleLinkedSeq Program.
 * 
 * @author Jesus Sisniega-Serrano.
 * @version 7/16/2025.
 */

public class DoubleLinkedSeq implements Cloneable{
    private int manyNodes;
    private DoubleNode tail;
    private DoubleNode head;
    private DoubleNode precursor;
    private DoubleNode cursor;
    
    /**Default class constructor.
     */
    public DoubleLinkedSeq(){
        this.manyNodes = 0;
        this.tail = null;
        this.head = null;
        this.precursor = null;
        this.cursor = null;
    }

    /**Returns the size of the list without iteration.
     * 
     * @return int manyNodes.
     */
    public int size(){
        return this.manyNodes;
    }

    /**Creates new DoubleNode obj and inserts it after the "cursor" DoubleNode.
     * 
     * @param data Number to be stored within obj.
     */
    public void addAfter(double data){
        if (this.head == null){ // empty list.
            this.head = new DoubleNode(data, this.head);
            this.cursor = this.head;
            this.precursor = null;
            this.tail = this.head;
        }
        else if (!isCurrent()) {// has no cursor or tail is cursor.
            tail.setLink(new DoubleNode(data, null));
            this.precursor = this.tail;
            this.tail = this.tail.getLink();
            this.cursor = tail;
        }
        else { 
            cursor.setLink(new DoubleNode(data, cursor.getLink()));
            this.precursor = this.cursor;
            this.cursor = this.precursor.getLink();
            if (cursor.getLink() == null)
            {
                this.tail = this.cursor;
            }
        } 
        this.manyNodes++;
    }

    /**Creates new DoubleNode obj and inserts it after the "precursor" DoubleNode.
     * 
     * @param data Number to be stored within obj.
     */
    public void addBefore(double data){
        if (this.head == null){ // empty list.
            this.head = new DoubleNode(data, null);
            this.precursor = null;
            this.tail = this.head;
            this.cursor = this.head;
        }
        else {
            if (!isCurrent()){ // has no cursor or head is cursor.
                this.head = new DoubleNode(data, this.cursor);
                this.cursor = this.head;
            }
            else { // there is a cursor
                if (this.precursor == null) {
                    this.head = new DoubleNode(data, this.cursor);
                    this.cursor = this.head;
                } else {
                    this.precursor.setLink(new DoubleNode(data, this.cursor));
                    this.cursor = precursor.getLink();
                }
            }
        }
        this.manyNodes++;
    }

    /**Creates a copy of the DoubleNode objs provided in the addend obj.
     * Links the end of the current list to the start of the copied list.
     * 
     * @param addend
     */
    public void addAll(DoubleLinkedSeq addend){
        if (addend == this) {
            addend = addend.clone();
        }

        DoubleNode iterator = addend.head;
        while (iterator != null) {

            this.tail.setLink(new DoubleNode(iterator.getData(), null));
            this.tail = this.tail.getLink();
            iterator = iterator.getLink();
        }
        this.manyNodes += addend.manyNodes;
    }
    
    /**Checks if there is an obj in the cursor reference variable.
     * 
     * @return
     */
    public boolean isCurrent(){
        return this.cursor != null;
    }

    /**Sets the cursor reference variable to the obj in the head reference variable.
     * Sets the precursor reference variable to null.
     * 
     */
    public void start(){
        this.cursor = this.head;
        this.precursor = null;
    }

    /**Moves the current cursor one step along the list.
     * If no cursor is found, throws new IllegalStateException.
     */
    public void advance() throws IllegalStateException {
        if  (isCurrent()) {
            this.precursor = this.cursor;
            this.cursor = cursor.getLink();
        }
        else {
            throw new IllegalStateException("No current item exists.");
        }
    }

    /**Returns the data found within the cursor node.
     * 
     * @return Double Data contained within obj.
     */
    public double getCurrent() throws IllegalStateException {
        if (isCurrent()) {
            return this.cursor.getData();
        } else {
            throw new IllegalStateException();
        }
    }

    /**Removes the current cursor DoubleNode from list.
     * Sets new cursor and precursor.
     */
    public void removeCurrent(){
        if (isCurrent()){
            if (this.precursor == null) {
                this.head = cursor.getLink();
                this.cursor = this.head;
            } else {
                this.precursor.setLink(this.cursor.getLink());
                this.cursor = precursor.getLink();
            }
            this.manyNodes--;
        }
        else {
            throw new IllegalStateException("No current item exists.");
        }
    }

    /**Creates a clone of the class.
     * 
     * @throws CloneNotSupportedException
     */
    @Override
    public DoubleLinkedSeq clone() {
        DoubleLinkedSeq answer = new DoubleLinkedSeq();
        answer.manyNodes = this.manyNodes;

        answer.head = DoubleNode.listCopy(this.head);
        DoubleNode iterator = this.head;
        DoubleNode iterator2 = answer.head;
        while (iterator != null) {
            if (iterator == this.cursor) {
                answer.cursor = iterator2;
            } else if (iterator == this.precursor) {
                answer.precursor = iterator2;
            } else if (iterator == this.tail) {
                answer.tail = iterator2;
            }

            if (iterator.getLink() == null) {
                answer.tail = iterator2;
                break;
            }

            iterator = iterator.getLink();
            iterator2 = iterator2.getLink();
        }

        return answer;
    }

    /**Converts obj to String obj.
     * 
     * @return String string.
     */
    public String toString(){
        String s = "<";
        // if (this.head == null){
        //     return "<>";
        // }

        DoubleNode i = this.head;
        while (i != null){
            if (this.cursor == i) {
                s += "["+ Double.toString(i.getData()) +"]";
            }
            else {
                s += Double.toString(i.getData());
            }
            i = i.getLink();
            if (i != null){
                s+= ", ";
            }
        }
        return s + ">";
    }

    /**Checks if two objs are same in content.
     * 
     * @return boolean t/f.
     */
    public boolean equals(Object other){
        if (!(other instanceof DoubleLinkedSeq)) {
            return false;
        }
        DoubleLinkedSeq object = (DoubleLinkedSeq) other;
        if (object.size() != this.size()) {
            return false;
        }

        DoubleNode iterator = this.head;
        DoubleNode iterator2 = object.head;

        while (iterator != null) {
            
            if (iterator == this.cursor && iterator2 != object.cursor) {
                return false;
            }
            if (iterator.getData() != iterator2.getData()) {
                return false;
            }
            if (iterator == this.precursor && iterator2 != object.precursor) {
                return false;
            }

            iterator = iterator.getLink();
            iterator2 = iterator2.getLink();
        }
        return true;
    }
    
    /**Combines two DoubleLinkedSeq's
     * 
     * @param s1 DoubleLinkedSeq 1.
     * @param s2 DoubleLinkedSeq 2.
     * @return DoubleLinkedSeq New obj.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2){
        DoubleLinkedSeq copy = s1.clone();
        copy.addAll(s2);
        copy.cursor = null;
        return copy;
    }
}
