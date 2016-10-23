package es.upm.miw.sports;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;

public class ApiArchitectureMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("themes");
		request.setBody("uno");
		this.request();
		request.setBody("dos");
		this.request();
		request.setPath("votes");
		request.setBody("1:4");
		this.request();
		request.setBody("1:5");
		this.request();
		request.setBody("2:5");
		this.request();
		request.setBody("2:6");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("votes");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setPath("themes");
		this.request();
		request.setPath("themes/1/overage");
		this.request();
		request.setPath("themes/2/overage");
		this.request();
		//Exceptions
		request.setPath("noValid");
		this.request();
		request.setPath("themes/x/overage");
		this.request();
		request.setPath("themes/99/overage");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("votes");
		request.setBody("99:4");
		this.request();
	}

	public void request() {
		HttpResponse response = server.request(request);
	}

	public static void main(String[] args) {
		//DaoFactory.setFactory(new DaoFactoryMemory());
		new ApiArchitectureMain().demo();		
	}
}
