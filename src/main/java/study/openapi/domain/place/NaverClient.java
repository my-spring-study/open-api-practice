package study.openapi.domain.place;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import study.openapi.domain.place.dto.SearchLocalReq;
import study.openapi.domain.place.dto.SearchLocalRes;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class NaverClient {

	@Value("${naver.client.id}")
	private String clientId;

	@Value("${naver.client.secret}")
	private String clientSecret;

	@Value("${naver.search.local}")
	private String searchLocalURL;

	@Value("${naver.search.image}")
	private String searchImageURL;

	public SearchLocalRes localSearch(SearchLocalReq searchLocalReq) {
		URI uri = UriComponentsBuilder
			.fromUriString(this.searchLocalURL)
			.queryParams(searchLocalReq.toMultiValueMap())
			.build()
			.encode()
			.toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

		ParameterizedTypeReference<SearchLocalRes> responseType = new ParameterizedTypeReference<>() {
		};

		var responseEntity = new RestTemplate()
			.exchange(
				uri,
				HttpMethod.GET,
				httpEntity,
				responseType
			);

		return responseEntity.getBody();
	}

	public void imageSearch() {

	}
}
