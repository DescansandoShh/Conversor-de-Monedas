public class NombreDeMoneda {
    public static String[] devolverNombreDeMoneda (int opcion) {
        String[] nombres = new String[2];

        switch (opcion) {
            case 1:
                nombres[0] = "PEN";
                nombres[1] = "USD";
                break;
            case 2:
                nombres[0] = "PEN";
                nombres[1] = "EUR";
                break;
            case 3:
                nombres[0] = "PEN";
                nombres[1] = "ARS";
                break;
            case 4:
                nombres[0] = "USD";
                nombres[1] = "EUR";
                break;
            case 5:
                nombres[0] = "USD";
                nombres[1] = "ARS";
                break;
            case 6:
                nombres[0] = "EUR";
                nombres[1] = "ARS";
                break;
            case 7:
                nombres[0] = "ARS";
                nombres[1] = "PEN";
                break;

        }
        return nombres;
    }
}
