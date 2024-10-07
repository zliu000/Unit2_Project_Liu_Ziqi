import java.text.DecimalFormat;

public class LinearEquation {
    // Instance variables
    // Format
    private DecimalFormat df = new DecimalFormat("#0.00");

    // Points
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double x;
    private double y;

    // Slopes
    private boolean isFraction = true;
    private int rise;
    private int run;
    private double slope;

    private double yIntercept;
    private double distance;


    public LinearEquation(String pointA, String pointB) {
        // Parsing pointA
        x1 = Integer.parseInt(pointA.substring(1, pointA.indexOf(",")));
        y1 = Integer.parseInt(pointA.substring((pointA.indexOf(",")) + 1, pointA.length() - 1));

        // Parsing pointB
        x2 = Integer.parseInt(pointB.substring(1, pointB.indexOf(",")));
        y2 = Integer.parseInt(pointB.substring((pointB.indexOf(",")) + 1, pointB.length() - 1));

        calculateSlope();
        calculateYIntercept();
        calculateDistance();
    }

    public void calculateSlope() {
        // Calculating rise over run
        rise = y2 - y1;
        run = x2 - x1;

        // Checking for clean division
        if (rise % run == 0) {
            slope = (double) rise / run;
            isFraction = false;
        }

        if (rise < 0 && run < 0) {
            rise = Math.abs(rise);
            run = Math.abs(run);
        }
    }

    public void calculateYIntercept() {
        // Find B by substituting point into equation
        yIntercept = y1 - ((double) rise / run) * x1;
    }


    public void calculateDistance() {
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public String calculatePoint(String x) {
        this.x = Double.parseDouble(x);
        y = this.x * ((double) rise / run) + yIntercept;
        return "Solved coordinate point is: (" + this.x + "," + df.format(y) + ")";
    }


    public String toString() {
        // Local variables
        String slopeStatement; // statement + slope
        String slope; // the slope, without any statement
        String slopeIntecept; // slope-intercept form

        // Point pairs
        String pair1 = "First pair: (" + x1 + ", " + y1 + ")";
        String pair2 = "Second pair: (" + x2 + ", " + y2 + ")";

        // Check for fractions in slope
        if (isFraction) {
            slope = rise + "/" + run;
            int negativeIndex = slope.indexOf("-");
            if (negativeIndex != -1) {
                String beforeNeg = slope.substring(0, negativeIndex+1);
                String afterNeg = slope.substring(negativeIndex + 1);
                slope = beforeNeg + afterNeg;
                slopeStatement = "Slope of line: " + slope;
            } else {
                slopeStatement = "Slope of line: " + slope;
            }
        } else {
            if (this.slope == 1) {
                slope = "";
                slopeStatement = "Slope of line: " + this.slope;
            } else if (this.slope == -1) {
                slope = "-";
                slopeStatement = "Slope of line: " + this.slope;
            } else {
                slope = "" + this.slope;
                slopeStatement = "Slope of line: " + slope;
            }
        }


        // Y-Intercept
        String yIntercept = "Y-intercept: " + df.format(this.yIntercept);

        // Check for 0 intercept
        if (this.yIntercept == 0) {
            slopeIntecept = "Slope intercept form: y = " + slope + "x";
        } else {
            if (this.yIntercept < 0) {
                slopeIntecept = "Slope intercept form: y = " + slope + "x " + df.format(this.yIntercept);
            } else {
                slopeIntecept = "Slope intercept form: y = " + slope + "x + " + df.format(this.yIntercept);
            }

        }

        // Distance
        String distance = "Distance between points: " + df.format(this.distance);

        String info = pair1 + "\n" + pair2 + "\n" + slopeStatement + "\n" + yIntercept + "\n" + slopeIntecept + "\n" + distance;

        return info;

    }
}
