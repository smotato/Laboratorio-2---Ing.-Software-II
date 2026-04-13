package view;

import entity.Barbero;

public abstract class BankingBeanBase {
    protected String barberoId, password;
    protected Barbero barbero;

    public String getBarberoId() { return barberoId; }
    public void setBarberoId(String barberoId) { this.barberoId = barberoId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Barbero getBarbero() { return barbero; }

    public abstract String showBalance();
}