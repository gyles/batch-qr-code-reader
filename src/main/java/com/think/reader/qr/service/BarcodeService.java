package com.think.reader.qr.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.think.reader.qr.domain.Barcode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import javax.imageio.ImageIO;

@Service
@RequiredArgsConstructor
public class BarcodeService {

	public Barcode read(MultipartFile image) {
		Barcode barcode = new Barcode();
		barcode.setFilename(image.getOriginalFilename());
		barcode.setText(getText(image));

		return barcode;
	}

	public List<Barcode> readAll(List<MultipartFile> images) {
		return images.stream().map(this::read).collect(Collectors.toList());
	}

	private String getText(MultipartFile image) {
		String text;
		try {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
			LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
			Result result = new MultiFormatReader().decode(binaryBitmap);

			text = result.getText();
		} catch (NotFoundException | IOException e) {
			text = "Unable to read code from binary source.";
		}

		return text;
	}

}
