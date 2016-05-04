package name.qd.fileCache.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import name.qd.fileCache.constant.AccessDataType;

public class FileStorage {
	private static Logger log = LoggerFactory.getLogger(FileStorage.class);
	
	private String sFilePath;
	private IFileWorker fileWorker;
	
	public FileStorage(String sFilePath, int iAccessDataType) {
		this.sFilePath = sFilePath;
		
		switch(iAccessDataType) {
		case AccessDataType.BYTE_ARRAY:
			fileWorker = new ByteArrayFileWorker();
			break;
		case AccessDataType.STRING:
			fileWorker = new StringFileWorker();
			break;
		default:
			log.error("AccessDataType not support. [" + iAccessDataType + "]");
			break;
		}
	}
}
