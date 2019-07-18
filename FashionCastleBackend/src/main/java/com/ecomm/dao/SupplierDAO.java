package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Supplier;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getsupplier(int supplierId);
	

}
