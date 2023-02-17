package study.openapi.domain.place;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import study.openapi.domain.place.dto.SearchLocalReq;
import study.openapi.domain.place.dto.SearchLocalRes;

@SpringBootTest
class NaverClientTest {

	@Autowired
	private NaverClient naverClient;

	@Test
	@DisplayName("search api test")
	void testMethodNameHere() {
	    // given
		SearchLocalReq req = new SearchLocalReq();
		req.setQuery("강남역 맛집");

		SearchLocalRes res = naverClient.localSearch(req);
		System.out.println("res = " + res);
		// when


	    // then
	}

}