public class RandomDrawing {
    //Methods
    public static void tomatocreature(double x, double y, int red, int green, int blue) {
        //head
        StdDraw.setPenColor(red, green, blue);
        StdDraw.filledCircle(x,y,.3);
        //eyes
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(x - .21,y,.05);
        StdDraw.filledCircle(x + .23,y,.05);
        //pupils
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.filledCircle(x - .21,y,.03);
        StdDraw.filledCircle(x + .23,y,.03);
        //sprout
        StdDraw.setPenColor(10, 120,50);
        StdDraw.filledEllipse(x, y +.3,.1,.15);
        //mouth
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.line(x-.03,y-.1,x + .05,y-.1);
    }
    public static void hatcreature(double x, double y, int red, int green, int blue) {
        //head
        StdDraw.setPenColor(red, green, blue);
        StdDraw.filledCircle(x, y-.05,.14);
        //hat
        StdDraw.setPenColor(150, 200, 150);
        StdDraw.filledEllipse(x,y,.29,.07);
        StdDraw.filledEllipse(x,y +.1,.14,.15);
        //eyes
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(x - .1,y -.1,.02);
        StdDraw.filledCircle(x + .1,y-.1,.02);
        StdDraw.setPenColor(0, 0, 0);
        //pupils
        StdDraw.filledCircle(x - .1,y -.1,.01);
        StdDraw.filledCircle(x + .1,y-.1,.01);
    }
    public static void longcreature(double x, double y,int red, int green, int blue) {
        //body
        StdDraw.setPenColor(red, green, blue);
        StdDraw.filledEllipse(x, y, .4, .05);
        //eye lids
        StdDraw.filledCircle(x - .1, y + .05, .04);
        StdDraw.filledCircle(x + .1, y + .05, .04);
        //eyeball
        StdDraw.setPenColor(255,255,255);
        StdDraw.filledCircle(x - .1, y + .05, .03);
        StdDraw.filledCircle(x + .1, y + .05, .03);
        //pupils
        StdDraw.setPenColor(0,0,0);
        StdDraw.filledCircle(x - .1, y + .05, .02);
        StdDraw.filledCircle(x + .1, y + .05, .02);
        //mouth
        StdDraw.line(x-.01,y,x + .03,y);
    }
    public static void squarecreature(double x, double y, int red, int green, int blue) {
        //body
        StdDraw.setPenColor(red, green, blue);
        StdDraw.filledRectangle(x, y, .1, .1);
        //eyeballs
        StdDraw.setPenColor(255,255,255);
        StdDraw.filledCircle(x - .03, y - .03, .01);
        StdDraw.filledCircle(x + .03, y - .03, .01);
        //eyes
        StdDraw.setPenColor(0,0,0);
        StdDraw.filledCircle(x - .03, y - .03, .007);
        StdDraw.filledCircle(x + .03, y - .03, .007);
    }
    //Main
    public static void main(String[]args) {
    //Background
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255));
        StdDraw.filledRectangle(.5,.5,1.0,1.0);
    //Randomization Engine
        //tomatocreature
        if (Math.random() <= .7) {
            double x, y;
                x = Math.random();
                y = Math.random();
            int red, green, blue;
                red = (int) (Math.random() * 255);
                green = (int) (Math.random() * 255);
                blue = (int) (Math.random() * 255);
                tomatocreature(x, y, red, green, blue);
        }
        //hatcreature
        if (Math.random() <= .7) {
            double x, y;
            x = Math.random();
            y = Math.random();
            int red, green, blue;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            hatcreature(x, y, red, green, blue);
        }
        //longcreature
        if (Math.random() <= .5) {
            double x, y;
            x = Math.random();
            y = Math.random();
            int red, green, blue;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            longcreature(x, y, red, green, blue);
        }
        //squarecreature
        if (Math.random() <= .5) {
            double x, y;
            x = Math.random();
            y = Math.random();
            int red, green, blue;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            squarecreature(x, y, red, green, blue);
        }
        //repetitions (chance of additional creatures appearing)
        if (Math.random() >= .8) {
            double x, y;
            x = Math.random();
            y = Math.random();
            int red, green, blue;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            tomatocreature(x + Math.random(), y + Math.random(), red, green, blue);
            longcreature(x + Math.random(), y + Math.random(), red, green, blue);
        } else if (Math.random() >= .8) {
            double x, y;
            x = Math.random();
            y = Math.random();
            int red, green, blue;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            squarecreature(x + Math.random(), y + Math.random(), red, green, blue);
            hatcreature(x + Math.random(), y + Math.random(), red, green, blue);
        }
    }
}