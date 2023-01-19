public class Solid1 {
    public static void main(String[] args) {
    //Instructions: Use arguments 0 through 2 to input/pass the given parameters for the pyramid. 0 = base length, 1 = base width, 2 = height
        //Parameters
            double baselength = Double.parseDouble(args[0]);
            double basewidth = Double.parseDouble(args[1]);
            double height = Double.parseDouble(args[2]);
            double volume = (((baselength * basewidth * height)/3));
        //Drawing
        StdDraw.line(.2, .4, .5,.35);
        StdDraw.line(.5,.35, .72, .43);
        StdDraw.line(.5, .35,.45, .74);
        StdDraw.line(.2,.4, .45, .74);
        StdDraw.line(.72,.43,.45,.74);
        StdDraw.line(.2,.4,.43,.462);
        StdDraw.line(.43,.462,.72,.43);
        StdDraw.line(.43,.462,.45,.74);
        //Text
        StdDraw.text(.5,.25,"Pyramid");
        StdDraw.text(.5,.2,"Base Length: " + baselength);
        StdDraw.text(.5,.15,"Base Width: " + basewidth);
        StdDraw.text(.5,.10,"Height: " + height);
        StdDraw.text(.5,.05,"Volume: " + volume);
    }
}
