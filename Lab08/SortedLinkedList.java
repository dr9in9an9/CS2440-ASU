package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic SortedLinkedList.
 * 
 * @author ???
 * @author Jesus Sisniega-Serrano
 * @version 7/23/2025
 * 
 */
public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T> 
{
    // reference to the first item in the list
    private Node<T> head;
    // number of elements in the list
    private int length;

    /**
     * Task: Default constructor for the SortedLinkedList.
     */
    public SortedLinkedList()
    {
        head = null;
        length = 0;
    }

    /**
     * Task: Helper method to get the node before the entry.
     * 
     * @param entry
     *            an entry in the sequence
     * @return a reference to the node before where the entry would fit in the
     *         sequence or null if the entry would be first
     */
    private Node<T> getPrevious(T entry)
    {
        Node<T> previous = null;
        Node<T> traverse = head;
        while (traverse != null)
        {
            //if (entry > traverse.getData())
            if ((entry.compareTo(traverse.getData())) > 0) //compareTo -ifless 0if== +ifmore
            {
                previous = traverse;
                traverse = traverse.getLink();
            }
            else
            {
                return previous;
            }
        }
        return previous;
    }

    /**
     * Task: Adds a new entry in its sorted position in the list. Entries
     * currently in the list are unaffected. The lists size is increased by 1.
     * 
     * @param entry
     *            the object to be added as a new entry
     * @return true if the addition is successful, or false if the list is full
     */
    public void add(T entry)
    {
        Node<T> newNode = new Node<T>(entry);
        Node<T> addHere = getPrevious(entry);
        if (addHere == null)
        {
            newNode.setLink(head);
            head = newNode;
        }
        else
        {
            newNode.setLink(addHere.getLink());
            addHere.setLink(newNode);
        }
        length++;
    }

    /**
     * Task: Removes the entry at the given index in the list. Entries
     * originally at positions higher than the given position are at the next
     * lower position within the list, and the lists size is decreased by 1.
     * 
     * @param position
     *            an integer that indicates the position of the entry to be
     *            removed
     * @return a the node's data, or returns a sentinel value if either the list is
     *         empty, givenPosition < 0, or givenPosition > getLength()-1
	 *         (hint: when making generic, return the data or null)
     */
    public T remove(int position)
    {
        T dataToReturn;
        if (position < 0 || position >= length)
        {
            return null;
        }
        if (position == 0)
        {
            dataToReturn = head.getData();
            head = head.getLink();
        }
        else
        {
            Node<T> previous = head;
            for (int i = 0; i < position - 1; i++)
            {
                previous = previous.getLink();
            }
            Node<T> oneToDelete = previous.getLink();
            dataToReturn = oneToDelete.getData();
            previous.setLink(oneToDelete.getLink());
            oneToDelete.setLink(null);
        }
        length--;
        return dataToReturn;
    }

    /**
     * Task: Removes all entries from the list. The length of the sequence
     * should be zero, and there will be no currentItem
     */
    public void clear()
    {
        head = null;
        length = 0;
    }

    /**
     * Task: Retrieves the entry at a given position in the list.
     * 
     * @param position
     *            an integer that indicates the position of the desired entry
     * @return a the node's data, or returns a sentinel value if either the list is
     *         empty, givenPosition < 0, or givenPosition > getLength()-1
	 *         (hint: when making generic, return the data or null)
     */
    public T getEntry(int position)
    {
        if (position < 0 || position >= length)
        {
            return null;
        }
        Node<T> traverse = head;
        for (int i = 0; i < position; i++)
        {
            traverse = traverse.getLink();
        }
        return traverse.getData();
    }

    /**
     * Task: Finds the index of the first occurrence of the entry in the list.
     * 
     * @param entry
     *            The object to find in the list.
     * @return the index of the first occurrence of this element, throws
     *         IllegalArgumentException if the element is not in the list
     */
    public int getPosition(T entry)
    {
        Node<T> traverse = head;
        for (int i = 0; i < length; i++, traverse = traverse.getLink())
        {
            if (entry == traverse.getData())
            {
                return i;
            }
        }
        throw new IllegalArgumentException("Element not in list");
    }

    /**
     * Task: Sees whether the list contains a given entry.
     * 
     * @param entry
     *            the object that is the desired entry
     * @return true if the list contains anEntry, or false if not
     */

    public boolean contains(T entry)
    {
        Node<T> traverse = head;
        for (int i = 0; i < length; i++, traverse = traverse.getLink())
        {
            if (entry == traverse.getData())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Task: Gets the length of the list.
     * 
     * @return the integer number of entries currently in the list
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Task: Sees whether the list is empty.
     * 
     * @return true if the list is empty, or false if not
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Task: Displays all entries that are in the list, one per line, in the
     * order in which they occur in the list.
     */
    public void display()
    {
        String str = "";
        for (Node<T> traverse = head; traverse != null; traverse = traverse
                .getLink())
        {
            str += traverse.getData() + " ";
        }
        System.out.print(str + "\n");
    }

    public Iterator<T> iterator(){
        return new SLLIterator(head);
    }

    private class SLLIterator implements Iterator<T>{
        private boolean calledNext;
        private Node<T> prevNode;
        private Node<T> currNode;
        private Node<T> nextNode;

        /**Constructor.
         * 
         * @param firstNode
         */
        public SLLIterator(Node<T> firstNode){
            calledNext = false;
            prevNode = null;
            currNode = firstNode;
            if (firstNode == null){
                nextNode = null;
            }
            else {
                nextNode = currNode.getLink();
            }
        }

        /**
         * 
         */
        public boolean hasNext(){
            return currNode != null && currNode.getLink() != null;
        }

        /**
         * 
         */
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException("No next element.");
            }
            if (calledNext){
                prevNode = currNode;
                currNode = nextNode;
                nextNode = nextNode.getLink();
            }
            calledNext = true;
            return currNode.getData();
        }

        /**
         * 
         */
        public void remove(){
            if (hasNext() && calledNext){
                if (prevNode == null){
                    Node<T> pre = getPrevious(currNode.getData());
                    if (pre != null){
                        pre.setLink(nextNode);
                    }
                    else {
                        head = head.getLink();
                    }
                    currNode = nextNode;
                    nextNode = nextNode.getLink();
                }
                else {
                    prevNode.setLink(nextNode);
                }
                calledNext = false;
            }
            else {
                throw new IllegalStateException("Method next() hasn't been called.");
            }
            length--;
        }
    }
    
} // end SortedSequence

