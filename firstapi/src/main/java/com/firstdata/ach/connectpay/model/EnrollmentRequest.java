package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentRequest extends TokenRequest {

	@JsonProperty("applicaiton")
	private EnrollmentApp enrollmentApplication;

	@JsonProperty("user")
	private EnrollmentUser enrollmentUser;

	@JsonProperty("billing_address")
	private Address address;



	@JsonProperty("additional_info")
	private AdditionalPersonalInfo additionalPersonalInfo;


	// for physical cards
	// may have to pass card id and pin

	@JsonProperty("token")
	private String token;

	@JsonProperty("pin")
	private String pin;




	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EnrollmentApp getEnrollmentApplication() {
		return enrollmentApplication;
	}

	public void setEnrollmentApplication(EnrollmentApp enrollmentApplication) {
		this.enrollmentApplication = enrollmentApplication;
	}

	public EnrollmentUser getEnrollmentUser() {
		return enrollmentUser;
	}

	public void setEnrollmentUser(EnrollmentUser enrollmentUser) {
		this.enrollmentUser = enrollmentUser;
	}

	public AdditionalPersonalInfo getAdditionalPersonalInfo() {
		return additionalPersonalInfo;
	}

	public void setAdditionalPersonalInfo(
			AdditionalPersonalInfo additionalPersonalInfo) {
		this.additionalPersonalInfo = additionalPersonalInfo;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


	public static class EnrollmentUser {


		@JsonProperty("routing_number")
		private String routingNumber;

		@JsonProperty("account_number")
		private String accountNumber;

		@JsonProperty("ssn")
		private String socialSecurityNumber;

		@JsonProperty("driver_license_number")
		private String driverLicenseNumber;

		@JsonProperty("driver_license_state")
		private String driverLicenseState;


		public String getRoutingNumber() {
			return routingNumber;
		}

		public void setRoutingNumber(String routingNumber) {
			this.routingNumber = routingNumber;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getSocialSecurityNumber() {
			return socialSecurityNumber;
		}

		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
		}

		public String getDriverLicenseNumber() {
			return driverLicenseNumber;
		}

		public void setDriverLicenseNumber(String driverLicenseNumber) {
			this.driverLicenseNumber = driverLicenseNumber;
		}

		public String getDriverLicenseState() {
			return driverLicenseState;
		}

		public void setDriverLicenseState(String driverLicenseState) {
			this.driverLicenseState = driverLicenseState;
		}


	}

	public static class AdditionalPersonalInfo {

		@JsonProperty("dob")
		private String dateOfBirth;

		@JsonProperty("gender")
		private String gender;

		@JsonProperty("member_date")
		private String memberDate;

		@JsonProperty("terms_and_conditions_version")
		private String termsAndConditionVersion;


		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getMemberDate() {
			return memberDate;
		}

		public void setMemberDate(String memberDate) {
			this.memberDate = memberDate;
		}

		public String getTermsAndConditionVersion() {
			return termsAndConditionVersion;
		}

		public void setTermsAndConditionVersion(String termsAndConditionVersion) {
			this.termsAndConditionVersion = termsAndConditionVersion;
		}


	}

	public static class EnrollmentApp {

		String application;

		@JsonProperty("application_id")
		String applicationId;


		String device;

		@JsonProperty("device_id")
		String deviceId;

		@JsonProperty("ip_address")
		String ipAddress;

		@JsonProperty("true_ip_address")
		String trueIpAddress;

		String imei;

		@JsonProperty("organization_id")
		String organizationId;

		@JsonProperty("session_id")
		String sessionId;

		public String getApplication() {
			return application;
		}

		public void setApplication(String application) {
			this.application = application;
		}

		public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}

		public String getDevice() {
			return device;
		}

		public void setDevice(String device) {
			this.device = device;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public String getTrueIpAddress() {
			return trueIpAddress;
		}

		public void setTrueIpAddress(String trueIpAddress) {
			this.trueIpAddress = trueIpAddress;
		}

		public String getImei() {
			return imei;
		}

		public void setImei(String imei) {
			this.imei = imei;
		}

		public String getOrganizationId() {
			return organizationId;
		}

		public void setOrganizationId(String organizationId) {
			this.organizationId = organizationId;
		}

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}


	}

	public static class Address {


		@JsonProperty("name")
		private String name;

		@JsonProperty("street")
		private String addressLine1;

		@JsonProperty("street2")
		private String addressLine2;


		@JsonProperty("state_province")
		private String state;

		@JsonProperty("city")
		private String city;

		@JsonProperty("country")
		private String country;

		@JsonProperty("email")
		private String email;

		private Phone phone;

		@JsonProperty("zip_postal_code")
		private String zip;

		public String getZip() {
			return zip;
		}

		@JsonProperty("zip_postal_code")
		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getName() {
			return name;
		}

		@JsonProperty("name")
		public void setName(String name) {
			this.name = name;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		@JsonProperty("street")
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}


		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getState() {
			return state;
		}

		@JsonProperty("state_province")
		public void setState(String state) {
			this.state = state;
		}

		public String getCity() {
			return city;
		}

		@JsonProperty("city")
		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		@JsonProperty("country")
		public void setCountry(String country) {
			if (country != null) {
				boolean isUS1 = country.toUpperCase().indexOf("US") >= 0;
				boolean isUS2 = country.toUpperCase().indexOf("840") >= 0;
				if (isUS1 || isUS2) {
					this.country = "0840";
				} else {
					this.country = country;
				}
			}
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@JsonProperty("phone")
		public Address.Phone getPhone() {
			return phone;
		}

		@JsonProperty("phone")
		public void setPhone(Address.Phone phone) {
			this.phone = phone;
		}

		public static class Phone {
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


	}
}
