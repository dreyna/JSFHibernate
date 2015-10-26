/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.UsuarioDao;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        boolean op = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(u);
            t.commit();
            op = true;
        } catch (Exception e) {
        }
        return op;
    }

    @Override
    public boolean modificarUsuario(Usuario u) {
        boolean op = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.delete(u);
            t.commit();
            op = true;
        } catch (Exception e) {
        }
        return op;
    }

    @Override
    public boolean eliminarUsuario(Usuario u) {
        boolean op = false;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(u);
        t.commit();
        op = true;
        }catch(Exception e){
            
        }finally{
            session.close();
        }
        return op;
    }

    @Override
    public Usuario getUsuario(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }

    @Override
    public Usuario buscarUsuario(String user) {
        session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, user);        
    }

    @Override
    public List<Usuario> listarUser() {
        List<Usuario> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            lista = session.createQuery("from Usuario").list();
            t.commit();
        } catch (Exception e) {
        }finally{
            session.close();
        }        
        return lista;
    }    
    
}
