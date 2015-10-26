/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import daoimpl.UsuarioDaoImpl;
import entidades.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Docente
 */
@ManagedBean
@RequestScoped
public class LoginBeans {
    private Usuario usuario = new Usuario();
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   public String logueo() throws Exception{
   UsuarioDao dao = new UsuarioDaoImpl();
   Usuario us;
   String resultado;
       try {
           us = dao.validarUser(this.usuario);
           if(us != null){
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
               resultado = "principal";              
           }else{
               resultado = "logueo";
           }
       } catch (Exception e) {
           throw  e;
       }
   return resultado;
   }
   public boolean verificarSesion(){
   boolean estado;
    if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")==null){
        estado = false;
   }else{
    estado = true;
    }
   return estado;
   }
   public String cerrarSesion(){
   FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
   return "logueo?faces-redirect=true";
   }
}
