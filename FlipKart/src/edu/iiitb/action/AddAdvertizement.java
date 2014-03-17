package edu.iiitb.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.Advertizement;

public class AddAdvertizement extends ActionSupport implements ModelDriven<Advertizement> , SessionAware , ServletRequestAware{
	
	DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
	Advertizement adv = new Advertizement();
	
	HttpServletRequest servletRequest;	
	/**
	 * @return the servletRequest
	 */
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	/**
	 * @param servletRequest the servletRequest to set
	 */
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	private Map session;
	
	
	
	/**
	 * @return the session
	 */
	public Map getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * @return the adv
	 */
	public Advertizement getAdv() {
		return adv;
	}

	/**
	 * @param adv the adv to set
	 */
	public void setAdv(Advertizement adv) {
		this.adv = adv;
	}

	public String execute()
	{
		String destPath = servletRequest.getSession().getServletContext().getRealPath("/");
		
		File destFile = new File(destPath,adv.getMyFileFileName());
		try {
			FileUtils.copyFile(adv.getMyFile(), destFile);
			FileInputStream inputStream = new FileInputStream(destFile);
			adv.setImage(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		try {
			dbHandler.addAdvertisement(adv);
			
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		
		addActionMessage("Advertisement registered successfully!!!");
		return "success";
	}

	@Override
	public Advertizement getModel() {
		// TODO Auto-generated method stub
		return adv;
	}
	
}
