package org.jose.java.jbdc.whizlabTest;

import org.jose.java.jbdc.modelo.Producto;
import org.jose.java.jbdc.repositorio.ProductoRepositorioImpl;
import org.jose.java.jbdc.repositorio.Repositorio;
import org.jose.java.jbdc.utilidad.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lecturas {

    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listarNombre().forEach(System.out::println);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}


