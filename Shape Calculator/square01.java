public class square01 {
    public static void main(String[] args) {
    //Parameters
        double sidelength = Double.parseDouble(args[0]);
        double perimeter = sidelength * 4;
        double area = Math.pow(sidelength,2);
    //Drawing
        StdDraw.square(.5, .5, .2);
    //Text
        StdDraw.text(.5,.25,"Square");
        StdDraw.text(.5,.2,"Perimeter: " + perimeter);
        StdDraw.text(.5,.15,"Edge Length: " + sidelength);
        StdDraw.text(.5,.10," Area: " + area);
    }
}
