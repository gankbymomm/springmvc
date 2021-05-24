package com.laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
	
	public Map<String , String > getMessage(String message){
		Map<String, String > results = new HashMap<String, String>();
		if (message.equals("delete_success")) {
			results.put("message", "Xóa thành công");
			results.put("alert", "success");
		} else if (message.equals("error_system")) {
			results.put("message", "Lỗi hệ thống");
			results.put("alert", "danger");
		}else if (message.equals("insert_success")) {
			results.put("message", "Thêm mới thành công");
			results.put("alert", "success");
		}else if (message.equals("update_success")) {
			results.put("message", "Cập nhật thành công");
			results.put("alert", "success");
		}
		return results;
	}

}
