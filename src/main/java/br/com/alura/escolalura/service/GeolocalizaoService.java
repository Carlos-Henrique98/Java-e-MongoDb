package br.com.alura.escolalura.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;

import br.com.alura.escolalura.models.Contato;

@Service
@Component
public class GeolocalizaoService {

	public List<Double> obterLatELongPor(Contato contato) throws Exception, InterruptedException, IOException {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyA03zKo_Ey2LXS6y9SS12t9Fq4ZIA29lOk");
		GeocodingApiRequest request = GeocodingApi.newRequest(context).address(contato.getEndereco());

		GeocodingResult[] results = request.await();
		GeocodingResult resultado = results[0];

		Geometry geometry = resultado.geometry;
		LatLng location = geometry.location;

		return Arrays.asList(location.lat, location.lng);
	}

}
