package com.watch.shopwatchonline.Service.ServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.watch.shopwatchonline.Exception.StorageFileException;
import com.watch.shopwatchonline.Exception.StrorageException;
import com.watch.shopwatchonline.Model.Image;
import com.watch.shopwatchonline.Repository.ImageRepository;
import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.config.StorageProperties;


@Service
public class FileSystemStogareServiceImlp implements StogareService {
	private final Path rootLocation;
@Autowired
ImageRepository imageRepository;

@Override
public List<Image> findImageByProductId(int productId) {
	return imageRepository.findImageByProductId(productId);
}
@Override
public List<Image> findImageByBlogId(int BlogId) {
	return imageRepository.findImageByBlogId(BlogId);
}



	@Override
	public String getFileName(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
            String uu = uuid.toString();
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		return "p" + uu + "." + ext;
	}

	public FileSystemStogareServiceImlp(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void store(MultipartFile file, String FileName) {
		try {
			if (file.isEmpty()) {
				throw new StrorageException("Failed to store empty file!");
			}
			Path des = this.rootLocation.resolve(Paths.get(FileName)).normalize().toAbsolutePath();

			if (!des.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StrorageException("Can't store file outside current directory!");
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, des, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StrorageException("Failed to store file! " + e);
		}
	}
	@Override
	public void save(MultipartFile file) {
		try {
		  Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
		  throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	  }

	@Override
	public Resource loadResource(String fileName) {
		try {
			Path file = load(fileName);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			throw new StorageFileException("Could not read file: " + fileName);
		} catch (Exception e) {
			throw new StorageFileException("Could not read file: " + fileName + e);
		}
	}

	@Override
	public Path load(String fileName) {
		return rootLocation.resolve(fileName);
	}

	@Override
	public void delete(String fileName) throws IOException {
		Path des = rootLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();
		Files.delete(des);
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);

		} catch (Exception e) {
			throw new StorageFileException("Could not initialize storage! " + e);
		}
	}

	@Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
}
