package controler;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class Server {
    private JFrame frame;
    private JButton[][] gridButtons;
    private JTextArea chatArea;
    private PrintWriter out;
    private BufferedReader in;
    private boolean canSend = true;

    public Server() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("PingPong Server");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // Setze die bevorzugte Größe für die JScrollPane
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setPreferredSize(new Dimension(450, 150)); // Hier kannst du die Größe anpassen

        // Auto-Scrolling für den Chat-Bereich
        DefaultCaret caret = (DefaultCaret)chatArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

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
        chatArea.append("Server: " + message + "\n"); // Nachricht in chatArea hinzufügen
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
        chatArea.append("From Client: " + message + "\n");
        if (message.startsWith("shot")) {
            String[] parts = message.split(" ");
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            if (y == 0) { // Alle Felder mit y = 0 sind Schiffe
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
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Server window = new Server();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
