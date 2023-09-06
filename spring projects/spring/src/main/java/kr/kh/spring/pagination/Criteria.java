package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page;		//���� ������
	private int perPageNum;	//�� ���������� ������ ����
	String type;	//�˻� Ÿ��
	String search;	//�˻���
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
		type = "0";	//��ü�˻�
		search = "";//�˻��� ����
	}

	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
		type = "0";
		search = "";
	}
	//�Խñ� ����Ʈ���� ���� �������� �´� �Խñ��� �������� ���� ���� ����
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	//�־��� ������������ ���
	public String getUrl(int page) {
		return "?page=" + page + "&type=" + type + "&search=" + search;	//?������=��&������=��
	}
	//���� ������������ ���
	public String getCurrentUrl() {
		return "?page=" + page + "&type=" + type + "&search=" + search;
	}
}
