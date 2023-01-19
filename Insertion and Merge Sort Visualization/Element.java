public class Element {
    //the value that the element object represents or should represent
    public int value;
    //array of samples
    double[]sound;
    //Methods
    //element constructor
    public Element (int n) {
        value = n;
    }
    //return value
    int getValue() {
        return value;
    }

    //return sound value
    double[] getSound() {
        return sound;
    }

    //compare values of this and other objects and return -1, 1 or 0
    int compareTo(Element other) {
        //check if this element is greater
        if (value > other.value) {
            return 1;
        }
        //check if this element is less
        else if (value < other.value) {
            return -1;
        }
        //check if this element is equal and return 0 if it is
        return 0;
    }

    //set hertz value for the sound
    public void setSound(int hertz) {
        //set sampling rate, always 44100
        int samplingRate = 44100; // samples per second
        //duration of waves
        double duration = .16; //seconds for sound playing
        //n
        int n = (int) (samplingRate * duration);
        //make array of sounds
        sound = new double[n + 1];
        //go through array and play each sound
        for (int i = 0; i <= n; i++)
            //go through array and set sound values
            sound[i] = Math.sin(2 * Math.PI * i * hertz / samplingRate);
    }
    public void draw(double x, double y, double scale) {
        //body
        StdDraw.filledEllipse(x, y, .4 * scale, .05 * scale);
        //eye lids
        StdDraw.filledCircle(x - (.1 * scale), y + (.05 * scale), .04 * scale);
        StdDraw.filledCircle(x + (.1 * scale), y + (.05 * scale), .04 * scale);
        //eyeball
        StdDraw.setPenColor(255,255,255);
        StdDraw.filledCircle(x - (.1 * scale), y + (.05 * scale), .03 * scale);
        StdDraw.filledCircle(x + (.1 * scale), y + (.05 * scale), .03 * scale);
        //pupils
        StdDraw.setPenColor(0,0,0);
        StdDraw.filledCircle(x - (.1 * scale), y + (.05 * scale), .02 * scale);
        StdDraw.filledCircle(x + (.1 * scale), y + (.05 * scale), .02 * scale);
        //mouth
        StdDraw.line(x - (.01 * scale),y,x + (.03 * scale),y);
    }
}
