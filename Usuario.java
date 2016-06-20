
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
    //para visualizar por pantalla el nombre del alimento más calórico por cada 100 gramos consumido hasta ahora por un usuario.
    private float alimentoMasCalorico;

    public Usuario(String nombreU) {
        this.nombreU = nombreU;
        proteinasIgeridas = 0.0f;
        carbohidratosIgeridas = 0.0f;
        grasasIgeridas = 0.0f;
        caloriasIngeridas = 0.0f;
        nombreA = "";
        alimentoConMasCalorias = 0.0f;//para almacenar el alimento con mayor nº de calorias
        alimentoMasCalorico = 0.0f;
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
        }
    }

    //     /**
    //      * para visualizar por pantalla el nombre del alimento más calórico por cada 100 gramos consumido hasta ahora por un usuario.
    //      */
    //     public void alimentoMasCalorico(Alimento alimento){
    //         if(alimento.getCaloriasIngeridas() > alimentoConMasCalorias){
    //             alimentoConMasCalorias = alimento.getCaloriasIngeridas();
    //         }
    //     }

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
