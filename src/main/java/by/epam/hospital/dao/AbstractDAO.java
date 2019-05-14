package by.epam.hospital.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface, that describes how to interact with the data model (CRUD)
 *
 * @param <K> key in table
 * @param <T> object
 */
public interface AbstractDAO<K extends Integer, T extends Object> {
    /**
     * method Select all
     *
     * @return List of objects
     * @throws SQLException exception
     */
    List<T> findAll() throws SQLException;

    /**
     * method Select by id
     *
     * @param id ID
     * @return object
     * @throws SQLException exception
     */
    T findObjectById(K id) throws SQLException;

    /**
     * method Delete by id
     *
     * @param id ID
     * @return true if delete success
     * @throws SQLException exception
     */
    boolean delete(K id) throws SQLException;

    /**
     * method Delete by object
     *
     * @param object object
     * @return true if delete success
     * @throws SQLException exception
     */
    boolean delete(T object) throws SQLException;

    /**
     * method Create by object
     *
     * @param object object
     * @return true if create success
     * @throws SQLException exception
     */
    boolean create(T object) throws SQLException;

    /**
     * method Update by object
     *
     * @param object object
     * @return true if update success
     * @throws SQLException exception
     */
    boolean update(T object) throws SQLException;
}
