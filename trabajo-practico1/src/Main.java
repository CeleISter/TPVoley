import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
    	//Determino los equipos
        GestorEquipos gestor = new GestorEquipos();
        gestor.getEquipos().add(new Equipo("San Juan", "San Juan"));
        gestor.getEquipos().add(new Equipo("Mendoza", "Mendoza"));
         
        //Menú principal
        String[] opcionesMenuPrincipal = {
            "Jugar partido", "Gestionar Equipos", "Ver los equipos actuales", "Salir"
        };

        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido, por favor, vaya a la parte de Gestionar Equipo, y agregue los jugadores para poder jugar un partido.", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcionesMenuPrincipal, opcionesMenuPrincipal[0]);

            switch (opcion) {
                case 0:
                	//Verificador, deben haber 2 equipos completos para jugar. Si hay dos sale y juega.
                    if (gestor.getEquipos().size() < 2) {
                        JOptionPane.showMessageDialog(null, "Debe agregar al menos dos equipos para jugar un partido.");
                        break;
                    }else {
                    	gestor.jugarPartido(gestor.getEquipos().get(0), gestor.getEquipos().get(1));	
                    } 
                    break;
                    
                    
                case 1:
                	//Elije un equipo y lo guarda en seleccionado
                    int seleccionado = buscarEquipo(gestor.getEquipos());
                    if (seleccionado == -1) {
                        JOptionPane.showMessageDialog(null, "No hay equipos para gestionar.");
                        break;
                    }
                    String[] opcionesDeEquipo = {
                        "Agregar jugador manualmente", "Rellenar equipo", "Ver jugadores del equipo", "Eliminar Equipo", "Salir"
                    };

                    int opcionEquipo;
                    do {
                    	//Menú de Gestión de Equipo
                        opcionEquipo = JOptionPane.showOptionDialog(null, "¿Qué desea hacer con en el equipo?",
                                "Menu Equipo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                opcionesDeEquipo, opcionesDeEquipo[0]);
                        
                        switch (opcionEquipo) {
                            case 0:
                                gestor.getEquipos().get(seleccionado).agregarJugador();
                                break;
                            case 1:
                                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores que desee agregar"
                                        + "\n(Esto es automático y no van a ser jugadores personalizados)"
                                        + "\n(Además, el límite es hasta 6 jugadores totales)"));
                                gestor.getEquipos().get(seleccionado).agregarJugadoresRelleno(cantidad);
                                break;
                            case 2:
                                gestor.getEquipos().get(seleccionado).mostrarJugadores();
                                break;
                            case 3:
                                String resp = JOptionPane.showInputDialog("¿Está seguro de querer eliminar el equipo?");
                                if (resp != null && resp.equalsIgnoreCase("si")) {
                                    gestor.getEquipos().remove(seleccionado);
                                    JOptionPane.showMessageDialog(null, "Equipo eliminado con éxito.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Operación cancelada. Volviendo al menú equipo.");
                                }
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Saliendo del menú equipo." + "\nVolviendo al menú principal");
                                break;
                        }

                    } while (opcionEquipo != 4);
                    break;
                case 2:
                	//Muestra los equipos actuales
                    if (gestor.getEquipos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay equipos registrados.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Equipo 1: " + gestor.getEquipos().get(0) + "\n"+"\nEquipo 2: " + gestor.getEquipos().get(1));
                    }
                    break;
                case 3: 
                	//Opción de salir
                	 String resp = JOptionPane.showInputDialog("¿Esta seguro que quiere salir del programa?");
                	 if (resp != null && resp.equalsIgnoreCase("si")) {
                		 JOptionPane.showMessageDialog(null, "Saliendo del menú principal."); 
                     }
                    break;
            }
        } while (opcion != 3);
    }

    private static int buscarEquipo(LinkedList<Equipo> equipos) {
        if (equipos.isEmpty()) {
            return -1;
        }

        String[] equiposArray = new String[equipos.size()];
        for (int i = 0; i < equipos.size(); i++) {
            equiposArray[i] = equipos.get(i).getNombre();
        }

        return JOptionPane.showOptionDialog(null, "Seleccione equipo", "Buscar Equipo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                equiposArray, equiposArray[0]);
    }

}



