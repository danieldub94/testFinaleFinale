package org.example;

import org.example.DAO.DaoContoCorrente;
import org.example.DAO.DaoException;
import org.example.DTO.ContoCorrente;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static Scanner sc = new Scanner(System.in);
    static DaoContoCorrente dao = new DaoContoCorrente();
    public static void main( String[] args ) throws DaoException {

        //cercaUtentePerCognome();
        //cercaUtentePerCodiceFiscale();
        //inserisciConto();
    }

    private static void cercaUtentePerCognome() throws DaoException {
        System.out.println("Inserisci il cognome dell'utente da cercare:");
        String cognome = sc.nextLine();
        List<ContoCorrente> contocorrente = dao.findByCognome(cognome);
        System.out.println(contocorrente);
    }

    private static void cercaUtentePerCodiceFiscale() throws DaoException {
        System.out.println("Inserisci il codicefiscale dell'utente da cercare:");
        String codicefiscale = sc.nextLine();
        List<ContoCorrente> contocorrente = dao.findByCodiceFiscale(codicefiscale);
        System.out.println(contocorrente);
    }
    private static void inserisciConto() throws DaoException {
        System.out.println("Inserisci il numero del conto:");
        Long numeroConto = sc.nextLong();
        sc.nextLine();
        System.out.println("Inserisci il CIN dell'utente:");
        String CIN = sc.nextLine();
        System.out.println("Inserisci abi");
        String ABI = sc.nextLine();
        System.out.println("Inserisci CAB");
        String CAB = sc.nextLine();
        System.out.println("nome");
        String nome = sc.nextLine();
        System.out.println("cognome");
        String cognome = sc.nextLine();
        System.out.println("codicefiscale");
        String codiceFiscale = sc.nextLine();
        dao.create(new ContoCorrente(numeroConto, CIN, ABI, CAB, nome, cognome, codiceFiscale));
    }
}
