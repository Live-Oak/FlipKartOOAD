/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.ViewStock;

/**
 * @author paras
 *
 */
public class StockRequestManagement extends ActionSupport implements ModelDriven<ViewStock>{

	ViewStock order = new ViewStock();
	
	public String execute()
	{
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.updateMinimumQuantityOfProduct(order.getSellerId(), order.getProductId(), order.getMinimumQty());
			dbHandler.insertOrderProductForStock(order);
			addActionMessage("Order Has been placed.. waiting for approval");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of StockRequestManagement.java");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	
	
	/**
	 * @return the order
	 */
	public ViewStock getOrder() {
		return order;
	}



	/**
	 * @param order the order to set
	 */
	public void setOrder(ViewStock order) {
		this.order = order;
	}



	@Override
	public ViewStock getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
}
