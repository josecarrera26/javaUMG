package com.umgprogra.erp.DAO;

import com.umgprogra.erp.DAO.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-18T21:35:15")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Empleado> idempleado;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, String> username;
    public int prueba;
}