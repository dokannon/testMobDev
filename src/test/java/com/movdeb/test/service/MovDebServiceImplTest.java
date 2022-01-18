package com.movdeb.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
class MovDebServiceImplTest {
	
	@InjectMocks
	MovDebServiceImpl movDebService;
	
	@DisplayName("Lanza excepcion si el id es nulo")
	@Test
	void shouldThrowNullPoiinterEceptionIfIdIsNull() {
		NumberFormatException numberFormatEception = Assertions.assertThrows(NumberFormatException.class
				, ()-> movDebService.getExternalApiValues(null));
		
		Assertions.assertEquals("Error en el formato del parametro", numberFormatEception);
	}

}
