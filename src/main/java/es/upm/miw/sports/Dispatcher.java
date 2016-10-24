package es.upm.miw.sports;

import es.upm.miw.sports.api.SportResource;
import es.upm.miw.sports.api.UserResource;
import es.upm.miw.sports.exceptions.InvalidRequestException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private SportResource sportResource = new SportResource();
	private UserResource userResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		if ("users".equals(request.getPath())) {
            response.setBody(userResource.userList().toString());
        }
	}

	public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        case "sports":
            try {
                sportResource.createSport(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                responseError(response, e);
            }
            break;
        case "users":
        	String requestBody = request.getBody();
            try {
                userResource.createUser(requestBody.split(":")[0], requestBody.split(":")[1]);
                response.setStatus(HttpStatus.CREATED);
            } catch (Exception e) {
                this.responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
	}

	public void doPut(HttpRequest request, HttpResponse response) {

	}

	public void doDelete(HttpRequest request, HttpResponse response) {

	}

}
