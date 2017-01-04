package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;


	public class Phone{
		@JsonProperty("type")
		private String type;
		@JsonProperty("number")
		private String number;
		@JsonProperty("primary")
		private String primary;
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getPrimary() {
			return primary;
		}
		public void setPrimary(String primary) {
			this.primary = primary;
		}
		
		
		
	}
	
	
	


