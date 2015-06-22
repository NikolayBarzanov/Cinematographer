/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinematographer.core.reservation.manager;

import com.cinematographer.core.screening.Seat;
import java.util.Collection;

/**
 *
 * @author Aleksandar
 */
public interface IReservationService
{
    void addSeats(Collection<Seat> seats);
}
