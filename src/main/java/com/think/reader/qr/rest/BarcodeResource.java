package com.think.reader.qr.rest;

import com.think.reader.qr.mapper.BarcodeMapper;
import com.think.reader.qr.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BarcodeResource {

    private final BarcodeService service;
    private final BarcodeMapper mapper;

    @PutMapping(value = "/barcodes",
        consumes = { MediaType.MULTIPART_FORM_DATA_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<BarcodeDto>> readBarcodes(@RequestPart("file") List<MultipartFile> images) {
        if (images == null || images.isEmpty()) {
            throw new IllegalArgumentException("File(s) must be provided.");
        }

        return ResponseEntity.ok(service.readAll(images).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList())
        );
    }

}
