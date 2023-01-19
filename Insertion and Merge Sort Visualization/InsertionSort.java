public class InsertionSort {
    //Teh visual is optimized for 13 or less elements since the frogs are kind of big
    public static void main(String[] args) {
        //minimum int
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
        insertionSort(elements);
    }
    public static void insertionSort(Element[] elements) {
        //go through array starting with the second element
        for (int i = 1; i < elements.length; i++) {
            //as long as there are elements continue going through the loop
            for (int j = i; j > 0; j--) {
                //compare element in front of position to element behind it
                if (elements[j - 1].compareTo(elements[j]) > 0) {
                    //create temporary element
                    Element tmp = elements[j];
                    //swap values of elements
                    elements[j] = elements[j - 1];
                    //swap previous element and temporary element
                    elements[j - 1] = tmp;
                    //draw background
                    StdDraw.setPenColor(140, 100, 70);
                    StdDraw.filledRectangle(.5, .5, 1, 1);
                    for (int k = 0; k < elements.length; k++) {
                       if (k == j - 1) {
                            StdDraw.setPenColor(200, 170, 20);
                        } else {
                            StdDraw.setPenColor(200, 120, 20);
                        }
                        //draw the element at k
                        elements[k].draw(.5, .02 + (k * .07), .05 * (elements[k].getValue()));
                        //play corresponding sound in the array
                        StdAudio.play(elements[k].getSound());
                    }
                } else break;
            }
        }
    }
}
