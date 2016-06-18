
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
    private float caloriasIgeridas;
    private String nombreA;

    public Usuario(String nombreU) {
        this.nombreU = nombreU;
        proteinasIgeridas = 0.0f;
        carbohidratosIgeridas = 0.0f;
        grasasIgeridas = 0.0f;
        caloriasIgeridas = 0.0f;
        nombreA = "";
    }

    public String getNombreU() {
        return nombreU;
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
            caloriasIgeridas      = caloriasIgeridas + alimento.getCalorias()* (cantidad/100);
        }
    }

    /**
     * muestra el nombre del cliente y los datos del alimento.
     */
    public void muestraDatos(){
        System.out.println("     ----              DATOS                   ----");
        System.out.println("");
        System.out.println("     Nombre del cliente:               " +nombreU);
        System.out.println("     Nombre del alimento:              " +nombreA);
        System.out.println("     Gramos totales de Proteinas:      " +proteinasIgeridas);
        System.out.println("     Gramos totales de Carbohidratos:  " +carbohidratosIgeridas);
        System.out.println("     Gramos totales de Grasas:         " +grasasIgeridas);
        System.out.println("     Total de calorias:                " +caloriasIgeridas);
        System.out.println("     ----------------------------------------------     ");

    }
}
