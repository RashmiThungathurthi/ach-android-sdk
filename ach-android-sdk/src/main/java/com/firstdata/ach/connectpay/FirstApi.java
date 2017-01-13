package com.firstdata.ach.connectpay;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.firstdata.ach.connectpay.interfaces.EnrollmentCallback;
import com.firstdata.ach.connectpay.model.BAARequest;
import com.firstdata.ach.connectpay.model.EnrollmentRequest;
import com.firstdata.ach.connectpay.model.ErrorResponse;
import com.firstdata.ach.connectpay.model.EstablishRequest;
import com.firstdata.ach.connectpay.model.EstablishResponse;
import com.firstdata.ach.connectpay.model.TokenResponse;
import com.firstdata.ach.connectpay.model.TransactionErrorResponse;
import com.firstdata.ach.connectpay.model.TransactionRequest;
import com.firstdata.ach.connectpay.model.TransactionResponse;
import com.firstdata.ach.connectpay.model.ValidateRequest;
import com.firstdata.ach.connectpay.model.ValidateResponse;
import com.firstdata.ach.connectpay.module.NetworkModule;
import com.firstdata.ach.connectpay.net.FirstApiClient;
import com.firstdata.ach.connectpay.net.services.EnrollmentService;
import com.firstdata.ach.connectpay.net.services.EstablishService;
import com.firstdata.ach.connectpay.net.services.TransactionService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import retrofit2.adapter.rxjava.HttpException;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import paywithmybank.com.android.sdk.PayWithMyBank;
import paywithmybank.com.android.sdk.PayWithMyBankCallback;
import paywithmybank.com.android.sdk.PayWithMyBankPanel;


public class FirstApi {

    private FirstApiClient firstApiClient;
    private FirstApiClient firstApiClientInt;
    private EnrollmentService enrollmentService;
    private TransactionService transactionService;
    private EstablishService establishService;
    private String jsonResponse;
    private ProgressDialog progressDialog;
    String accessId = null;
    String returnUrl = null;
    String merchantId = null;
    String description = null;
    String currency = null;
    String amount = null;
    String paymentType = null;
    String merchantReference = null;
    String requestSignature = null;
    String transactionId = null;
    String panel = null;
    String verified = null;
    String status = null;
    String transactionType = null;
    String paymentProviderType = null;
    String enrollmentId = null;

    public FirstApi(String apiUrl, String apiKey, String apiSecret, String token) {
        // NetworkModule networkModule = new NetworkModule("https://api-cert.payeezy.com/", "y6pWAJNyJyjGv66IsVuWnklkKUPFbb0a", "2b940ece234ee38131e70cc617aa2afa3d7ff8508856917958e7feb3ef190447", "fdoa-a480ce8951daa73262734cf102641994c1e55e7cdf4c02b6");
        NetworkModule networkModule = new NetworkModule(apiUrl,apiKey, apiSecret, token);

        firstApiClient = DaggerFirstApiComponent.builder().networkModule(networkModule).build().apiClient();
        enrollmentService = firstApiClient.createService(EnrollmentService.class);
        transactionService = firstApiClient.createService(TransactionService.class);
        establishService = firstApiClient.createService(EstablishService.class);
    }


