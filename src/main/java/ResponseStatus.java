public enum ResponseStatus {

    TWOHUNDRED("200 OK", ""),
    FOUROHFOUR("404 Not Found", "Requested resource not found on this server.");

    private String reasonPhrase;
    private String statusBody;

    ResponseStatus(String reasonPhrase, String statusBody) {
        this.reasonPhrase = reasonPhrase;
        this.statusBody = statusBody;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public String getStatusBody() {
        return statusBody;
    }
}