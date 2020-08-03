package com.gls.sio.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gls.sio.file.service.FileService;
import com.gls.sio.file.service.exception.FileStorageException;
import com.gls.sio.persistent.entity.FileEntity;
import com.gls.sio.persistent.repository.FileRepository;

@Service
@PropertySources({ @PropertySource("classpath:file.properties") })
public class FileServiceImpl implements FileService {

	private final static Logger LOGGER = LoggerFactory.getLogger(FileService.class);

	private final static String DOWN_LOAD_URI = "product.image.uri";
	private final static String PRODUCT_IMAGES_DIRECTORY = "product.image.filepath";

	private final static String INVALID_FILENAME_MESSAGE = "Filename contains invalid path sequence: [%s]";
	private final static String ERROR_SAVING_MESSAGE = "Error when saving file: [%s]";

	@Autowired
	private Environment environment;

	@Autowired
	private FileRepository fileRepository;

	/*
	 * String pathToSaveImage =
	 * servletRequest.getServletContext().getRealPath("/product-images"); The file
	 * will be stored in: pathToSaveImage = D:/Individual/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sio-console/product-images
	 * 
	 */
	@Override
	public FileEntity storeFile(MultipartFile file) {

		String filename = StringUtils.cleanPath(file.getOriginalFilename());

		if (filename.contains("..")) {
			throw new FileStorageException(String.format(INVALID_FILENAME_MESSAGE, filename));
		}

		String uniqueName = generateUniqueFilename(filename);

		File image = new File(String.format(environment.getProperty(PRODUCT_IMAGES_DIRECTORY), uniqueName));

		try {

			FileUtils.writeByteArrayToFile(image, file.getBytes());

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(environment.getProperty(DOWN_LOAD_URI)).path(uniqueName).toUriString();

			return new FileEntity(uniqueName, file.getContentType(), fileDownloadUri, file.getBytes());

		} catch (IOException ex) {

			throw new FileStorageException(String.format(ERROR_SAVING_MESSAGE, uniqueName), ex);
		}
	}

	@Override
	public FileEntity findById(Long id) {
		return fileRepository.findOne(id);
	}

	@Override
	public FileEntity create(FileEntity fileEntity) {
		return fileRepository.create(fileEntity);
	}

	private String generateUniqueFilename(String filename) {

		String extension = FilenameUtils.getExtension(filename);
		String baseName = FilenameUtils.getBaseName(filename);

		StringBuilder builder = new StringBuilder().append(baseName).append(Calendar.getInstance().getTimeInMillis())
				.append(".").append(extension);

		return builder.toString();
	}

	@Override
	public void detelePhysicalFile(String filename) {

		String imageName = filename.substring(filename.lastIndexOf("/")+1, filename.length());

		String filePath = String.format(environment.getProperty(PRODUCT_IMAGES_DIRECTORY), imageName);

		try {
			java.nio.file.Files.delete(Paths.get(filePath));
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public FileEntity findByProductId(Long productId) {
		return fileRepository.findByProductId(productId);
	}

	@Override
	public FileEntity update(FileEntity fileEntity) {
		return fileRepository.update(fileEntity);
	}
}
