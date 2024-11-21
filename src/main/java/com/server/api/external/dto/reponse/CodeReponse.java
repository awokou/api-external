package com.server.api.external.dto.reponse;

import java.io.Serializable;

public class CodeReponse  implements Serializable {
    private String libelle;
    private Integer code;
    private String description;

    public CodeReponse() {
        this.code=200;
        this.libelle="Ok";
        this.description="";
    }

    public CodeReponse(String libelle,Integer code) {
        this.libelle=libelle;
        this.code=code;
    }

    public CodeReponse(Integer code) {
        this.code=code;
    }

    public CodeReponse(String libelle,Integer code,String description) {
        this.libelle=libelle;
        this.code=code;
        this.description=description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CodeReponse{" + "libelle='" + libelle + '\'' + ", code=" + code + '}';
    }
}
