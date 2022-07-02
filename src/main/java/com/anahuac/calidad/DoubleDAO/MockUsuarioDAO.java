package com.anahuac.calidad.DoubleDAO;

public class MockUsuarioDAO implements UsuarioDAO {

    @Override
    public boolean addUsuario (Usuario a) {
        return false;
    }

    @Override
    public boolean deleteUsuario (Usuario a) {
        return false;
    }

    @Override
    public boolean updateEmail (Usuario a){
        return false;
    }

    @Override
    public Usuario consultarUsuario (String id) {
        return null;
    }
}