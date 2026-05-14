package ej5.tp4;

public class MenuCeliaco extends Menu {

    private boolean certificadoSinTACC;

    public MenuCeliaco(String diaSemana,
                       int caloriasTotales,
                       boolean certificadoSinTACC) {

        super(diaSemana, caloriasTotales);
        this.certificadoSinTACC = certificadoSinTACC;
    }

    public boolean getCertificadoSinTACC() {
        return certificadoSinTACC;
    }

    public void setCertificadoSinTACC(boolean certificadoSinTACC) {
        this.certificadoSinTACC = certificadoSinTACC;
    }
}
