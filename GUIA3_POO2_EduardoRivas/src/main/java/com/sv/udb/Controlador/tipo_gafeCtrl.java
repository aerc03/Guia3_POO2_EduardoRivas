/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.TipoGafe;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aerc
 */
public class tipo_gafeCtrl {
    /**
     * Metodo que guarda el objeto en la base de datos en la tabla tipo_gafe
     * @param obje de tipo LugaAcce
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean guar(TipoGafe obje)
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
     * Metodo que Consulta el objeto en la base de datos en la tabla tipo_gafe
     * @param codi de tipo long, se utiliza para consultar un registro en la base
     * @return resp de tipo TipoGafe con el objeto del registro consultado
     * @since Este metodo se incluye desde la version 1.0
     */
    public TipoGafe cons(Long codi)
    {
        TipoGafe resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(TipoGafe.class, codi);
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
     * Metodo que consulta todos los registros de la tabla tipo_gafe
     * @return resp una lista con los registros de la tabla tipo_gafe
     * @since Este metodo se incluye desde la version 1.0
     */
    public List<TipoGafe> consTodo()
    {
        List<TipoGafe> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("TipoGafe.findAll", TipoGafe.class).getResultList();
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
     * Metodo que "elimina" el objeto en la base de datos en la tabla tipo_gafe, cambia el estado y guarda
     * la fecha en la que se elimino en el campo fech_baja
     * @param obje de tipo TipoGafe
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean elim(TipoGafe obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            TipoGafe e = em.find(TipoGafe.class, obje.getCodiTipoGafe());
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
     * Metodo que modifica el registro en la base de datos en la tabla tipo_gafe
     * @param obje de tipo TipoGafe
     * @return resp de tipo boolean true si no hubo ningun problema de lo contrario false
     * @since Este metodo se incluye desde la version 1.0
     */
    public boolean modi(TipoGafe obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            TipoGafe e = em.find(TipoGafe.class, obje.getCodiTipoGafe());
            e.setNombTipoGafe(obje.getNombTipoGafe());
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
