package view;

import javax.ejb.EJB;
import session.BarberoFacadeLocal;

public class BankingBeanAjax extends BankingBeanBase {

    @EJB
    private BarberoFacadeLocal barberoFacade;

    private String message = "";

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String showBalance() {
        if (!password.equals("secret")) {
            message = "Contraseña incorrecta";
        } else {
            try {
                Long id = Long.parseLong(barberoId);
                barbero = barberoFacade.findById(id);
                if (barbero == null) {
                    message = "Barbero no encontrado";
                } else {
                    message = String.format("Balance de %s %s es $%,.2f",
                            barbero.getNombres(),
                            barbero.getApellidos(),
                            barbero.getBalance());
                }
            } catch (NumberFormatException e) {
                message = "ID inválido, debe ser un número";
            }
        }
        return null;
    }
}