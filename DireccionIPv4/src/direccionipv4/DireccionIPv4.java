package direccionipv4;
import java.util.Scanner;

public class DireccionIPv4 {
    public String[] crearDireccion(String cadena) {
        return cadena.split("\\.");
    }
    public void calcularTipoDireccion(int octeto1, int octeto2, int octeto3){
        if(octeto1<128){
            System.out.println("IP clase A");
            System.out.println("Direccion de red: "+octeto1+".0.0.0");
            System.out.println("Direccion de broadcast: "+octeto1+".255.255.255");
            System.out.println("Mascara de red: 255.0.0.0/8");
        }else if(octeto1> 127 && octeto1 < 192){
            System.out.println("IP clase B");
            System.out.println("Direccion de red: "+octeto1+"."+octeto2+".0.0");
            System.out.println("Direccion de broadcast: "+octeto1+"."+octeto2+".255.255");
            System.out.println("Mascara de red: 255.255.0.0/16");
        }else if(octeto1> 191 && octeto1 < 224){
            System.out.println("IP clase C");
            System.out.println("Direccion de red: "+octeto1+"."+octeto2+"."+octeto3+".0");
            System.out.println("Direccion de broadcast: "+octeto1+"."+octeto2+"."+octeto3+".255");
            System.out.println("Mascara de red: 255.255.255.0/32");
        }else{
            System.out.println("No existen resultados para esta direccion");
        }
    }
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        int[] aregloIp = new int[4];
        System.out.println("Ingresa una direccion IP: ");
        String direccionIp = sc.nextLine();
        DireccionIPv4  direccion =   new DireccionIPv4();
        String [] arreglo = direccion.crearDireccion(direccionIp);
        try{
            for(int i = 0; i<aregloIp.length; i++){
                aregloIp[i] = Integer.parseInt(arreglo[i]);
            }
            for(int i = 0; i < aregloIp.length; i++){
                System.out.print(aregloIp[i]+".");
            }
            direccion.calcularTipoDireccion(aregloIp[0],aregloIp[1],aregloIp[2]);
        }catch(NumberFormatException excepcion){
            System.out.println("IP no valida");
        }
    }
}