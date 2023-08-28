package org.example.DAO;

import java.util.List;

public interface IDao <T>{
    void create (T t) throws DaoException;
    List<T> findByCognome(String testo) throws DaoException;
    List<T> findByCodiceFiscale(String testo) throws DaoException;
}
