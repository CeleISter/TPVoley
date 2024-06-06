import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;
public class Jugador {
	private String nombre;
    private int posicion;
    private int edad;

    public Jugador(String nombre, int posicion, int edad) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\nJugador [nombre=" + nombre + ", posicion=" + posicion + ", edad=" + edad + "]";
    }

    public void validarEdad() {
    	int anio=0;
        int intanio;
        do {
            intanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento (Debe ser desde 1980 en adelante):"));
            if (intanio < 1980 || intanio > LocalDate.now().getYear()) {
                JOptionPane.showMessageDialog(null, "El año debe ser desde 1980 en adelante y no mayor al año actual. Vuelva a intentarlo.");
            }else {
            	JOptionPane.showMessageDialog(null, "La fecha es correcta.");
            	anio=intanio;
            }
            } while (intanio < 1980 || intanio > LocalDate.now().getYear());
            

        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento (1-12):"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento (1-31):"));

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        this.setEdad(edad);

        if (edad <= 18) {
            JOptionPane.showMessageDialog(null, "No puede participar porque es menor de edad.");
        } else {
            JOptionPane.showMessageDialog(null, "Puede participar.");
        }
    }
}

