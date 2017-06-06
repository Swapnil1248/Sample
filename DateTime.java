import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTime
{

	public DateTime()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		System.out.println(10*12*13);
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		System.out.println(date); // 15/10/2013

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		try
		{
			Date date1 = sdf1.parse(dateInString);
			System.out.println(date1); // Tue Aug 31 10:20:56 SGT 1982
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date2 = new Date();
		System.out.println(dateFormat.format(date2)); // 2013/10/15 16:16:39

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar1 = new GregorianCalendar(2013, 0, 31);
		System.out.println(sdf2.format(calendar1.getTime()));

		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2013, 1, 28, 13, 24, 56);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR); // 12 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		System.out.println(sdf3.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);

	}

}
