package com.firstdata.ach.connectpay.interfaces;

import com.firstdata.ach.connectpay.model.EnrollmentRequest;
import com.firstdata.ach.connectpay.model.ErrorResponse;

/**
 * Created by FA2XBKQ on 10/19/2016.
 */

public interface EnrollmentCallback{
    void onSuccess(EnrollmentRequest enrollmentRequest);
    void onFailure(ErrorResponse errorResponse);
}
