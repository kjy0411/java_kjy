package day28.practice.baseballgame.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class RecordGame implements Serializable{
	
	private static final long serialVersionUID = -3614753301356838037L;
	
	private String id;
	private Integer count;
	
	public RecordGame(String id, int count) {
		this.id = id;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return id + " : " + count;
	}
}
