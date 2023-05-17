import java.awt.Font;

public class Project {
    //Create chord name string
    private static String chordName = "No chord yet";
    //Set font for menu title(s)
    private static final Font bigFont = new Font("Georgia", Font.BOLD, 32);
    //Set font for options/smaller text
    private static final Font smallFont = new Font("Georgia", Font.BOLD, 20);
    //set smaller font
    private static final Font smallerFont = new Font("Georgia", Font.PLAIN, 18);
    //set smallest font
    private static final Font smallestFont = new Font("Georgia", Font.PLAIN, 16);

    public static void main(String[] args) {
        title();
        while (true) {
            //Check if space is pressed to change to the next image/slide
            if (StdDraw.hasNextKeyTyped()) {
                //accept keyboard input
                String Key = String.valueOf(StdDraw.nextKeyTyped());
                if (" ".equals(Key)) {
                    menu(smallFont, smallerFont, smallestFont);
                }
                mainSwitch(Key);
            }
        }
    }

    public static void title() {
        //draw a default image/menu on canvas
        StdDraw.picture(.4, .6, "menu.JPG", .94, .94);
        //Draw title
        StdDraw.setFont(bigFont);
        StdDraw.text(.73, .35, "Guitar Synth");
        //Draw proceed text
        StdDraw.setFont(smallFont);
        StdDraw.text(.73, .25, "Press space to proceed");
    }

    public static void menu(Font smallFont, Font smallerFont, Font smallestFont) {
        //set pen color + draw background
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledSquare(.5, .5, .7);
        //write intro text
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.text(.5, .85, "Hello, which mode would you like to use?");
        StdDraw.text(.12, .7, "There are:");
        //set another font for smaller print/longer writing
        StdDraw.setFont(smallerFont);
        //write out mode descriptions + prompt user
        StdDraw.text(.45, .6, "Train mode - allows you to play each guitar string");
        StdDraw.text(.424, .5, "Chords mode - allows you to play basic chords");
        StdDraw.text(.427, .4, "Jazz mode - allows you to extended jazz chords");
        //set another font for smallest print/longer writing
        StdDraw.setFont(smallestFont);
        StdDraw.text(.5, .3, "To select a mode, type the number corresponding to the mode \nyou'd");
        StdDraw.text(.39, .25, "like to use (1 for Train, 2 for Chords, and 3 for Jazz)");
        //reset font for modes
        StdDraw.setFont(smallFont);
    }

    public static void trainCase(String Key) {
        System.out.println("\nTo use the Train mode, play with the a, s, d, f, e and r keys on your keyboard. Each key corresponds to a different open guitar string.");
        StdDraw.clear();
        StdDraw.picture(.5, .5, "train.PNG", .5, .8);
        while (true) {
            // if the user has typed a key do stuff with it
            if (StdDraw.hasNextKeyTyped()) {
                // wait for input
                Key = String.valueOf(StdDraw.nextKeyTyped());
                //set pen color
                StdDraw.setPenColor(255, 0, 0);
                switch (Key) {
                    case "a":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.315, .13, .02);
                        //play sound
                        StdAudio.play("Elostr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.315, .13, .023);
                        break;
                    case "s":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.386, .13, .02);
                        //play sound
                        StdAudio.play("Astr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.385, .13, .023);
                        break;
                    case "d":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.460, .13, .02);
                        //play sound
                        StdAudio.play("Dstr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.460, .13, .023);
                        break;
                    case "f":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.532, .13, .02);
                        //play sound
                        StdAudio.play("Gstr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.532, .13, .023);
                        break;
                    case "e":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.604, .13, .02);
                        //play sound
                        StdAudio.play("Bstr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.604, .13, .023);
                        break;
                    case "r":
                        //draw red dot to indicate string played
                        StdDraw.filledCircle(.677, .13, .02);
                        //play sound
                        StdAudio.play("estr.WAV");
                        //draw white circle over old circle to erase it
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.filledCircle(.677, .13, .023);
                        break;
                    case " ":
                        return;
                }
            }
        }
    }

