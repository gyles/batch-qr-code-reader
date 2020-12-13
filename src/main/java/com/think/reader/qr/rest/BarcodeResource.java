package com.think.reader.qr.rest;

import com.think.reader.qr.mapper.BarcodeMapper;
import com.think.reader.qr.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/barcode")
@RequiredArgsConstructor
public class BarcodeResource {

	private final BarcodeService service;
	private final BarcodeMapper mapper;

	@PutMapping(value = "/image", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<BarcodeDto> getUrl(@RequestParam("file") MultipartFile image) {
		if (image == null) {
			throw new IllegalArgumentException("File must be provided.");
		}

		return ResponseEntity.ok(mapper.toDto(service.read(image)));
	}

}
