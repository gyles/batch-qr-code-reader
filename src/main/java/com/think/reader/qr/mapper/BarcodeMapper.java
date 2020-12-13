package com.think.reader.qr.mapper;

import com.think.reader.qr.domain.Barcode;
import com.think.reader.qr.rest.BarcodeDto;
import org.mapstruct.Mapper;

@Mapper
public interface BarcodeMapper {
	
	BarcodeDto toDto(Barcode barcode);

}
