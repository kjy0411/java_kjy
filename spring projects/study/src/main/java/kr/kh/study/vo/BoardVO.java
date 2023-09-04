package kr.kh.study.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num, bo_ori_num, bo_views, bo_up, bo_down, bo_bt_num, bo_comment;
	private String bo_title, bo_me_id, bo_contents;
	private Date bo_up_date, bo_reg_date;
}
