package kganesh1795_ecompg.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/checkout")
public class Checkout {
	@Autowired
	RestTemplate rest;
	
	@PostMapping
	public void doCheckout(Long cartValue, HttpServletResponse res) throws JSONException, IOException {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		String gatewayUrl = "https://test.instamojo.com/api/1.1/payment-requests/";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
		headers.add("X-Api-Key", "test_09f9c50e6ad3afd81ae389bf6b3");
		headers.add("X-Auth-Token", "test_9c78bada54cd21978edb849858f");
		
		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
		data.add("amount", cartValue.toString());
		data.add("purpose", "books");
		data.add("redirect_url", baseUrl+"/checkoutResult");
		
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(data, headers);

		ResponseEntity<String> response = this.rest.postForEntity(gatewayUrl, httpEntity, String.class);
		
		JSONObject jsonResponse = new JSONObject(response.getBody());
		JSONObject payment = (JSONObject) jsonResponse.get("payment_request");
		
		res.sendRedirect((String)payment.get("longurl"));
	}

}
