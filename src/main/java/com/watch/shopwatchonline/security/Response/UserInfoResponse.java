package com.watch.shopwatchonline.security.Response;

import java.util.List;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private int id;
	private String username;
	private String email;
    private Short gender;
    private String phone;
	private List<String> roles;
}
