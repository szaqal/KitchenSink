package upload;

public class ProgressListener implements org.apache.commons.fileupload.ProgressListener {

	private long num100Ks = 0;

	private long theBytesRead = 0;
	private long theContentLength = -1;
	private int percentDone = 0;
	private boolean contentLengthKnown = false;
	
	@Override
	public void update(long bytesRead, long contentLength, int items) {
		
		if (contentLength > -1) {
			contentLengthKnown = true;
		}
		theBytesRead = bytesRead;
		theContentLength = contentLength;

		long nowNum100Ks = bytesRead / 100000;
		// Only run this code once every 100K
		if (nowNum100Ks > num100Ks) {
			num100Ks = nowNum100Ks;
			if (contentLengthKnown) {
				percentDone = (int) Math.round(100.00 * bytesRead / contentLength);
			}
//			System.out.println(getMessage());
		}
		
	}
	
	public String getMessage() {
		if (theContentLength == -1) {
			return "";
		} else {
			return String.valueOf(percentDone);
		}

	}


}
