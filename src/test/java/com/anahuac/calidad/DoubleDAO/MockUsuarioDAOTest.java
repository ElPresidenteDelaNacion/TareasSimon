package com.anahuac.calidad.DoubleDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;


import java.util.HashMap;

import static org.junit.Assert.*;

public class MockUsuarioDAOTest {
	private MockUsuarioDAO dao;
	public HashMap<String, Usuario> usuarios;

	Usuario usuatest;

@Before
public void setUp() throws Exception {
    dao = Mockito.mock(MockUsuarioDAO.class);
    usuarios = new HashMap<String, Usuario>();
    usuatest = new Usuario("Frank", "01","21", "asdasd@gmail");
}

@After
public void tearDown() throws Exception {

}

@Test
public void addUsuario() {

    int antesCantidad = usuarios.size();
    System.out.println("Tamaño antes = " + antesCantidad);

    when(dao.addUsuario(any(Usuario.class))).thenAnswer(
        new Answer<Boolean>(){
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                Usuario arg = (Usuario) invocation.getArguments()[0];
                usuarios.put("01", arg);
                System.out.println("Tamaño despues = " + usuarios.size());
                return true;
            }
        }
    );

    dao.addUsuario(usuatest);
    int despuesCantidad = usuarios.size();

    assertThat(antesCantidad + 1, is(despuesCantidad));
}


@Test
public void consultarUsuario() {

    usuarios.put("01", usuatest);
    int antesCantidad = usuarios.size();
    System.out.println("Tamaño antes = " + antesCantidad);

    when(dao.consultarUsuario(any(String.class))).thenAnswer(
        new Answer<Usuario>(){
            public Usuario answer(InvocationOnMock invocation) throws Throwable {
                String arg = (String) invocation.getArguments()[0];
                System.out.println("Consultar Usuario = " + usuarios.get(arg).getNombre());
                return usuarios.get(arg);
            }
    });

    dao.consultarUsuario("01");
    int despuesCantidad = usuarios.size();
    System.out.println("Tamaño despues = " + despuesCantidad);

    assertThat(antesCantidad, is(despuesCantidad));
}

@Test
public void updateEmail() 
{
	
	usuarios.put(usuatest.getId(), usuatest);
	String correoAntes = usuatest.getEmail();
	System.out.println("Correo antes: " + correoAntes);
	doAnswer(new Answer() 
	{
	    public Object answer(InvocationOnMock invocation) {
	    Usuario arg = (Usuario) invocation.getArguments()[0];
		usuarios.get(arg.getId()).setEmail("Elpresidented@gmail.com");
	    return null;
	      }})
	  .when(dao).updateEmail(any(Usuario.class));
	
	dao.updateEmail(usuatest);
	String correoDesp = usuarios.get(usuatest.getId()).getEmail();
	System.out.println("Correo despues: " + correoDesp);
	assertThat(correoAntes,is((correoDesp)));
}

@Test
public void deleteUsuario() {

    usuarios.put("01", usuatest);
    int antesCantidad = usuarios.size();
    System.out.println("Tamaño antes = " + antesCantidad);

    when(dao.deleteUsuario(any(Usuario.class))).thenAnswer(
            new Answer<Boolean>() {
                public Boolean answer(InvocationOnMock invocation) throws Throwable {
                    Usuario arg = (Usuario) invocation.getArguments()[0];
                    usuarios.remove(arg.getId(), arg);

                    return true;
                }
            }
    );dao.deleteUsuario(usuatest);

    System.out.println("Tamaño despues = " + usuarios.size());
    int despuesCantidad = usuarios.size();
    assertThat(antesCantidad - 1, is(despuesCantidad));


    }
}
