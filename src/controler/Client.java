package controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class Client {
    private JFrame frame;
    private JButton[][] gridButtons;
    private JTextArea chatArea;
    private PrintWriter out;
    private BufferedReader in;
    private boolean canSend = false;

    public Client() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("PingPong Client");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);

        JPanel gridPanel = new JPanel(new GridLayout(10, 10)); // 10x10 Grid
        gridButtons = new JButton[10][10];
        for (int i = 0; i < gridButtons.length; i++) {
            for (int j = 0; j < gridButtons[i].length; j++) {
                gridButtons[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                gridButtons[i][j].addActionListener(e -> handleButtonPress(finalI, finalJ));
                gridPanel.add(gridButtons[i][j]);
            }
        }
        frame.getContentPane().add(gridPanel, BorderLayout.CENTER);

        setUpNetworking();
        Thread readerThread = new Thread(this::readMessages);
        readerThread.start();
    }

    private void handleButtonPress(int x, int y) {
        if (canSend) {
            sendMessage("shot " + x + " " + y);
            canSend = false;
        }
    }

    private void sendMessage(String message) {
        out.println(message);
        chatArea.append("Client: " + message + "\n"); // Nachricht in chatArea hinzufügen
    }


    private void readMessages() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                handleReceivedMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleReceivedMessage(String message) {
        chatArea.append("From Server: " + message + "\n");
        if (message.startsWith("shot")) {
            String[] parts = message.split(" ");
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            if (x == 0) { // Alle Felder mit x = 0 sind Schiffe
                sendMessage("hit");
            } else {
                sendMessage("miss");
            }
        } else if (message.equals("hit")) {
            canSend = true;
        } else if (message.equals("miss")) {
            sendMessage("done");
            canSend = false;
        } else if (message.equals("done")) {
            canSend = true;
        }
    }

    private void setUpNetworking() {
        try {
            String serverAddress = "127.0.0.1";
            Socket socket = new Socket(serverAddress, 1234);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Client window = new Client();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
