package com.bossy.myrestapiapp.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bossy.myrestapiapp.application.SubjectApplicationService;
import com.bossy.myrestapiapp.application.dto.SubjectRequestDto;
import com.bossy.myrestapiapp.application.dto.SubjectResponseDto;

@RestController
@RequestMapping("/api")
public class SubjectApiController {

	private final SubjectApplicationService restService;

	public SubjectApiController(SubjectApplicationService restService) {
		this.restService = restService;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello world !";
	}

	@PostMapping
	public ResponseEntity<SubjectResponseDto> createNewSubject(@RequestBody /* @Valid */ SubjectRequestDto request) {
		try {
			SubjectResponseDto response = restService.createSubject(request);
			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubjectResponseDto> getSubjectById(@PathVariable String id) {
		return null;
		// TODO: maybe in future
	}

	@GetMapping("/subjects")
	public ResponseEntity<SubjectResponseDto[]> getAllSubject() {
		return new ResponseEntity<>(restService.getAllSubjects(), HttpStatus.CREATED);
	}

//	@GetMapping("/data")
//	public MyData getData() {
//		return new MyData("Spring Boot", "rest API");
//	}
}
