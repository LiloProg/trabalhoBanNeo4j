/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seilatestando;

/**
 *
 * @author Ryzen
 */
public class clienteBeanTest {
    private String cliente;
    private String telefone;
    private String numero;
    private String clID;
    private String cep;
    private String rua;
    
    public clienteBeanTest(String cliente, String telefone, String numero, String clID, String cep, String rua) {
        this.cliente = cliente;
        this.telefone = telefone;
        this.numero = numero;
        this.clID = clID;
        this.cep = cep;
        this.rua = rua;
    }
    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the clID
     */
    public String getClID() {
        return clID;
    }

    /**
     * @param clID the clID to set
     */
    public void setClID(String clID) {
        this.clID = clID;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "clienteBean{" + "cliente=" + cliente + ", telefone=" + telefone + ", numero=" + numero + ", clID=" + clID + ", cep=" + cep + ", rua=" + rua + '}';
    }
    
       
}

