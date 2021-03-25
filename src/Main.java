import javafx.application.Platform;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final double threadLoopValue = 100000000000000000000000000000.0;

    public static Point mouseLoc1;
    public static Point mouseLoc2;

    public static double distanceX = 0;
    public static double directionX = 0;
    public static double rawVelocityX = 0;

    public static double smoothVelocityX = 0;
    public static double interpolationValue = 5;
    public static double animationChangeFactor = 2;

    public static String [] imageStrings = new String [] {"Vert.png", "C1.png", "C2.png", "C3.png", "C4.png", "C5.png", "C6.png", "C7.png", "C8.png", "C9.png", "C10.png", "C11.png", "C12.png", "C13.png", "C14.png", "C15.png", "C16.png", "C17.png", "C18.png",
    "CC1.png", "CC2.png", "CC3.png", "CC4.png", "CC5.png", "CC6.png", "CC7.png", "CC8.png", "CC9.png", "CC10.png", "CC11.png", "CC12.png", "CC13.png", "CC14.png", "CC15.png", "CC16.png", "CC17.png", "CC18.png"};

    public static ImageIcon [] imageIcons = new ImageIcon[imageStrings.length];

    public static JLabel label = null;

    public static void main(String[] args) throws AWTException, InterruptedException {
        // write your code here

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setAlwaysOnTop(true);
        frame.setSize(196, 120);

        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));

        label = new JLabel();
        frame.add(label);

        frame.setVisible(true);


        for (int i=0; i<imageStrings.length; i++){
            imageIcons[i] = new ImageIcon(Main.class.getResource(imageStrings[i]));
        }

        Thread mouseInfoThread = new Thread(new Runnable() {
            @Override
            public void run() {

                double temp;

                for (int i=0; i<threadLoopValue; i++){


                    try{
                        mouseLoc1 = MouseInfo.getPointerInfo().getLocation();
                    }catch (Exception e){
                        //System.out.println("Err: MouseLocNull");
                        continue;
                    }

                    try {
                        Thread.sleep(10); //Sleep 10 ms
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        continue;
                    }

                    try{
                        mouseLoc2 = MouseInfo.getPointerInfo().getLocation();
                    }catch (Exception e){
                        //System.out.println("Err: MouseLocNull");
                        continue;
                    }

                    distanceX = mouseLoc2.getX() - mouseLoc1.getX();

                    if (distanceX < 0){
                        directionX = -1;
                    }else {
                        if (distanceX > 0){
                            directionX = 1;
                        }else {
                            directionX = 0;
                        }
                    }

                    rawVelocityX = distanceX / 0.01; //0.01 s = 10 ms (From sleep)

                    temp = rawVelocityX / 60.0;//60 being max - ish velocity


                    smoothVelocityX += interpolationValue * directionX;

                    //gravity
                    if (smoothVelocityX < temp){
                        smoothVelocityX += interpolationValue;
                    }else {
                        if (smoothVelocityX > temp){
                            smoothVelocityX -= interpolationValue;
                        }
                    }

                    if (smoothVelocityX < 0){
                        smoothVelocityX += interpolationValue;
                    }else {
                        if (smoothVelocityX > 0){
                            smoothVelocityX -= interpolationValue;
                        }
                    }


                    //System.out.println(smoothVelocityX);




                }

            }
        });

        mouseInfoThread.start();



        Thread animationThread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<threadLoopValue; i++){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    //C
                    if (smoothVelocityX <= 3 && smoothVelocityX >= -3){
                        label.setIcon(imageIcons[0]);//VerticalDown Image

                        continue;
                    }

                    if (smoothVelocityX > 3 * animationChangeFactor && smoothVelocityX <= 6 * animationChangeFactor){
                        label.setIcon(imageIcons[1]);
                        continue;
                    }

                    if (smoothVelocityX > 6 * animationChangeFactor && smoothVelocityX <= 9 * animationChangeFactor){
                        label.setIcon(imageIcons[2]);
                        continue;
                    }

                    if (smoothVelocityX > 9 * animationChangeFactor && smoothVelocityX <= 12 * animationChangeFactor){
                        label.setIcon(imageIcons[3]);
                        continue;
                    }

                    if (smoothVelocityX > 12 * animationChangeFactor && smoothVelocityX <= 15 * animationChangeFactor){
                        label.setIcon(imageIcons[4]);
                        continue;
                    }

                    if (smoothVelocityX > 15 * animationChangeFactor && smoothVelocityX <= 18 * animationChangeFactor){
                        label.setIcon(imageIcons[5]);
                        continue;
                    }

                    if (smoothVelocityX > 18 * animationChangeFactor && smoothVelocityX <= 21 * animationChangeFactor){
                        label.setIcon(imageIcons[6]);
                        continue;
                    }

                    if (smoothVelocityX > 21 * animationChangeFactor && smoothVelocityX <= 24 * animationChangeFactor){
                        label.setIcon(imageIcons[7]);
                        continue;
                    }

                    if (smoothVelocityX > 24 * animationChangeFactor && smoothVelocityX <= 27 * animationChangeFactor){
                        label.setIcon(imageIcons[8]);
                        continue;
                    }

                    if (smoothVelocityX > 27 * animationChangeFactor && smoothVelocityX <= 30 * animationChangeFactor){
                        label.setIcon(imageIcons[9]);
                        continue;
                    }

                    if (smoothVelocityX > 30 * animationChangeFactor && smoothVelocityX <= 33 * animationChangeFactor){
                        label.setIcon(imageIcons[10]);
                        continue;
                    }

                    if (smoothVelocityX > 33 * animationChangeFactor && smoothVelocityX <= 36 * animationChangeFactor){
                        label.setIcon(imageIcons[11]);
                        continue;
                    }

                    if (smoothVelocityX > 36 * animationChangeFactor && smoothVelocityX <= 39 * animationChangeFactor){
                        label.setIcon(imageIcons[12]);
                        continue;
                    }

                    if (smoothVelocityX > 39 * animationChangeFactor && smoothVelocityX <= 42 * animationChangeFactor){
                        label.setIcon(imageIcons[13]);
                        continue;
                    }

                    if (smoothVelocityX > 42 * animationChangeFactor && smoothVelocityX <= 45 * animationChangeFactor){
                        label.setIcon(imageIcons[14]);
                        continue;
                    }

                    if (smoothVelocityX > 45 * animationChangeFactor && smoothVelocityX <= 48 * animationChangeFactor){
                        label.setIcon(imageIcons[15]);
                        continue;
                    }

                    if (smoothVelocityX > 51 * animationChangeFactor && smoothVelocityX <= 54 * animationChangeFactor){
                        label.setIcon(imageIcons[16]);
                        continue;
                    }

                    if (smoothVelocityX > 54 * animationChangeFactor && smoothVelocityX <= 57 * animationChangeFactor){
                        label.setIcon(imageIcons[17]);
                        continue;
                    }

                    if (smoothVelocityX > 57 * animationChangeFactor){
                        label.setIcon(imageIcons[18]);
                        continue;
                    }


                    //CC
                    if (smoothVelocityX < -3 * animationChangeFactor && smoothVelocityX >= -6 * animationChangeFactor){
                        label.setIcon(imageIcons[19]);
                        continue;
                    }

                    if (smoothVelocityX < -6 * animationChangeFactor && smoothVelocityX >= -9 * animationChangeFactor){
                        label.setIcon(imageIcons[20]);
                        continue;
                    }

                    if (smoothVelocityX < -9 * animationChangeFactor && smoothVelocityX >= -12 * animationChangeFactor){
                        label.setIcon(imageIcons[21]);
                        continue;
                    }

                    if (smoothVelocityX < -12 * animationChangeFactor && smoothVelocityX >= -15 * animationChangeFactor){
                        label.setIcon(imageIcons[22]);
                        continue;
                    }

                    if (smoothVelocityX < -15 * animationChangeFactor && smoothVelocityX >= -18 * animationChangeFactor){
                        label.setIcon(imageIcons[23]);
                        continue;
                    }

                    if (smoothVelocityX < -18 * animationChangeFactor && smoothVelocityX >= -21 * animationChangeFactor){
                        label.setIcon(imageIcons[24]);
                        continue;
                    }

                    if (smoothVelocityX < -21 * animationChangeFactor && smoothVelocityX >= -24 * animationChangeFactor){
                        label.setIcon(imageIcons[25]);
                        continue;
                    }

                    if (smoothVelocityX < -24 * animationChangeFactor && smoothVelocityX >= -27 * animationChangeFactor){
                        label.setIcon(imageIcons[26]);
                        continue;
                    }

                    if (smoothVelocityX < -27 * animationChangeFactor && smoothVelocityX >= -30 * animationChangeFactor){
                        label.setIcon(imageIcons[27]);
                        continue;
                    }

                    if (smoothVelocityX < -30 * animationChangeFactor && smoothVelocityX >= -33 * animationChangeFactor){
                        label.setIcon(imageIcons[28]);
                        continue;
                    }

                    if (smoothVelocityX < -33 * animationChangeFactor && smoothVelocityX >= -36 * animationChangeFactor){
                        label.setIcon(imageIcons[29]);
                        continue;
                    }

                    if (smoothVelocityX < -36 * animationChangeFactor && smoothVelocityX >= -39 * animationChangeFactor){
                        label.setIcon(imageIcons[30]);
                        continue;
                    }

                    if (smoothVelocityX < -39 * animationChangeFactor && smoothVelocityX >= -42 * animationChangeFactor){
                        label.setIcon(imageIcons[31]);
                        continue;
                    }

                    if (smoothVelocityX < -42 * animationChangeFactor && smoothVelocityX >= -45 * animationChangeFactor){
                        label.setIcon(imageIcons[32]);
                        continue;
                    }

                    if (smoothVelocityX < -45 * animationChangeFactor && smoothVelocityX >= -48 * animationChangeFactor){
                        label.setIcon(imageIcons[33]);
                        continue;
                    }

                    if (smoothVelocityX < -48 * animationChangeFactor && smoothVelocityX >= -51 * animationChangeFactor){
                        label.setIcon(imageIcons[34]);
                        continue;
                    }

                    if (smoothVelocityX < -51 * animationChangeFactor && smoothVelocityX >= -54 * animationChangeFactor){
                        label.setIcon(imageIcons[35]);
                        continue;
                    }

                    if (smoothVelocityX < -54 * animationChangeFactor){
                        label.setIcon(imageIcons[36]);
                        continue;
                    }


                    //System.out.println(frame.getBackground());

                }
            }
        });

        animationThread.start();



        Thread mousePositionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Point mouseTempLoc;
                //Point point;

                for (int i=0; i<threadLoopValue; i++){

                    try{
                        mouseTempLoc = MouseInfo.getPointerInfo().getLocation();
                    }catch (Exception e){
                        //System.out.println("Err: MouseLocNull");
                        continue;
                    }

                    //point = new Point(mouseTempLoc.x - 98, mouseTempLoc.y + 10);
                    frame.setLocation(mouseTempLoc.x - 98, mouseTempLoc.y + 10);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        });

        mousePositionThread.start();


    }
}
