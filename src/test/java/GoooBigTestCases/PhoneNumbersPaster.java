package GoooBigTestCases;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumbersPaster {
    private static List<String> phoneNumbers = new ArrayList<>();
    private static int currentIndex = 0;
    private static boolean isPasting = false;

    public static void main(String[] args) {
        try {
            loadPhoneNumbers("phone_numbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        JFrame frame = new JFrame("Phone Numbers Paster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton pasteButton = new JButton("Paste Next Number");
        pasteButton.addActionListener(e -> {
            if (!isPasting) {
                isPasting = true;
                SwingUtilities.invokeLater(() -> {
                    try {
                        pasteNextPhoneNumber();
                    } catch (AWTException ex) {
                        ex.printStackTrace();
                    } finally {
                        isPasting = false;
                    }
                });
            }
        });

        frame.add(pasteButton);
        frame.setVisible(true);
    }

    private static void loadPhoneNumbers(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                phoneNumbers.add(line);
            }
        }
    }

    private static void pasteNextPhoneNumber() throws AWTException {
        if (currentIndex < phoneNumbers.size()) {
            String phoneNumber = phoneNumbers.get(currentIndex);
            System.out.println("Pasting phone number: " + phoneNumber);
            if (setClipboardContents(phoneNumber)) {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.delay(50);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                currentIndex++;
            } else {
                System.out.println("Failed to access clipboard. Try again.");
            }
        } else {
            System.out.println("No more phone numbers to paste.");
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