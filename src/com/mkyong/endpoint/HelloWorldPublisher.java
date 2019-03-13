package com.mkyong.endpoint;
 
import javax.xml.ws.Endpoint;
import com.mkyong.ws.HelloWorldImpl;
 
//Endpoint publisher
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
		/*Endpoint es un equipo remoto que se comunica ida y vuelta con una red a la que
		está conectada*/
	   Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	   /*.publish permite la entrada de peticiones al endpoint*/
    }
 
}