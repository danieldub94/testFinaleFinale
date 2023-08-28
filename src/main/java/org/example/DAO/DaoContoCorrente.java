package org.example.DAO;

import org.example.DTO.ContoCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoContoCorrente extends DaoAbstract<ContoCorrente> {

    @Override
    protected PreparedStatement getPreparedStatementSelect(ContoCorrente contoCorrente, Connection cn) throws SQLException {
        PreparedStatement ps = cn.prepareStatement("insert into testfinalefinale.conticorrenti(numeroConto, CIN, ABI, CAB, nomeTitolare, cognomeTitolare, codiceFiscaleTitolare) values (?,?,?,?,?,?,?)");
        ps.setLong(1, contoCorrente.getNumeroConto());
        ps.setString(2, contoCorrente.getCIN());
        ps.setString(3, contoCorrente.getABI());
        ps.setString(4, contoCorrente.getCAB());
        ps.setString(5, contoCorrente.getNomeTitolare());
        ps.setString(6, contoCorrente.getCognomeTitolare());
        ps.setString(7,contoCorrente.getCodiceFiscaleTitolare());
        return ps;
    }

    @Override
    protected List<ContoCorrente> rsCognomeToObject(ResultSet rs) throws SQLException {
        List<ContoCorrente> result = new ArrayList<>();
        Long numeroConto = rs.getLong("numeroConto");
        String CIN = rs.getString("CIN");
        String ABI = rs.getString("ABI");
        String CAB = rs.getString("CAB");
        String nomeTitolare = rs.getString("nomeTitolare");
        String cognomeTitolare = rs.getString("cognomeTitolare");
        String codiceFiscaleTitolare = rs.getString("codiceFiscaleTitolare");
        result.add(new ContoCorrente(numeroConto,CIN, ABI,CAB,nomeTitolare,cognomeTitolare, codiceFiscaleTitolare));
        return result;
    }

    @Override
    protected PreparedStatement getPreparedStatementFindByCognome(Connection cn, String cognome) throws SQLException {
        PreparedStatement ps = cn.prepareStatement("select * from testfinalefinale.conticorrenti where cognomeTitolare LIKE  ?");
        ps.setString(1, "%" + cognome + "%");
        return ps;
    }

    @Override
    protected List<ContoCorrente> rsCodiceFiscaleToObject(ResultSet rs) throws SQLException {
        List<ContoCorrente> result = new ArrayList<>();
        Long numeroConto = rs.getLong("numeroConto");
        String CIN = rs.getString("CIN");
        String ABI = rs.getString("ABI");
        String CAB = rs.getString("CAB");
        String nomeTitolare = rs.getString("nomeTitolare");
        String cognomeTitolare = rs.getString("cognomeTitolare");
        String codiceFiscaleTitolare = rs.getString("codiceFiscaleTitolare");
        result.add(new ContoCorrente(numeroConto,CIN, ABI,CAB,nomeTitolare,cognomeTitolare, codiceFiscaleTitolare));
        return result;
    }

    @Override
    protected PreparedStatement getPreparedStatementFindByCodiceFiscale(Connection cn, String codiceFiscale) throws SQLException {
        PreparedStatement ps = cn.prepareStatement("select * from testfinalefinale.conticorrenti where codiceFiscaleTitolare like ?");
        ps.setString (1, "%" + codiceFiscale + "%");
        return ps;
    }
}
