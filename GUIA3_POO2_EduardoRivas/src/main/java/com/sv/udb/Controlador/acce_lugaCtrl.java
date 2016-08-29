/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.LugaAcce;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aerc
 * @version 1.0 25 de agosto de 2016
 */
public class acce_lugaCtrl {
    
    /**
     * Metodo que guarda el objeto en la base de datos en la tabla acce_luga
     * @param obje de tipo LugaAcce
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean guar(LugaAcce obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    /**
     * Metodo que "elimina" el objeto en la base de datos en la tabla acce_luga, cambia el estado y guarda
     * la fecha en la que se elimino en el campo fech_baja
     * @param obje de tipo LugaAcce
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean elim(LugaAcce obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            LugaAcce e = em.find(LugaAcce.class, obje.getCodiLugaAcce());
            e.setFechBaja(new Date());
            e.setEsta(0);
            em.merge(e);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    /**
     * Metodo que modifica el registro en la base de datos en la tabla acce_luga
     * @param obje de tipo LugaAcce
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean modi(LugaAcce obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            LugaAcce e = em.find(LugaAcce.class, obje.getCodiLugaAcce());
            e.setNombLugaAcce(obje.getNombLugaAcce());
            em.merge(e);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    /**
     * Metodo que Consulta el objeto en la base de datos en la tabla acce_luga
     * la fecha en la que se elimino en el campo fech_baja
     * @param codiLugaAcce de tipo long, se utiliza para consultar un registro en la base
     * @return resp de tipo LugaAcce con el objeto del registro consultado
     * @since Este metodo se incluye desde la version 1.0
     */
    public LugaAcce cons(Long codiLugaAcce)
    {
        LugaAcce resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(LugaAcce.class, codiLugaAcce);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    /**
     * Metodo que consulta todos los registros de la tabla luga_acce
     * @return resp una lista con los registros de la tabla luga_acce
     * @since Este metodo se incluye desde la version 1.0
     */
    public List<LugaAcce> consTodo()
    {
        List<LugaAcce> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("LugaAcce.findAll", LugaAcce.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
}
