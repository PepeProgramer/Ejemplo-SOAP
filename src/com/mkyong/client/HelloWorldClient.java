package com.mkyong.client;
 
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.mkyong.ws.HelloWorld;
 
public class HelloWorldClient{
 
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
 
        //El primer argumento es la uri del servicio
		//2º argumento es el nombre del servicio, se refiere al espacio de nombres
        QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");
		
		//Primero, el cliente envia una peticion wsdl al "service endpoint"
        /*En una segunda llamada, Método de solicitud de invocación del cliente en un sobre SOAP y lo envía al "service endpoint".
        Éste llama al método requerido y  pone el resultado en un "sobre" SOAP que es enviado al cliente.*/
        Service service = Service.create(url, qname);
 
        HelloWorld hello = service.getPort(HelloWorld.class);
        System.out.println("Introduce el mensaje que quieres enviar al servidor");
        String mensaje = sc.nextLine();

 
        System.out.println(hello.getHelloWorldAsString(mensaje));
        //Solicita un archivo WSDL
        //https://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example-document-style/
 
    }
 
}