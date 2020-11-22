package com.kosmo.springapp.basic.fileupdown;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadCommand {
	private String writer;
	private String title;
	//※ input type="file"는 MultipartFile타입으로]	
	private MultipartFile upload;
	
}
