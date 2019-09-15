/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import entidades.Menu;
import entidades.Tipoplato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import metodosIndex.ServiciosIndex;

/**
 *
 * @author Natalia Beltrán */
@ManagedBean
@ViewScoped
public class MbIngresarMenu {

    @EJB
    private ServiciosIndex servicio;

    private Menu menuIngresar;
    private List<Tipoplato> listaTipoPlato;

    @PostConstruct
    public void Inicializar() {
        this.setMenuIngresar(new Menu());
        this.getMenuIngresar().setFktipoplato(new Tipoplato());
        this.setListaTipoPlato(this.servicio.obtenerListadoTiposPlatos());
    }

    public void ingresarNuevoMenu() {
        this.getMenuIngresar().setHabilitado(true);
        this.servicio.ingresarNuevoMenu(this.getMenuIngresar());
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Menu ingresado correctamente"));
        this.setMenuIngresar(new Menu());
        this.getMenuIngresar().setFktipoplato(new Tipoplato());
    }

    public Menu getMenuIngresar() {
        return menuIngresar;
    }

    public void setMenuIngresar(Menu menuIngresar) {
        this.menuIngresar = menuIngresar;
    }

    public List<Tipoplato> getListaTipoPlato() {
        return listaTipoPlato;
    }

    public void setListaTipoPlato(List<Tipoplato> listaTipoPlato) {
        this.listaTipoPlato = listaTipoPlato;
    }

}
