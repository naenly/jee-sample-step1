/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dto;
import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Cliente implements Serializable {

    private String name;
    private String user;
    private String password;
    private Integer clienteId=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
        public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Cliente == false)
            return false;
        Cliente that = (Cliente) o;
        return that.clienteId.equals(this.clienteId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.clienteId != null ? this.clienteId.hashCode() : 0);
        return hash;
    }
}

