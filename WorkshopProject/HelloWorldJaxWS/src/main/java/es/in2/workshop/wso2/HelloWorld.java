package es.in2.workshop.wso2;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "HelloWorld")
public class HelloWorld {

	public final static String WEB_SERVICE_CONTEXT = "/HelloWorldService";
	
	/** This is a sample web service operation */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		return "Hello " + txt + " !";
	}


}