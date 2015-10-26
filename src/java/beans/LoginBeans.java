/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import daoimpl.UsuarioDaoImpl;
import entidades.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Docente
 */
@ManagedBean
@RequestScoped
public class LoginBeans {
    private Usuario usuario = new Usuario();
    private DataModel listaUsuarios;
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
    public DataModel getListarUsuarios() {
        List<Usuario> lista = new UsuarioDaoImpl().listarUser();
        listaUsuarios = new ListDataModel(lista);
        return listaUsuarios;
    }
     public String prepararAdicionarUsuario() {
        usuario = new Usuario();
        return "insertar";
    }

    public String prepararmodificarUsuario() {
        usuario = (Usuario) (listaUsuarios.getRowData());
        return "modificar";
    }

    public String excluirUsuario() {
        Usuario userTemp = (Usuario) (listaUsuarios.getRowData());
        UsuarioDao dao = new UsuarioDaoImpl();
        dao.eliminarUsuario(userTemp);
        return "listar";
    }

    public String adicionarUsuario() {
        UsuarioDao dao = new UsuarioDaoImpl();
        dao.registrarUsuario(usuario);
        return "listar";
    }

    public String alterarLUsuario() {
        UsuarioDao dao = new UsuarioDaoImpl();
        dao.modificarUsuario(usuario);
        return "listar";
    }
}
