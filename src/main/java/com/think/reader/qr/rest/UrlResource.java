package com.think.reader.qr.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.think.reader.qr.mapper.UrlMapper;
import com.think.reader.qr.service.QrCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlResource {

	private final QrCodeService service;
	private final UrlMapper mapper;

	@PostMapping
	public ResponseEntity<List<UrlDto>> getUrl(@RequestParam MultipartFile[] images) {
		if (images == null || images.length < 1) {
			throw new IllegalArgumentException("File(s) must be provided.");
		}

		return ResponseEntity.ok(service.read(images).stream().map(mapper::toDto).collect(Collectors.toList()));
	}

}
