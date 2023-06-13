package model;

import java.util.ArrayList;

public class Pedido extends Informacoes {
     
    public static ArrayList<Pedido> pedid = new ArrayList<>();
    public static ArrayList<Informacoes> pedidofinal = new ArrayList<>();
 
    private String item;
    private int quantidade;

   
    public Pedido(){
    }
    
    public Pedido(String item,int quantidade){
        this.item = item;
        this.quantidade = quantidade;
    }
    
    public ArrayList getLista() {
        return (ArrayList) info;
    }
    
    public ArrayList<Informacoes> getPedidofinal() {
        return pedidofinal;
    }
    
    public ArrayList<Pedido> getPedid() {
        return pedid;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean deletaPedido(){
        pedid.clear();
        return true;
    }
    
    public boolean delatainfos(){
        info.clear();
        pedid.clear();
        pedidofinal.clear();
        return true;
    }
     
    public boolean salvainfo(String nome, String telefone, String email, String cep, String endereco, String numero){
        Informacoes objeto = new Informacoes(nome, telefone, email, cep, endereco, numero){};
        info.add(objeto);
        return true;
    }
    
    public boolean salvapedido(String item, int quantidade) {
        Pedido objeto = new Pedido();
        objeto.setItem(item); 
        objeto.setQuantidade(quantidade); 
        pedid.add(objeto);
        return true;
    }
    
    public boolean salvapedidofinal(String nome, String telefone, String email, String cep, String endereco, String numero, String formapagamento, String preco, String item) {
        Informacoes objeto = new Informacoes(nome, telefone, email, cep, endereco, numero, formapagamento, preco, item);
        pedidofinal.add(objeto);
        return true;
    }
    
    @Override
    public String toString() {
        return "Item: " + item + ", Quantidade: " + quantidade;
    }

}

