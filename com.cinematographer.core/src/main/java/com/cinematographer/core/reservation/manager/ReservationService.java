/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinematographer.core.reservation.manager;

import com.cinematographer.core.screening.Seat;
import com.cinematographer.core.screening.Status;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Aleksandar
 */
public class ReservationService implements IReservationService
{
    private EntityManagerFactory emf;

    public ReservationService(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    

    @Override
    public void addSeats(Collection<Seat> seats)
    {
        EntityManager em = emf.createEntityManager();
        
        for(Seat s : seats){
            Seat data = em.find(Seat.class, s.getNumber());
            
            em.getTransaction().begin();
            data.setStatus(Status.RESERVED);
            em.getTransaction().commit();
        }
    }
    
}
