
package service;

import dao.*;
import java.util.List;



public interface IService<T> {

    boolean create(T o);

    boolean delete(T o);

    boolean update(T o);

    List<T> findAll();

    T findById(int id);
}