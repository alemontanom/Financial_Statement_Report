/*
Este programa va a simular el estado financiero de el parque acuático El Rollo. Para esto 
se van a tomar en cuenta los empleados, los productos vendidos y las entradas vendidas.
Vamos a tener tres clases:
1. Estado financiero
2. Empleados
3. Productos
4. Boletos
 */
package el_rollo;
import java.util.Random;
/**
 *
 * @author Alejandro Christlieb & Alejandra Montaño
 */
public class El_Rollo {

    /**
     * @param args the command line arguments
     * main unicamente llamará a otras clases/métodos y generará los objetos (empleados y boletos) 
     * Va a mostrar si el estado financiero es bueno o es malo
     */
    public static void main(String[] args) {
        double personal; // solo despliega el valor del costo por personal 
        double boletos; //solo va a devolver las ganancias por los boletos vendidos
        //double estadofin; 
        personal = generapersonal();
       // despliegapersonal(); 
        boletos = generaboletos(); 
       // despliegaboletos();
        estadofin(personal, boletos);     
    }
    public static double generapersonal(){
        empleados [] personal = new empleados[2]; 
        double totalempleados = 0, sueldo;  
        for (int i=0;i<personal.length;i++) { 
            personal[i]= new empleados();
            System.out.println("La información de ese empleado es:\nNombre: " + personal[i].getnombre()
             + "\nEspecialidad: "+ personal[i].getespecialidad() + "\nNómina: " + personal[i].getnomina()
             +  "\nAños de experiencia: " + personal[i].getañosExp() + "\nSalario: $"+ personal[i].getsalario() + "\n");
            sueldo = personal[i].getsalario(); 
            totalempleados = totalempleados + sueldo; 
        } 
        //Se genera un objeto de tipo personal, el cual tiene todas las características de arriba. 
        return totalempleados; 
    }
    public static double generaboletos(){
        boletos [] boletos = new boletos [3];
        double ganancias = 0, precio; 
        for (int c=0;c<boletos.length; c++) {
            boletos [c] = new boletos(); 
            System.out.println("\nLa información del boleto comprado es:\nTipo de boleto: " + boletos[c].gettipo() 
            + "\nNúmero de boleto: "+ boletos[c].getnumbol() + "\nCosto del boleto: $" + boletos[c].getprecio());
            precio = boletos[c].getprecio(); 
            ganancias = ganancias + precio; 
        }
        return ganancias;
        //Se genera un objeto de tipo boleto con sus características y se regresa al precio del boleto.
    }
    public static double estadofin(double x, double y){ // Saca el estao financiero 
        double edo = y - x; //Establece mi estado financiero: y son las ganancias por los boletos y x son los gastos en los salarios del personal
        System.out.print("\n*****************************\n**                         **\n**    Estado "
                + "financiero    **\n**                         **\n** Gastos personal:        **\n**                 $" 
                + x + " **\n**                         **\n"
                + "** Ganancia boletos:       **\n**                 $" + y + "  ** "
                + "\n**                         **\n** Estado de cuenta:       **\n**                 $" + edo + "**\n**                         **"); 
//Despliega un menú con el estado financiero
        if (edo > 0)//decirle si gana o pierde dinero 
            System.out.print("\n** Balance positivo        **");     
        else if (edo == 0)
            System.out.print("\n** Balance en ceros        **");
        else 
            System.out.print("\n** Balance negativo        **");
        
        System.out.print("\n**                         **\n*****************************"); // cierra la caja del estado financiero
        return edo;  //Regresa el balance de las ganancias y los gastos 
    }
    
}

class empleados { // clase objeto
    //Definimos el objeto con sus respectivas características, en este caso van a ser las variables
    String nombre;
    int nomina;
    String especialidad; 
    Double salario; 
    int añosExp;
    Random aleatorio = new Random(); /*Se define la variable 'aleatorio' como una variable de tipo
    random, pero que no está asociada a ninguna otra variable. Genera un número aleatorio de tipo 
    entero o flotannte, dependiendo de lo que se pide. No puede generar números negativos. */
    
