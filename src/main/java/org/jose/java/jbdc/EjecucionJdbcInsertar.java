package org.jose.java.jbdc;

import org.jose.java.jbdc.modelo.Categoria;
import org.jose.java.jbdc.modelo.Producto;
import org.jose.java.jbdc.repositorio.ProductoRepositorioImpl;
import org.jose.java.jbdc.repositorio.Repositorio;
import org.jose.java.jbdc.utilidad.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjecucionJdbcInsertar {
    public static void main(String[] args) {


        try(Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("========== Listar ==========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("========== Obtener por id ==========");
            System.out.println(repositorio.porId(2L));

            System.out.println("========== Insertar nuevo producto ==========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragon mecanico");
            producto.setPrecio(700);
            producto.setFechaRegistro(new Date());


            repositorio.guardar(producto);

            System.out.println("Producto guardado con exito");

            System.out.println("========== Lista Actualizada ==========");
            repositorio.listar().forEach(System.out::println);




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
