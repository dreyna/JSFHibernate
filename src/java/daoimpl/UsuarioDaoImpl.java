/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.UsuarioDao;
import entidades.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


/**
 *
 * @author Docente
 */

public class UsuarioDaoImpl implements UsuarioDao{
  
    private Session session;

    @Override
    public Usuario validarUser(Usuario u) {
        Usuario user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Usuario where nomUser ='"+u.getNomUser()+"' and clave ='"+u.getClave()+"'";
            Query query = session.createQuery(hql);
            if(!query.list().isEmpty()){
            user = (Usuario) query.list().get(0);
                System.err.println(user);
            }            
        } catch (Exception e) {
            throw  e;
        }
        return user;
    }
    @Override
    public boolean registrarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscarUsuario(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
