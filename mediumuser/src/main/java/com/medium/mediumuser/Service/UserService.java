/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.medium.mediumuser.Service;

import com.medium.mediumuser.Entity.MediumUser;

/**
 *
 * @author ayushpuri
 */
public interface UserService {
    public MediumUser saveUser(MediumUser entity);
    public String updateUser(MediumUser user);
    public String deleteUser(Integer userid);
    public MediumUser getUser(Integer userid);
}
