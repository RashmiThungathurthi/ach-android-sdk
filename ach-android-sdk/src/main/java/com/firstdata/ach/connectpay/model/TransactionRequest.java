package com.firstdata.ach.connectpay.model;



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "transaction_type" 
 * (class com.firstdata.firstapi.service.transaction.payload.TransactionRequest), 
 * not marked as ignorable (11 known properties: "threeDomainSecureToken", "paymentMethod", "referenceNo", "descriptor", "card", "currency", 
 * "transactionType", "amount", "id", "billing", "transactionTag"])
 * @author f2ivckd
 *
 */

@JsonAutoDetect(getterVisibility=Visibility.DEFAULT,setterVisibility=Visibility.DEFAULT,fieldVisibility=Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class TransactionRequest {
	public TransactionRequest() {
	}

	@JsonIgnore
	private String id;
	

	@JsonProperty("transaction_type")
	private String transactionType;
	public String getTransactionType() {
		return (transactionType != null ? transactionType.toLowerCase() : null);
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@JsonProperty("method")
	private String paymentMethod;
	@JsonProperty("amount")
	private String amount;

	@JsonProperty("currency_code")
	private String currency;
	
	
	@JsonProperty("billing_address")
	private Address billing;
	
   

    

    @JsonProperty("ach")
	private ConnectPay connectPay;
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public ConnectPay getConnectPay() {
		return connectPay;
	}

	public void setConnectPay(ConnectPay connectPay) {
		this.connectPay = connectPay;
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

		private EnrollmentRequest.Address.Phone phone;

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


	}



	}
