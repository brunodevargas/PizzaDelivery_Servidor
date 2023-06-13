package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculapreco {
    
        //Cria a tabela de preços
    private static Map<String, Double> preco;

    static {
        // Defina os preços das pizzas
        preco = new HashMap<>();
        //Pizza Salgadas
        preco.put("Pizza de Marguerita", 29.9);
        preco.put("Pizza de Calabresa", 29.9);
        preco.put("Pizza de Frango", 29.9);
        preco.put("Pizza de Portuguesa", 29.9);
        preco.put("Pizza de Quatro queijos", 29.9);
        //Pizza doces
        preco.put("Pizza de Chocolate branco", 19.9);
        preco.put("Pizza de Chocolate preto", 19.9);
        preco.put("Pizza de Banana", 19.9);
        preco.put("Pizza de Nutela", 19.9);
        //Bebidas
        preco.put("Coca", 7.0);
        preco.put("Funta", 6.0);
        preco.put("Guaraney", 5.5);
        preco.put("Suco de Laranja", 6.5);
        preco.put("Agua", 4.0);
        //Acompanhamento
        preco.put("Ketchup", 3.0);
        preco.put("Maionese", 3.0);
        preco.put("Mostarda", 3.0);
    }
   
    //Cacula o preço total do Pedido
    public static double calcularValorTotal(ArrayList<Pedido> pedidos) {
        double valorTotal = 0.0;

        // Itere sobre os pedidos e calcule o valor total com base nos sabores e quantidades
        for (Pedido ped : pedidos) {
            String sabor = ped.getItem();
            int quantidade = ped.getQuantidade();
            if (preco.containsKey(sabor)) {
                double preco = Calculapreco.preco.get(sabor);
                valorTotal += preco * quantidade;
            } else {
                System.out.println("Sabor de pizza inválido: " + sabor);
            }
        }

        return valorTotal;
    }
}


