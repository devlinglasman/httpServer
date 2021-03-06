package http.server;

public class ServerStatusStub extends ServerStatus {

    private int numberOfRequests;
    private int counter;

    public ServerStatusStub(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
        counter = -1;
    }

    @Override
    public boolean isRunning() {
        counter++;
        return counter < numberOfRequests;
    }
}
