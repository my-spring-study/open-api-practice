package study.openapi.domain.place.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalReq {

	private String query; // 필수.

	private int display = 5; // 한 번에 표시할 검색 결과 개수(기본값: 1, 최댓값: 5)

	private int start = 1; // 검색 시작 위치(기본값: 1, 최댓값: 1)

	// - random: 정확도순으로 내림차순 정렬(기본값)
	// - comment: 업체 및 기관에 대한 카페, 블로그의 리뷰 개수순으로 내림차순 정렬
	private String sort = "comment"; // 검색 결과 정렬 방법

	public MultiValueMap<String, String> toMultiValueMap() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

		map.add("query", query);
		map.add("display", String.valueOf(display));
		map.add("start", String.valueOf(start));
		map.add("sort", sort);

		return map;
	}
}
