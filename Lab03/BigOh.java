package algorithms;
import java.util.Random;

/**BigOh method.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/18/2025
 */
public class BigOh 
{
    private static final double MILLISECONDS_PER_SECOND = 1000;
    private static final int NUM_TRIALS = 5;
    private Random rand;

    /**Default constructor class.
     */
    public BigOh()
    {
        rand = new Random();
    }

    /**1-Param constructor class.
     * 
     * @param rand Random obj used to generate pseudorandom num.
     */
    public BigOh(Random rand)
    {
        this.rand = rand;
    }

    /**Runs desired algorithm with desired num of elements.
     * 
     * @param choice Desired algorithm.
     * @param numElements Number of elements algorithm will consider.
     * @return int result.
     */
    public int runAlgorithm(int choice, int numElements)
    {
        switch (choice)
        {
            case 1:
                return MysteryAlgorithms.alg1(numElements, rand);
            case 2:
                return MysteryAlgorithms.alg2(numElements, rand);
            case 3:
                return MysteryAlgorithms.alg3(numElements, rand);
            case 4:
                return MysteryAlgorithms.alg4(numElements, rand);
            case 5:
                return MysteryAlgorithms.alg5(numElements, rand);
            case 6:
                return MysteryAlgorithms.alg6(numElements, rand);
            default:
                return -1;
        }   
    }

    /**Runs desired static algorithm with 'n' number of elements.
     * 
     * @param choice Desired algorithm.
     * @param n Number of elements algorithm will consider.
     * @return double result.
     */
    public double bigOhFunc(int choice, double n)
    {
        switch (choice)
        {
            case 1:
                return n;
            case 2:
                return Math.pow(n,3);
            case 3:
                return Math.pow(n,2);
            case 4:
                return Math.pow(n,2);
            case 5:
                return Math.pow(n,5);
            case 6:
                return Math.pow(n,4);
            default:
                return -1;
        }
    }

    /**Calculates real-runtime of desired algorithm with 'n' number of elements. 
     * 
     * @param choice Desired algorithm.
     * @param n Number of elements algorithm will consider.
     * @return double result.
     */
    public double timeAlgorithm(int choice, int n)
    {
    
        System.gc();
        double timeStart = System.currentTimeMillis();
        runAlgorithm(choice, n);
        double timeEnd = System.currentTimeMillis();
        return (timeEnd - timeStart)/MILLISECONDS_PER_SECOND;
    }

    /**Calculates multiple real-runtimes 
     * of desired algorithm with 'n' number of elements. 
     * Finds average.
     * 
     * @param choice Desired algorithm.
     * @param n Number of elements algorithm will consider.
     * @return double result.
     */
    public double robustTimeAlgorithm(int choice, int n)
    {
        double smol = Double.MAX_VALUE;
        for (int x = 0; x < NUM_TRIALS; x++) {
            double output = timeAlgorithm(choice, n);
            if (output < smol)
            {
                smol = output;
            }
        }
        return smol;
    }

    /**Calculates expected runtime of an algorithm 
     * based on previous outcome that algorithm.
     * 
     * @param choice Desired algorithm.
     * @param n1 Initial number of elements algorithm will consider.
     * @param t1 Initial runtime.
     * @param n2 New number of elements algorithm will consider.
     * @return double estimated timing.
     */
    public double estimateTiming(int choice, int n1, double t1, int n2)
    {
        return bigOhFunc(choice, n2) / bigOhFunc(choice, n1) * t1;
    }

    /**Calculates accuracy of expected runtime when compared to actual runtime.
     * 
     * @param correct Actual runtime.
     * @param estimate Expected runtime.
     * @return double percentage of error.
     */
    public double percentError(double correct, double estimate)
    {
        return (estimate-correct)/correct;
    }

    /**Calculates accuracy of expected runtime when compared to multiple actual runtimes.
     * 
     * @param choice Algorithm choice.
     * @param n1 Initial number of elements.
     * @param n2 New number of elements.
     * @return double percentage of error.
     */
    public double computePercentError(int choice, int n1, int n2)
    {
        return percentError(robustTimeAlgorithm(choice, n2), estimateTiming(choice, n1, robustTimeAlgorithm(choice, n1), n2));
    }
}
