/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinematographer.core.user.manager;

import com.cinematographer.core.user.User;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 *
 * @author Aleksandar
 */
public interface IUserService
{
    User findUser(String name);
    boolean addUser (User user);
    boolean validateUser(String name, String password) throws NoSuchAlgorithmException ;
}
