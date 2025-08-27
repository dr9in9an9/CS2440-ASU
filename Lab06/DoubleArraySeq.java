package storage;

/**DoubleArraySeq Program.
 * 
 * @version 7/9/2025.
 * @author Jesus Sisniega-Serrano.
 */
public class DoubleArraySeq implements Cloneable{
public static final int DEFAULT_CAPACITY = 10;
private double[] data;
private int manyItems;
private int currentIndex;

/**Param Constructor.
 * 
 * @param initialCapacity 
 */
public DoubleArraySeq(int initialCapacity)
{
    this.data = new double[initialCapacity];
    this.manyItems = 0;
    this.currentIndex = 0;
}

/**Default Constructor.
 */
public DoubleArraySeq()
{
    this(DEFAULT_CAPACITY);
}

/**Adds new elem to seq, after current elem.
 * If no current, adds at end.
 * 
 * @param element Elem to be added.
 */
public void addAfter(double element)
{
    if (size() >= getCapacity()){
        ensureCapacity(getCapacity() + 10);
    }
    
    if (isCurrent()){
        for (int i = size(); i > this.currentIndex + 1; i--) {
            this.data[i] = this.data[i-1];
        }
        this.currentIndex++;
    }
    else{
        this.currentIndex = size();
    }
    this.data[this.currentIndex] = element;
    this.manyItems++;
}

/**Adds new elem to seq, before current elem.
 * If no current, adds at start.
 * 
 * @param element Elem to be added.
 */
public void addBefore(double element)
{
    if (size() >= getCapacity()){
        ensureCapacity(getCapacity() + 10);
    }

    for (int i = size(); i > this.currentIndex; i--) {
        this.data[i] = this.data[i-1];
    }
    this.data[this.currentIndex] = element;
    if (!isCurrent()){
        this.currentIndex = 0;
    }
    this.manyItems++;
}

/**Adds all elems of a seq after current seq.
 * 
 * @param addend Seq to be added.
 */
public void addAll(DoubleArraySeq addend)
{
    if (data.length < manyItems + addend.size())
        {
            ensureCapacity(manyItems * 2 + addend.size());
        }

        for (int i = 0; i < addend.size(); i++)
        {
            data[manyItems + i] = addend.data[i];
        }
        manyItems += addend.manyItems;
}

/**Creates new array that only fits current seq elems.
 */
public void trimToSize()
{
    double[] arr = new double[this.size()];
    for (int i = 0; i < size(); i++)
    {
        arr[i] = data[i];
    }
    data = arr;
}

/**Makes sure seq has a capacity of atleast n.
 * 
 * @param minimumCapacity bareminimum capacity.
 */
public void ensureCapacity(int minimumCapacity)
{
    if (getCapacity() < minimumCapacity) {
        double[] data2 = new double[minimumCapacity];
        for (int i = 0; i < size(); i++){
            data2[i] = this.data[i];
        }
        this.data = data2; 
    }
}
/**Sets curr to first elem.
 */
public void start()
{
    this.currentIndex = 0;
} 

/**Moves current cursor to next elem.
 * If no next elem, removes current cursor. 
 */
public void advance()
{
    if (isCurrent()){
        this.currentIndex++;
    }
    else{
        throw new IllegalStateException();
    }
}

/**Returns current elem.
 * If no curr elem, throws exception.
 * 
 * @return double contained in elem.
 */
public double getCurrent()
{
    if (isCurrent()){
        return this.data[this.currentIndex];
    }
    else{
        throw new IllegalStateException();
    }
}

/**Removes curr elem.
 */
public void removeCurrent()
{
    if (isCurrent()){
        for(int i = this.currentIndex; i < size(); i++){
            this.data[i] = this.data[i+1];
        }
        this.manyItems--;
    }
    else{
        throw new IllegalStateException();
    }
}

/**Checks if there is a curr elem.
 * 
 * @return boolean.
 */
public boolean isCurrent()
{ 
    return (this.currentIndex < size()) && (this.currentIndex >= 0);
}

/**Returns array size.
 * 
 * @return int of array size.
 */
public int getCapacity()
{
    return this.data.length;
}

/**Returns current num of elements.
 * 
 * @return int of current size of seq.
 */
public int size()
{
    return this.manyItems;
}

public DoubleArraySeq clone()
{
    DoubleArraySeq copy = new DoubleArraySeq(data.length);
    copy.currentIndex = this.currentIndex;
    copy.manyItems = this.manyItems;

    for (int i = 0; i < this.data.length; i++)
    {
        copy.data[i] = this.data[i];
    }

    return copy;
}

public String toString()
{
    String str = "<";
        for (int i = 0; i < size(); i++) {
            if (i == this.currentIndex){
                str += "[" + this.data[i] + "]";
            }
            else{
                str += this.data[i];
            }
            if ((i + 1 < size())){
                str += ", ";
            }
        } 
    return str += ">";
}

public boolean equals(Object other)
{
    return toString().equals(other.toString());
}

public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2)
{
    DoubleArraySeq newSequence = new DoubleArraySeq(s1.getCapacity() + s2.getCapacity());
        newSequence.manyItems = s1.size() + s2.size();
        newSequence.currentIndex = newSequence.manyItems;

        for (int i = 0; i < s1.size(); i++)
        {
            newSequence.data[i] = s1.data[i];
        }
        for (int j = 0; j < s2.size(); j++)
        {
            newSequence.data[j + s1.size()] = s2.data[j];
        }
        return newSequence;
}
}
