package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page;	//���� ������
	private int perPageNum;	//�� ���������� ������ ����
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	//�Խñ� ����Ʈ���� ���� �������� �´� �Խñ��� �������� ���� ���� ����
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}