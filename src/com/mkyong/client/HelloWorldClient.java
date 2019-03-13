package com.mkyong.client;
 
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.mkyong.ws.HelloWorld;
 
public class HelloWorldClient{
 
	public static void main(String[] args) throws Exception {
        //Create a web service client to access your published service.
        //First, client send a wsdl request to service endpoint
        /*A second call, client put method invoke request in SOAP envelope and send it to service endpoint.
        At the service endpoint, call the requested method and put the result in a SOAP envelope and send it back to client.*/
        Scanner sc = new Scanner(System.in);
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
 
        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");
 
        Service service = Service.create(url, qname);
 
        HelloWorld hello = service.getPort(HelloWorld.class);
        System.out.println("Introduce el mensaje que quieres enviar al servidor");
        String mensaje = sc.nextLine();

 
        System.out.println(hello.getHelloWorldAsString(mensaje));
        //Solicita un archivo WSDL
        //https://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example-document-style/
 
    }
 
}