package com.tas.springmvc.demo.model.dao;

import java.util.List;

public interface DemoMVCDao<T> {
	Boolean add(final T t);
	Boolean addMany(List<T> list);
	int update(final  T t);
	int updateMany(List<T> list);
	int deleteById(final int id);
	int deleteManyById(List<Integer> list);
	T searchById(int id);
	List<T> getAll();
	
	
	
	
}
