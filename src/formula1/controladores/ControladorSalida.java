/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

/**
 *
 * @author 505
 */
public class ControladorSalida implements ActionListener{
    /* Atributos */
    VistaSalida vistaSalida = new VistaSalida();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorSalida(VistaSalida vistaSalida, 
            Escuderia escuderia, Piloto piloto) {
        this.vistaSalida = vistaSalida;
        this.escuderia = escuderia;
        this.piloto = piloto;
        
        vistaSalida.botonRetirar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Traer las consultas SQL
        ConsultasEscuderia consultasEscuderia= 
                new ConsultasEscuderia();
        
        ConsultasPilotos consultasPilotos=
                new ConsultasPilotos();
        
        //Obtener la fecha de salida
        piloto=consultasPilotos.buscarPiloto(Integer.parseInt(vistaSalida.cajaIdPiloto.getText()));
        String fechaEntrada=piloto.getFechaIn();
        try{
            
        }catch(ParseException error){
            System.out.println("uppss."+error);
        }
        
        
        
    }
}
