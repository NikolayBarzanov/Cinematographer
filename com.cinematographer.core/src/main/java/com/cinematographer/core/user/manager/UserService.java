/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinematographer.core.user.manager;

import com.cinematographer.core.user.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Aleksandar
 */
public class UserService implements IUserService
{

    private EntityManagerFactory emf;

    public UserService(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public User findUser(String name)
    {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, name);
    }
    
    public boolean addUser(User user)
    {
        EntityManager em = emf.createEntityManager();	

        if (em.find(User.class, user.getName()) == null)
            return false;
        
        EntityTransaction transaction = em.getTransaction();
	transaction.begin();
	em.merge(user);
	transaction.commit();
        
        return true;
    }
    
    public boolean validateUser(String name, String password) throws NoSuchAlgorithmException // here password is hashed
    {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, name);
        
        if(user == null)
            return false;
        
        MessageDigest mda = MessageDigest.getInstance("SHA-512");
        String userPassword = new String(mda.digest(user.getPassword().getBytes()));
        
        if(!userPassword.equals(password))
            return false;
        
        return true;
        
    }
}
