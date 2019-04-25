package com.ecommerce.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "C:\\Users\\VISHAL\\git\\shopping\\shopping\\src\\main\\webapp\\assets\\images\\";
	private static String realPath = "";

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void upload(HttpServletRequest request, MultipartFile file, String code) {

		realPath = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info("Real Path : " + realPath);
		File absFile = new File(ABS_PATH);
		if (!absFile.exists()) {
			absFile.mkdirs();
		}
		File realFile = new File(realPath);
		if (!realFile.exists()) {
			realFile.mkdirs();
		}

		absFile = new File(ABS_PATH + code + ".jpg");
		realFile = new File(realPath + code + ".jpg");
		try {
			file.transferTo(absFile);
			file.transferTo(realFile);
		} catch (IllegalStateException | IOException e) {
			logger.error("File Upload error : " + e.toString());
		}
	}

}
