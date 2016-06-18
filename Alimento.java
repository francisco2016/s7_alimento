
/**
 * Se desea realizar una aplicación destinada a personas que están a dieta y que necesitan contar la calorías y los
 * macronutrientes de los alimentos que ingieren.
 * 
 * autor Francisco.
 */
public class Alimento
{
    private String nombre;
    private float proteinas;
    private float carbohidratos;
    private float grasas;
    private float calorias;

    //Cons. el valor de los atri representa los gramos por cada 100 gm de alimento.

    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas) {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        calorias = (proteinas + carbohidratos)*4 + (grasas * 9);
    }

    //serie de mt para obtener los valores de los atributos.
    public String getNombre(){
        return nombre;
    }

    public float getProteinas(){
        return proteinas;
    }

    public float getCarbohidratos(){
        return carbohidratos;
    }

    public float getGrasas() {
        return grasas;
    }

    public float getCalorias() {
        return calorias;
    }

    //serie de mt para asignar valores a los atributos.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    //muestra por pantalla los datos de los macronutrientes/ 100 gm de alimento.
    public void muestraDatos(){
        System.out.println("        ---- LISTA DE MACRONUTRIENTES ----");
        System.out.println("");
        System.out.println("        Nombre del alimento:              " +nombre);
        System.out.println("        Proteinas por 100/gm:             " +proteinas);
        System.out.println("        Carbohidratos por 100/gm:         " +carbohidratos);
        System.out.println("        Grasas por 100/gm:                " +grasas);
        System.out.println("        Total de calorias:                " +getCalorias());
        System.out.println("        Macronutriente/s mayoritario/s:   " +macronutrientreMayoritaio());
        System.out.println("    -----------------------------------------------     ");

    }

    //muestra el macronutriente mayoritario.
    public String macronutrientreMayoritaio() {
        String macronutrientreMayoritaio = "";
        if ((getProteinas() > getCarbohidratos()) && (getProteinas() > getGrasas())) {
            macronutrientreMayoritaio = "Proteinas.";
        }
        if ((getCarbohidratos() > getProteinas()) && (getProteinas() > getGrasas())) {
            macronutrientreMayoritaio = "Carbohidratos.";
        }
        if (( getGrasas() > getProteinas()) && (getProteinas() > getCarbohidratos())) {
            macronutrientreMayoritaio = "grasas.";
        }

        if ((getProteinas() == getCarbohidratos()) && (getProteinas() > getGrasas())) {
            macronutrientreMayoritaio = "Proteinas y Carbohidratos.";
        }
        if ((getProteinas() == getGrasas()) && (getProteinas() > getCarbohidratos())) {
            macronutrientreMayoritaio = "Proteinas y grasas.";
        }
        if ((getGrasas() == getProteinas()) && (getGrasas() > getCarbohidratos())) {
            macronutrientreMayoritaio = "Grasas y proteinas.";
        }
        if ((getProteinas() == getCarbohidratos()) && (getGrasas() == getCarbohidratos())) {
            macronutrientreMayoritaio = "Proteinas, Carbohidratos y Grasas.";
        }
        return macronutrientreMayoritaio;
    }
}
