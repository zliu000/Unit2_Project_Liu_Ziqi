import java.text.DecimalFormat;

public class LinearEquation {
    // Instance variables
    // Format
    private DecimalFormat df = new DecimalFormat("#.00");

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
    private double b;

    private double yIntercept;
    private double distance;


    public LinearEquation(String pointA, String pointB)
    {
        // Parsing pointA
        x1 = Integer.parseInt(pointA.substring(1, pointA.indexOf(",")));
        y1 = Integer.parseInt(pointA.substring((pointA.indexOf(",")) + 1, pointA.length()-1));

        // Parsing pointB
        x2 = Integer.parseInt(pointB.substring(1, pointB.indexOf(",")));
        y2 = Integer.parseInt(pointB.substring((pointB.indexOf(",")) + 1, pointB.length()-1));

        calculateSlope();
        calculateB();
        calculateYIntercept();
        calculateDistance();
    }

    public void calculateSlope()
    {
        // Calculating rise over run
        rise = y2 - y1;
        run = x2 - x1;

        // Checking for clean division
        if (rise%run == 0) {
            slope = (double) rise / run;
            isFraction = false;
        }
    }

    public void calculateB()
    {
        // Find B by substituting point into equation
        b = y1 - (rise / run) * x1;
    }

    public void calculateYIntercept()
    {
        yIntercept = -b / (rise / run);
    }

    public void calculateDistance()
    {
        distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1), 2));
    }

    public double calculatePoint(String x)
    {
        this.x = Integer.parseInt(x);
        y = this.x * (rise / run) + b;
        return y;
    }


    public String toString()
    {
        // Local variables
        String slopeStatement;
        String slope;
        String slopeIntecerpt;

        // Point pairs
        String pair1 = "First pair: (" + x1 + ", " + y1 + ")";
        String pair2 = "Second pair: (" + x2 + ", " + y2 + ")";

        // Check for fractions
        if (isFraction)
        {
            slope = rise + "/" + run;
        }else
        {
            slope = "" + this.slope;
        }
        slopeStatement = "Slope of the line: " + slope;

        // Y-Intercept
        String yIntercept = "Y-intercept: " + this.yIntercept;

        // Check for 0 intercept
        if (b == 0)
        {
            slopeIntecerpt = "Slope intercept form: y = " + slope + "x";
        }else
        {
            if (this.yIntercept < 0)
            {
                slopeIntecerpt = "Slope intercept form: y = " + slope + "x " + this.yIntercept;
            }else
            {
                slopeIntecerpt = "Slope intercept form: y = " + slope + "x + " + this.yIntercept;
            }

        }

        // Distance
        String distance = "Distance between points: " + df.format(this.distance);

        String info = pair1 + "\n" + pair2 + "\n" + yIntercept + "\n" + slopeStatement + "\n" + slopeIntecerpt + "\n" + distance;

        return info;


    }
}
