package Connection;


import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class Dispatcher extends StrutsPrepareAndExecuteFilter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		try {
			HibernateUtill.createSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
