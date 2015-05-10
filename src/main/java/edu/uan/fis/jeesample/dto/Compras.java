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
public class Compras implements Serializable {

    private String name;
    private String user;
    private String nomproduct;
    private Integer comprasId=0;
    private Integer productId=0;
    private Integer clienteId=0;


      
    public Integer getComprasId() {
        return comprasId;
    }

    public void setComprasId(Integer comprasId) {
        this.comprasId = comprasId;
    }
    
     public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
        public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String name) {
        this.name = name;
    }
        
     public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Compras == false)
            return false;
        Compras that = (Compras) o;
        return that.comprasId.equals(this.comprasId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.comprasId != null ? this.comprasId.hashCode() : 0);
        return hash;
    }
}


