public class MergeSort {
    //The visual is optimized for 12 or less elements because the frogs are big!
    public static void main(String[] args) {
        //min int
        int min = 1;
        //check validity of amount of arguments
        if (args.length != 1) {
            System.err.print("Invalid argument amount!");
            System.exit(1);
        }
        //create one argument
        int n = Integer.parseInt(args[0]);
        //create array to store elements
        Element[] elements = new Element[n];
        //check validity of argument itself
        if (n < 1) {
            System.err.print("Invalid integer!");
            System.exit(1);
        }
        //go through the array of elements
        for (int i = 0; i < elements.length; i++) {
            //create random numbers from 1 to n
            int randomN = (int) (Math.random() * (n - 1) + 1);
            //create element at random location
            Element randomElement = new Element(randomN);
            //assign into a valid position in the array
            elements[i] = randomElement;
            //if i = 0 the element at i becomes 0
            if (i == 0) {
                min = elements[i].getValue();
                //if value at i is less than min make that value the new min
            } else if (elements[i].getValue() < min) {
                min = elements[i].getValue();
            }
            //if element is equal to the minimum value play a tone
            if (elements[i].getValue() == min) {
                elements[i].setSound(440);
                //reset frequency based on value of element at i
            } else {
                int freq = (int) (440 * Math.pow(2, (elements[i].getValue() - min) / 12.0));
                elements[i].setSound(freq);
            }
        }
        //sort the array
        mergeSort(elements, 0, elements.length);
    }

    public static void mergeSort(Element[] elements, int lo, int hi) {
        // Base case: the sub-array has length 0 or 1.
        // (void methods can return, they just don't return anything)
        if (hi - lo <= 1) {
            return;
        }
        // Find the mid-point to "split" the sub-array in two "halves"
        int mid = lo + (hi - lo) / 2;
        // Recursive calls / "Divide" phase
        // Sort the two "halves" recursively
        mergeSort(elements, lo, mid);
        mergeSort(elements, mid, hi);
        // Merge the two "halves" into a new array merged
        Element[] merged = new Element[hi - lo];
        // Merge two sorted sub arrays [lo, mid) and [mid,hi) of arr (mid is
        // computed in the method). This method is separate from mergesort_helper
        int ai = lo;
        int bi = mid;
        //index for, for loop within merge
        for (int mergeI = 0; mergeI < merged.length; mergeI++) {
            if (ai == mid) {
                merged[mergeI] = elements[bi];
                bi++;
            } else if (bi == hi) {
                merged[mergeI] = elements[ai];
                ai++;
            } else if (elements[ai].compareTo(elements[bi]) > 0) {
                merged[mergeI] = elements[ai];
                ai++;
            } else {
                merged[mergeI] = elements[bi];
                bi++;
            }
        }
        for (int mergedI = 0; mergedI < merged.length; mergedI++) {
            elements[lo + mergedI] = merged[mergedI];
        }
        StdDraw.clear();
        StdDraw.setPenColor(10,70,100);
        StdDraw.filledRectangle(.5,.5,1,1);
        for (int k = 0; k < elements.length; k++) {
            if (k <= lo) {
                StdDraw.setPenColor(80, 120, 50);
            } else {
                StdDraw.setPenColor(230, 150, 150);
            }
            elements[k].draw(.5, .04 + (k * .07), .05 * (elements[k].getValue()));
            //play corresponding sound in the array
            StdAudio.play(elements[k].getSound());
        }
    }
}