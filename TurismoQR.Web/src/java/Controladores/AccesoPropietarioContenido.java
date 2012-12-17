/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import TurismoQR.AccesoDatos.IAccesoDatos;
import TurismoQR.ObjetosTransmisionDatos.DTOUsuario;
import TurismoQR.Servicios.Usuario.IServicioCliente;
import java.security.Principal;
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
public class AccesoPropietarioContenido implements AccessDecisionVoter {

    private static final String PREFIX = "CONTENIDO_";
    private IServicioCliente servicioEmpresa;

    @Autowired
    public void setAccesoDatos(IServicioCliente servicioEmpresa) {
        this.servicioEmpresa = servicioEmpresa;
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
                    String urlRequest = ((FilterInvocation) object).getRequest().getRequestURI();
                    String urlProcesada = urlRequest.replace(((FilterInvocation) object).getRequest().getContextPath() + "/administracion/crearPunto/", "");
                    String idPunto = urlProcesada.split("/")[0];

                    if (servicioEmpresa.esClienteDueñoDePunto(idPunto, ((DTOUsuario) authentication.getPrincipal()).getNombreUsuario())) {
                        return ACCESS_GRANTED;
                    }
                    else
                    {
                        return ACCESS_DENIED;
                    }
                }
            }
        }
        return ACCESS_ABSTAIN;
    }
}
