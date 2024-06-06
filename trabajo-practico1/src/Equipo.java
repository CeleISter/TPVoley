import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Equipo {
	
	    private String nombre;
	    private String ciudad;
	    private LinkedList<Jugador> jugadores = new LinkedList<>();

	    public Equipo(String nombre, String ciudad) {
	        this.nombre = nombre;
	        this.ciudad = ciudad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getCiudad() {
	        return ciudad;
	    }

	    public void setCiudad(String ciudad) {
	        this.ciudad = ciudad;
	    }

	    public LinkedList<Jugador> getJugadores() {
	        return jugadores;
	    }

	    public void setJugadores(LinkedList<Jugador>jugadores) {
	        this.jugadores = jugadores;
	    }

	    @Override
	    public String toString() {
	        return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", jugadores=" + jugadores + "]";
	    }

	    public void agregarJugador() {
	        Jugador jugador = new Jugador("", 0, 0);
	        jugador.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del jugador"));
	        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición del jugador"));
	        jugador.setPosicion(posicion);
	        jugador.validarEdad();

	        jugadores.add(jugador);
	        JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente");
	    }

	    public void agregarJugadoresRelleno(int cantidad) {
	        Jugador[] jugadoresRelleno = {
	            new Jugador("Ana", 170, 25),
	            new Jugador("Carlos", 185, 28),
	            new Jugador("María", 165, 23),
	            new Jugador("Pedro", 190, 30),
	            new Jugador("Laura", 175, 27),
	            new Jugador("Javier", 180, 26),
	            new Jugador("Sofía", 172, 24),
	            new Jugador("Alejandro", 188, 29),
	            new Jugador("Elena", 168, 22),
	            new Jugador("David", 183, 31)
	        };

	        for (int i = 0; i < cantidad && i < jugadoresRelleno.length; i++) {
	            jugadores.add(jugadoresRelleno[i]);
	        }

	        JOptionPane.showMessageDialog(null, "Jugadores de relleno agregados exitosamente");
	    }


	    public void buscarJugador() {
	        if (jugadores.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "La lista no tiene elementos");
	            return;
	        }

	        String[] opciones = new String[jugadores.size()];
	        for (int i = 0; i < opciones.length; i++) {
	            opciones[i] = jugadores.get(i).toString();
	        }

	        JOptionPane.showInputDialog(null, "Elija el jugador que desee", "Buscar Jugador",
	                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	    }

	    

	    public void mostrarJugadores() {
	        if (jugadores.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "La lista no tiene elementos");
	        } else {
	            StringBuilder sb = new StringBuilder();
	            for (Jugador jugador : jugadores) {
	                sb.append(jugador).append("\n");
	            }
	            JOptionPane.showMessageDialog(null, sb.toString());
	        }
	    }
	}

