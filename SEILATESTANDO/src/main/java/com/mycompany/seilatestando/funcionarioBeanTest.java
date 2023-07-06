/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seilatestando;

/**
 *
 * @author Ryzen
 */
public class funcionarioBeanTest {
    private String funcionario;
    private String fuID;
    private String telefone;
    private String salario;
    private String email;

    public funcionarioBeanTest(String funcionario, String fuID, String telefone, String salario, String email) {
        this.funcionario = funcionario;
        this.fuID = fuID;
        this.telefone = telefone;
        this.salario = salario;
        this.email = email;
    }

    /**
     * @return the funcionario
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the fuID
     */
    public String getFuID() {
        return fuID;
    }

    /**
     * @param fuID the fuID to set
     */
    public void setFuID(String fuID) {
        this.fuID = fuID;
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
     * @return the salario
     */
    public String getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(String salario) {
        this.salario = salario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "funcionarioBeanTest{" + "funcionario=" + funcionario + ", fuID=" + fuID + ", telefone=" + telefone + ", salario=" + salario + ", email=" + email + '}';
    }

    
}
