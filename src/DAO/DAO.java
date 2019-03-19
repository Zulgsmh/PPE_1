package DAO;

import java.sql.SQLException;

import javafx.collections.ObservableList;

public interface DAO <T>{
	default void insert(T t) {};
	default void create(T t) {};
	ObservableList<T> findAll() throws SQLException ;
 default	T findById(String id) throws SQLException  {return null ;};
	default ObservableList<T> findByIdListe(String id) throws SQLException {return null ;} ;
	

} 
