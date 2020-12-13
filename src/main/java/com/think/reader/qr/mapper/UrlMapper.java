package com.think.reader.qr.mapper;

import org.mapstruct.Mapper;

import com.think.reader.qr.domain.Url;
import com.think.reader.qr.rest.UrlDto;

@Mapper
public interface UrlMapper {
	
	UrlDto toDto(Url url); 

}
