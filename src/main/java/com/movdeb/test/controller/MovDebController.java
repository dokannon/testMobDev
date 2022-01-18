package com.movdeb.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movdeb.test.service.IMovDebService;

@RestController
@RequestMapping("/api/rickandmorty")
public class MovDebController {
	@Autowired
	IMovDebService service;
	
	@GetMapping("/characterid/{id}")
	public ResponseEntity<?> getJsonFromApi(@PathVariable("id") Integer id){
		try {
			return new ResponseEntity<>(service.getExternalApiValues(id), HttpStatus.OK);
		}catch(NumberFormatException e){
			return new ResponseEntity<>(e, HttpStatus.CONFLICT);
		}
		
	}
	
}
