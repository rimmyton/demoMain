package com.example.bootapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.bootapi.base.MediaTypes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockMvcTests {

//	@Rule
//	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("docs");
//
//	@Autowired
//	private WebApplicationContext context;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
//				.apply(MockMvcRestDocumentation.documentationConfiguration(this.restDocumentation)).build();
//	}
//
//	@Test
//	public void ss() throws Exception {
//		this.mockMvc.perform(get("/api/book/list").accept(MediaTypes.JSON_UTF_8)).andExpect(status().isOk())
//				.andDo(MockMvcRestDocumentation.document("index"));
//	}

}
