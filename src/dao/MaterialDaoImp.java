package dao;

import java.util.List;

import model.Material;

public interface MaterialDaoImp {	
	
	public Material selectAll();
	
	public List find();
	
	public Material selectByName(String name,String pwd);
}
