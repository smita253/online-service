package com.example.demo;
import com.example.demo.AppError;

import lombok.Data;

@Data
public class AppError {
	private String code;
	private String message;
}
