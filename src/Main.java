import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final Parabola P1 = new Parabola(3, 1, 1);
    public static final Rectangle RM = new Rectangle(3, 2, 1, -3);
    public static final Rectangle RSR = new Rectangle(4, 9, 0, -2);
    public static final Rectangle RB = new Rectangle(5, 8, -2, -1);
    public static final HorizontalParabola HP1 = new HorizontalParabola(-2, -4, 1);

    public static SimpleColor getColor(double x, double y) {

        if (y < -1 && HP1.isPointInsideOfHorizontalParabola(x, y) && RM.isPointInsideRectangle(x, y)){
            return SimpleColor.ORANGE;
        }

        if (HP1.isPointInsideOfHorizontalParabola(x, y)){
            return SimpleColor.YELLOW;
        }

        if (x >= 3 && !RSR.isPointInsideRectangle(x, y) && RB.isPointInsideRectangle(x, y)){
            return SimpleColor.YELLOW;
        }

        if (y > 0 && x > 0 && P1.isPointInsideOfParabola(x, y) && !RSR.isPointInsideRectangle(x, y) && !RB.isPointInsideRectangle(x, y)){
            return SimpleColor.GREY;
        }

        if (y >= 0 && x >= 0 && !P1.isPointInsideOfParabola(x, y) && !RM.isPointInsideRectangle(x, y) && RSR.isPointInsideRectangle(x, y) && RB.isPointInsideRectangle(x, y)){
            return SimpleColor.ORANGE;
        }

        if (y > 0 && P1.isPointInsideOfParabola(x, y) && RM.isPointInsideRectangle(x, y) && RSR.isPointInsideRectangle(x, y) && RB.isPointInsideRectangle(x, y)){
            return SimpleColor.ORANGE;
        }

        if (RSR.isPointInsideRectangle(x, y) && RM.isPointInsideRectangle(x, y)){
            return SimpleColor.GREY;
        }

        if (x <= 3 && RB.isPointInsideRectangle(x, y) && !P1.isPointInsideOfParabola(x, y) ){
            return SimpleColor.GREEN;
        }

        if (x <= 4 && P1.isPointInsideOfParabola(x, y) && RSR.isPointInsideRectangle(x, y) && RB.isPointInsideRectangle(x, y)){
            return SimpleColor.BLUE;
        }

        if (y >= 0 && x >= 0 &&!HP1.isPointInsideOfHorizontalParabola(x, y) && !P1.isPointInsideOfParabola(x, y)  && !RM.isPointInsideRectangle(x, y) && !RSR.isPointInsideRectangle(x, y) && !RB.isPointInsideRectangle(x, y)){
            return SimpleColor.WHITE;
        }

        return SimpleColor.ORANGE;
    }


    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%s, %s) -> %s", x, y, getColor(x, y));
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);


        printColorForPoint(-7, 5);
        printColorForPoint(-1, -1);
        printColorForPoint(7, 5);
        printColorForPoint(3.5, 2.2);
        printColorForPoint(-9, 0);
        printColorForPoint(-8, -1.1);
        printColorForPoint(-8, -4);
        printColorForPoint(0, -5);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = scanner.nextDouble();
        System.out.print("Input y: ");
        double y = scanner.nextDouble();
        printColorForPoint(x, y);
    }

}