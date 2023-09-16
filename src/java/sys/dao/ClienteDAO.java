
package sys.dao;

import java.util.List;
import sys.modelo.Cliente;

/**
 * DAO: Data Access Object
 * DTO: Data Transfer Object
 * Siempre que se interactúa dentro de una aplicación, netamente son objetos.
 */

public interface ClienteDAO {
    
    /*Los métodos abstractos no tienen un cuerpo */
    public List<Cliente> select();

    /*variable cliente: Un objeto de tipo Cliente */
    public void insert(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(Cliente cliente);
         
}
