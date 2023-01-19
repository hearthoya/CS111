public class RandomAnimation {
    //bg is a small method to set background as pink when called in each for loop
    public static void bg() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(230,220,230);
        StdDraw.filledRectangle(.5,.5,1.0,1.0);
    }
    public static void main(String[]args) {
        //element 1 and 2 movement/animation
        //while true ensures indefinite loop until user closes the canvas
        while (true) {
            //initialize double buffering
            StdDraw.enableDoubleBuffering();
            //color variables (r,g and b vals are randomized for each loop but the two elements match each other)
            int r, g, b;
            r = (int) (Math.random() * 255);
            g = (int) (Math.random() * 255);
            b = (int) (Math.random() * 255);
            //position vals are randomized and then regulated using while loops
            double x, y, x2, y2;
            //x and y vals
            x = Math.random();
            y = Math.random();
            //while loops ensure x and y are random within a suitable range so the whole animation is visible
            while (!(x > .2 && x <= .6)) {
                x = Math.random();
            }
            while (!(y > .2 && y <= .55)) {
                y = Math.random();
            }
            //x2 and y2 are for the coordinates of the square creature so the position vars are distinct
            x2 = x + .4;
            y2 = y - .07;
            //for loops/movement engine
            //moves both elements to the right or left for the first time
            for (int i = 0; i <= 406; i++) {
                //clears canvas at the start of a loop
                StdDraw.clear();
                //aformentioned background method
                bg();
                //both elements are altered based on their velocity values
                RandomDrawing.hatcreature((x += .001), y, r, g, b);
                RandomDrawing.squarecreature((x2 -= .0012), y2, r, g, b);
                //canvas is shown at the end of a loop
                StdDraw.show();
                //canvas is paused and unpaused to show movement with double buffering
                StdDraw.pause(5);
            }
            //moves both elements up
            for (int i = 406; i <= 506; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature(x, (y += .001), r, g, b);
                RandomDrawing.squarecreature(x2, (y2 += .001), r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //moves both elements top the right or left again
            for (int i = 506; i <= 912; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature((x -= .001), y, r, g, b);
                RandomDrawing.squarecreature((x2 += .0012), y2, r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //moves both elements up again
            for (int i = 912; i <= 1012; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature(x, (y += .001), r, g, b);
                RandomDrawing.squarecreature(x2, (y2 += .001), r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //moves both elements right or left once more
            for (int i = 1012; i <= 1418; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature((x += .001), y, r, g, b);
                RandomDrawing.squarecreature((x2 -= .0012), y2, r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //moves both elements up once more
            for (int i = 1418; i <= 1518; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature(x, (y += .001), r, g, b);
                RandomDrawing.squarecreature(x2, (y2 += .001), r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //moves both elements right or left for the final time
            for (int i = 1518; i <= 1750; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature(x -= .001, y, r, g, b);
                RandomDrawing.squarecreature((x2 += .0012), y2, r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
            //sends both elements dashing off the screen
            for (int i = 1750; i <= 1840; i++) {
                StdDraw.clear();
                bg();
                RandomDrawing.hatcreature(x, y += .025, r, g, b);
                RandomDrawing.squarecreature(x2, y2 += .025, r, g, b);
                StdDraw.show();
                StdDraw.pause(5);
            }
        }
    }
}
