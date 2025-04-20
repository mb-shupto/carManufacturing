package supto_1930875;

public class Batch {
    private String batchId;
    private String testResult;
    private String status;

    public Batch(String batchId, String testResult, String status) {
        this.batchId = batchId;
        this.testResult = testResult;
        this.status = status;
    }

    public String getBatchId() { return batchId; }
    public void setBatchId(String batchId) { this.batchId = batchId; }
    public String getTestResult() { return testResult; }
    public void setTestResult(String testResult) { this.testResult = testResult; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return batchId + "," + testResult + "," + status;
    }

    public static Batch fromString(String line) {
        String[] parts = line.split(",");
        return new Batch(parts[0], parts[1], parts[2]);
    }
}