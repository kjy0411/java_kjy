package kr.kh.study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_role;
}