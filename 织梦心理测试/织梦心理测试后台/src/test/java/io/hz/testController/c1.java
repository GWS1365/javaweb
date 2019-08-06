
package io.hz.testController;

//静态导入,静态方法
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;

/**
 * 测试
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-01-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class c1 {

	private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

	@Autowired
	private WebApplicationContext wac; // 注入WebApplicationContext

	@Before // 在测试开始前初始化工作
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testQ1() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("id", "4");

		MvcResult result = mockMvc.perform(post("/stu/get").content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void testSave() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("paramKey", "合肥");
		map.put("paramValue", "测试");
		map.put("remark", null);

		MvcResult result = mockMvc
				.perform(post("/sys/config/save").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void testPage() throws Exception {
		MvcResult result = mockMvc.perform(post("/sys/config/list"))
				.andExpect(status().isOk())// 模拟向testRest发送get请求
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andReturn();// 返回执行请求的结果

		System.out.println(result.getResponse().getContentAsString());
	}

}
