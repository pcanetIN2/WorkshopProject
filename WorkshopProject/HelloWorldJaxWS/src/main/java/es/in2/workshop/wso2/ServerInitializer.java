package es.in2.workshop.wso2;

import java.net.InetSocketAddress;

import javax.xml.ws.Endpoint;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

public class ServerInitializer {

	private static final String HTTP_HOSTNAME = "localhost";
	private static final int HTTP_PORT = 8080;
	
	private static HttpServer server = null;

	
	
	public static void main(String... args) {
		ServerInitializer serverInitializer = new ServerInitializer();
		
		try {
			serverInitializer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void start() throws Exception {
		server = HttpServer.create(new InetSocketAddress(HTTP_HOSTNAME, HTTP_PORT), 10);
		server.start();

		registerHelloWorldService();
	}
			
	
	/**
	 * Registra Web Service HelloWorld
	 * @throws Exception
	 */
	private void registerHelloWorldService() throws Exception {
		System.out.println("Registering WebService JAX-WS");
		
		Endpoint endPoint = Endpoint.create(new HelloWorld());
		
		
		HttpContext httpContext = null;
		httpContext = server.createContext(HelloWorld.WEB_SERVICE_CONTEXT);
				
		//Publish
		endPoint.publish(httpContext); 
		
		System.out.println("Web Service published!");
	}
	
}
