/* @Beanclass : StudentMaintenanceResponse
 * @Description : Bean class to return response including statusCode, statusMessage, 
 *                Description and studentInfoBean object
 * */
package com.onebill.Spring.response;

/*
 * @author : Rathesh Prabakar
 * @Version 2.0 17/06/2021
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.onebill.Spring.bean.StudentInfoBean;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "statusCode", "statusMessage", "Description", "studentInfoBean" })
public class StudentMaintenanceResponse {

	private int statusCode;

	private String statusMessage;

	private String Description;

	private StudentInfoBean studentInfoBean;

}
