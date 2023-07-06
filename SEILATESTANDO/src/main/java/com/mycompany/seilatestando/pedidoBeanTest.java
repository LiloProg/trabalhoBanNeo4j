/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seilatestando;

/**
 *
 * @author Ryzen
 */
public class pedidoBeanTest {
    private String peID;
    private String clienteId;
    private String funcionarioId;
    private String produtoId;
    private String precoPed;
    private String metdPagamento;

    public pedidoBeanTest(String peID, String clienteId, String funcionarioId, String produtoId, String precoPed, String metdPagamento) {
        this.peID = peID;
        this.clienteId = clienteId;
        this.funcionarioId = funcionarioId;
        this.produtoId = produtoId;
        this.precoPed = precoPed;
        this.metdPagamento = metdPagamento;
    }

    /**
     * @return the peID
     */
    public String getPeID() {
        return peID;
    }

    /**
     * @param peID the peID to set
     */
    public void setPeID(String peID) {
        this.peID = peID;
    }

    /**
     * @return the clienteId
     */
    public String getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * @return the funcionarioId
     */
    public String getFuncionarioId() {
        return funcionarioId;
    }

    /**
     * @param funcionarioId the funcionarioId to set
     */
    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    /**
     * @return the produtoId
     */
    public String getProdutoId() {
        return produtoId;
    }

    /**
     * @param produtoId the produtoId to set
     */
    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * @return the precoPed
     */
    public String getPrecoPed() {
        return precoPed;
    }

    /**
     * @param precoPed the precoPed to set
     */
    public void setPrecoPed(String precoPed) {
        this.precoPed = precoPed;
    }

    /**
     * @return the metdPagamento
     */
    public String getMetdPagamento() {
        return metdPagamento;
    }

    /**
     * @param metdPagamento the metdPagamento to set
     */
    public void setMetdPagamento(String metdPagamento) {
        this.metdPagamento = metdPagamento;
    }

    @Override
    public String toString() {
        return "pedidoBeanTest{" + "peID=" + peID + ", clienteId=" + clienteId + ", funcionarioId=" + funcionarioId + ", produtoId=" + produtoId + ", precoPed=" + precoPed + ", metdPagamento=" + metdPagamento + '}';
    }
    
}
