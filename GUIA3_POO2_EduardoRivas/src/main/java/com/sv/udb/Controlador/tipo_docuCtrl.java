/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.TipoDocu;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aerc
 * @since 25 agosto de 2016
 */
public class tipo_docuCtrl {
    /**
     * Metodo que guarda el objeto en la base de datos en la tabla tipo_docu
     * @param obje de tipo LugaAcce
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean guar(TipoDocu obje)
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
     * Metodo que Consulta el objeto en la base de datos en la tabla tipo_docu
     * @param codiTipoDocu de tipo long, se utiliza para consultar un registro en la base
     * @return resp de tipo TipoDocu con el objeto del registro consultado
     * @since Este metodo se incluye desde la version 1.0
     */
    public TipoDocu cons(Long codiTipoDocu)
    {
        TipoDocu resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(TipoDocu.class, codiTipoDocu);
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
     * Metodo que consulta todos los registros de la tabla tipo_docu
     * @return resp una lista con los registros de la tabla tipo_docu
     * @since Este metodo se incluye desde la version 1.0
     */
    public List<TipoDocu> consTodo()
    {
        List<TipoDocu> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("TipoDocu.findAll", TipoDocu.class).getResultList();
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
     * Metodo que "elimina" el objeto en la base de datos en la tabla tipo_docu, cambia el estado y guarda
     * la fecha en la que se elimino en el campo fech_baja
     * @param obje de tipo TipoDocu
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean elim(TipoDocu obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            TipoDocu e = em.find(TipoDocu.class, obje.getCodiTipoDocu());
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
     * Metodo que modifica el registro en la base de datos en la tabla tipo_docu
     * @param obje de tipo TipoDocu
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean modi(TipoDocu obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            TipoDocu e = em.find(TipoDocu.class, obje.getCodiTipoDocu());
            e.setNombTipoDocu(obje.getNombTipoDocu());
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
}
