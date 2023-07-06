/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seilatestando;

/**
 *
 * @author Ryzen
 */
public class materialBeanTest {
    private String material;
    private String maID;
    private String estoque;
    private String qualidade;

    public materialBeanTest(String material, String maID, String estoque, String qualidade) {
        this.material = material;
        this.maID = maID;
        this.estoque = estoque;
        this.qualidade = qualidade;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the maID
     */
    public String getMaID() {
        return maID;
    }

    /**
     * @param maID the maID to set
     */
    public void setMaID(String maID) {
        this.maID = maID;
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
     * @return the qualidade
     */
    public String getQualidade() {
        return qualidade;
    }

    /**
     * @param qualidade the qualidade to set
     */
    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    @Override
    public String toString() {
        return "materialBeanTest{" + "material=" + material + ", maID=" + maID + ", estoque=" + estoque + ", qualidade=" + qualidade + '}';
    }
    
    
}
