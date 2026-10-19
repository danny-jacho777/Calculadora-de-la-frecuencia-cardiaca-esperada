import java.time.LocalDate;

public class FrecuenciasCardiacas {
    private String primerNombre;
    private String apellido;
    private int mesNacimiento;
    private int diaNacimiento;
    private int anioNacimiento;

    public FrecuenciasCardiacas(String primerNombre, String apellido, int mesNacimiento, int diaNacimiento, int anioNacimiento) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.mesNacimiento = mesNacimiento;
        this.diaNacimiento = diaNacimiento;
        this.anioNacimiento = anioNacimiento;
    }

    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }
    public String getPrimerNombre() { return primerNombre; }

    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getApellido() { return apellido; }

    public void setMesNacimiento(int mesNacimiento) { this.mesNacimiento = mesNacimiento; }
    public int getMesNacimiento() { return mesNacimiento; }

    public void setDiaNacimiento(int diaNacimiento) { this.diaNacimiento = diaNacimiento; }
    public int getDiaNacimiento() { return diaNacimiento; }

    public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }
    public int getAnioNacimiento() { return anioNacimiento; }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - anioNacimiento;
        if (fechaActual.getMonthValue() < mesNacimiento ||
                (fechaActual.getMonthValue() == mesNacimiento && fechaActual.getDayOfMonth() < diaNacimiento)) {
            edad--;
        }
        return edad;
    }

    public int calcularFrecuenciaCardiacaMaxima() {
        return 220 - calcularEdad();
    }

    public String calcularFrecuenciaCardiacaEsperada() {
        int max = calcularFrecuenciaCardiacaMaxima();
        double minEsperada = max * 0.50;
        double maxEsperada = max * 0.85;
        return String.format("%.0f - %.0f lpm", minEsperada, maxEsperada);
    }
}