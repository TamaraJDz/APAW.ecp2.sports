package es.upm.miw.sports;

import es.upm.miw.sports.api.SportResource;
import es.upm.miw.sports.api.UserResource;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private SportResource themeResource = new SportResource();
	private UserResource voteResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {

	}

	public void doPost(HttpRequest request, HttpResponse response) {

	}

	public void doPut(HttpRequest request, HttpResponse response) {

	}

	public void doDelete(HttpRequest request, HttpResponse response) {
	
	}

}
