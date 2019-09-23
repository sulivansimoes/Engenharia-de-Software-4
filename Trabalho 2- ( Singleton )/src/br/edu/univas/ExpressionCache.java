package br.edu.univas;

import java.util.HashMap;
import java.util.Map;

public class ExpressionCache {

	private Map<String, Double> cache;
	private static ExpressionCache instance;
	
	
	private ExpressionCache() {
		cache = new HashMap();
	}
	
	public static ExpressionCache getInstance(){
		
		return instance = (  ( instance == null ) ? new ExpressionCache() : instance );		
	}	
	
	public void add(String expression, Double result) {
		cache.put(expression, result);
	}
	
	public Double get(String expression) {
		return cache.get(expression);
	}
	
}
