
import java.util.Scanner;

public class Principal {

    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];

    public static void main(String[] args){

        insertarDatosAeropuerto(aeropuertos);
        menu();
    }

    public static void insertarDatosAeropuerto(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(80000000, "Adolfo Suarez","Madrid", "España");
        aero[0].insertarCompañia(new Compañia("Iberia"));
        aero[0].insertarCompañia(new Compañia("AirEuropa"));
        aero[0].getCompañia("Iberia").insertarVuelo(new Vuelo("IB20", "Madrid", "Barcelona", 150.90, 150));
        aero[0].getCompañia("Iberia").insertarVuelo(new Vuelo("IB21", "Madrid", "Bilbao", 180.90, 140));
        aero[0].getCompañia("AirEuropa").insertarVuelo(new Vuelo("AIR10", "Madrid", "Sevilla", 90.50, 100));
        aero[0].getCompañia("Iberia").getVuelo("IB20").insertarPasajero(new pasajero("Carlos", "20BGHP", "Española"));
        aero[0].getCompañia("Iberia").getVuelo("IB20").insertarPasajero(new pasajero("Andres", "15FGLF", "Española"));
        aero[0].getCompañia("AirEuropa").getVuelo("AIR10").insertarPasajero(new pasajero("Jose", "56KLFJ", "Española"));

        aero[1] = new AeropuertoPrivado("Aeropuerto de Leon", "León", "España");
        aero[1].insertarCompañia(new Compañia("RyanAir"));
        String empresas[] = {"Mantenimientos S.L.", "Reparaciones S.A."};
        ((AeropuertoPrivado)aero[1]).insertarEmpresas(empresas);
        aero[1].getCompañia("RyanAir").insertarVuelo(new Vuelo("RY32", "León", "Madrid", 125, 80));
        aero[1].getCompañia("RyanAir").getVuelo("RY32").insertarPasajero(new pasajero("Fernando", "89FJKD", "Española"));

        aero[2] = new AeropuertoPublico(20000000, "Prats","Barcelona", "España");
        aero[2].insertarCompañia(new Compañia("Vueling"));
        aero[2].insertarCompañia(new Compañia("Latam"));
        aero[2].getCompañia("Vueling").insertarVuelo(new Vuelo("VL49", "Barcelona", "Madrid", 80.90, 100));
        aero[2].getCompañia("Vueling").insertarVuelo(new Vuelo("VL52", "Barcelona", "Sevilla", 100.90, 100));
        aero[2].getCompañia("Vueling").getVuelo("VL49").insertarPasajero(new pasajero("Roberto", "45KLDK", "Española"));
        aero[2].getCompañia("Vueling").getVuelo("VL49").insertarPasajero(new pasajero("Adrián", "70KELF", "Española"));

        aero[3] = new AeropuertoPublico(40000000, "Santiago","Santiago de Compostela", "España");
        aero[3].insertarCompañia(new Compañia("PlusUltra"));
        aero[3].insertarCompañia(new Compañia("United"));
        aero[3].getCompañia("PlusUltra").insertarVuelo(new Vuelo("PU70", "Santiago de Compostela", "Malaga", 110.75, 80));
        aero[3].getCompañia("PlusUltra").insertarVuelo(new Vuelo("PU90", "Santiago de Compostella", "Melilla", 150.80, 80));
        aero[3].getCompañia("PlusUltra").getVuelo("PU70").insertarPasajero(new pasajero("Roberto", "45KLDK", "Española"));

    }

    public static void menu(){

        String nombreAeropuerto;
        int opcion;
        Aeropuerto aeropuerto;

        do { 
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados (Públicos o Privados): ");
            System.out.println("2. Ver empresas(Privado) o subvencion(Publico): ");
            System.out.println("3. Lista de compañias de un Aeropuerto: ");
            System.out.println("4. Lista de vuelos por compañia: ");
            System.out.println("5. Listar posibles vuelso de Origen a Destino: ");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");
            opcion = entrada.nextInt();

            switch(opcion){

                case 1:

                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);

                    break;

                case 2:

                    System.out.println("");
                    mostrarPatrocinio(aeropuertos);

                    break;

                case 3:
                    entrada.nextLine();
                    System.out.print("\nIntroduzca el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                        if(aeropuerto == null){
                            System.out.println("El aeropuerto no existe");    
                        }else{
                            mostrarCompañias(aeropuerto);
                        }

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                default:

                    System.out.println("Error. Se ha equivocado en la opcion del menú");
            }

        } while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for(int i = 0; i < aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("País: "+aeropuertos[i].getPais());
            }else{
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: "+aeropuertos[i].getNombre());
                System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                System.out.println("País: "+aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }

    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){

        String empresas[];

        for(int i = 0; i <aeropuertos.length; i++){
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("Empresas: ");
                for(int j = 0; j < empresas.length; j++){
                    System.out.println(empresas[j]);
                }
            }else{
                System.out.println("Aeropuerto Public: "+aeropuertos[i].getNombre());
                System.out.println("Subvencion: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println("");
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while((!encontrado) && (i<aeropuertos.length)){
            if(nombre.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }

        return aero;
    }

    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas compañias del aeropuerto: "+aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++){
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
            
    }
    
}
