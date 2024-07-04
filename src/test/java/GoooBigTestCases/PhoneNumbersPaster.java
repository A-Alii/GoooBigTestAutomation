package GoooBigTestCases;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class PhoneNumbersPaster {
    private static BufferedReader reader;
    private static boolean isPasting = false;
    private static int pasteCount = 0; // Track the number of pastes

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new FileReader("phone_numbers.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        JFrame frame = new JFrame("Phone Numbers Paster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0) && !isPasting) {
                    isPasting = true;
                    SwingUtilities.invokeLater(() -> {
                        try {
                            pasteNextPhoneNumber();
                        } catch (AWTException | IOException awtException) {
                            awtException.printStackTrace();
                        }
                    });
                }
            }
        });

        frame.setVisible(true);
    }

    private static void pasteNextPhoneNumber() throws IOException, AWTException {
        String phoneNumber = reader.readLine();
        if (phoneNumber != null) {
            if (setClipboardContents(phoneNumber)) {
                System.out.println("Pasting phone number: " + phoneNumber);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            } else {
                System.out.println("Failed to access clipboard. Try again.");
            }
        } else {
            System.out.println("No more phone numbers to paste.");
            resetReader();
        }
    }

    private static void resetReader() {
        try {
            reader.close(); // Close the current reader
            reader = new BufferedReader(new FileReader("phone_numbers.txt")); // Open a new reader
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean setClipboardContents(String contents) {
        try {
            StringSelection selection = new StringSelection(contents);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
