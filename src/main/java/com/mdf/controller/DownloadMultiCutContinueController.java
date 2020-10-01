package com.mdf.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadMultiCutContinueController {
	
	/**
	 * 断点续传实现：
	 * HTTP协议：
			Content-Length: 65804256  // 请求的文件的大小，单位 byte
			Accept-Ranges: bytes      // 是否允许指定传输范围，bytes：范围请求的单位是 bytes （字节），none：不支持任何范围请求单位，
			Last-Modified: Tue, 07 Jul 2020 13:19:46 GMT  // 服务端文件最后修改时间，可以用于校验文件是否更改过
			x-bs-meta-crc32: 3545941535 // crc32，可以用于校验文件是否更改过
			ETag: dcd0bfef7d90dbb3de50a26b875143fc //Etag 标签，可以用于校验文件是否更改过

	 *当需要断点续传时： 
			Content-Range: <unit>=<range-start>-<range-end>/<size> // size 为文件总大小,如果不知道可以用 *
			Content-Range: <unit>=<range-start>-<range-end>/*  
			Content-Range: <unit>=<range-start>-
			Content-Range: <unit>=* /<size>
	 *
	 *
	 * 
			
	 */
	

}
