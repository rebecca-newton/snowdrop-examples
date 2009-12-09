package springdemo.adder;

import javax.jws.WebService;

/**
 * Created by IntelliJ IDEA.
 * User: marius
 * Date: Mar 31, 2009
 * Time: 5:03:15 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(serviceName = "adder")
public class Multiplier
{
    public int multiply(int x, int y)
    {
        return x * y; 
    }

}