    /**
     * Call reguler enrollment
     *
     * @param enrollmentRequest
     * @return TokenResponse
     * @URL v1/connectpay/consumer/enrollment
     */
    public Observable<TokenResponse> performRegularEnrollment(EnrollmentRequest enrollmentRequest) {
        return enrollmentService.create(enrollmentRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends TokenResponse>>() {
            @Override
            public Observable<? extends TokenResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        errorResponse = (ErrorResponse) JacksonConverterFactory.create().responseBodyConverter(ErrorResponse.class, null, null).convert(httpException.response().errorBody());

                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }
    /**
     * Call enrollment with Pay With My Bank
     *
     * @param enrollmentRequest
     * @return TokenResponse
     * @URL v1/connectpay/consumer/enrollment/pwmb
     */
    private Observable<TokenResponse> enrollPayWithMYBank(EnrollmentRequest enrollmentRequest) {

        return enrollmentService.createWithPayWithMyBank(enrollmentRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends TokenResponse>>() {
            @Override
            public Observable<? extends TokenResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        errorResponse = (ErrorResponse) JacksonConverterFactory.create().responseBodyConverter(ErrorResponse.class, null, null).convert(httpException.response().errorBody());

                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }

    /**
     * Call transaction
     *
     * @param transactionRequest
     * @return TransactionResponse
     * @URL v1/transactions
     */
    public Observable<TransactionResponse> createPrimaryTransaction(TransactionRequest transactionRequest) {
        return transactionService.primaryTransaction(transactionRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends TransactionResponse>>() {
            @Override
            public Observable<? extends TransactionResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        TransactionErrorResponse transactionErrorResponse = (TransactionErrorResponse) JacksonConverterFactory.create().responseBodyConverter(TransactionErrorResponse.class, null, null).convert(httpException.response().errorBody());
                        TransactionErrorResponse.Error error = transactionErrorResponse.getError();
                        errorResponse = new ErrorResponse();
                        List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                        List<TransactionErrorResponse.Error.Message> messages =  error.getMessages();
                        for (int i=0; i<messages.size(); i++) {
                            TransactionErrorResponse.Error.Message message = messages.get(i);
                            ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                            errorMessage.setMessage(message.getMessage());
                            errorMessage.setStatusCode(message.getCode());
                            errorMessageList.add(errorMessage);
                        }
                        errorResponse.setErrorMessages(errorMessageList);
                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }
    /**
     * Call refund transaction
     *
     * @param transactionRequest
     * @return TransactionResponse
     * @URL v1/transactions/{transactionId}
     */
    public Observable<TransactionResponse> createSecondaryTransaction(String transactionId, TransactionRequest transactionRequest) {
        Log.d("Ok", "createRefund : " + transactionId);
        return transactionService.secondaryTransaction(transactionId, transactionRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends TransactionResponse>>() {
            @Override
            public Observable<? extends TransactionResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        TransactionErrorResponse transactionErrorResponse = (TransactionErrorResponse) JacksonConverterFactory.create().responseBodyConverter(TransactionErrorResponse.class, null, null).convert(httpException.response().errorBody());
                        TransactionErrorResponse.Error error = transactionErrorResponse.getError();
                        errorResponse = new ErrorResponse();
                        List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                        List<TransactionErrorResponse.Error.Message> messages =  error.getMessages();
                        for (int i=0; i<messages.size(); i++) {
                            TransactionErrorResponse.Error.Message message = messages.get(i);
                            ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                            errorMessage.setMessage(message.getMessage());
                            errorMessage.setStatusCode(message.getCode());
                            errorMessageList.add(errorMessage);
                        }
                        errorResponse.setErrorMessages(errorMessageList);
                    }
                }catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }

    public void performPayWithMyBankEnrollment(final ViewGroup view, final Activity act,final String callType,final String env,final String returnURL,final EnrollmentCallback enrollmentCallback) {
        final EditText editTextName = new EditText(act);
        final LinearLayout linearLayout = new LinearLayout(act);
        EstablishRequest establishRequest = new EstablishRequest();
        establishRequest.setCallType(callType);
        establishRequest.setReturnUrl(returnURL);
        callEstablish(establishRequest).doOnSubscribe(new Action0() {
            @Override
            public void call() {
            }
        }).subscribe(new Observer<EstablishResponse>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error","Establish error");
                if (e instanceof ErrorResponse) {
                    ErrorResponse error = (ErrorResponse) e;
                    enrollmentCallback.onFailure(error);
                }
                act.finish();
            }

            @Override
            public void onNext(EstablishResponse establishResponse) {
                final Map<String, String> establishData = new HashMap<>();
                Log.d("Ok", "Merchant Reference -> " + establishResponse.getMerchantReference());
                establishData.put("accessId", establishResponse.getAccessId());
                establishData.put("merchantId", establishResponse.getMerchantId());
                //establishData.put("version", "2");
                establishData.put("currency", establishResponse.getCurrency());
                establishData.put("amount", establishResponse.getAmount());
                establishData.put("description", establishResponse.getDescription());
                establishData.put("merchantReference", establishResponse.getMerchantReference());
                establishData.put("paymentType", establishResponse.getPaymentType());
                establishData.put("requestSignature", establishResponse.getRequestSignature());
                establishData.put("env", "sandbox");
                createPayWithMyBank(establishData, view, act,callType,returnURL, enrollmentCallback);
            }
        });

    }


    private void createPayWithMyBank( Map<String, String> returnEstablishData,ViewGroup view, final Activity act,final String callType, final String returnURL,final EnrollmentCallback enrollmentCallback) {

        PayWithMyBank payWithMyBank = new PayWithMyBankPanel(act);
        final StringBuilder sb = new StringBuilder();

        try {
            payWithMyBank.establish(returnEstablishData).onReturn(new PayWithMyBankCallback<PayWithMyBank, Map<String, String>>() {
                @Override
                public void handle(PayWithMyBank view, Map<String, String> returnParameters) {
                    Iterator it = returnParameters.entrySet().iterator();
                    Log.d("Results PCB Call :", " " + returnParameters);
                    {
                        Log.d("Results PCB Call :", " " + returnParameters);
                        String transactionId = returnParameters.get("transactionId");
                        String panel = returnParameters.get("panel");
                        String merchantRef = returnParameters.get("merchantReference");
                        String requestSignature = returnParameters.get("requestSignature");
                        String verified = returnParameters.get("payment.account.verified");
                        String status = returnParameters.get("status");
                        String paymentType = returnParameters.get("payment.paymentType");
                        String transactionType = returnParameters.get("transactionType");
                        String paymentProviderType = returnParameters.get("payment.paymentProvider.type");

                        ValidateRequest validateRequest = populate(transactionId, requestSignature, merchantRef, panel, status, transactionType,paymentType,verified,paymentProviderType,callType,returnURL);
                        callValidation(validateRequest,act,enrollmentCallback);


                    }

                }
            }).onCancel(new PayWithMyBankCallback<PayWithMyBank, Map<String, String>>() {
                @Override
                public void handle(PayWithMyBank view, Map<String, String> cancelParameters) {
                    Log.d("on cancel", " " + "Cancel got called");
                    Intent result = new Intent();
                    result.putExtra("paywithmybank:cancel", (Serializable) cancelParameters);
                    //setResult(Activity.RESULT_CANCELED, result);
                    act.finish();
                }
            });

        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse();
            List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
            ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
            errorMessage.setMessage(e.getMessage());
            errorMessage.setStatusCode("-1");
            errorMessageList.add(errorMessage);
            errorResponse.setErrorMessages(errorMessageList);
            enrollmentCallback.onFailure(errorResponse);
        }
        view.addView((View) payWithMyBank);


    }

    private ValidateRequest populate(final String transactionId, final String requestSignature, final String merchantReference,
                                     final String panel,
                                     final String status, final String transactionType,final String paymentType,final String verified,final String paymentProviderType,final String callType,final String returnURL) {
        ValidateRequest req = new ValidateRequest();
        req.setTransactionId(transactionId);
        req.setCallType(callType);
        req.setRequestSignature(requestSignature);
        req.setTransactionType(transactionType);
        req.setMerchantReference(merchantReference);
        req.setStatus(status);
        req.setReturnUrl(returnURL);
        req.setPanel(panel);
        req.setVerified(verified);
        req.setPaymentType(paymentType);
        req.setType(paymentProviderType);
        return req;
    }

    /**
     * Call establish
     *
     * @param establishRequest
     * @return EstablishResponse
     * @URL v1/connectpay/establish
     */
    private Observable<EstablishResponse> callEstablish(EstablishRequest establishRequest) {
        return establishService.callEstablish(establishRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends EstablishResponse>>() {
            @Override
            public Observable<? extends EstablishResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        errorResponse = (ErrorResponse) JacksonConverterFactory.create().responseBodyConverter(ErrorResponse.class, null, null).convert(httpException.response().errorBody());
                        List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                        ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                        errorMessage.setMessage(errorResponse.getError());
                        errorMessage.setStatusCode("-1");
                        errorMessageList.add(errorMessage);
                        errorResponse.setErrorMessages(errorMessageList);

                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }


    /**
     * Call Validate
     *
     * @param validateRequest
     * @return ValidateResponse
     * @URL v1/connectpay/validate
     */
    private Observable<ValidateResponse> callValidate(ValidateRequest validateRequest) {
        return establishService.callValidate(validateRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends ValidateResponse>>() {
            @Override
            public Observable<? extends ValidateResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        errorResponse = (ErrorResponse) JacksonConverterFactory.create().responseBodyConverter(ErrorResponse.class, null, null).convert(httpException.response().errorBody());
                        List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                        ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                        errorMessage.setMessage(errorResponse.getError());
                        errorMessage.setStatusCode("1");
                        errorMessageList.add(errorMessage);
                        errorResponse.setErrorMessages(errorMessageList);
                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }


    public void callValidation(ValidateRequest req,final Activity act,final EnrollmentCallback enrollmentCallback) {

        callValidate(req).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                //progressDialog = ProgressDialog.show(act, "Processing Validate call", "Please Wait processing Validate call", true, false);
            }
        }).subscribe(new Observer<ValidateResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error","Validation error");
                if (e instanceof ErrorResponse) {
                    ErrorResponse error = (ErrorResponse) e;
                    enrollmentCallback.onFailure(error);
                    act.finish();
                }
            }

            @Override
            public void onNext(ValidateResponse validateResponse) {
                //progressDialog.dismiss();
                EnrollmentRequest enrollmentRequest = populateEnrollment(validateResponse);
                callEnrollmentWithPayWithMyBank(enrollmentRequest, act, enrollmentCallback);

            }
        });

    }

    /**
     * This method calls pay with my bank enrollment and based on enrollment id it calls transaction flow
     *
     * @param req
     */
    private void callEnrollmentWithPayWithMyBank(EnrollmentRequest req,final Activity act,final EnrollmentCallback enrollmentCallback) {

        enrollPayWithMYBank(req).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                // progressDialog = ProgressDialog.show(act, "Processing Enrollment call", "Please Wait processing Enrollment call", true, false);
            }
        }).subscribe(new Observer<TokenResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error","PayWithMyBank enrollment error");
                if (e instanceof ErrorResponse) {
                    ErrorResponse error = (ErrorResponse) e;
                    enrollmentCallback.onFailure(error);
                    act.finish();
                }
            }

            @Override
            public void onNext(TokenResponse tokenResponse) {
                //progressDialog.dismiss();
                enrollmentId = tokenResponse.getToken();
                EnrollmentRequest request = new EnrollmentRequest();
                request.setToken(enrollmentId);
                enrollmentCallback.onSuccess(request);
            }
        });

    }


    /**
     * Populates enrollment object based on response coming from validate
     *
     * @param res
     * @return
     */
    private EnrollmentRequest populateEnrollment(ValidateResponse res) {
        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setPayWithMyBankTransactionId(res.getTckObj().getTransactionId());
        String name = res.getTckObj().getName();
        String[] first_last_names = name.split("\\s");
        enrollmentRequest.setFirstName(first_last_names[0]);
        enrollmentRequest.setLastName(first_last_names[1]);

        EnrollmentRequest.Address address = new EnrollmentRequest.Address();
        address.setAddressLine1(res.getTckObj().getAddress1());
        address.setState(res.getTckObj().getState());
        address.setCity(res.getTckObj().getCity());
        address.setEmail(res.getTckObj().getEmail());
        address.setZip(res.getTckObj().getZip());
        address.setCountry("USA");

        EnrollmentRequest.Address.Phone phone = new EnrollmentRequest.Address.Phone();
        phone.setType("MOBILE");
        phone.setNumber(res.getTckObj().getPhone());
        address.setPhone(phone);

        enrollmentRequest.setAddress(address);
        return enrollmentRequest;
    }


    /**
     * Call micro validate
     *
     * @param baaRequest
     * @return TokenResponse
     * @URL v1/connectpay/consumer/enrollment/baa
     */
    public Observable<TokenResponse> callMicroValidate(BAARequest baaRequest) {
        return enrollmentService.callMicroValidate(baaRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorResumeNext(new Func1<Throwable, Observable<? extends TokenResponse>>() {
            @Override
            public Observable<? extends TokenResponse> call(Throwable throwable) {
                ErrorResponse errorResponse = null;
                try {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        errorResponse = (ErrorResponse) JacksonConverterFactory.create().responseBodyConverter(ErrorResponse.class, null, null).convert(httpException.response().errorBody());

                    }
                } catch (Exception e) {
                    errorResponse = new ErrorResponse();
                    List<ErrorResponse.ErrorMessage> errorMessageList =  new ArrayList<ErrorResponse.ErrorMessage>();
                    ErrorResponse.ErrorMessage errorMessage = new ErrorResponse.ErrorMessage();
                    errorMessage.setMessage(e.getMessage());
                    errorMessage.setStatusCode("-1");
                    errorMessageList.add(errorMessage);
                    errorResponse.setErrorMessages(errorMessageList);

                }
                return Observable.error(errorResponse);
            }
        });
    }
}
