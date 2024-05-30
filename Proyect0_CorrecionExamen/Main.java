package Proyect0_CorrecionExamen;

public class Main {
    public static void main(String[] args) {
        // Crear 5 instancias de la clase Hoteles con valores específicos
        Hoteles hotel1 = new Hoteles("Sky", "Tumbaco", "123456789");
        Hoteles hotel2 = new Hoteles("Ocena", "Cumbaya", "987654321");
        Hoteles hotel3 = new Hoteles("San marino", "La comuna", "456789123");
        Hoteles hotel4 = new Hoteles("Val verde", "Puembo", "321654987");
        Hoteles hotel5 = new Hoteles("Typton ", "Calderon", "654987321");

        // Crear dos objetos con valores nulos y setear sus valores
        Hoteles hotelNulo1 = new Hoteles();
        hotelNulo1.modificarHotel("Hotel F", "Dirección F", "111111111");
        Hoteles hotelNulo2 = new Hoteles();
        hotelNulo2.modificarHotel("Bypolar", "Valle de los chillos", "222222222");

        // Imprimir todos los objetos
        hotel1.imprimirHotel();
        hotel2.imprimirHotel();
        hotel3.imprimirHotel();
        hotel4.imprimirHotel();
        hotel5.imprimirHotel();

        // Imprimir los objetos con valores nulos
        hotelNulo1.imprimirHotel();
        hotelNulo2.imprimirHotel();

        System.out.println("Hola , se agrega este comentario");
    }
}