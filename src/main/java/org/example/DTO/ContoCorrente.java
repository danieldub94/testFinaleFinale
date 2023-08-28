package org.example.DTO;

public class ContoCorrente {

    private Long numeroConto;
    private String CIN;
    private String ABI;
    private String CAB;
    private String nomeTitolare;
    private String cognomeTitolare;
    private String codiceFiscaleTitolare;

    public ContoCorrente(Long contoCorrente, String CIN, String ABI, String CAB, String nomeTitolare, String cognomeTitolare, String codiceFiscaleTitolare) {
        this.numeroConto = contoCorrente;
        this.CIN = CIN;
        this.ABI = ABI;
        this.CAB = CAB;
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.codiceFiscaleTitolare = codiceFiscaleTitolare;
    }

    public ContoCorrente() {
    }

    public Long getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(Long numeroConto) {
        this.numeroConto = numeroConto;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getABI() {
        return ABI;
    }

    public void setABI(String ABI) {
        this.ABI = ABI;
    }

    public String getCAB() {
        return CAB;
    }

    public void setCAB(String CAB) {
        this.CAB = CAB;
    }

    public String getNomeTitolare() {
        return nomeTitolare;
    }

    public void setNomeTitolare(String nomeTitolare) {
        this.nomeTitolare = nomeTitolare;
    }

    public String getCognomeTitolare() {
        return cognomeTitolare;
    }

    public void setCognomeTitolare(String cognomeTitolare) {
        this.cognomeTitolare = cognomeTitolare;
    }

    public String getCodiceFiscaleTitolare() {
        return codiceFiscaleTitolare;
    }

    public void setCodiceFiscaleTitolare(String codiceFiscaleTitolare) {
        this.codiceFiscaleTitolare = codiceFiscaleTitolare;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" +
                "numeroConto=" + numeroConto +
                ", CIN='" + CIN + '\'' +
                ", ABI='" + ABI + '\'' +
                ", CAB='" + CAB + '\'' +
                ", nomeTitolare='" + nomeTitolare + '\'' +
                ", cognomeTitolare='" + cognomeTitolare + '\'' +
                ", codiceFiscaleTitolare='" + codiceFiscaleTitolare + '\'' +
                '}';
    }
}
