import java.util.LinkedList;
import javax.swing.JOptionPane;
public class GestorEquipos {

	private LinkedList<Equipo> equipos = new LinkedList<>();

    public GestorEquipos() {}

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void jugarPartido(Equipo equipo1, Equipo equipo2) {
        if (equipo1.equals(equipo2)) {
            JOptionPane.showMessageDialog(null, "No se puede jugar entre los mismos equipos");
            return;
        } else {
			if (equipo1.getJugadores().size()<6 || equipo2.getJugadores().size()<6) {
				JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
				
			} else {

			JOptionPane.showMessageDialog(null, "Se enfrentan " + equipo1.getNombre() + " vs " + equipo2.getNombre());

			int puntosEquipo1=0;
			int puntosEquipo2=0;
			
	        for (int ronda = 1; ronda <= 5; ronda++) {
	            int rondasEquipo1, rondasEquipo2;
	            do {
	                rondasEquipo1 = (int)(Math.random() * 5);
	                rondasEquipo2 = (int)(Math.random() * 5);
	            } while (rondasEquipo1 == rondasEquipo2);

	            puntosEquipo1 += rondasEquipo1;
	            puntosEquipo2 += rondasEquipo2;

	            JOptionPane.showMessageDialog(null, "Ronda " + ronda + ":\n" +
	                    equipo1.getNombre() + " - " + rondasEquipo1 + " vs " + rondasEquipo2 + " - " + equipo2.getNombre());
	            }

	            if (puntosEquipo1 > puntosEquipo2) {
	                JOptionPane.showMessageDialog(null, "El equipo ganador es " + equipo1.getNombre() + " con " + puntosEquipo1 + " puntos");
	            } else {
	                JOptionPane.showMessageDialog(null, "El equipo ganador es " + equipo2.getNombre() + " con " + puntosEquipo2 + " puntos");
	            }
	        }
        }
        
    }
    
    
   
}

