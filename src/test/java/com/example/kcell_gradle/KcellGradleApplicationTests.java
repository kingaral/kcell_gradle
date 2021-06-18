//package com.example.kcell_gradle;
//
//import com.example.kcell_gradle.models.Affairs;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//class KcellGradleApplicationTests extends AbstractTest{
//
//	@Override
//	public void setUp() {
//		super.setUp();
//	}
//	@Test
//	public void getAffairsList() throws Exception {
//		String uri = "/affairs";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Affairs [] affairsList = super.mapFromJson(content, Affairs[].class);
//		assertTrue(affairsList.length > 0);
//	}
//	@Test
//	public void createProduct() throws Exception {
//		String uri = "/affairs";
//		Affairs affairs = new Affairs("Done","Need to done", LocalDate.now().plusMonths(3));
//		String inputJson = super.mapToJson(affairs);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content(inputJson)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Affair is added successfully");
//	}
//	@Test
//	public void updateProduct() throws Exception {
//		String uri = "/affairs/2";
//		Affairs affairs = new Affairs();
//		affairs.setName("Changed");
//		String inputJson = super.mapToJson(affairs);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content(inputJson)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Affair is updated successsfully");
//	}
//	@Test
//	public void deleteProduct() throws Exception {
//		String uri = "/affairs/2";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Affair is deleted successsfully");
//	}
//}
//
//
