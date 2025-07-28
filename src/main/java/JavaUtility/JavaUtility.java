package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Days360;

public class JavaUtility {

		public int getRandomNumber() {
			Random random = new Random();
			int randomCount= random.nextInt(10000);
			return randomCount;
		}
		
		public String getCurrentDate()
		{
			Date date=new Date();
			 SimpleDateFormat sim= new SimpleDateFormat("MM-dd-YYYY");
			 String currentdate= sim.format(date);
			 return currentdate;
		}
		
		public String togetRequired(int days) {
			 Date date=new Date();
			 SimpleDateFormat sim= new SimpleDateFormat("MM-dd-YYYY");
			 sim.format(date);
			 Calendar cal = sim.getCalendar();
			 cal.add(Calendar.DAY_OF_MONTH, days);
			 String datereq= sim.format(cal.getTime());
			 return datereq;
		}

	}

