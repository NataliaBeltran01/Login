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
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import metodosIndex.ServiciosIndex;

/**
 *
 * @author Natalia Beltrán
 */
@ManagedBean
@ViewScoped
public class MbConsulta {
    @EJB
    private ServiciosIndex servicio;
    
    private Integer tipoPlatoSeleccionado;
    private List<Menu>listadoResultadoBusqueda;
    private List<Tipoplato>listaTipoPlato;
    
    
    @PostConstruct
    public void Inicializar() {
        this.setListaTipoPlato(this.servicio.obtenerListadoTiposPlatos());
    }
    
    public void buscarMenus(){
        this.setListadoResultadoBusqueda(this.servicio.obtenerListasdoMenu(this.getTipoPlatoSeleccionado()));
    }
            
    public Integer getTipoPlatoSeleccionado() {
        return tipoPlatoSeleccionado;
    }

    public void setTipoPlatoSeleccionado(Integer tipoPlatoSeleccionado) {
        this.tipoPlatoSeleccionado = tipoPlatoSeleccionado;
    }

    public List<Menu> getListadoResultadoBusqueda() {
        return listadoResultadoBusqueda;
    }

    public void setListadoResultadoBusqueda(List<Menu> listadoResultadoBusqueda) {
        this.listadoResultadoBusqueda = listadoResultadoBusqueda;
    }

    public List<Tipoplato> getListaTipoPlato() {
        return listaTipoPlato;
    }

    public void setListaTipoPlato(List<Tipoplato> listaTipoPlato) {
        this.listaTipoPlato = listaTipoPlato;
    }
    
    
}
