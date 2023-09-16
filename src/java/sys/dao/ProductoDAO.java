/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.modelo.Producto;

/**
 *
 * @author Compus
 */
public interface ProductoDAO {
    
     /*Los métodos abstractos no tienen un cuerpo */
    public List<Producto> select();
    
    /*variable cliente: Un objeto de tipo Cliente */
    public void insert (Producto producto);
    public void update (Producto producto);
    public void delete (Producto producto);
    
}
