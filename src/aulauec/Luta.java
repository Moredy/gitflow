/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulauec;

import java.util.Random;

/**
 *
 * @author Valdecir
 */
public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    private Lutador vencedor;
    
    // métodos da classe
    
    public void marcarLuta(Lutador l1, Lutador l2,int r){
        if (l1.getCategoria().equals(l2.getCategoria()) && !l1.getNome().equals(l2.getNome())) {
            this.setAprovada(true);
            this.setDesafiado(l1);
            this.setDesafiante(l2);
            this.setRounds(r);
            System.out.println("Luta aprovada e marcada");
        }else{
            this.setAprovada(false);
            this.setDesafiado(null);
            this.setDesafiante(null);
            this.setRounds(0);
            System.out.println("Luta não aprovada");
        }
    }
    
    public void lutar(){
        if (aprovada) {
            Random gerador = new Random();
            int qLutas[]= new int[2];
            int i;
            qLutas[0]=this.desafiado.getDerrotas()+this.desafiado.getVitorias()+this.desafiado.getEmpates();
            qLutas[1]=this.desafiante.getDerrotas()+this.desafiante.getVitorias()+this.desafiante.getEmpates();
            int resultado = 0;
            this.desafiado.apresentar();
            System.out.println("Sendo desafiado por:");
            this.desafiante.apresentar();
            resultado= gerador.nextInt(100);
            resultado-=qLutas[0];
            resultado+=qLutas[1];
            System.out.println("Iniciar luta!!!!!");
            for (i = 1; i<this.getRounds()+1; i++) {
                System.out.println("Round "+ i +"!!!");
                System.out.println("Luta!!!");
            }
            if (resultado<=33) {
                this.setVencedor(this.getDesafiado());
                System.out.println("O vencedor é: "+this.getVencedor().getNome());
                this.getDesafiado().ganharLuta();
                this.getDesafiante().perderLuta();
            }else if(resultado <=66){
                this.setVencedor(null);
                System.out.println("A luta resultou em empate");
                this.getDesafiado().empatarLuta();
                this.getDesafiante().empatarLuta();
            }else{
                this.setVencedor(this.getDesafiante());
                System.out.println("O vencedor é: "+ this.getVencedor().getNome());
                this.getDesafiante().ganharLuta();
                this.getDesafiado().perderLuta();
            }
        } else {
            System.out.println("Esta luta não foi aprovada e não pode acontecer");
        }
    }
    
    //métodos especiais
    
    //getters e setters
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public Lutador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Lutador vencedor) {
        this.vencedor = vencedor;
    }
    
    
}
