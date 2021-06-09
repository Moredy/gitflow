/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulauec;

import aulauec.Lutador;

/**
 *
 * @author Valdecir
 */
public class Winrate {
    private Lutador avaliado;

    public Winrate(Lutador avaliado) {
        this.avaliado = avaliado;
        double winrate;
        winrate=this.avaliado.getVitorias()-this.avaliado.getDerrotas()/this.avaliado.getEmpates();
        System.out.println("O winrate do lutador"+ this.avaliado.getNome()+ " é:" + winrate + "%");
    }

    
}
