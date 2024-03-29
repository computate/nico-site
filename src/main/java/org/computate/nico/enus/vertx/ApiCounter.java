package org.computate.nico.enus.vertx;

/**
 * Keyword: classSimpleNameApiCounter
 */
public class ApiCounter {

	public ApiCounter() {
		totalNum = 0L;
		queueNum = 0L;
	}

	private Long totalNum;

	public Long getTotalNum() {
		return totalNum;
	}

	public void incrementTotalNum() {
		this.totalNum++;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	private Long queueNum;

	public Long getQueueNum() {
		return queueNum;
	}

	public void incrementQueueNum() {
		this.queueNum++;
	}

	public void decrementQueueNum() {
		this.queueNum--;
	}

	public void setQueueNum(Long countNum) {
		this.queueNum = countNum;
	}
}
