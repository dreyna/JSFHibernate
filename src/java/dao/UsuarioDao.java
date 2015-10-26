/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Docente
 */
public interface UsuarioDao {
    public Usuario validarUser(Usuario u);
    public boolean registrarUsuario(Usuario u);
    public boolean modificarUsuario(Usuario u);
    public boolean eliminarUsuario(Usuario u);
    public Usuario getUsuario(int id);
    public Usuario buscarUsuario(String user);
    public List<Usuario> listarUser();
}
