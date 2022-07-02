package com.anahuac.calidad.DoubleDAO;

public interface UsuarioDAO {
    public boolean addUsuario(Usuario a);
    public boolean deleteUsuario(Usuario a);
    public boolean updateEmail(Usuario a);
    public Usuario consultarUsuario(String id);

}