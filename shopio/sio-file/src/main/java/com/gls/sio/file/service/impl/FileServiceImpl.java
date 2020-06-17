package com.gls.sio.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gls.sio.file.service.FileService;
import com.gls.sio.file.service.exception.FileStorageException;
import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

	private final static String DOWN_LOAD_URI = "/download-file/";
	private final static String PRODUCT_IMAGES_DIRECTORY = "/Individual/Project/shopio/sio-file/product-images/%s";
	private final static String INVALID_FILENAME_MESSAGE = "Filename contains invalid path sequence: [%s]";
	private final static String ERROR_SAVING_MESSAGE = "Error when saving file: [%s]";

	@Autowired
	private FileRepository fileRepository;

	@Override
	public FileEntity store(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());

		if (filename.contains("..")) {
			throw new FileStorageException(String.format(INVALID_FILENAME_MESSAGE, filename));
		}

		String uniqueName = generateUniqueFilename(filename);

		try {

			FileEntity fileEntity = new FileEntity(uniqueName, file.getContentType(), file.getBytes());

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(DOWN_LOAD_URI)
					.path(fileEntity.getFilename()).toUriString();

			fileEntity.setFileDownloadUri(fileDownloadUri);
			
			File image = new File(String.format(PRODUCT_IMAGES_DIRECTORY, fileEntity.getFilename()));
			FileUtils.writeByteArrayToFile(image, fileEntity.getData());

			return null;// fileRepository.create(fileEntity);

		} catch (IOException ex) {
			throw new FileStorageException(String.format(ERROR_SAVING_MESSAGE, uniqueName), ex);
		}
	}

	@Override
	public FileEntity findById(Long id) {
		return fileRepository.findOne(id);
	}

	private String generateUniqueFilename(String filename) {

		String extension = FilenameUtils.getExtension(filename);
		String baseName = FilenameUtils.getBaseName(filename);

		StringBuilder builder = new StringBuilder()
				.append(baseName)
				.append(Calendar.getInstance().getTimeInMillis())
				.append(".")
				.append(extension);

		return builder.toString();
	}
}
