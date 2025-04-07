package com.nn.sa.requests.nn_sa_requests.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nn.sa.requests.nn_sa_requests.models.entity.Request;
import com.nn.sa.requests.nn_sa_requests.models.service.IRequestService;

import jakarta.websocket.ClientEndpoint;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RequestServiceController {

	
	@Autowired
	private IRequestService requestService;
	
	@GetMapping("/requests")
	public List<Request> index(){
		return requestService.findAll();
	}
	
	@GetMapping("/requests/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Request request = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			request = requestService.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje: ", "Error al realizar consulta en la Base de Datos");
			response.put("Error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("Status: ", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(request == null) {
			response.put("Mensaje: ", "El Cliente con ID: ".concat(id.toString()).concat(" No existe!!"));
			response.put("Status: ", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		response.put("Mensaje: ", "Estos son los datos del Cliente!! ");
		response.put("Cliente: ", request);
		response.put("Status: ",  HttpStatusCode.valueOf(200));
		System.out.print("CODE RESPONSE: "+HttpStatusCode.valueOf(200));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/requests")
	public ResponseEntity<?> create(@RequestBody Request request) {
		
		Request requestNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			
			requestNew = requestService.save(request);
			
		} catch (DataAccessException e) {
			response.put("Mensaje: ", "Error al realizar la creación en la Base de Datos");
			response.put("Error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("Status: ", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje: ", "Cliente creado correctamente!!");
		response.put("Cliente: ", requestNew);
		response.put("Status: ", HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/requests/{id}")
	public ResponseEntity<?> update(@RequestBody Request request, @PathVariable Long id) {
		Request requestCurrent = requestService.findById(id);
		Request requestUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if(requestCurrent == null) {
			response.put("Mensaje: ", "El Cliente con ID: ".concat(id.toString()).concat(" No existe!!"));
			response.put("Status: ", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			requestCurrent.setRequesterId(request.getRequesterId());
			requestCurrent.setStatusId(request.getStatusId());
			requestUpdate = requestService.save(requestCurrent);
		} catch (DataAccessException e) {
			response.put("Mensaje: ", "Error al realizar la creación en la Base de Datos");
			response.put("Error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("Status: ", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje: ", "Cliente Actualizado correctamente!!");
		response.put("Cliente: ", requestUpdate);
		response.put("Status: ", HttpStatus.CREATED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("/requests/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Request request = requestService.findById(id);
		Map<String, Object> response = new HashMap<>();
		if (request != null) {

		try {
			requestService.delete(id);
		} catch (DataAccessException e) {
			response.put("Mensaje: ", "Error al realizar la eliminación en la Base de Datos");
			response.put("Error: ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("Status: ", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje: ", "Cliente Eliminado con exito!!");
		response.put("Status: ", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
		
		}else {
			
			response.put("Mensaje: ", "Cliente con ID: ".concat(id.toString()).concat(" no existe !!") );
			response.put("Status: ", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST) ;
			
		}
		
	}
	
	

}
