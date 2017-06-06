import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ErrorHandling
{

	static int a = 1;

	public ErrorHandling()
	{
		// TODOuto-generated constructor stub
	}

	public static void main(String[] args) throws MyException
	{
		Exception myExp =  new MyException(null);
		
		ErrorHandling eHand = new ErrorHandling();
		//eHand.methodCaller();
		if (a == 1)
			;
		Map map = new HashMap();
		map.put(1, 1);
		List list = new ArrayList();
		list.add(1);
		Set set = new HashSet();
		set.add(1);
		try{
			//System.exit(0);
			throw new ParseException("sdasd", 1);
		}
		catch(ParseException e){
			
		}
		finally{
			System.out.println("in finally");
		}
	}

	public void methodCaller() throws MyException
	{
		methodCalled(1);
	}

	public void methodCalled(int a) throws MyException
	{
		try
		{
			if (a == 1)
				throw new MyException("Error Messages");
		}
		catch (MyException e)
		{
			e.printStackTrace();
		}
	}

}

class MyException extends Exception
{
	public MyException(String message)
	{
		System.out.println(message);
	}
}
