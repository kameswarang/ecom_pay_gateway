package kganesh1795_ecompg.web;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/checkoutResult")
public class CheckoutResult {
	@Autowired
	RestTemplate rest;
	
	@GetMapping
	public String getCheckoutResult(@RequestParam Map<String, String> params, Model model) {
		String gatewayUrl = "https://test.instamojo.com/api/1.1/payments/";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Api-Key", "test_09f9c50e6ad3afd81ae389bf6b3");
		headers.add("X-Auth-Token", "test_9c78bada54cd21978edb849858f");

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = this.rest.exchange(gatewayUrl, HttpMethod.GET, httpEntity, String.class);
		JSONObject jsonResponse = new JSONObject(response.getBody());
		
		model.addAttribute("params", params);
		model.addAttribute("payment", jsonResponse);
		
		return "checkoutResult";
	}
}