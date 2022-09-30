package com.app.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Min(value = 1, message = "Enter a valid Id")
	@Max(value = 999999999, message = "Category Id cannot exceed 9 digit")
	private Integer categoryId;
	
	@NotNull(message = "Category name can not be null.")
	@NotEmpty(message = "Category name can not be empty.")
	@NotBlank(message = "Category name can not be blank.")
	private String categoryName;
	
	
	
}
