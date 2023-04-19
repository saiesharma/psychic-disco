package edu.iu.c322.assetmanagement.assetservice.client;

import edu.iu.c322.assetmanagement.licensingservice.model.Organization;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@FeignClient(name = "license-client", url = "http://localhost:8080") // Change the URL to match the license service URL
public interface AssetClient {
    @GetMapping("/licensings/{id}")
    License getLicense(@PathVariable("id") int licenseId);
}
