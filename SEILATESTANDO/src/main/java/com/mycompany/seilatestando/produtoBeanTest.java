/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seilatestando;

/**
 *
 * @author Ryzen
 */
public class produtoBeanTest {
    private String produto;
    private String prID;
    private String materialId;
    private String preco;
    private String estoque;
    private String tamanho;

    public produtoBeanTest(String produto, String prID, String materialId, String preco, String estoque, String tamanho) {
        this.produto = produto;
        this.prID = prID;
        this.materialId = materialId;
        this.preco = preco;
        this.estoque = estoque;
        this.tamanho = tamanho;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the prID
     */
    public String getPrID() {
        return prID;
    }

    /**
     * @param prID the prID to set
     */
    public void setPrID(String prID) {
        this.prID = prID;
    }

    /**
     * @return the materialId
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the estoque
     */
    public String getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "produtoBeanTest{" + "produto=" + produto + ", prID=" + prID + ", materialId=" + materialId + ", preco=" + preco + ", estoque=" + estoque + ", tamanho=" + tamanho + '}';
    }

    
}
