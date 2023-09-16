/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.ProductoDAO;
import sys.impl.ProductoDAOImpl;
import sys.modelo.Producto;

@ManagedBean
@Named(value = "productoBean")
@ViewScoped
public class ProductoBean {

    private Producto producto = null;
    private List<Producto> productos = null;

    public ProductoBean() {
    }

    public List<Producto> getProductos() {
        ProductoDAO datos = new ProductoDAOImpl();
        productos = datos.select();
        return productos;
    }

    public void prepareProducto() {
        this.producto = new Producto();
    }

    public void insertProducto() {
        ProductoDAO datos = new ProductoDAOImpl();
        datos.insert(producto);
    }

    public void updateProducto() {
        ProductoDAO datos = new ProductoDAOImpl();
        datos.update(producto);
        this.producto = new Producto();
    }

    public void deleteProducto() {
        ProductoDAO datos = new ProductoDAOImpl();
        datos.delete(producto);
        this.producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
