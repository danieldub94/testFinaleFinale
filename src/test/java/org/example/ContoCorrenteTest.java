package org.example;

import org.example.DAO.DaoContoCorrente;
import org.example.DAO.IDao;
import org.example.DTO.ContoCorrente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class ContoCorrenteTest extends DaoAbstractTest<ContoCorrente> {
    @Override
    IDao<ContoCorrente> getDao() {
        return new DaoContoCorrente();
    }

    @Override
    Executable getAssertionsTestReadCognome(ContoCorrente item) {
        return () -> {
            String expectedCognome = "Guidolin";
            String actualCognome = item.getCognomeTitolare();
            Assertions.assertEquals(expectedCognome, actualCognome, "Cognome non corrisponde");
        };
    }

    @Override
    ContoCorrente getItemTestInsert() {
        return new ContoCorrente(222222222222L, "2", "22222", "22222", "Pasquale", "Pasqualino", "GDLDNL94C28L219Z");
    }

    @Override
    Executable getAssertionsTestInsert() {
        return () -> Assertions.assertTrue(getDao().findByCognome("Pasqualino").equals("Pasqualino"));
    }

    @Override
    Executable getAssertionsTestReadCodiceFiscale(ContoCorrente item) {
        return () -> {
            String expectedCodiceFiscale = "GDLDNL94C28L219P";
            String actualCodiceFiscale = item.getCodiceFiscaleTitolare();
            Assertions.assertEquals(expectedCodiceFiscale, actualCodiceFiscale, "Codice Fiscale non corrisponde");
        };
    }
}
