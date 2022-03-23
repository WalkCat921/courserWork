package com.egor.zhukovsky.phoneshop.dao.impl;

import com.egor.zhukovsky.phoneshop.config.HibernateSessionFactory;
import com.egor.zhukovsky.phoneshop.dao.DAO;
import com.egor.zhukovsky.phoneshop.model.entity.Item;
import lombok.NonNull;
import org.hibernate.Session;

import java.util.List;

public abstract class AbstractDao<T extends Item> implements DAO<T> {

    protected static final Object LOCK = new Object();
    protected  Session sessionDB;

    protected AbstractDao() {
    }

    @Override
    public T get(Long id) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                T object = null;
                sessionDB.beginTransaction();
                return (T) sessionDB.get(object.getClass(),id);
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public List<T> findAll() {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                return sessionDB.createQuery("FROM Product ").list();
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public void save(@NonNull T object) {
        sessionDB = HibernateSessionFactory.getSessionFactory().openSession();
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                sessionDB.save(object);
            }finally {
                sessionDB.flush();
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        synchronized (LOCK) {
            try{
                sessionDB.beginTransaction();
                int res = sessionDB.createQuery("delete Product where id = :id").setParameter("id",id).executeUpdate();
                System.out.println(res);
            } finally {
                sessionDB.getTransaction().commit();
                sessionDB.close();
            }
        }
    }
}