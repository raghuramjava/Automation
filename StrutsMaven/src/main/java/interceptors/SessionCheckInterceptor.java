package interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionCheckInterceptor implements Interceptor {
	public void destroy() {
	}

    public void init() {
	}
    public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map session = actionInvocation.getInvocationContext().getSession();
		if (session.get("loginId") == null) {
			return "loginAction";
		}
		else {
			return actionInvocation.invoke();
		}
	}

}