    empleados (){/* Método de creación del objeto. No se define nada porque es una subclase y solo 
        se puede llamar igual a la clase principal.*/ 
        this.nombre = setnombre();/*'this' se utiliza en una sub-clases tipo objeto para agarrar la
        información de la variable en la clase general. 'setnombre' te redirecciona al siguiente método
        */ 
        this.nomina = setnomina();
        this.especialidad = setespecialidad();
        this.salario = setsalario(); 
        this.añosExp = setañosExp(); 
    }
    
    private String setnombre(){// 'Private' es un método que solo funciona en la clase en la que está.
        String [] nombre = {"Esuebio", "Ramón", "Anastacia", "Ticaro", "Sofía", "Ximena", "José", 
        "Ermenegildo", "Susana", "Julián"};
        String [] apellido  = {"Ramirez", "Gomes", "Christlieb", "Montaño", "Yolandez", "Jordan", 
        "Westbrook", "Jobs", "Slim", "Woody"};
        return nombre[aleatorio.nextInt(nombre.length)] + " " + apellido[aleatorio.nextInt(nombre.length)];
        /* '[aleatorio.nextInt(nombre.length)]' sirve para generar un número aleatorio entre
        0 y la longitud del vector 'nombre'. Luego se recuperará el elemento en la posición del 
        número generado en el vector 'nombre'.
        */
    }
    

    
    private String setespecialidad (){
        int n = aleatorio.nextInt(6); //Genera un númeroaleatorio que te direcciona al siguiente switch
        switch (n){ //El switch regresa el tipo de empleado que es
            case 0: 
                return "Salvavidas";
            case 1:
                return "Taquillero";
            case 2: 
                return "Seguridad";
            case 3:
                return "Operadores";
            case 4: 
                return "Intendente";
            case 5: 
                return "Vendedor";
            case 6: 
                return "Chef";
            default:
                return null; 
        }    
    }
    
    private int setnomina (){// Se genera un número aleatorio del 1 al 1000 que será la nómina del empleado
        int nom = aleatorio.nextInt(1000); 
        return nom; 
    }
    
    private double setsalario () { // Dependiendo de la especialidad del empleado, se asigna un salario
        switch (especialidad) { // Un switch con Strings
            case "Salvavidas": 
                return 4500; 
            case "Taquillero": 
                return 2600; 
            case "Seguridad": 
                return 3800; 
            case "Operadores": 
                return 2750; 
            case "Intendente":
                return 1500; 
            case "Vendedor": 
                return 2300; 
            case "Chef": 
                return 5900;       
            default: 
                return 0; 
        }            
    }
    
    private int setañosExp() { //Genera un número del 1 al 40 para saber la antigüedad del empleado
        return aleatorio.nextInt(40); 
    }
    
    //Las siguientes clases recuperan el valor de la variable.
    public String getnombre() { 
     return nombre;   
    }
    public String getespecialidad() {
     return especialidad;   
    }
    public int getnomina() {
     return nomina;   
    }
    public Double getsalario() {
     return salario;   
    }
    public int getañosExp() {
     return añosExp;   
    }
}

class boletos { //La clase de boletos es como la de empleados 
    String tipo; 
    int numbol; 
    int precio; 
    Random aleatorio = new Random(); 
    
    boletos (){
        this.tipo = settipo(); 
        this.numbol = setnumbol(); 
        this.precio = setprecio(); 
    }
    
    
    private String settipo(){
        int k = aleatorio.nextInt(3); 
        switch (k){
            case 0:
                return "Pase anual"; 
            case 1: 
                return "Medio día";
            case 2: 
                return "Día entero"; 
            case 3: 
                return "Pase VIP"; 
            default: 
                return null; 
        }
    }
    private int setnumbol(){
        int venta = aleatorio.nextInt(3000);
        return venta ;  
    }
    private int setprecio(){
        switch (tipo) {
            case "Pase anual": 
                return 630; 
            case "Medio día":
                return 150; 
            case "Día entero": 
                return 420; 
            case "Pase VIP":
                return 590; 
            default:
                return 0; 
        }
    }
    
    //Las siguientes tres clases te regresan los valores de los objetos en cada una 
    public String gettipo() {
        return tipo;
    }
    
    public int getnumbol() {
        return numbol;
    }
    
    public int getprecio() {
        return precio;
    }
    
}


