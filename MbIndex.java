/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import entidades.Usuario;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import metodosIndex.ServiciosIndex;

/**
 *
 * @author Natalia Beltrán
 */
@ManagedBean
@ViewScoped
public class MbIndex {
    
    private Usuario usuarioLogin;

    @EJB
    private ServiciosIndex servicio;
    
    @PostConstruct
    public void Inicializar(){
        this.setUsuarioLogin(new Usuario());
    }
    
    /**
     * Metodo encargado de validar el usuario desde la vista
     */
    public void validarUsuarioLogin() throws IOException{
        if(this.servicio.validarUsuario(this.getUsuarioLogin())){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("ingresar.xhtml");
        }else{
            System.out.println("======= NO OK ========");
        }
 
    }

    public Usuario getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(Usuario usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }




    
    
}
