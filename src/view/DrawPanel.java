//package view;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class DrawPanel extends JPanel {
//
//    private double multiplier = 50;
//    private int width = 1000;
//    private int axisOffset = width / 2;
//    private int size = 25;
//    private int sizeOffset = size / 2;
//    private JFrame application = new JFrame();
//
//
//    public DrawPanel() {
//        super();
//        setBackground(Color.BLACK);
//    }
//
//    public void paintComponent(Graphics g) {
//
//        super.paintComponent(g);            // call superclass to make panel display correctly
//
//        g.setColor(Color.YELLOW);
//        g.drawLine(0, width / 2, width, width / 2);
//        g.drawLine(width / 2, 0, width / 2, width);
//
//        g.setColor(Color.RED);
//
//
//        int frequency = 0;
//
//
//        for(int i = 0; i < frequencies.length; i++) {
//            if(i < 20) {
//                g.setColor(Color.BLACK);
//            } else if(i > 20000) {
//                g.setColor(Color.BLACK);
//            } else {
//                g.setColor(Color.CYAN);
//            }
//            double realPart = outReal[i];
//            double imaginaryPart = outImag[i];
//
//            if(realPart == 0 && imaginaryPart == 0) {
//                if(time > 20000) {
////                    System.out.println("both zero at i = " + i);
////                    System.exit(0);
//                }
//            } else {
//                System.out.print("\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n");
//            }
//
//            double magnitude = this.getMagnitude(realPart, imaginaryPart);
////            System.out.println("MAG: " + magnitude);
//            int x = this.getX(i);
//            int y = 500;
//
//            g.fillRect(x, y - (int) (magnitude * 4), 1, (int) (magnitude * 4 ));
//            if(magnitude != 0) {
//                output(new Complex(outReal[i], outImag[i]), frequency);
//            }
//            frequency++;
//        }
//        time++;
//    }
//
//    private void drawStartScreen() {
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        application.setSize(width, width);
//        application.add(this);
//        application.setVisible(true);
//    }
//
//    private void output(Complex c, int bucket) {
//        System.out.println("x: " + c.re + ", y: " + c.im +
//                "\nmagnitude: " + this.getMagnitude(c.re, c.im) + " for " +
//                "frequency: " + bucket + "\n------------------------------\n");
//    }
//
//    private int getX(double frequency) {
//        return (int) (frequency * 2);
//    }
//
//    private int getY(double magnitude) {
//        return (int) (axisOffset - (magnitude * multiplier) - sizeOffset);
//    }
//
//    private double getMagnitude(double a, double b) {
//        return Math.sqrt(a * a + b * b) * 2 / 128;
//        //the magnitude is the magnitude of the triangle formed by the real
//        // and imaginary parts, multiplied by 2 and divided by your sample size
//
//        //the youtube video that explained this well has info on why and the
//        // limits of sampling
//    }
//}
