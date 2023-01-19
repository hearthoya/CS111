public class rightTriangle03 {
    public static void main(String[] args) {
        //Parameters
            double baselength = Double.parseDouble(args[0]);
            double height = Double.parseDouble(args[1]);
            double perimeter = (baselength + height) + Math.sqrt((Math.pow(baselength,2) + Math.pow(height,2)));
            double area = .5 * (baselength * height);
        //Drawing
            StdDraw.line(0.2, 0.3, 0.8, 0.3);
            StdDraw.line(0.2, 0.8, 0.8, 0.3);
            StdDraw.line(0.2, 0.3, 0.2, 0.8);
        //Text
            StdDraw.text(.5,.25,"Right Triangle");
            StdDraw.text(.5,.2,"Base Length: " + baselength);
            StdDraw.text(.5,.15,"Height: " + height);
            StdDraw.text(.5,.10,"Perimeter: " + perimeter);
            StdDraw.text(.5,.05,"Area: " + area);
    }
}
