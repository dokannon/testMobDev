package com.movdeb.test.service;

import com.movdeb.test.jsonmap.Root;

public interface IMovDebService {

	public Root getExternalApiValues(Integer id) throws NumberFormatException;
	
}
