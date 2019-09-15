/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosIndex;

import entidades.Menu;
import entidades.Tipoplato;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface ServiciosIndex {
        
    /**
     * Metodo encargado de validar el usario directamente en la base de datos
     * @param usuarioPendiente Usuario a validar
     * @return True si esta validado, de lo contrario False
   */
    Boolean validarUsuario(Usuario usuarioPendiente);
    
    List<Tipoplato> obtenerListadoTiposPlatos();
    
    void ingresarNuevoMenu(Menu menuGuardar);
    
    List<Menu> obtenerListasdoMenu(Integer idTipoMenu);
    
}
