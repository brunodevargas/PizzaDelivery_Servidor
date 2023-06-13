package principal;

import model.ServidorSocket;

public class Principal {

    public static void main(String[] args) {
        ServidorSocket servidor = new ServidorSocket();
        servidor.createGUI();

        // Cria uma thread para o método enviapreco()
        Thread threadEnviaPreco = new Thread(servidor::enviapreco);
        threadEnviaPreco.start();

        // Cria uma thread para o método pegapedido()
        Thread threadPegaPedido = new Thread(servidor::pegapedido);
        threadPegaPedido.start();
    }
}
