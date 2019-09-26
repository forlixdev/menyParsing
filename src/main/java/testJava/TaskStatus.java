package testJava;

import java.util.List;

import com.google.common.collect.MoreCollectors;

public class TaskStatus {
	
	private String orderId;
	private String taskId;
	private String taskStatus;
	private List<DocumentsStatus> documents;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public List<DocumentsStatus> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentsStatus> documents) {
		this.documents = documents;
	}
	
	public DocumentsStatus getDocumentStatus(String id) {
		return this.documents.stream().filter(i->i.getId().equals(id)).collect(MoreCollectors.onlyElement());
		
	}
}
