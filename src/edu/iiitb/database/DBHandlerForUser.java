	package edu.iiitb.database;

	import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

	import com.mysql.jdbc.Connection;

	import edu.iiitb.model.Advertizement;
import edu.iiitb.model.CategoryModel;
import edu.iiitb.model.ProductInfo;
import edu.iiitb.model.SignupModel;
import edu.iiitb.model.UserEntry;


	/**
	 * @author paras
	 *
	 */
public class DBHandlerForUser {

	/**
	 * 
	 */
		DBConnectivity db=new DBConnectivity();
		
		
		public boolean chkForEmailIDAlreadyExists(String email) throws SQLException
		{
			Connection con = db.createConnection();
			String query="select email from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					con.close();
					return true;
				}
			}
			return false;
		}
		
		public boolean SignupUserinDB(SignupModel user) throws SQLException
		{	
			Connection con = db.createConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String date = sdf.format(new java.util.Date());
			System.out.println(user.getDate());
			String[] splitedDate=user.getDate().split("T");
			String query="INSERT INTO UserCredantials(`firstName`,`lastName`,`password`,`role`,`dateOfBirth`,`addressLine1`,`addressLine2`,`city`,`country`,`pinCode`,`email`,`phoneNumber`,`dateOfRegistration`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prep =con.prepareStatement(query);
			
			prep.setString(1, user.getFirstName());
			prep.setString(2, user.getLastName());
			prep.setString(3, user.getPassword());
			prep.setString(4, "User");
			prep.setString(5, splitedDate[0]);
			prep.setString(6, user.getAddress1());
			prep.setString(7, user.getAddress2());
			prep.setString(8, user.getCity());
			prep.setString(9, user.getCountry());
			prep.setString(10, user.getPincode());
			prep.setString(11, user.getEmail());
			prep.setString(12, user.getPhonenumber());
			prep.setString(13, date );
			prep.execute();
			
			con.close();
			return true;
		}

		public String chkForEmailID_PasswordAlreadyExists(String email,
				String password) throws SQLException 
		{
			Connection con = db.createConnection();
			String role=null;
			String query="select email,password,role from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			System.out.println(email+password);
			while(rs.next())
			{
				if(rs.getString("email").equals(email)&&rs.getString("password").equals(password))
					role=rs.getString("role");
			}
			System.out.println(role);
			if (role==null)
			{
				System.out.println(role);
				return "invalid";
			}
			con.close();
			return role;
				
		}

		
		public String chkForEmailID(String email) throws SQLException 
		{
			Connection con = db.createConnection();
			String role=null;
			String query="select email,role from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			System.out.println(email);
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
					role=rs.getString("role");
			}
			System.out.println(role);
			if (role==null)
			{
				System.out.println(role);
				return "invalid";
			}
			con.close();
			return role;
				
		}

		
		public String getPasswordformDB(String email) throws SQLException 
		{
			// TODO Auto-generated method stub
			Connection con = db.createConnection();
			String query="select email,password from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			String password=null;
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					password=rs.getString("password");
			
				}
			}
			con.close();
			return password;
		
		}	
		
		public ArrayList<Advertizement> getadvertizement(String Type, String Limit) throws SQLException, IOException
		{
			Connection con = db.createConnection();
			ArrayList<Advertizement> advertize = new ArrayList<Advertizement>();
			DBConnectivity db=new DBConnectivity();															
			
			String query="SELECT * FROM Advertizement where Advertizement.advertizementType= '" +Type +"' ORDER BY Advertizement.timeStamp desc LIMIT " + Limit;
		
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				Advertizement obj = new Advertizement();
				obj.setProductId(rs.getInt("productId"));
				obj.setTimeStamp(rs.getTimestamp("timeStamp"));
				obj.setPhoto(rs.getString("image"));
				obj.setCaption(rs.getString("caption"));
				
				//System.out.println(rs.getString("caption"));
				//System.out.println(rs.getInt("productID"));
				advertize.add(obj);
				
			}
			db.closeConnection(con);
			return advertize;
		}
		
		public ArrayList<Advertizement> getadvertizementforfront(String Type, String category) throws SQLException, IOException
		{
			//System.out.println("value in handler : " +Type);
			//System.out.println("value in handler : " +category);
			Connection con = db.createConnection();
			ArrayList<Advertizement> advertize = new ArrayList<Advertizement>();
			DBConnectivity db=new DBConnectivity();															
			
			String query="SELECT distinct(Advertizement.productId), Advertizement.image FROM Advertizement, ProductInfo, CategoryRelation as c1, CategoryRelation as c2, CategoryRelation as c3 where Advertizement.advertizementType= '"+Type+"' and Advertizement.productId = ProductInfo.productId and ProductInfo.categoryId = c3.subCategoryId and c1.categoryId = '"+category+"' and c2.categoryId = c1.subCategoryId and c3.categoryId = c2.subCategoryId ORDER BY Advertizement.timeStamp desc LIMIT 3"; 
		
			ResultSet rs=db.executeQuery(query, con);
			
			if (rs.next() == false)
			{
				query = "SELECT distinct(Advertizement.productId), Advertizement.image FROM Advertizement, ProductInfo, CategoryRelation where Advertizement.advertizementType= '"+Type+"' and Advertizement.productId = ProductInfo.productId and ProductInfo.categoryId = CategoryRelation.subCategoryId and CategoryRelation.categoryId = '"+category+"' ORDER BY Advertizement.timeStamp desc LIMIT 3"; 
				rs=db.executeQuery(query, con);
			}
			else
				rs.previous();
			while(rs.next())
			{
				System.out.println("hi");
				Advertizement obj = new Advertizement();
				obj.setProductId(rs.getInt("productId"));
				obj.setPhoto(rs.getString("image"));
	
				//System.out.println(rs.getInt("productId"));
				//System.out.println(rs.getString("image"));
				advertize.add(obj);
			}
			db.closeConnection(con);
			return advertize;
		}
		
		public ArrayList<CategoryModel> getsubcategorylist(int parentcategoryId) throws SQLException, IOException
		{
			ArrayList<CategoryModel> categoryModel = new ArrayList<CategoryModel>();
			DBConnectivity db=new DBConnectivity();
			Connection con= db.createConnection();																
			
			String query= " SELECT Category.categoryName, Category.categoryId FROM Category, CategoryRelation WHERE Category.categoryId = CategoryRelation.subCategoryId AND CategoryRelation.categoryId =" + parentcategoryId;  
		
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				CategoryModel obj = new CategoryModel();
				obj.setCategoryName(rs.getString("categoryName"));
				obj.setCategoryId(rs.getString("categoryId"));
				categoryModel.add(obj);
			}
			db.closeConnection(con);
			return categoryModel;
		}
		
		public ArrayList<CategoryModel> getsubcategorydeatils(int parentcategoryId) throws SQLException, IOException
		{
			ArrayList<CategoryModel> categoryModel = new ArrayList<CategoryModel>();
			DBConnectivity db=new DBConnectivity();
			Connection con= db.createConnection();																
			
			String query= " SELECT Category.categoryName, Category.categoryId, Category.image FROM Category, CategoryRelation WHERE Category.categoryId = CategoryRelation.subCategoryId AND CategoryRelation.categoryId =" + parentcategoryId;  
		
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				CategoryModel obj = new CategoryModel();
				obj.setCategoryName(rs.getString("categoryName"));
				obj.setCategoryId(rs.getString("categoryId"));
				obj.setCategoryImage(rs.getString("image"));
				//System.out.println(rs.getString("categoryName"));
				categoryModel.add(obj);
			}
			db.closeConnection(con);
			return categoryModel;
		}

		
		public String getfName(String email) throws SQLException
		{
			// TODO Auto-generated method stub
			Connection con = db.createConnection();
			String query="select email,firstName from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			String fName=null;
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					fName=rs.getString("firstName");
			
				}
			}
			System.out.println(fName);
			con.close();
			return fName;
		
		}

		public String chkUserId(String email) throws SQLException
		{
			// TODO Auto-generated method stub
			Connection con = db.createConnection();
			String query="select email,userId from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			String userId=null;
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					userId=rs.getString("userId");
			
				}
			}
			System.out.println(userId);
			con.close();
			return userId;
		}	
		
		public UserEntry getpersonalinfo(String email) throws SQLException
		{
			// TODO Auto-generated method stub
			DBConnectivity db=new DBConnectivity();
			Connection con=db.createConnection();
			String query="select * from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			UserEntry user = new UserEntry();
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
			
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setPhonenumber(rs.getString("phoneNumber"));
				}
		}
			return user;
		}
		
		public void updatepersonalinfo(UserEntry user) throws SQLException
		{
			DBConnectivity db=new DBConnectivity();
			Connection con=db.createConnection();

			String query1="UPDATE UserCredantials SET firstName =?,lastName =?,phoneNumber =? WHERE email=?";
			PreparedStatement prep1 =con.prepareStatement(query1);
			prep1.setString(1, user.getFirstName());
			prep1.setString(2, user.getLastName());
			prep1.setString(3, user.getPhonenumber());
			prep1.setString(4, user.getEmail());
			System.out.println("in db handler for user");
			
			prep1.execute();
			
		}
		
	
		
		public ArrayList<ProductInfo> getproductinfo(int Productid) throws SQLException
		{
			//System.out.println("ProductId in dbhandler : " +Productid);
			Connection con = db.createConnection();
			ArrayList<ProductInfo> ProductInfo = new ArrayList<ProductInfo>();	
			String query="select * from ProductInfo where ProductInfo.productId = '" + Productid + "'";
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				ProductInfo obj = new ProductInfo();
				obj.setProductID(rs.getInt("productId"));
				obj.setProductName(rs.getString("productName"));
				obj.setPrice(rs.getInt("price"));
				obj.setImage(rs.getString("image"));
				obj.setOffer(rs.getInt("offer"));
				obj.setCategoryID(rs.getString("categoryId"));
				obj.setDescription(rs.getString("description"));
				obj.setBrand(rs.getString("brand"));
				obj.setWarranty(rs.getInt("warranty"));
				ProductInfo.add(obj);
			}
			db.closeConnection(con);
			return ProductInfo;
		}
		public ProductInfo getproductinfoforcomparison(int Productid) throws SQLException
		{
			String category="Mobile";
			//System.out.println("ProductId in dbhandler : " +Productid);
			Connection con = db.createConnection();
			String query="select ProductInfo.productId, ProductInfo.productName, ProductInfo.price, ProductInfo.image, ProductInfo.offer, ProductInfo.categoryId, ProductInfo.description, ProductInfo.brand, ProductInfo.warranty, Stock.availableQuantity, Stock.minimumQuantity from ProductInfo, Category, Stock where ProductInfo.categoryId = Category.categoryId and  ProductInfo.productId = Stock.productId and Category.categoryName = '" + category + "' and ProductInfo.productId = '" + Productid + "'" ;       
			ResultSet rs=db.executeQuery(query, con);
			ProductInfo obj = new ProductInfo();
				
			while(rs.next())
			{
				//System.out.println("product is : " +rs.getString("productName") );
				obj.setProductID(rs.getInt("productId"));
				obj.setProductName(rs.getString("productName"));
				obj.setPrice(rs.getInt("price"));
				obj.setImage(rs.getString("image"));
				obj.setOffer(rs.getInt("offer"));
				obj.setCategoryID(rs.getString("categoryId"));
				obj.setDescription(rs.getString("description"));
				obj.setBrand(rs.getString("brand"));
				obj.setWarranty(rs.getInt("warranty"));
				obj.setMinimumQuantity(rs.getInt("minimumQuantity"));
				obj.setAvailableQuantity(rs.getInt("availableQuantity"));
			}
			db.closeConnection(con);
			return obj;
		}
		
		public ArrayList<ProductInfo> getproductlistoncategory(String category) throws SQLException
		{
			//System.out.println("category in dbhandler : " +category);
			Connection con = db.createConnection();
			ArrayList<ProductInfo> ProductInfo = new ArrayList<ProductInfo>();	
			  
			String query="select ProductInfo.productId, ProductInfo.productName, ProductInfo.price, ProductInfo.image, ProductInfo.offer, ProductInfo.categoryId, ProductInfo.description, ProductInfo.brand, ProductInfo.warranty, Stock.availableQuantity, Stock.minimumQuantity from ProductInfo, Category, Stock where ProductInfo.categoryId = Category.categoryId and  ProductInfo.productId = Stock.productId and Category.categoryName = '" + category + "'";       
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				//System.out.println("product is : " +rs.getString("productName") );
				ProductInfo obj = new ProductInfo();
				obj.setProductID(rs.getInt("productId"));
				obj.setProductName(rs.getString("productName"));
				obj.setPrice(rs.getInt("price"));
				obj.setImage(rs.getString("image"));
				obj.setOffer(rs.getInt("offer"));
				obj.setCategoryID(rs.getString("categoryId"));
				obj.setDescription(rs.getString("description"));
				obj.setBrand(rs.getString("brand"));
				obj.setWarranty(rs.getInt("warranty"));
				obj.setMinimumQuantity(rs.getInt("minimumQuantity"));
				obj.setAvailableQuantity(rs.getInt("availableQuantity"));
				ProductInfo.add(obj);
			}
			db.closeConnection(con);
			return ProductInfo;
		}
		
		public ArrayList<String> getCompanylistoncategory(String category) throws SQLException
		{
			//System.out.println("category in dbhandler : " +category);
			Connection con = db.createConnection();
			ArrayList<String> companyname = new ArrayList<String>();	
			String query="select distinct(ProductInfo.brand) from ProductInfo, Category where Category.categoryId = ProductInfo.categoryId and Category.categoryName = '" + category + "'";       
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				//System.out.println("product is : " +rs.getString("brand") );
				companyname.add(rs.getString("brand"));
			}
			db.closeConnection(con);
			return companyname;
		}
		
		public ArrayList<ProductInfo> getproductlist(String keyword) throws SQLException
		{
			//System.out.println("keyword in dbhandler : " +keyword);
			Connection con = db.createConnection();
			ArrayList<ProductInfo> ProductInfo = new ArrayList<ProductInfo>();	
			String query="select ProductInfo.productId, ProductInfo.productName, ProductInfo.price, ProductInfo.image, ProductInfo.offer, ProductInfo.categoryId, ProductInfo.description, ProductInfo.brand, ProductInfo.warranty, Stock.availableQuantity, Stock.minimumQuantity from ProductInfo, Keywords, Stock where ProductInfo.productId = Keywords.productId and  ProductInfo.productId = Stock.productId and Keywords.keyword = '" + keyword + "'";       
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				ProductInfo obj = new ProductInfo();
				obj.setProductID(rs.getInt("productId"));
				obj.setProductName(rs.getString("productName"));
				obj.setPrice(rs.getInt("price"));
				obj.setImage(rs.getString("image"));
				obj.setOffer(rs.getInt("offer"));
				obj.setCategoryID(rs.getString("categoryId"));
				obj.setDescription(rs.getString("description"));
				obj.setBrand(rs.getString("brand"));
				obj.setWarranty(rs.getInt("warranty"));
				obj.setMinimumQuantity(rs.getInt("minimumQuantity"));
				obj.setAvailableQuantity(rs.getInt("availableQuantity"));
				ProductInfo.add(obj);
			}
			db.closeConnection(con);
			return ProductInfo;
		}
		
		public ArrayList<String> getCompanylist(String keyword) throws SQLException
		{
			//System.out.println("keyword in dbhandler : " +keyword);
			Connection con = db.createConnection();
			ArrayList<String> companyname = new ArrayList<String>();	
			String query="select distinct(ProductInfo.brand) from ProductInfo, Keywords where ProductInfo.productId = Keywords.productId and Keywords.keyword = '" + keyword + "'";       
			ResultSet rs=db.executeQuery(query, con);
			
			while(rs.next())
			{
				//System.out.println("product is : " +rs.getString("brand") );
				companyname.add(rs.getString("brand"));
			}
			db.closeConnection(con);
			return companyname;
		}

		public ArrayList<String>  getproductsforcomparison(int categoryId) throws SQLException 
		{
			Connection con = db.createConnection();
			ArrayList<String> categoryproducts = new ArrayList<String>();	
			String query="select ProductInfo.productId, ProductInfo.productName from FlipKartDatabase.ProductInfo where ProductInfo.categoryId =  " + categoryId ;       
			ResultSet rs=db.executeQuery(query, con);
			System.out.println("hello1");
			while(rs.next())
			{
				System.out.println(rs.getString("productName"));
				categoryproducts.add(rs.getString("productName"));
			}
			System.out.println("hello2");
			for (String i : categoryproducts)
			System.out.println(i);
			
			db.closeConnection(con);
			
			return categoryproducts;		
		}

		public ArrayList<ProductInfo> getProductInfoByName(String productname) throws SQLException 
		{
			
			Connection con = db.createConnection();
			ArrayList<ProductInfo> productInfoAdded = new ArrayList<ProductInfo>();	
			String query="select ProductInfo.productId, ProductInfo.productName, ProductInfo.price, ProductInfo.image, ProductInfo.offer, ProductInfo.categoryId, ProductInfo.description, ProductInfo.brand, ProductInfo.warranty, Stock.availableQuantity, Stock.minimumQuantity from ProductInfo, Stock where  ProductInfo.productId = Stock.productId and ProductInfo.productName = '" + productname + "'" ;       
			      
			ResultSet rs=db.executeQuery(query, con);
			System.out.println("hello1");
			ProductInfo obj = new ProductInfo();
			while(rs.next())
			{
				
				obj.setProductID(rs.getInt("productId"));
				obj.setProductName(rs.getString("productName"));
				obj.setPrice(rs.getInt("price"));
				obj.setImage(rs.getString("image"));
				obj.setOffer(rs.getInt("offer"));
				obj.setCategoryID(rs.getString("categoryId"));
				obj.setDescription(rs.getString("description"));
				obj.setBrand(rs.getString("brand"));
				obj.setWarranty(rs.getInt("warranty"));
				obj.setMinimumQuantity(rs.getInt("minimumQuantity"));
				obj.setAvailableQuantity(rs.getInt("availableQuantity"));
				productInfoAdded.add(obj);
			}
			
			db.closeConnection(con);
			System.out.println("hello2");
			return productInfoAdded;		}
}

