package edu.iiitb.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import edu.iiitb.model.User;

public class LoginAuthentication implements Interceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> session=actionInvocation.getInvocationContext().getSession();
		User l=(User)session.get("user");
		if(l==null)
		{
			System.out.println("returning login");
			return ActionSupport.SUCCESS;
		}
		
		return actionInvocation.invoke();
	}

}
