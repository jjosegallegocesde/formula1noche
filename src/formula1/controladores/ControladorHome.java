/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.vistas.VistaRegistro;
import formula1.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class ControladorHome implements ActionListener{
    
    VistaHome vistaHome = new VistaHome();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorHome(VistaHome vistaHome,Escuderia escuderia,Piloto piloto) {
        
        this.vistaHome=vistaHome;
        this.escuderia=escuderia;
        this.piloto=piloto;
        
        vistaHome.botonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasEscuderia consultasEscuderia = new ConsultasEscuderia();
        String id= vistaHome.cajaIdEscuderia.getText();
        
        if(consultasEscuderia.buscarEscuderia(id)!=null){
            
            VistaSalida vistaSalida = new VistaSalida();
            vistaHome.setVisible(false);
            vistaSalida.setVisible(true);
            
            ControladorSalida controladorSalida=new ControladorSalida(vistaSalida,
            escuderia,piloto);
            
            
        }else{
            
            VistaRegistro vistaRegistro = new VistaRegistro();
            vistaHome.setVisible(false);
            vistaRegistro.setVisible(true);
            
            ControladorRegistro controladorRegistro=new ControladorRegistro(vistaRegistro,
            escuderia,piloto);
            
        }
        
    }
    
    
    
    
}
