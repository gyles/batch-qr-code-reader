package com.think.reader.qr.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url")
public class UrlResource {
	
	
	 @GetMapping
	 public ResponseEntity<UrlDto> getUrl() {
		 UrlDto dto = new UrlDto();
		 dto.setFilename("filename");
		 dto.setUrl("url");
		 
		 return ResponseEntity.ok(dto);
	 }

}
