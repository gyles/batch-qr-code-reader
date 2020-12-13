package com.think.reader.qr.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.think.reader.qr.domain.Url;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QrCodeService {

	public List<Url> read(MultipartFile[] images) {
		return Arrays.stream(images).map(image -> {
			Url url = new Url();
			url.setFilename(image.getName());

			return url;
		}).collect(Collectors.toList());
	}

}
