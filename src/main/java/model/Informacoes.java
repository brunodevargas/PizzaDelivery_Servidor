package model;
import java.io.Serializable;
import java.util.*;

public class Informacoes implements Serializable {
   
    public static List<Informacoes> info = new ArrayList<>();
    
    protected String nome;
    protected String telefone;
    protected String email;
    protected String cep;
    protected String endereco;
    protected String numero;
    protected String formapagamento;
    protected String preco;
    protected String item;
    protected String quantidade;

    public Informacoes(){
    }
        
    public Informacoes(String nome, String telefone, String email, String cep, String endereco, String numero) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
    }
        
    public Informacoes(String nome, String telefone, String email, String cep, String endereco, String numero, String formapagamento, String preco, String item) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.formapagamento = formapagamento;
        this.preco = preco;
        this.item = item;
    }
   
    public static List<Informacoes> getInfo() {
        return info;
    }

    public static void setInfo(List<Informacoes> info) {
        Informacoes.info = info;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return "Item: " + item + ", Quantidade: " + quantidade;
    }
    
    public String toStringPedido() {
        return "\n Nome: " + nome +
                "\n Telefone: " + telefone +
                "\n Email: " + email +
                "\n Pedido: " + item +
                "\n Preço: " + preco +
                "\n Forma de Pagamento: " + formapagamento +
                "\n Infomarções de entrega: " +
                "\n Cep: " + cep +
                "\n Endereço: " + endereco +
                "\n Numero: " + numero;
    }
    
}
