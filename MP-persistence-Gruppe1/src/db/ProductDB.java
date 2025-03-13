package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Accessory;
import model.Address;
import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;
import model.Supplier;

public class ProductDB implements ProductDBIF {
	
	private static final String FIND_PRODUCT_BY_BARCODE_QUERY = "SELECT FROM Product WHERE barcode = ?";
	private PreparedStatement findProductByBarcode;
	private static final String UPDATE_PRODUCT_QUERY = "";
	private PreparedStatement updateProduct;
	private static final String INSERT_PRODUCT_QUERY = "INSERT INTO Product(name, purchase_price, rent_price, country_of_origin, barcode, supplier_id, min_stock, product_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertProduct;
	
	private static final String FIND_SUPPLIER_BY_ID_QUERY = "SELECT * FROM Supplier WHERE supplier_id = ?";
	private PreparedStatement findSupplierByID;
	private static final String FIND_ADDRESS_BY_ID_QUERY = "SELECT * FROM Address WHERE address_id = ?";
	private PreparedStatement findAddressByID;
	
	private static final String FIND_ACCESSORY_QUERY = "SELECT * FROM AccessoryView WHERE barcode = ?";
	private PreparedStatement findAccessory;
	private static final String FIND_CLOTHING_QUERY = "SELECT * FROM ClothingView WHERE barcode = ?";
	private PreparedStatement findClothing;
	private static final String FIND_EQUIPMENT_QUERY = "SELECT * FROM EquipmentView WHERE barcode = ?";
	private PreparedStatement findEquipment;
	private static final String FIND_GUN_REPLICA_QUERY = "SELECT * FROM GunReplicaView WHERE barcode = ?";
	private PreparedStatement findGunReplica;
	

	
	public ProductDB() {
		init();
	}
	
	private void init() {
		Connection con = DBConnection.getInstance().getConnection();
		
		try {
			findProductByBarcode = con.prepareStatement(FIND_PRODUCT_BY_BARCODE_QUERY);
			updateProduct = con.prepareStatement(UPDATE_PRODUCT_QUERY);
			insertProduct = con.prepareStatement(INSERT_PRODUCT_QUERY);
			
			findSupplierByID = con.prepareStatement(FIND_SUPPLIER_BY_ID_QUERY);
			findAddressByID = con.prepareStatement(FIND_ADDRESS_BY_ID_QUERY);
			
			findAccessory = con.prepareStatement(FIND_ACCESSORY_QUERY);
			findClothing = con.prepareStatement(FIND_CLOTHING_QUERY);
			findEquipment = con.prepareStatement(FIND_EQUIPMENT_QUERY);
			findGunReplica = con.prepareStatement(FIND_GUN_REPLICA_QUERY);
			
		} catch (SQLException e) {
			
		}
	}
	
	private Product buildObject(ResultSet resultSet) {
		Product currentProduct = null;
		
		try {
			findSupplierByID.setInt(1, resultSet.getInt("supplier_id"));
			ResultSet resultSetSupplier = findSupplierByID.executeQuery();
			findSupplierByID.setInt(1, resultSetSupplier.getInt("address_id"));
			ResultSet resultSetAddress = findAddressByID.executeQuery();
			
			String productType = resultSet.getString("product_type");
			switch (productType) {
			case "Accessory":
				currentProduct = new Accessory(resultSet.getString("name"), 
						resultSet.getDouble("purchase_price"), 
						resultSet.getDouble("rent_price"), 
						resultSet.getString("country_of_origin"), 
						resultSet.getInt("min_stock"), 
						resultSet.getString("barcode"), 
						new Supplier(resultSetSupplier.getString("name"), resultSetSupplier.getString("phone_no"), resultSetSupplier.getString("email"), new Address(resultSetAddress.getString("street_name"), resultSetAddress.getInt("zipcode"), resultSetAddress.getString("city"), resultSetAddress.getString("country")), resultSetSupplier.getString("cvr")), 
						resultSet.getString("type"), 
						resultSet.getString("description"));
				break;
			case "Clothing":
				currentProduct = new Clothing(resultSet.getString("name"), 
						resultSet.getDouble("purchase_price"), 
						resultSet.getDouble("rent_price"), 
						resultSet.getString("country_of_origin"), 
						resultSet.getInt("min_stock"), 
						resultSet.getString("barcode"),  
						new Supplier(resultSetSupplier.getString("name"), resultSetSupplier.getString("phone_no"), resultSetSupplier.getString("email"), new Address(resultSetAddress.getString("street_name"), resultSetAddress.getInt("zipcode"), resultSetAddress.getString("city"), resultSetAddress.getString("country")), resultSetSupplier.getString("cvr")), 
						resultSet.getString("size"), 
						resultSet.getString("colour"));
				break;
			case "Equipment":
				currentProduct = new Equipment(resultSet.getString("name"), 
						resultSet.getDouble("purchase_price"), 
						resultSet.getDouble("rent_price"), 
						resultSet.getString("country_of_origin"), 
						resultSet.getInt("min_stock"), 
						resultSet.getString("barcode"), 
						new Supplier(resultSetSupplier.getString("name"), resultSetSupplier.getString("phone_no"), resultSetSupplier.getString("email"), new Address(resultSetAddress.getString("street_name"), resultSetAddress.getInt("zipcode"), resultSetAddress.getString("city"), resultSetAddress.getString("country")), resultSetSupplier.getString("cvr")), 
						resultSet.getString("type"), 
						resultSet.getString("description"));
				break;
			case "GunReplica": 
				currentProduct = new GunReplica(resultSet.getString("name"), 
						resultSet.getDouble("purchase_price"), 
						resultSet.getDouble("rent_price"), 
						resultSet.getString("country_of_origin"), 
						resultSet.getInt("min_stock"), 
						resultSet.getString("barcode"), 
						new Supplier(resultSetSupplier.getString("name"), resultSetSupplier.getString("phone_no"), resultSetSupplier.getString("email"), new Address(resultSetAddress.getString("street_name"), resultSetAddress.getInt("zipcode"), resultSetAddress.getString("city"), resultSetAddress.getString("country")), resultSetSupplier.getString("cvr")), 
						resultSet.getString("calibre"), 
						resultSet.getString("material"));
				break;
			}
			
		} catch (SQLException e) {
			
		}
		
		return currentProduct;
	}
	
	@Override
	public Product findProductByBarcode(String barcode) {
		Product currentProduct = null;
		
		try {
			findProductByBarcode.setString(1, barcode);
			ResultSet resultSet = findProductByBarcode.executeQuery();
			ResultSet resultSetView = null;
			
			String productType = resultSet.getString("product_type");
			switch (productType) {
			case "Accessory":
				resultSetView = findAccessory.executeQuery();
				break;
			case "Clothing":
				resultSetView = findClothing.executeQuery();
				break;
			case "Equipment":
				resultSetView = findEquipment.executeQuery();
				break;
			case "GunReplica":
				resultSetView = findGunReplica.executeQuery();
				break;
			}
			
			currentProduct = buildObject(resultSetView);
			
		} catch (SQLException e) {
			
		}
		
		return currentProduct;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		return;
	}

}
