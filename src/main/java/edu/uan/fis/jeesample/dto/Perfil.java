package edu.uan.fis.jeesample.dto;

import java.io.Serializable;

public class Perfil implements Serializable {

    private String name;
    private Integer perfilId=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Perfil == false)
            return false;
        Perfil that = (Perfil) o;
        return that.perfilId.equals(this.perfilId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.perfilId != null ? this.perfilId.hashCode() : 0);
        return hash;
    }
}

