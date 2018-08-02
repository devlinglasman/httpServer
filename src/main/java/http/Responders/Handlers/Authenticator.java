package http.Responders.Handlers;

import http.HardcodedValues;
import http.Requesters.HTTPVerb;
import http.Requesters.Request;
import http.Responders.Response;

import java.util.Base64;

public class Authenticator {

    private Request request;
    private Response response;

    public String handleLogs(Request request, Response response) {
        this.request = request;
        this.response = response;
        if (notGET()) {
            return "NotAllowed";
        } else {
            if (unAuthorised()) {
                return "Unauthorised";
            } else {
                return "GET";
            }
        }
    }

    private boolean unAuthorised() {
        boolean unAuthorised = true;
        if ((request.getHeaders().get(HardcodedValues.AUTHORIZATIONHEADER.getS())) != null) {
            String credentials = request.getHeaders().get(HardcodedValues.AUTHORIZATIONHEADER.getS())
                    .replace("Basic ", "");
            String decodedCreds = (new String(Base64.getDecoder().decode(credentials.getBytes())));
            if ("admin:hunter2".equals(decodedCreds)) {
                unAuthorised = false;
            }
        }
        return unAuthorised;
    }

    private boolean notGET() {
        return request.getHTTPVerb() != HTTPVerb.GET;
    }
}