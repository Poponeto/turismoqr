/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Punto.IServicioPunto;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

/**
 *
 * @author ftacchini
 */
public class AccesoCantidadPuntos implements AccessDecisionVoter {

    private static final String PREFIX = "CANTIDAD_";
    private IServicioPunto servicioPunto;

    @Autowired
    public void setAccesoDatos(IServicioPunto servicioPunto) {
        this.servicioPunto = servicioPunto;
    }

    public boolean supports(ConfigAttribute attribute) {
        if (attribute.getAttribute().startsWith(PREFIX)) {

            return true;
        }
        return false;

    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        for (ConfigAttribute attribute : attributes) {

            if (supports(attribute)) {
                for (GrantedAuthority permiso : authentication.getAuthorities()) {
                    if (permiso.getAuthority().equalsIgnoreCase("PERMISO_ADMINISTRADOR")) {
                        return ACCESS_GRANTED;
                    }
                }

                if (object instanceof FilterInvocation) {

                    if (servicioPunto.puedeCrearPuntos(((DTOUsuario) authentication.getPrincipal()).getNombreUsuario())) {
                        return ACCESS_GRANTED;
                    } else {
                        return ACCESS_DENIED;
                    }
                }
            }
        }
        return ACCESS_ABSTAIN;
    }
}
