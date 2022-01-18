package com.movdeb.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movdeb.test.jsonmap.Root;
import com.movdeb.test.util.UtilApiImpl;

@Service
public class MovDebServiceImpl implements IMovDebService {

	@Autowired
	UtilApiImpl utilApi;

	public Root getExternalApiValues(Integer id) throws NumberFormatException{
		Root character = null;
		if (null != id ) {
			character = utilApi.getExternalApiValues(id);
			return character;
		} else {
			return null;
		}

	}
	
}
