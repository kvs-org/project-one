package com.kvs.addition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kvs.addition.service.AdditionService;

@RestController
public class AdditionController {
	
	@Autowired
	private AdditionService addService;

	@GetMapping(path = {"/add"})
	public ResponseEntity<Integer> addition(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		Integer sum = addService.add(a, b);
		return ResponseEntity.ok(sum);
	}
}
