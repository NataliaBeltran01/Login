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
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
public class ServiciosIndexImp implements ServiciosIndex {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean validarUsuario(Usuario usuarioPendiente) {
        Boolean retornar = null;
        String consulta = "SELECT u FROM Usuario u WHERE u.nombre = :pNombre AND u.password = :pPassword AND u.habilitado = 1";
        Query qConsulta = em.createQuery(consulta, Usuario.class);
        qConsulta.setParameter("pNombre", usuarioPendiente.getNombre());
        qConsulta.setParameter("pPassword", usuarioPendiente.getPassword());
        if (qConsulta.getResultList().isEmpty()) {
            retornar = Boolean.FALSE;
        } else {
            retornar = Boolean.TRUE;
        }
        return retornar;
    }

    @Override
    public List<Tipoplato> obtenerListadoTiposPlatos() {
        String consulta = "SELECT t FROM Tipoplato t WHERE t.habilitado = 1";
        Query qConsulta = em.createQuery(consulta, Tipoplato.class);
        return qConsulta.getResultList();
    }

    @Override
    public void ingresarNuevoMenu(Menu menuGuardar) {
        // INSERT INTO `bdrestaurante`.`menu` (`idmenu`, `habilitado`, `nombreplato`, `calorias`, `fktipoplato`) VALUES ('25', '1', 'Perro ', '250', '13');
        em.persist(menuGuardar);
    }

    @Override
    public List<Menu> obtenerListasdoMenu(Integer idTipoMenu) {
        String consulta = "SELECT m FROM Menu m WHERE m.habilitado = 1 AND m.fktipoplato.idtipoplato = :pTipoPlato";
        Query qConsulta = em.createQuery(consulta, Menu.class);
        qConsulta.setParameter("pTipoPlato", idTipoMenu);
        return qConsulta.getResultList();
    }

}
