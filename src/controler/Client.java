package controler;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client {
    private JFrame frame;
    private JTextField messageField;
    private JButton sendButton;
    private JTextArea chatArea;
    private PrintWriter out;
    private BufferedReader in;
    private boolean canSend = false;

    public Client() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("PingPong Client");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        messageField = new JTextField();
        messageField.setBounds(10, 230, 350, 20);
        frame.getContentPane().add(messageField);
        messageField.setColumns(10);

        sendButton = new JButton("Send");
        sendButton.setBounds(370, 230, 100, 20);
        frame.getContentPane().add(sendButton);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBounds(10, 10, 460, 210);
        frame.getContentPane().add(scrollPane);

        setUpNetworking();
        Thread readerThread = new Thread(this::readMessages);
        readerThread.start();

        sendButton.addActionListener(e -> {
            if (canSend) {
                sendMessage();
                canSend = false;
            }
        });
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

    private void readMessages() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                chatArea.append("Server: " + message + "\n");
                canSend = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageField.getText();
        chatArea.append("Client: " + message + "\n");
        out.println(message);
        messageField.setText("");
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