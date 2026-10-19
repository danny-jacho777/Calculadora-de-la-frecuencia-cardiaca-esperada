import javax.swing.JOptionPane;

public class PruebaFrecuenciasCardiacas {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el primer nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento:"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento:"));
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento:"));

        FrecuenciasCardiacas usuario = new FrecuenciasCardiacas(nombre, apellido, mes, dia, anio);

        String reporte = String.format(
                "=== REPORTE DE FRECUENCIA CARDÍACA ===\n" +
                        "Nombre: %s %s\n" +
                        "Fecha de Nacimiento: %02d/%02d/%d\n" +
                        "Edad: %d años\n" +
                        "Frecuencia Cardíaca Máxima: %d ppm\n" +
                        "Rango Esperado (50-85%%): %s",
                usuario.getPrimerNombre(), usuario.getApellido(),
                usuario.getDiaNacimiento(), usuario.getMesNacimiento(), usuario.getAnioNacimiento(),
                usuario.calcularEdad(),
                usuario.calcularFrecuenciaCardiacaMaxima(),
                usuario.calcularFrecuenciaCardiacaEsperada()
        );

        JOptionPane.showMessageDialog(null, reporte, "Frecuencias Cardíacas", JOptionPane.INFORMATION_MESSAGE);
    }
}