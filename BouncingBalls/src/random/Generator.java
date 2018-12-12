package random;

import java.util.Random;

/**
 * Pseudo-random generator.
 * Possible better implementations of randomness.
 */
public class Generator {

    private Random random;

    public Generator(){
        random = new Random();
    }
    public Generator(long seed){
        random = new Random(seed);
    }

    /**
     * @return integer, max-range (0 - 2^32-1)
     */
    public int nextInt(){
        return random.nextInt();
    }
    /**
     * @return integer, ranged "0 - maxValue"
     */
    public int nextInt(int maxValue) throws RangeException {
        if(maxValue < 0)
            throw new RangeException();
        return random.nextInt(maxValue);
    }
    /**
     * @return integer, ranged "minValue - maxValue"
     */
    public int nextInt(int minValue, int maxValue) throws RangeException {
        if(minValue > maxValue)
            throw new RangeException();
        return minValue + random.nextInt(maxValue - minValue);
    }

    /**
     * @return double, ranged "0-1"
     */
    public double nextDouble(){
        return random.nextDouble();
    }
    /**
     * @return double, ranged "minValue - maxValue"
     */
    public double nextDouble(double minValue, double maxValue) throws RangeException {
        if(minValue > maxValue)
            throw new RangeException();
        return minValue + (maxValue - minValue) * random.nextDouble();
    }

    /**
     * @return boolean (true/false)
     */
    public boolean nextBoolean(){
        return random.nextBoolean();
    }

}
