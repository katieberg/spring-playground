package com.galvanize.playground;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PlaygroundApplication.class)
public class PlaygroundApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
		this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("3.141592653589793"));
	}

	@Test
	public void testMathThing() throws Exception {
		this.mvc.perform(get("/vehicles?year=1987&doors=2"))
				.andExpect(status().isOk());
	}
}
