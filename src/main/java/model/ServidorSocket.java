package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ServidorSocket {
    private JFrame frame;

   public void enviapreco() {
    ServerSocket serverSocket = null;

    try {
        // Cria um ServerSocket que aguarda conexões na porta especificada
        serverSocket = new ServerSocket(4444);
        System.out.println("Servidor aguardando conexões... Para preço");

        while (true) {
            // Aguarda uma conexão
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

            // Cria Fluxo de entrada e saída
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Recebe o ArrayList de pedidos enviado pelo cliente
            ArrayList<Pedido> pedidos = (ArrayList<Pedido>) inputStream.readObject();

            // Exibe itens do Array
            for (Pedido ped : pedidos) {
                System.out.println("Pedido recebido: " + ped.toString());
            }

            double valorTotal = Calculapreco.calcularValorTotal(pedidos);
            System.out.println(valorTotal);
            String valorTotalString = String.format("%.2f", valorTotal);

            // Envia a String do valor total para o cliente
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(valorTotalString);
            outputStream.flush();

            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("Processo de preço finalizado");
        }

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }

    public void pegapedido() {
    ServerSocket serverSocket = null;

    try {
        // Cria um ServerSocket que aguarda conexões na porta especificada
        serverSocket = new ServerSocket(4445);
        System.out.println("Servidor aguardando conexões... Para pedido");

        while (true) {
            // Aguarda uma conexão
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

            // Cria Fluxo de entrada
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Recebe o ArrayList de pedidos enviado pelo cliente
            ArrayList<Informacoes> pedidos = (ArrayList<Informacoes>) inputStream.readObject();

            Email.enviaremail(pedidos);

            inputStream.close();
            socket.close();
            System.out.println("Processo de pedido finalizado");
        }

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }


    public void createGUI() {
        frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton closeButton = new JButton("Fechar Servidor");
        closeButton.addActionListener(e -> stopServer());

        panel.add(closeButton);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void stopServer() {
        frame.dispose(); // Fecha a janela do servidor
        System.exit(0); // Encerra o programa inteiro
    }
}



