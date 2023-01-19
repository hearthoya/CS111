public class circle04 {
    public static void main(String[] args) {
        //Parameters
            double diameter = Double.parseDouble(args[0]);
            double perimeter = diameter * (Math. PI);
            double area = (Math. PI) * (Math.pow((diameter * .5),2));
        //Drawing
            StdDraw.circle(.5,.5,.2);
        //Text
            StdDraw.text(.5,.25,"Circle");
            StdDraw.text(.5,.2,"Diameter: " + diameter);
            StdDraw.text(.5,.15,"Perimeter: " + perimeter);
            StdDraw.text(.5,.10,"Area: " + area);
    }
}
