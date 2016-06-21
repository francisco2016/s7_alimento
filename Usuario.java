import java.util.ArrayList;
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    private String nombreU;
    private float proteinasIgeridas;
    private float carbohidratosIgeridas;
    private float grasasIgeridas;
    private float caloriasIngeridas;
    private String nombreA;
    //para almacenar el alimento con mayor nº de calorias
    private float alimentoConMasCalorias;
    //para guardar y visualizar por pantalla el nombre del alimento más calórico por cada 100 gramos consumido
    //hasta ahora por un usuario.
    private Alimento alimentoMasCalorico;
    //colección de alimentos comidos hasta el momento.
    private ArrayList<Alimento> alimentosComidos;
    //para contar el nº de veces que un cliente come el mismo plato.
    private int  cuentaMismoAlimento;
    private String nombreAlimentoRepetido;
    public Usuario(String nombreU) {
        this.nombreU = nombreU;
        proteinasIgeridas = 0.0f;
        carbohidratosIgeridas = 0.0f;
        grasasIgeridas = 0.0f;
        caloriasIngeridas = 0.0f;
        nombreA = "";
        alimentoConMasCalorias = 0.0f;//para almacenar el alimento con mayor nº de calorias
        alimentoMasCalorico = null;
        alimentosComidos = new ArrayList<>();
        cuentaMismoAlimento = 0;  //para contar el nº de veces que un cliente come el mismo plato.
        nombreAlimentoRepetido = "";
    }

    /**
     *mt para indicar el alimento que come el usuario, y la cantidad en gramos del mismo. 
     */
    public void comer(Alimento alimento, float cantidad){
        if(alimento != null){
            nombreA = alimento.getNombre();
            proteinasIgeridas     = proteinasIgeridas + alimento.getProteinas() *(cantidad/100);
            carbohidratosIgeridas = carbohidratosIgeridas + alimento.getCarbohidratos() *(cantidad/100);
            grasasIgeridas        = grasasIgeridas + alimento.getGrasas() * (cantidad/100);
            caloriasIngeridas      = caloriasIngeridas + alimento.getCalorias()* (cantidad/100);
            //para almacenar el alimento con mayor nº de calorias
            alimentoConMasCalorias = caloriasIngeridas;
            //
            if((alimentoMasCalorico == null)|| alimento.getCalorias() >= alimentoMasCalorico.getCalorias()){
                alimentoMasCalorico = alimento;
            }
            alimentosComidos.add(alimento);
        }
    }
    
    /**
     * mt para  mostrar por pantalla todos los alimentos pedidos por el cliente.
     */
    public void muestraTodosLosAlimentos(){
        for(int i = 0; i < alimentosComidos.size(); i++){
            System.out.println("");
             System.out.println("Plato nº " +(i+1)+ " ************************\n " );
             System.out.println("     ----              DATOS                   ----");
        System.out.println("");
        System.out.println("     Nombre del cliente:               " +nombreU);
        System.out.println("     Nombre del alimento:              " +nombreA);
        System.out.println("     Gramos totales de Proteinas:      " +proteinasIgeridas +     " (" +getPorProte()+ " %)");
        System.out.println("     Gramos totales de Carbohidratos:  " +carbohidratosIgeridas + " (" +getPorCarbo()+ " %)");
        System.out.println("     Gramos totales de Grasas:         " +grasasIgeridas+         " (" +getPorGra()+   " %)");
        System.out.println("     Total de calorias:                " +caloriasIngeridas);
        System.out.println("     ----------------------------------------------     ");
        }
    }
    
    /**
     * permita pasar como parámetro el nombre de un alimento e indique si el usuario ha comido ese 
     * alimento más de una vez o no y, en caso afirmativo, cuántas veces lo ha hecho.
     */
    public void alimentosRepetidos(String nombreAlimento){

        for(Alimento repetidos: alimentosComidos){
            if(repetidos.getNombre() == nombreAlimento){
                cuentaMismoAlimento ++;
            }
        }
        if(cuentaMismoAlimento > 1){
            System.out.println("Ha comido " +nombreAlimento + ", " +cuentaMismoAlimento+ " veces. ");
        }
        else{
            System.out.println("No ha repetido.  ");
        }
    }

    /**
     * codifica el código necesario para poder visualizar por pantalla los datos nutricionales del alimento que el 
     * usuario ha comido en una determinada posición invocando un método sobre el objeto que representa a dicho usuario.
     */
    public void posicionDeAlimentoElegido(int posicion){
        System.out.println("Caracteristicas del plato servido en la posición nº " +posicion);
        if(posicion >= 0 && posicion < alimentosComidos.size()){

            alimentosComidos.get(posicion).muestraDatos();
        }
        else{
            System.out.println("Ningún plato tiene la posición " +posicion);
        }
    }

    /**
     * para visualizar por pantalla el nombre del alimento más calórico por cada 100 gramos consumido hasta ahora por un usuario.
     */
    public void alimentoMasCalorico(){
        System.out.println("");
        if(alimentoMasCalorico != null){
            System.out.println("    Alimento más calórico ingerido por. " + getNombreU()+ " hasta el momento es:\n " +
                alimentoMasCalorico.getNombre()+ " con un total de: " +alimentoMasCalorico.getCalorias() 
                + " calorias por cada 100 gm.");

        }
        else{
            System.out.println("No se han ingerido alimentos.");
        }
    }

    /**
     * mt para mostrar la diferencia de calorías consumidas entre dos clientes.
     */
    public void mayorNumeroDeCalorias(Usuario usuario){
        if(usuario.getCaloriasIngeridas() == getCaloriasIngeridas()){
            System.out.println("");
            System.out.println("   " +usuario.getNombreU()+ " ha ingerido el mismo nºde calorias que " +getNombreU()+ ": (" +
                usuario.getCaloriasIngeridas()+ " frente a " +getCaloriasIngeridas()+ ")");
        }
        else{
            if(usuario.getCaloriasIngeridas() > getCaloriasIngeridas()){
                System.out.println("");
                System.out.println("   " +usuario.getNombreU()+ " ha ingerido más calorias que " +getNombreU()+ ": (" +
                    usuario.getCaloriasIngeridas()+ " frente a " +getCaloriasIngeridas()+ ")");
            }
            else{
                System.out.println("");
                System.out.println("   " +usuario.getNombreU()+ " ha ingerido menos calorias que " +getNombreU()+ ": (" +
                    usuario.getCaloriasIngeridas()+ " frente a " +getCaloriasIngeridas()+ ")");
            }
        }
    }

    /**
     * serie de mt para calcular el % de cada macronutriente ingerido y el nombre del cliente.
     */
    public float getPorProte(){
        return (proteinasIgeridas /(carbohidratosIgeridas + grasasIgeridas + proteinasIgeridas)) *100;
    }

    public float getPorCarbo(){
        return  (carbohidratosIgeridas /(proteinasIgeridas + grasasIgeridas + carbohidratosIgeridas)) *100;
    }

    public float getPorGra(){
        return  (grasasIgeridas /(proteinasIgeridas + carbohidratosIgeridas +grasasIgeridas)) *100;
    }

    public float getCaloriasIngeridas(){
        return  caloriasIngeridas;
    }

    public String getNombreU() {
        return nombreU;
    }

    public String getNombreAlimentoRepetido(){
        return  nombreAlimentoRepetido;
    }

    /**
     * muestra el nombre del cliente y los datos del alimento.
     */
    public void muestraDatos(){
        System.out.println("     ----              DATOS                   ----");
        System.out.println("");
        System.out.println("     Nombre del cliente:               " +nombreU);
        System.out.println("     Nombre del alimento:              " +nombreA);
        System.out.println("     Gramos totales de Proteinas:      " +proteinasIgeridas +     " (" +getPorProte()+ " %)");
        System.out.println("     Gramos totales de Carbohidratos:  " +carbohidratosIgeridas + " (" +getPorCarbo()+ " %)");
        System.out.println("     Gramos totales de Grasas:         " +grasasIgeridas+         " (" +getPorGra()+   " %)");
        System.out.println("     Total de calorias:                " +caloriasIngeridas);
        System.out.println("     ----------------------------------------------     ");

    }
}
