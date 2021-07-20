package org.jose.java.jbdc.repositorio;

import org.jose.java.jbdc.modelo.Categoria;
import org.jose.java.jbdc.modelo.Producto;
import org.jose.java.jbdc.utilidad.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> producto = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {

            while (rs.next()) {
                Producto p = crearProducto(rs);

                producto.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                        " inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
//        if (producto.getId() != null && producto.getId() > 0) {
//            sql = "UPDATE productos SET nombre =?, precio=?  WHERE (id = ?)";
//        } else {
        sql = "INSERT INTO productos(nombre, precio, fecha_registro) " +
                " VALUES(?,?,?)";
//        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.executeUpdate();

            stmt.setString(1, producto.getNombre());

            stmt.setInt(2, producto.getPrecio());

            stmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE * FROM productos WHERE id =?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));

        return p;
    }
}
