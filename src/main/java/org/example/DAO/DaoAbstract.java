package org.example.DAO;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DaoAbstract<T>  implements IDao<T> {

    private static final String URL="URL";
    private static final String USERNAME="USERNAME";
    private static final String PASSWORD="PASSWORD";
    private String url;
    private String username;
    private String password;

    private void setting() throws DaoException {
        Properties p = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("./config.properties")) {
            p.load(input);
            this.url = p.getProperty(URL);
            this.username = p.getProperty(USERNAME);
            this.password = p.getProperty(PASSWORD);
        } catch (IOException e) {
            throw new DaoException("Impossibile trovare il file.");
        }
    }

    protected Connection getConnection() throws DaoException{
        Connection c;
        try{
            if(this.url == null){
                setting();
            }
            c = DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            throw new DaoException(e.getMessage());
        }
        return c;
    }

    //--------------------------------------------------

    @Override
    public void create(T t) throws DaoException {
        try(Connection cn = getConnection()){
            getPreparedStatementSelect(t, cn).executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    protected abstract PreparedStatement getPreparedStatementSelect(T t, Connection cn) throws SQLException;

    //--------------------------------------------------

    @Override
    public List<T> findByCognome(String testo) throws DaoException {
        List<T> result = new ArrayList<>();
        try (Connection cn = getConnection()) {
            ResultSet rs = getPreparedStatementFindByCognome(cn, testo).executeQuery();
            while(rs.next()){
                result = rsCognomeToObject(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    protected abstract List<T> rsCognomeToObject(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement getPreparedStatementFindByCognome(Connection cn, String testo) throws SQLException;


    @Override
    public List<T> findByCodiceFiscale(String testo) throws DaoException {
        List<T> result = new ArrayList<>();
        try (Connection cn = getConnection()) {
            ResultSet rs = getPreparedStatementFindByCodiceFiscale(cn, testo).executeQuery();
            while(rs.next()){
                result = rsCodiceFiscaleToObject(rs);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return result;
    }

    protected abstract List<T> rsCodiceFiscaleToObject(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement getPreparedStatementFindByCodiceFiscale(Connection cn, String testo) throws SQLException;
}