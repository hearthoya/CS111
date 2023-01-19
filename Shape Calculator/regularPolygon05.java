public class regularPolygon05 {
    public static void main(String[]args) {
        //Parameters
            int numberofedges = Integer.parseInt(args[0]);
            double edgelength = Double.parseDouble(args[1]);
            double perimeter = (numberofedges * edgelength);
            double apothem = edgelength/ (2 * Math.tan((Math. PI)/numberofedges));
            double area = .5 * (apothem * perimeter);
        //Drawing
            StdDraw.line(.3, .3, .7, .3);
            StdDraw.line(.3, .3,.22, .6);
            StdDraw.line(.22, .6,.52, .79);
            StdDraw.line(.52, .79,.78, .6);
            StdDraw.line(.7, .3,.78, .6);
        //Text
            StdDraw.text(.5,.24,"Square");
            StdDraw.text(.5,.2,"Number of Edges: " + numberofedges);
            StdDraw.text(.5,.16,"Edge Length: " + edgelength);
            StdDraw.text(.5,.12,"Perimeter: " + perimeter);
            StdDraw.text(.5,.08,"Apothem: " + apothem);
            StdDraw.text(.5,.04,"Area: " + area);
    }
}
