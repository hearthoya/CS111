public class Solid2 {
    public static void main(String[] args) {
//Instructions: Use arguments 0 through 2 to input/pass the given parameters for the rectangular prism: 0 = length, 1 = width, 2 = height
        //Parameters
        double length = Double.parseDouble(args[0]);
        double width = Double.parseDouble(args[1]);
        double height = Double.parseDouble(args[2]);
        double volume = length * width * height;
        //Drawing
        StdDraw.line(.2,.35,.4,.35);
        StdDraw.line(.2,.35,.2,.5);
        StdDraw.line(.4,.35,.4,.5);
        StdDraw.line(.2,.5,.4,.5);
        StdDraw.line(.4,.5,.74,.8);
        StdDraw.line(.74,.8,.74,.65);
        StdDraw.line(.4,.35,.74,.65);
        StdDraw.line(.54,.8,.74,.8);
        StdDraw.line(.2,.5,.54,.8);
        StdDraw.line(.54,.65,.54,.8);
        StdDraw.line(.54,.65,.74,.65);
        StdDraw.line(.2,.35,.54,.65);
        //Text
        StdDraw.text(.5,.25,"Rectangular Prism");
        StdDraw.text(.5,.2,"Length: " + length);
        StdDraw.text(.5,.15,"Width: " + width);
        StdDraw.text(.5,.10,"Height: " + height);
        StdDraw.text(.5,.05,"Volume: " + volume);
    }
}
