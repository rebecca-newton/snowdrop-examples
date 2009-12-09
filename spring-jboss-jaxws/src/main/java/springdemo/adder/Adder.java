package springdemo.adder;

import javax.jws.WebService;
import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(serviceName = "adderService", targetNamespace = "")
public class Adder extends SpringBeanAutowiringSupport
{
	@Autowired
	@Qualifier("message")
	String message;

    @WebMethod
    public String add(int x, int y)
    {
        return message + x + y;   
    }
    
}
