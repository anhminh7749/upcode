package com.watch.shopwatchonline.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.watch.shopwatchonline.Model.Image;
@Service
public interface StogareService {

	void init();

	void delete(String fileName) throws IOException;

	Path load(String fileName);

	Resource loadResource(String fileName);

	void store(MultipartFile file, String FileName);

	String getFileName(MultipartFile file);

	void save(MultipartFile file);

	Stream<Path> loadAll();

	List<Image> findImageByProductId(int productId);
	List<Image> findImageByBlogId(int BlogId);
}