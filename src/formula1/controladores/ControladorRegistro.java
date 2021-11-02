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
import formula1.vistas.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class ControladorRegistro implements ActionListener{
    
    VistaRegistro vistaRegistro = new VistaRegistro();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorRegistro(VistaRegistro vistaRegistro,
            Escuderia escuderia,Piloto piloto) {
        
        this.vistaRegistro=vistaRegistro;
        this.escuderia=escuderia;
        this.piloto=piloto;
        
        vistaRegistro.botonRegistro.addActionListener(this);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasPilotos consultasPilotos = new ConsultasPilotos();
        ConsultasEscuderia consultasEscuderia = new ConsultasEscuderia();
        
        //registro escuderia
        escuderia.setId(vistaRegistro.cajaIdEscuderia.getText());
        escuderia.setNombre(vistaRegistro.cajaNombreEscuderia.getText());
        escuderia.setPresupuesto(Integer.parseInt(vistaRegistro.cajaPresupeustoEscuderia.getText()));
        escuderia.setTipoMotor(vistaRegistro.cajaMotorEscuderia.getText());
        
        //registro piloto
        piloto.setNombres(vistaRegistro.cajaNombrePiloto.getText());
        piloto.setApellidos(vistaRegistro.cajaApellidoPiloto.getText());
        piloto.setSalario(Integer.parseInt(vistaRegistro.cajaSalarioPiloto.getText()));
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada=formato.format(entrada);
        piloto.setFechaIn(fechaEntrada);
        
        piloto.setIdEscuderia(vistaRegistro.cajaIdEscuderia.getText());
        
        if(consultasEscuderia.registrarEscuderia(escuderia) && 
                consultasPilotos.registrarPiloto(piloto)){
            
            JOptionPane.showMessageDialog(null, "Exito en el registro");
            
        }else{
            
             JOptionPane.showMessageDialog(null, "Error en el registro");
            
        }
        
        
    }
    
    
    
}
