/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.dao.PacienteJpaController;

/**
 *
 * @author EddyA
 */
public class ControlPaciente {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private PacienteJpaController pacienteJpaControlador= new PacienteJpaController(emf);
    
    public void guardarpaciente(String inst, String uo, String coduo, String parr, String cant, String prov, int codpaciente, 
            String ced, String ape1, String ape2, String nom1, String nom2, String dir, String barr, String parro, String canton, 
            String provin, String zona, String telf /*Date fechanac*/, String lugarnac, String nacio, String grupoc, int edad, String genero, 
            String estadoc, String instrucc /*Date fechaad*/, String ocup, String emp, String seg, String refe, String llamar, String paren, 
            String dirparen, String nroparen, String codadmi)
    {
        
    }
}