    public static void chordCase(String Key, String chordName) {
        System.out.println("\nTo use the Chord mode, play with the a, s, d, f keys on your keyboard. Each key corresponds to a different basic guitar chord.");
        StdDraw.clear();
        //Draw background
        StdDraw.picture(.839, .5, "chords.JPG");
        //draw chord acceptor
        StdDraw.setPenColor(54, 35, 21);
        StdDraw.filledRectangle(.5, .51, .3, .045);
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.text(.5, .505, "Current chord: " + chordName);
        while (true) {
            // if the user has typed a key do stuff with it
            if (StdDraw.hasNextKeyTyped()) {
                // wait for input
                Key = String.valueOf(StdDraw.nextKeyTyped());
                switch (Key) {
                    case "a":
                        //Set pen color and cover previous chord names
                        StdDraw.setPenColor(54, 35, 21);
                        StdDraw.filledRectangle(.66, .51, .14, .045);
                        //Reset chord name + pen color
                        chordName = "C major 5";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.66, .505, chordName);
                        StdAudio.play("C.WAV");
                        break;
                    case "s":
                        //Set pen color and cover previous chord names
                        StdDraw.setPenColor(54, 35, 21);
                        StdDraw.filledRectangle(.66, .51, .14, .045);
                        //Reset chord name + pen color
                        chordName = "E major 5";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.66, .505, chordName);
                        StdAudio.play("E.WAV");
                        break;
                    case "d":
                        //Set pen color and cover previous chord names
                        StdDraw.setPenColor(54, 35, 21);
                        StdDraw.filledRectangle(.66, .51, .14, .045);
                        //Reset chord name + pen color
                        chordName = "G major 5";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.66, .505, chordName);
                        StdAudio.play("G.WAV");
                        break;
                    case "f":
                        //Set pen color and cover previous chord names
                        StdDraw.setPenColor(54, 35, 21);
                        StdDraw.filledRectangle(.66, .51, .14, .045);
                        //Reset chord name + pen color
                        chordName = "D major 5";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.66, .505, chordName);
                        StdAudio.play("D.WAV");
                        break;
                    case " ":
                        return;
                }
            }
        }
    }

    public static void jazzCase(String Key, String chordName) {
        StdDraw.clear();
        //Draw background
        StdDraw.picture(.5, .5, "jazz.JPG");
        //draw chord acceptor
        StdDraw.setPenColor(70, 42, 76);
        StdDraw.filledRectangle(.5, .5, .3, .045);
        StdDraw.setPenColor(255, 255, 255);
        //create chord name var
        chordName = "No chord yet";
        StdDraw.text(.5, .5, "Current chord: " + chordName);
        while (true) {
            // if the user has typed a key do stuff with it
            if (StdDraw.hasNextKeyTyped()) {
                // wait for input
                Key = String.valueOf(StdDraw.nextKeyTyped());
                switch (Key) {
                    case "a":
                        //Set pen color and cover previous chord names
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "C major 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Cmajor7.WAV");
                        break;
                    case "s":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "D minor 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Dminor7.WAV");
                        break;
                    case "d":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "E minor 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Eminor7.WAV");
                        break;
                    case "f":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "F major 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Fmajor7.WAV");
                        break;
                    case "q":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "G major 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Gmajor7.WAV");
                        break;
                    case "w":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "A minor 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Aminor7.WAV");
                        break;
                    case "e":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "B diminished";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.66, .5, chordName);
                        StdAudio.play("Bdim.WAV");
                        break;
                    case "r":
                        StdDraw.setPenColor(70, 42, 76);
                        StdDraw.filledRectangle(.66, .5, .14, .045);
                        //Reset chord name + pen color
                        chordName = "C major 7";
                        StdDraw.setPenColor(255, 255, 255);
                        StdDraw.text(.65, .5, chordName);
                        StdAudio.play("Cmajor7(hi).WAV");
                        break;
                    case " ":
                        return;
                }
            }
        }

    }

    public static void mainSwitch(String Key) {
        switch (Key) {
            case "1":
                trainCase(Key);
                break;
            case "2":
                chordCase(Key, chordName);
                break;
            case "3":
                jazzCase(Key, chordName);
                break;
        }
    }
}