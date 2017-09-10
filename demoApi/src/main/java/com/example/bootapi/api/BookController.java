package com.example.bootapi.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootapi.base.BeanMapper;
import com.example.bootapi.base.MediaTypes;
import com.example.bootapi.domain.Book;
import com.example.bootapi.repository.BookRepository;
import com.example.dto.BookDto;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(value = "/api/book/list", produces = MediaTypes.JSON_UTF_8)
	public Page<BookDto> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size, HttpServletRequest request) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, size, sort);
		Page<Book> pageInfo = bookRepository.findAll(pageable);
		Page<BookDto> mapPage = BeanMapper.mapPage(pageInfo, Book.class, BookDto.class, pageable);
		return mapPage;
	}

	@RequestMapping(value = "/api/book/test", produces = MediaTypes.JSON_UTF_8)
	public String test() {
		return "test";
	}
}
