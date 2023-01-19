public class rectangle02 {
    public static void main(String[] args) {
    //Parameters
        double baselength = Double.parseDouble(args[0]);
        double height = Double.parseDouble(args[1]);
        double perimeter = 2 * (baselength + height);
        double area = baselength * height;
    //Drawing
        StdDraw.rectangle(.5,.6,.1,.25);
    //Text
        StdDraw.text(.5,.25,"Rectangle");
        StdDraw.text(.5,.2,"Base Length: " + baselength);
        StdDraw.text(.5,.15,"Height: " + height);
        StdDraw.text(.5,.10,"Perimeter: " + perimeter);
        StdDraw.text(.5,.05,"Area: " + area);
    }
}
