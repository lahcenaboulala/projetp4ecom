package com.youcode.ecommerce.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.entities.Ebook;
import com.youcode.ecommerce.services.CategoryService;
import com.youcode.ecommerce.services.EbookService;
import com.youcode.ecommerce.services.imp.var;

@RestController
public class EbookController extends ApiController {

	private final EbookService ebookService;
	private final CategoryService catService;

	public EbookController(EbookService ebookService, CategoryService catService) {
		super();
		this.ebookService = ebookService;
		this.catService = catService;
	}

	private boolean isBlank(String param) {
		return param.isEmpty() || param.trim().equals("");
	}

	private Sort getSort(String sort) {
		switch (sort) {
		case "lowest":
			return Sort.by(Sort.Direction.ASC, "price");
		case "highest":
			return Sort.by(Sort.Direction.DESC, "price");
		case "name":
			return Sort.by(Sort.Direction.ASC, "name");
		default:
			return null;
		}
	}

	@GetMapping("/ebooks")
	public ResponseEntity getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "category", required = false) String category) {
		if (page == null || size == null) {
			throw new IllegalArgumentException("Page and size parameters are required");
		}
		PageRequest pageRequest;
		if (sort != null && !isBlank(sort)) {
			Sort sortRequest = getSort(sort);
			if (sortRequest == null) {
				throw new IllegalArgumentException("Invalid sort parameter");
			}
			pageRequest = PageRequest.of(page, size, sortRequest);
		} else {
			pageRequest = PageRequest.of(page, size);
		}
		if (category != null && !isBlank(category)) {
			Category productCategory = catService.findByName(category);
			if (productCategory == null) {
				throw new IllegalArgumentException("Invalid category parameter");
			}
			List returnList = ebookService.findAllByCategory(pageRequest, productCategory);
			return new ResponseEntity<List>(returnList, HttpStatus.OK);
		}

		List returnList = ebookService.findAll(pageRequest);
		return new ResponseEntity<>(returnList, HttpStatus.OK);

	}

	@RequestMapping(value = "/ebook", method = RequestMethod.GET, params = "id")
	public ResponseEntity getFullById(@RequestParam("id") Long id) {
		Ebook ebook = ebookService.findbyId(id);
		if (ebook == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ebook>(ebook, HttpStatus.OK);
	}

	@RequestMapping(value = "/ebooks/mostselling", method = RequestMethod.GET)
	public ResponseEntity getByMostSelling() {
		List returnList = ebookService.findTop8ByOrderBySellCountDesc();
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}

	// some logic
	@RequestMapping(value = "/ebooks/interested", method = RequestMethod.GET)
	public ResponseEntity getByInterested() {
		List returnList = ebookService.findTop8ByOrderBySellCountDesc();
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}

	// search
	@RequestMapping(value = "/ebooks/search", method = RequestMethod.GET, params = { "page", "size", "keyword" })
	public ResponseEntity searchProduct(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("keyword") String keyword) {
		List returnList = ebookService.searchEbooks(keyword, page, size);
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}
	


}
